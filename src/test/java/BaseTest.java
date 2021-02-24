import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTest {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement inputsLink = driver.findElement(By.linkText("Form Authentication"));
        inputsLink.click();

        driver.findElement(By.id("username")).sendKeys("tomsmith");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//form/button")).click();

        //driver.manage().window().setSize(new Dimension(300,700));

        //List<WebElement> links  = driver.findElements(By.tagName("a"));
        //System.out.println(links.size());

        //WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        //inputsLink.click();

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(driver.getTitle());
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
    }

}
