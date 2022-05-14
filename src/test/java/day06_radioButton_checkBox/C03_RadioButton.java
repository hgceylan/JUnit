package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

    // radio button birini isaretleyince diger isareti kaldirir

    WebDriver driver;

    // 1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test01(){
        //-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //-Cookies’i kabul edin
        //-“Create an Account” button’una basin

        //-“radio buttons” elementlerini locate edin

        //-Secili degilse cinsiyet butonundan size uygun olani secin


    }



}
