package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. text.txt dosyasını indirelim
        WebElement textLinki=driver.findElement(By.xpath("//a[text()='text.txt']"));
        textLinki.click();
        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim

        // dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim

        String fakliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\text.txt";

        String arananDosyaYolu=fakliKisim+ortakKisim;

        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));


    }
}
