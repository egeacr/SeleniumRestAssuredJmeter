package insider.automation.ui.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class Driver {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Driver.class);



    public static WebDriver getDriver(){
        if (driver == null){
            String browser = System.getProperty("browser", "chrome");
            logger.info("Browser type = " + browser );
            if(browser.equalsIgnoreCase("chrome")){

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-notifications");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--start-maximized");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            }
            else if (browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

        }
        return driver;
    }

    @AfterSuite
    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
