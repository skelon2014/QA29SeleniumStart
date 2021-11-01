import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoQa {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/automation-practice-form");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

    @Test
    public void fillStudentForm() {
        type(By.id("firstName"), "Sergey");
        type(By.cssSelector("#lastName"), "Sergeev");
        type(By.xpath("//*[@id='userEmail']"), "kselon@bk.ru");
        click(By.xpath("//label[.='Male']"));
        type(By.id("userNumber"), "1234567890");
        type(By.xpath("//*[@id='dateOfBirthInput']"), "17 October 1970");

        if (wd.findElement(By.id("close-fixedban")).isDisplayed()) {
            click(By.id("close-fixedban"));
        }
        wd.findElement(By.xpath("//label[.='Sports']")).click();

        if (wd.findElement(By.id("close-fixedban")).isDisplayed()) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//button[@id='submit']"));
    }

    //====================================================
    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement((locator)).click();
    }
}
