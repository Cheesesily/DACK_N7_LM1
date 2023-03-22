package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;


/*
Test Steps
Step 1. Go to https://shopvnb.com/
Step 2. Click on -> Product -> Badminton Racket
Step 3. In the list of BADMINTON RACKET , select Arrange -> Prices go up .
Step 4. Verify products according to selected methods
*/


@Test
public class test1 {

        public static void testLaunchBrowser() {
                WebDriver driver = driverFactory.getFireFoxDriver();
                //1. Go to http://shopvnb.com/
                driver.get("http://shopvnb.com");

                //2.Click on -> Product -> Badminton Racket
                driver.findElement(By.xpath("//a[@title='Sản Phẩm']")).click();
                driver.findElement(By.cssSelector("li[class='level1 parent item fix-navs'] a[title='Vợt Cầu Lông']")).click();

                //3. In the list of BADMINTON RACKET , select Arrange -> Prices go up
                driver.findElement(By.xpath("//span[contains(text(),'Mặc định')]")).click();
                driver.findElement(By.cssSelector("a[onclick=\"sortby('price-desc')\"]")).click();
                //Debug only



                System.out.println(driver.findElement(By.xpath("//h1[@class='title-page d-md-block d-none']")).getText());

                try {
                        Thread.sleep(2000);
                } catch (Exception ignored) {
                }
                driver.close();
                driver.quit();
        }
}
