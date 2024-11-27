package com.arivanamin.app.name.backend;

import com.arivanamin.app.name.backend.testing.architecture.rules.CleanArchitectureRules;
import com.arivanamin.app.name.backend.testing.architecture.rules.CommonBestPracticeRules;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;

import static com.arivanamin.app.name.backend.base.domain.config.CoreApplicationConfig.BASE_PACKAGE;

@AnalyzeClasses (packages = BASE_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
class EmployeeArchitectureTest implements CommonBestPracticeRules, CleanArchitectureRules {
    
}
