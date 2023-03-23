package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Test
public class TC4 {
    public static void testLaunchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Go to http://shopvnb.com/
        driver.get("http://shopvnb.com");

        //2. Click on SALE OFF
        driver.findElement(By.xpath("//a[contains(text(),'Sale off')]")).click();

        //3. Chọn những lựa chọn
        List<WebElement> checkboxesElms = driver.findElements(By.tagName("label"));

        WebElement chcbx1Elem = checkboxesElms.get(0);
        WebElement chcbx2Elem = checkboxesElms.get(41);

        chcbx1Elem.click();
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        chcbx2Elem.click();
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        //4. Xác nhận sản phẩm hiện ra là sp giảm 20%
        String giamgia = driver.findElement(By.cssSelector(".smart")).getText();
        String expGiamgia = "Giảm 20%";
        System.out.println("Step 4: ");
        try {
            Assert.assertEquals(giamgia, expGiamgia);
            System.out.println("Similar");
        } catch (AssertionError e) {
            System.out.println("Dissimilarity");
            e.printStackTrace();
        }

        //5. Xác nhận chi nhánh là VNB Thanh Khê Đà Nẵng
        String chinhanh = driver.findElement(By.cssSelector("div[class='product-info'] div b")).getText();
        String expChinhanh = "VNB Thanh Khê Đà Nẵng";
        System.out.println("Step 5: ");
        try {
            Assert.assertEquals(chinhanh, expChinhanh);
            System.out.println("Similar");
        } catch (AssertionError e) {
            System.out.println("Dissimilarity");
            e.printStackTrace();
        }

        //Debug only
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}
