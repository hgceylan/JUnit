package study;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class seleniumStudy2 {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://n11.com/");
    }
    @Test
    public void test() throws InterruptedException {
        //I'm verifying the "n11"

        Assert.assertTrue("URL n11 içermiyor", driver.getCurrentUrl().contains("n11"));
        Thread.sleep(6000);
        driver.findElement(By.xpath("(//div[@id='myLocation-close-info'])")).click();
        driver.findElement(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]")).click();
        //I'm move to Magazalar
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//span[@title='Mağazalar'])"))).perform();

        //I select MagazalarıGör
        driver.findElement(By.xpath("(//a[@title='Mağazaları Gör'])")).click();
        Assert.assertTrue("Mağazalar sayfasina yönlendirilemedi",driver.getCurrentUrl().contains("https://www.n11.com/magazalar"));

        //I click the Tüm Magazalar button.
        driver.findElement(By.xpath("(//div[@class='tabList'])//ul//li[4]//div//h3")).click();
        String tumMgazalarTitle=driver.findElement(By.xpath("(//div[@id='contentSellerList']/div/div[2]/div/div[2]/div[4]/h2)")).getText();
        String AileBas=driver.findElement(By.xpath("(//div[@class='sellerListHolder'])[4]//span//i")).getText();
        Assert.assertTrue("Tüm Magazalar Title görüntülenemedi",tumMgazalarTitle.contains("Tüm Mağazalar"));
        Assert.assertTrue("Aile baslayan Magazalar Görüntülenemedi",AileBas.contains("A"));

        //I print the Tüm Magazalar in the letter A.
        List<WebElement> magaza = driver.findElements(By.xpath("(//div[@class='sellerListHolder'])[4]//ul"));

        //new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sellerListHolder'])[4]//ul")));

        Writer writer = null;


       // try {
            //writer = new BufferedWriter(new OutputStreamWriter(
                   // new FileOutputStream("SeleniumStudy .txt"), "utf-8"));
          //  writer.write("N11 A ile başlayan Mağazalar : " + driver.findElement(By.xpath("(//div[@class='sellerListHolder'])[4]//ul")).getText());

        //} catch (IOException ex) {
            // report
        //} catch (FileNotFoundException e) {
           // e.printStackTrace();
      //  } catch (UnsupportedEncodingException e) {
           // e.printStackTrace();
      //  } catch (IOException e) {
            //e.printStackTrace();
        //} finally {
            //try {
               // writer.close();
          //  } catch (Exception ex) {
            }




    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
