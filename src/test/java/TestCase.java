//Selenium Web Otomasyon: gittigidiyor.com

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestCase {
    @Test
    public void testMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.get("www.gittigidiyor.com");

        //"Giris Yap veya Uye ol" kismi
        WebElement logInBt = wd.findElement(By.className("gekhq4-6 hnYHyk"));
        logInBt.click();
        //"Giris Yap" butonu gelene kadar bekle
        WebDriverWait wdwait = new WebDriverWait(wd,3);
        WebElement logInBt2 = wd.findElement(By.className("qjixn8-0 sc-1bydi5r-0 kNKwwK"));
        wdwait.until(ExpectedConditions.elementToBeClickable(logInBt2));
        //"Giris Yap" butonu
        logInBt2.click();

        //Kullanici girisi
        WebElement username = wd.findElement(By.id("L-UserNameField"));
        username.click();
        username.sendKeys("testMail");

        WebElement pw = wd.findElement(By.id("L-PasswordField"));
        pw.click();
        pw.sendKeys("testPassword");

        //Kullanici girisi butonu
        wd.findElement(By.id("gg-login-enter")).click();

        //Anasayfaya don
        wd.findElement(By.className("logo_gg imglink logo-small")).click();

        //Arama kutusuna "Bilgisayar" yazma
        WebElement search = wd.findElement(By.className("sc-4995aq-0 sc-14oyvky-0 itMXHg"));
        search.click();
        search.sendKeys("bilgisayar");

        wd.findElement(By.className("qjixn8-0 sc-1bydi5r-0 hKfdXF")).click();

        //Rastgele bir urun secme
        List<WebElement> catalogCells = (List<WebElement>) wd.findElement(By.className("gg-uw-6 gg-w-8 gg-d-8 gg-t-8 gg-m-24 gg-mw-12 catalog-seem-cell srp-item-list browser sent"));
        int randomProduct = (int)Math.random()*catalogCells.size();
        catalogCells.get(randomProduct).click();

        //Fiyat dogrulanmasi icin sayfadaki ve sepetteki fiyatlar
        String catalogPrice = wd.findElement(By.id("sp-price-lowPrice")).getText();

         wd.findElement(By.id("add-to-basket")).click();

        wd.findElement(By.className("dIB")).click();

        String boxPrice = wd.findElement(By.className("new-price-box")).getText();

        //fiyatlarin dogrulanmasi
        boolean price = (catalogPrice == boxPrice);

        //sepetin bosaltilmasi
        wd.findElement(By.className("btn-delete btn-update-item")).click();


    }
}
