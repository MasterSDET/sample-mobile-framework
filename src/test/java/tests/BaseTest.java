package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverUtils;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverUtils.initializeDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        DriverUtils.quitDriver();
    }

}
