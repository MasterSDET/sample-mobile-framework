package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
 
    public class TrustWalletTests {
    
        private AppiumDriver driver;
     private TrustWalletCreatePage createPage;
    
        @BeforeClass
        public void setup() throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            caps.setCapability(MobileCapabilityType.APP_PACKAGE, "com.wallet.crypto.trustapp");
            caps.setCapability(MobileCapabilityType.APP_ACTIVITY, ".splash.SplashActivity");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability(MobileCapabilityType.NO_RESET, false);
            caps.setCapability(MobileCapabilityType.FULL_RESET, false);
    
            URL url = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(url, caps);
    
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
            createPage = new TrustWalletCreatePage(driver);
        }
    
        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    
        @Test
        public void testCreateWallet() {
            // Step 1: Tap on Create Wallet
            TrustWalletCreatePage createPage = new TrustWalletCreatePage(driver);
            createPage.enterPassword("TestPassword123");
            createPage.confirmPassword("TestPassword123");
            createPage.tapCreateWallet();
    
            // Step 2: Verify Recovery Phrase
            boolean recoveryPhraseDisplayed = createPage.isRecoveryPhraseDisplayed();
            assert recoveryPhraseDisplayed : "Recovery phrase not displayed";
        }
    
        @Test
        public void testSendCryptocurrency() {
            // Placeholder for Send Cryptocurrency test
        }
    
        @Test
        public void testReceiveCryptocurrency() {
            // Placeholder for Receive Cryptocurrency test
        }
    
        @Test
        public void testViewTransactionHistory() {
            // Placeholder for View Transaction History test
        }
    }
    
