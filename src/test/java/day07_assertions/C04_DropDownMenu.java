package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    // amazona gidip dropDown'dan
    // books secenegini secip java aratalim
    // ve arama sonuclarinin java icerdigini test edelim
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("htpps://www.amazon.com");
        // dropdown dan bir option secmek icin 3 adim vardir
        // 1- dropdown locate edelim




       // select.deselectByValue("search-alias=garden");
       // select.deselectByIndex(1);


        // arama kutusuna java yazdiralim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        Thread.sleep(5000);

    }


}
