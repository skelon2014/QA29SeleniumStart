import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        type(By.id("firstName"),"Sergey");
        type(By.cssSelector("#lastName"),"Sergeev");
        type(By.xpath("//*[@id='userEmail']"),"kselon@bk.ru");
        wd.findElement(By.xpath("//label[.='Male']")).click();
       // click(By.cssSelector("#gender-radio-1"));
        type(By.id("userNumber"),"1234567890");
        type(By.xpath("//*[@id='dateOfBirthInput']"),"17 October 1970");

        wd.findElement(By.id("close-fixedban")).click();
        wd.findElement(By.xpath("//button[@id='submit']")).click();


    }

    //====================================================
    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement((locator)).click();
    }
}
