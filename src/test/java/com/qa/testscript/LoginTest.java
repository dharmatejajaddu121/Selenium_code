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
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "D:\\dharma\\Eclipse 2025\\chromedriver-win64\\chromedriver.exe");
       // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://lionfish-app-by3cf.ondigitalocean.app/login"); // replace with your site
        loginPage = new Loginpage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("dharmateja.jaddu121@gmail.com");
        loginPage.enterPassword("Dharma@2904");
        loginPage.clickLogin();
        // Add assertion here to check login success (e.g., check URL or dashboard element)
        
        
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Cotchel"));
        System.out.println(driver.getTitle());
     
      
       assert driver.getTitle().contains("Cotchel");
    }

//   @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}
