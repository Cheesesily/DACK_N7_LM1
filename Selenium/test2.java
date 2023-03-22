package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class test2 {
    /*
Test Steps:.
1. Goto https://shopvnb.com/
2. Click on "Product" menu
3. Click on Kumpoo Power Control K520 Pro Badminton Racket Black
4. Product Reviews
*/

    public static void test2(){

        WebDriver driver = driverFactory.getFireFoxDriver();
        try{
            //1. Goto https://shopvnb.com/
            driver.get("https://shopvnb.com/");

            //2. Click on -> MOBILE -> Badminton Racket
            driver.findElement(By.xpath("//a[@title='Sản Phẩm']")).click();
            driver.findElement(By.cssSelector("li[class='level1 parent item fix-navs'] a[title='Vợt Cầu Lông']")).click();


            //3. Click on Kumpoo Power Control K520 Pro Badminton Racket Black
            driver.findElement(By.xpath("//img[@alt='Vợt Cầu Lông Lining Windstorm 72 Blue (Mã CH)']")).click();

            //4. Comment Product
            driver.findElement(By.xpath("//textarea[@id='txt_noi_dung_0']")).click();
            driver.findElement(By.xpath("//textarea[@id='txt_noi_dung_0']")).sendKeys("San pham tot");
            driver.findElement(By.xpath("//button[contains(text(),'Gửi')]")).click();
            Thread.sleep(2000);
            //5. Fill in the form
            driver.findElement(By.xpath("//input[@placeholder='Họ tên (bắt buộc)']")).sendKeys("Pham Van A");
            driver.findElement(By.xpath("//form[@id='commentForm']//input[@placeholder='Số điện thoại']")).sendKeys("0903571111");
            driver.findElement(By.xpath("//input[@placeholder='Email (để nhận phản hồi qua email)']")).sendKeys("admin@gmail.com");
            driver.findElement(By.xpath("//form[@id='commentForm']//input[@placeholder='Mã xác nhận']")).sendKeys("Pham Van A");

            driver.findElement(By.xpath("//strong[contains(text(),'Gửi bình luận')]")).click();


        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}