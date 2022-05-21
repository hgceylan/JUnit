package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        // bana icinde oldugum projenin dosya yolunu (path) verir
        //C:\Users\asus\IdeaProjects\com.Batch59JUnit

        System.out.println(System.getProperty("user.home"));
        //C:\Users\asus yani benim bilgisayarimin bana ozel kismini verdi
        //C:\Users\asus\IdeaProjects\com.Batch59JUnit\src\test\java\day05_JUnit
        //C:\Users\Default\Downloads

        // homePath + "/Downloads


        // masaustumuzdeki text dosyasinin varligini test edelim
        //"C:\Users\asus\Desktop\text.txt"

        String dosyaYolu=System.getProperty("user.home")+"C:\\Users\\asus\\Desktop";
        System.out.println(dosyaYolu);


        /*
        bilgisayarimizdaki bir dosyanin varligin test etmek icin once
        o dosyaya ulasmamiz gerekir
         Java 'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
         her bilgisayarin kullanici adi farkli olacagindan
         masa ustu dosya yolu da birbirinden farkli olackatir
         testlerimizin tum  bilgisayarlarda calismasi icin dinamik yapmak zorundayiz

         bunu icin
          her bilgisayarin birbirinden farkli olan yolunu bulmak icin

         */
          String farkliKisim=System.getProperty("user.home");

         // herkesin bilgisayarinda ortak olan kisim ise
          String ortakKisim="\\Desktop\\text.txt";
          // mac icin "/Desktop/text"

          String masaUstuDosyaYolu=farkliKisim +ortakKisim;

        System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));

        Assert.assertFalse(Files.exists(Paths.get(masaUstuDosyaYolu)));





    }
}
