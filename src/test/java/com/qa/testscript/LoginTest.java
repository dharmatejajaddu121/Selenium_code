package com.qa.testscript;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.qa.pages.Loginpage;

public class LoginTest {

    WebDriver driver;
    Loginpage loginPage;
  

    @BeforeClass
    public void setUp() throws InterruptedException {
    	System.setProperty("webdriver.edge.silentOutput", "true");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://lionfish-app-by3cf.ondigitalocean.app/login"); // replace with your site
        loginPage = new Loginpage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.login("dharmateja.jaddu121@gmail.com", "Dharma@2904");
        // Add assertion here to check login success (e.g., check URL or dashboard element)
        
        
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("Cotchel"));
        System.out.println(driver.getTitle());
     
      
        assert driver.getCurrentUrl().contains("Cotchel");
    }

//   @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}
