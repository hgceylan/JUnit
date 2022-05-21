package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C03_homeWork extends TestBase {
    @Test
    public void test01() {
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

       Select select=new Select(dropDownMenu);
        //3- dropdown menude 40 eleman olduğunu doğrulayın
        List<WebElement> optionsList=select.getOptions();
        int actualOptionSayisi=optionsList.size();
        int expectedOptionSayisi=40;
        if(actualOptionSayisi==expectedOptionSayisi){
            System.out.println("eleman sayisi esit");
        }else{
            System.out.println("eleman sayisi esit degildir");
        }

        //1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone" + Keys.ENTER);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
       WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
       String sonucYazisiStr=sonucYazisi.getText();
       String arananKelime="iphone";
       Assert.assertTrue(sonucYazisiStr.contains(arananKelime));

        //4- ikinci ürüne relative locater kullanarak tıklayin

        //1- yeni bir sekme açarak amazon anasayfaya gidin
        //2-dropdown’dan bebek bölümüne secin
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        //4-sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin



        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }





}
