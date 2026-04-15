package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    private WebDriver driver;
    private InventoryPage inventoryPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    // ✅ 1. Añadir un producto
    @Test
    void anadirUnProductoAlCarrito() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginCompleto("standard_user", "secret_sauce");

        inventoryPage = new InventoryPage(driver);

        // Añadir producto
        inventoryPage.anadirBackpack();

        // Comprobación
        int cantidad = inventoryPage.obtenerNumeroProductosCarrito();
        assertEquals(1, cantidad);
    }

    // ✅ 2. Añadir dos productos
    @Test
    void anadirDosProductosAlCarrito() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginCompleto("standard_user", "secret_sauce");

        inventoryPage = new InventoryPage(driver);

        // Añadir productos
        inventoryPage.anadirBackpack();
        inventoryPage.anadirBikeLight();

        // Comprobación
        int cantidad = inventoryPage.obtenerNumeroProductosCarrito();
        assertEquals(2, cantidad);
    }

    // ✅ 3. Botón cambia tras añadir producto
    @Test
    void botonCambiaTrasAnadirProducto() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginCompleto("standard_user", "secret_sauce");

        inventoryPage = new InventoryPage(driver);

        // Añadir producto
        inventoryPage.anadirBackpack();

        // Comprobación
        inventoryPage.existeBotonProducto("Sauce Labs Backpack");
        inventoryPage.anadirProductoPorNombre("Sauce Labs Backpack");

    }
}