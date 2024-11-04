package com.arivanamin.healthcare.backend.core.domain.base;

import com.arivanamin.healthcare.backend.core.domain.testing.BaseUnitTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static com.arivanamin.healthcare.backend.core.domain.base.CoreApplicationConfig.USER_HOME_DIRECTORY_PROPERTY;
import static java.io.File.separator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.ReflectionTestUtils.invokeMethod;

class CoreApplicationConfigTest implements BaseUnitTest {
    
    @Test
    void getApplicationConfigDirectoryReturnsCorrectPath () {
        String userHomeDirectory = System.getProperty(USER_HOME_DIRECTORY_PROPERTY);
        String expectedPath = userHomeDirectory + separator + "Apps" + separator + "Healthcare";
        
        Path actualPath = CoreApplicationConfig.getApplicationConfigDirectory();
        
        assertEquals(expectedPath, actualPath.toString());
    }
    
    @Test
    void getUserHomeDirectoryReturnsPathAsString () {
        String expectedUserHomeDirectory = System.getProperty(USER_HOME_DIRECTORY_PROPERTY);
        
        String actualUserHomeDirectory =
            invokeMethod(CoreApplicationConfig.class, "getUserHomeDirectory");
        
        assertEquals(expectedUserHomeDirectory, actualUserHomeDirectory);
    }
}
