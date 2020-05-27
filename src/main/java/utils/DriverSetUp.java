package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class DriverSetUp {

    static WebDriver driver;

    public void setUP() {

        try {
            System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            setDriver(driver);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverSetUp.driver = driver;
    }

    public static void killDriver(){
        DriverSetUp.driver.close();
    }

}