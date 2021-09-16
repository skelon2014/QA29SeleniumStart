import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StartSelenium {
    WebDriver wd;

    @BeforeMethod
    public void preCondition() {//open browser
        wd = new ChromeDriver();
    }

    @Test
    public void startContact() throws InterruptedException {
        //  with history
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");//mozet delat' "back","refresh","forward"

        //without history
        //  wd.get("https://contacts-app.tobbymarshall815.vercel.app/home).");//tolko perehodit po ssilke. ne zapominaet istoriu

        WebElement element1 = wd.findElement(By.tagName("div"));
        wd.findElement(By.cssSelector("div"));
        wd.findElement(By.xpath("//div"));

        WebElement login = wd.findElement(By.cssSelector("[href='/login']"));
        login.click();

        List<WebElement> list = wd.findElements(By.tagName("div"));
        System.out.println(list.size());
        WebElement eldiv2 = list.get(1);
        //   WebElement login = wd.findElement(By.xpath("//*[@href='/login']"));

        System.out.println(eldiv2.getText());
        WebElement element2 = wd.findElement(By.id("root"));
        wd.findElement(By.cssSelector("#root"));
        wd.findElement(By.xpath("//*[@id='root']"));

        Thread.sleep(2000);
        WebElement element3 = wd.findElement(By.className("login_login__3EHKB"));
        wd.findElement(By.cssSelector(".login_login__3EHKB"));
        wd.findElement(By.xpath("//*[@class='login_login__3EHKB']"));

        WebElement element4 = wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.xpath("//*[@class='container']"));

    }

    @Test
    public void loginTest() throws InterruptedException {
        //step 1 open www
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        //step 2 click on login button

        WebElement loginA = wd.findElement(By.linkText("LOGIN"));
        loginA.click();
        //step 3 type email

        List<WebElement> input = wd.findElements(By.tagName("input"));

        WebElement email = input.get(0);
        email.click();
        email.clear();
        email.sendKeys("kselon+4@bk.ru");

        //step 4 type password
        WebElement password = input.get(1);
        password.click();
        password.clear();
        password.sendKeys("Qwerty$4");

        //step 5 click on login
        List<WebElement> button = wd.findElements(By.tagName("button"));
        WebElement login = button.get(0);
        login.click();
        Thread.sleep(3000);
        //step 6 signout
        WebElement signOut = wd.findElement(By.tagName("button"));
        signOut.click();

    }

    @AfterMethod
    public void postCondition() {
        //close browser

        //  wd.close();     //close only this page and WebDriver
        //close browser
        wd.quit();

    }
}
