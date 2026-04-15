package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private final WebDriver driver;

    //Productos
    private final By backpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By bikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");

    //  Carrito
    private final By cartBadge = By.className("shopping_cart_badge");

    //  Elementos visibles
    private final By inventoryTitle = By.className("title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //
    // __________________________________AÑADIR PRODUCTOS
    //

    public void anadirBackpack() {
        driver.findElement(backpackButton).click();
    }

    public void anadirBikeLight() {
        driver.findElement(bikeLightButton).click();
    }


    public void anadirProductoPorNombre(String nombreProducto) {
        String id;

        switch (nombreProducto) {
            case "Sauce Labs Backpack":
                id = "add-to-cart-sauce-labs-backpack";
                break;
            case "Sauce Labs Bike Light":
                id = "add-to-cart-sauce-labs-bike-light";
                break;
            default:
                throw new IllegalArgumentException("Producto no valido: " + nombreProducto);
        }

        driver.findElement(By.id(id)).click();
    }


    //  CARRITO


    public int obtenerNumeroProductosCarrito() {
        try {
            String cantidad = driver.findElement(cartBadge).getText();
            return Integer.parseInt(cantidad);
        } catch (Exception e) {
            return 0; // carrito vacío
        }
    }


    //  VALIDACIONES


    public boolean esTituloVisible() {
        return driver.findElement(inventoryTitle).isDisplayed();
    }

    public boolean existeTexto(String texto) {
        return driver.findElement(By.tagName("body")).getText().contains(texto);
    }

    public void existeBotonProducto(String nombreProducto) {
        driver.getPageSource();
    }
}