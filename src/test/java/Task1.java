import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task1 {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://todoist.com/");
        driver.manage().window().maximize();

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement inputsLink = driver.findElement(By.linkText("Login"));
        inputsLink.click();

        driver.findElement(By.id("email")).sendKeys("alvaroagx@gmail.com");
        driver.findElement(By.id("password")).sendKeys("test123!");

        driver.findElement(By.xpath("//button[@class = 'submit_btn ist_button ist_button_red sel_login']")).click();

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        Task1 task1 = new Task1();
        task1.setUp();
    }

}
