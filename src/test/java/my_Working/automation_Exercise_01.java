package my_Working;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class automation_Exercise_01  extends TestBase {
    @Test
    public void name() {
        Faker faker = new Faker();


        //Test Case 1: Register User
        //1. Launch browser
        //1. browseri baslatin

        //2. Navigate to url 'http://automationexercise.com'
        //2. 'http://automationexercise.com' adresine gidin
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //3- Anasayfanın gorunur oldugunu dogrulayin
        String actualAnasayfaUrl = driver.getCurrentUrl();
        String expectedAnasayfaUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedAnasayfaUrl,actualAnasayfaUrl);


        //4. Click on 'Signup / Login' button
        //4. 'Signup / Login' tuşuna basın
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'New User Signup!' is visible
        //5. 'New User Signup!' yazısının gorunur oldugunu dogrulayin
        WebElement newUserYazisi = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUserYazisi.isDisplayed());


        //6. Enter name and email address
        //6. isim ve email adres girin
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("Asim");

        WebElement mail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        mail.sendKeys("abcc1273456@gmail.com");


        //7. Click 'Signup' button
        //7. 'Signup' tusuna basin
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //8. 'ENTER ACCOUNT INFORMATION' yazisinin gorunur oldugunu dogrulayin
        WebElement eaiElementi = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(eaiElementi.isDisplayed());


        //9. Fill details: Title, Name, Email, Password, Date of birth
        //9. Title, Name, Email, Password, Date of birth kisimlarini doldurun
        // baslik, isim, , mail, sifre, dogum gunu
        //10. Select checkbox 'Sign up for our newsletter!'
        //10. 'Sign up for our newsletter!' checkbox'i secin
        //11. Select checkbox 'Receive special offers from our partners!'
        //11. 'Receive special offers from our partners!' checkbox'i secin
        Actions actions = new Actions(driver);
        WebElement radioBox = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        actions.click(radioBox).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("123456" + Keys.TAB)
                .sendKeys("28" + Keys.TAB)
                .sendKeys("April")
                .sendKeys(Keys.TAB)
                .sendKeys("1993")
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .click()


        //12. Fill details:
        // First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        // isim, soyisim, firma, adres, ikinci adres, ulke, eyalet, sehir, posta kodu , telefon numarasi
        //13. Click 'Create Account button'
        //13. 'Create Account button' tiklayin
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.superhero().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().country())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().streetAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("U")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .perform();



        //14. Verify that 'ACCOUNT CREATED!' is visible
        //14. Verify that 'ACCOUNT CREATED!' gorunur oldugunu test edin
        WebElement acElementi = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(acElementi.isDisplayed());

        //15. Click 'Continue' button
        //15. 'Continue' tusuna basin
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();


        //16. Verify that 'Logged in as username' is visible
        //16. 'Logged in as username' gorunur oldugunu dogrulayin
        WebElement loggedInElementi = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedInElementi.isDisplayed());


        //17. Click 'Delete Account' button
        //17.  'Delete Account' tusuna basin
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        //18. 'ACCOUNT DELETED!' yazisinin gorunu oldugunu dogrulayin ve 'Continue' tusuna basin


    }
}
