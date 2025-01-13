package com.arivanamin.app.name.backend.employee.storage;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.testing.architecture.bases.BaseDatabaseTest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class JpaEmployeeStorageIntegrationTest implements BaseDatabaseTest {
    
    @Autowired
    private EmployeeRepository repository;
    
    private JpaEmployeeStorage persistence;
    
    private int numberOfSavedEntities;
    private UUID expectedId;
    
    private List<Employee> expectedEmployees;
    private Employee expectedEmployee;
    
    @BeforeEach
    void setUp () {
        persistence = new JpaEmployeeStorage(repository);
    }
    
    @AfterEach
    void tearDown () {
        repository.deleteAll();
    }
    
    @Test
    void shouldReturnAllEmployeesWhenFindAllIsCalled () {
        givenRepositoryWithSavedEmployees();
        whenFindAllIsCalled();
        thenAssertThatAllEntitiesOfRepositoryAreReturned(expectedEmployees);
    }
    
    private void givenRepositoryWithSavedEmployees () {
        numberOfSavedEntities = FAKER.number()
            .numberBetween(3, 10);
        for (int i = 0; i < numberOfSavedEntities; i++) {
            JpaEmployee entity = createSampleEmployee();
            repository.save(entity);
        }
    }
    
    private void whenFindAllIsCalled () {
        expectedEmployees = persistence.findAll();
    }
    
    private void thenAssertThatAllEntitiesOfRepositoryAreReturned (List<Employee> result) {
        assertThat(result.size()).isEqualTo(numberOfSavedEntities);
    }
    
    private static JpaEmployee createSampleEmployee () {
        JpaEmployee entity = RANDOM.nextObject(JpaEmployee.class);
        entity.setId(null);
        entity.setDateOfBirth(LocalDate.now()
            .minusYears(25));
        return entity;
    }
    
    @Test
    void shouldReturnSingleEmployeeWhenFindByIdIsCalled () {
        givenRepositoryWithSampleEmployeesAndOneEmployeeExtracted();
        whenFindByIdIsCalled(expectedId);
        thenAssertThatCorrectEmployeeIsReturned(expectedEmployee);
    }
    
    private void givenRepositoryWithSampleEmployeesAndOneEmployeeExtracted () {
        givenRepositoryWithSavedEmployees();
        expectedId = repository.findAll()
            .get(FAKER.number()
                .numberBetween(0, numberOfSavedEntities))
            .getId();
        expectedEmployee = repository.findAll()
            .stream()
            .filter(employee -> employee.getId()
                .equals(expectedId))
            .findFirst()
            .orElseThrow()
            .toDomain();
    }
    
    private void whenFindByIdIsCalled (UUID sampleId) {
        expectedEmployee = persistence.findById(sampleId)
            .orElseThrow();
    }
    
    private void thenAssertThatCorrectEmployeeIsReturned (Employee resultEmployee) {
        assertThat(resultEmployee).isEqualTo(expectedEmployee);
    }
    
    @Test
    void shouldDeleteEmployeeInRepositoryWhenDeleteIsCalled () {
        givenRepositoryWithSampleEmployeesAndOneEmployeeExtracted();
        whenDeleteIsCalled();
        thenAssertThatEntityIsDeletedFromRepository();
    }
    
    private void whenDeleteIsCalled () {
        persistence.delete(expectedId);
    }
    
    private void thenAssertThatEntityIsDeletedFromRepository () {
        assertThat(persistence.findAll()
            .size()).isEqualTo(numberOfSavedEntities - 1);
        assertThat(repository.findById(expectedId)).isEmpty();
    }
    
    @Test
    void shouldSaveEmployeeInRepositoryWhenCreateIsCalled () {
        givenValidSampleEmployee();
        whenCreateIsCalled();
        thenAssertThatEmployeeIsCreatedInRepository();
    }
    
    private void givenValidSampleEmployee () {
        expectedEmployee = createSampleEmployee().toDomain();
    }
    
    private void whenCreateIsCalled () {
        persistence.create(expectedEmployee);
    }
    
    private void thenAssertThatEmployeeIsCreatedInRepository () {
        assertThat(repository.findAll()
            .size()).isOne();
    }
    
    @Test
    void shouldUpdateEmployeeInRepositoryWhenUpdateIsCalled () {
        givenRepositoryWithSampleEmployeesAndOneEmployeeExtracted();
        whenUpdateIsCalledWithModifiedEmployee();
        thenAssertThatEmployeeIsUpdatedInRepository();
    }
    
    private void whenUpdateIsCalledWithModifiedEmployee () {
        expectedEmployee.setName(FAKER.zelda()
            .character());
        persistence.update(expectedEmployee);
    }
    
    private void thenAssertThatEmployeeIsUpdatedInRepository () {
        JpaEmployee result = repository.findById(expectedId)
            .orElseThrow();
        assertThat(result.getName()).isEqualTo(expectedEmployee.getName());
    }
}
