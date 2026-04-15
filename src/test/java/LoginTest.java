//package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void loginCorrecto() {
        loginPage.loginCompleto("standard_user", "secret_sauce");

        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    void loginIncorrecto() {
        loginPage.loginCompleto("standard_user", "wrong_password");

        String error = loginPage.obtenerError();

        assertTrue(error.contains("Username and password do not match"));
    }
}