package my_Working2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class slayt_174 extends TestBase {
    //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    //2. “Our Products” butonuna basin
    //3. “Cameras product”i tiklayin
    //4. Popup mesajini yazdirin
    //5. “close” butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));

        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]")).click();

        Thread.sleep(3000);

        System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());

        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();

        Thread.sleep(3000);

        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedUrl, actualUrl);




    }
}
