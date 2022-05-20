package day09_handWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //1-amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();

        // 2-url 'in amazon icerdigini test edelim
        String istenenKelime="amazon";
        String actuelUrl=driver.getCurrentUrl();
        Assert.assertTrue(actuelUrl.contains(istenenKelime));

        // 3-yeni bir pencere acip bestbuy anasayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandleDegeri=driver.getWindowHandle();

        // 4-title'in Best Buy oldugunu test edelim
        String actuelTitle=driver.getTitle();
        String arananKelime="Best Buy";
        Assert.assertTrue(actuelTitle.contains(arananKelime));

        // 5-ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        // 6-arama sonuclarinin java icerdigini test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        String aradigimizKelime="Java";
        Assert.assertTrue(sonucYazisiStr.contains(aradigimizKelime));

        // 7-yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        // 8-logo nun gorundugunu test edelim
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());


    Thread.sleep(3000);

    }
}
