package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyBoardActions extends TestBase {
    @Test
    public void name() throws InterruptedException {
        //facebook anasayfaya gidip
        driver.get("https://www.facebook.com");

        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // isim kutusunu locate edip
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));

        // geriye kalan alanlari Tab ile dolasarak
        // formu doldurun
        Actions actions=new Actions(driver);
        actions.click(isimKutusu).
                sendKeys("Taha")
                .sendKeys(Keys.TAB)
                .sendKeys("Ustaoglu")
                .sendKeys(Keys.TAB)
                .sendKeys("hsiks@gmail.com").perform();


        Thread.sleep(5000);



    }
}
