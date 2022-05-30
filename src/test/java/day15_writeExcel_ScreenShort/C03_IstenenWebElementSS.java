package day15_writeExcel_ScreenShort;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {
    @Test
    public void webElementSS() throws IOException {

        // amazona gidip  Nutella aratalim
        // ve sonuc sayisinin oldugu web elementin fotografini cekelim

        driver.get("https://amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // webElementi locate edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        //kaydettigimiz ekran goruntusunu projede istedigimiz yere
        // kaydebilmek icin path ile yeni bir file olusturalim
        File sonucYaziElementSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");

        //webElement uzerinden getScreenshotAs() methodunu calistiralim
        // ve gelen resmi olusturdugumuz gecici file'e assing edelim
        File temp=sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        // gecici resmi saklamak istedigimiz dosyaya kopyalayalim
        FileUtils.copyFile(temp,sonucYaziElementSS); // temp dosyasini asil dosyaya kopyaliyor








    }
}
