package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    // Localizadores
    private final By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos
    public void escribirUsuario(String usuario) {
        driver.findElement(usernameInput).sendKeys(usuario);
    }

    public void escribirPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void pulsarLogin() {
        driver.findElement(loginButton).click();
    }

    public void loginCompleto(String usuario, String password) {
        escribirUsuario(usuario);
        escribirPassword(password);
        pulsarLogin();
    }

    public String obtenerError() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean botonEsRemove(String nombreProducto) {
        String id;

        switch (nombreProducto) {
            case "Sauce Labs Backpack":
                id = "remove-sauce-labs-backpack";
                break;
            case "Sauce Labs Bike Light":
                id = "remove-sauce-labs-bike-light";
                break;
            default:
                throw new IllegalArgumentException("Producto no válido");
        }

        return driver.findElement(By.id(id)).isDisplayed();
    }
}