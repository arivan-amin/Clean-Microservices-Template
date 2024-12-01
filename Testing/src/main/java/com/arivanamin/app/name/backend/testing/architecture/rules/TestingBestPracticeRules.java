package com.arivanamin.app.name.backend.testing.architecture.rules;

import com.arivanamin.app.name.backend.testing.architecture.bases.BaseIntegrationTest;
import com.arivanamin.app.name.backend.testing.architecture.bases.BaseUnitTest;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.library.GeneralCodingRules.testClassesShouldResideInTheSamePackageAsImplementation;

public interface TestingBestPracticeRules extends BaseUnitTest {
    
    String TEST_SUFFIX = "Test";
    
    String INTEGRATION_TEST_SUFFIX = "IntegrationTest";
    
    @ArchTest
    ArchRule TEST_CLASSES_PLACEMENT = testClassesShouldResideInTheSamePackageAsImplementation();
    
    @ArchTest
    ArchRule TEST_CLASSES_SHOULD_BE_PACKAGE_PRIVATE = classes().that()
        .haveSimpleNameEndingWith(TEST_SUFFIX)
        .should()
        .notHaveModifier(JavaModifier.ABSTRACT)
        .andShould()
        .bePackagePrivate();
    
    @ArchTest
    ArchRule TEST_CLASSES_SHOULD_EXTEND_BASE_UNIT_TEST = classes().that()
        .haveSimpleNameEndingWith(TEST_SUFFIX)
        .should()
        .beAssignableTo(BaseUnitTest.class);
    
    @ArchTest
    ArchRule INTEGRATION_TEST_CLASSES_SHOULD_BE_PACKAGE_PRIVATE = classes().that()
        .haveSimpleNameEndingWith(INTEGRATION_TEST_SUFFIX)
        .should()
        .notHaveModifier(JavaModifier.ABSTRACT)
        .andShould()
        .bePackagePrivate();
    
    @ArchTest
    ArchRule INTEGRATION_TEST_CLASSES_SHOULD_EXTEND_BASE_INTEGRATION_UNIT_TEST = classes().that()
        .haveSimpleNameEndingWith(INTEGRATION_TEST_SUFFIX)
        .should()
        .beAssignableTo(BaseIntegrationTest.class);
    
    @ArchTest
    ArchRule TEST_METHODS_SHOULD_BE_PACKAGE_PRIVATE = methods().that()
        .areAnnotatedWith(Test.class)
        .should()
        .bePackagePrivate();
}
