import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPhoneBook {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().window().maximize();
    }

    @Test
    public void LoginTest()  {
        //open //loginForm
        click(By.cssSelector("[href='/login']"));
        //fillEmail
        type(By.cssSelector("[placeholder = 'Email']"), "skelon+4@bk.ru");
        //fillPassword
        type(By.cssSelector("[placeholder = 'Password']"), "Qwerty$4");
        //clickLogin
        click(By.cssSelector(".login_login__3EHKB :nth-child(4)"));
        // click(By.cssSelector("button"));
        // click(By.cssSelector("button:nth-child(4)"));
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //sign out
        click(By.cssSelector(".navbar-logged_nav__2Hx7M :last-child"));
        //  click(By.cssSelector("button"));
    }
    @Test
    public void loginXPathTest() throws InterruptedException {
        click(By.xpath("//*[@href='/login']"));
        type(By.xpath("//input[1]"),"skelon+4@bk.ru");
       // type(By.xpath("//input[@placeholder='Email']"),"skelon+4@bk.ru");
        type(By.xpath("//input[2]"),"Qwerty$4");
      //  click(By.xpath("//button[1]"));
        click(By.xpath("//button[.=' Login']"));
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // click(By.xpath("//*[.='Sign Out']"));
        click(By.xpath("//*[@class='navbar-logged_nav__2Hx7M']/button"));
    }

    //==============================================================================================
    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement((locator)).click();
    }

    @AfterMethod
    public void tearDown() {
         wd.quit();
    }
}
