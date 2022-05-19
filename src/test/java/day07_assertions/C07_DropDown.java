package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C07_DropDown {
    /*

13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */
WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        // driver.quit();
    }
    @Test
    public void test01() {
        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("// button[@id='signin_button']")).click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[@class='ui-state-default ui-corner-top ui-state-hover']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Eurozone");

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("2000");

        //10. “US Dollars” in secilmedigini test edin
        WebElement UsDollars=driver.findElement(By.xpath("pc_inDollars_true"));
        Assert.assertFalse(UsDollars.isDisplayed());

        //11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("pc_inDollars_false")).click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("pc_calculate_costs")).click();
        driver.findElement(By.xpath("purchase_cash")).click();


        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@id='alert_content']"));
        if(sonucYazisi.isDisplayed()){
            System.out.println("test PASSED");
        }else{
            System.out.println("test FAILED");
        }



    }

}
