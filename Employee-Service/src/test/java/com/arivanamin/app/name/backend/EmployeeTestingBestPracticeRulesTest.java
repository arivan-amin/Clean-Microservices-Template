package com.arivanamin.app.name.backend;

import com.arivanamin.app.name.backend.testing.architecture.rules.TestingBestPracticeRules;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;

import static com.arivanamin.healthcare.backend.base.domain.base.CoreApplicationConfig.BASE_PACKAGE;

@AnalyzeClasses (packages = BASE_PACKAGE, importOptions = ImportOption.OnlyIncludeTests.class)
class EmployeeTestingBestPracticeRulesTest implements TestingBestPracticeRules {
    
}
