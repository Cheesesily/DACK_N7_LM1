package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class test6{
    /*
Test Steps:
1. Go to https://shopvnb.com/
2.Click the ADD PRODUCT TO CART link
3.Add to Cart link
4 Enter Billing information.

*/
@Test
    public static void TC6(){
        WebDriver driver = driverFactory.getFireFoxDriver();
        try{
            //1. Go to https://shopvnb.com/

            driver.get("https://shopvnb.com/");
            Thread.sleep(2000);

            //2.Click the ADD PRODUCT TO CART link
            driver.findElement(By.xpath("//a[contains(@title,'2 - Đen Cam (Mã JP)')][contains(text(),'u lông Mizuno Wave Claw El')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//label[@for='Size 43']")).click();
            Thread.sleep(2000);

            //3.Add to Cart link
            driver.findElement(By.xpath("//span[@class='txt-main']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[@title='Thanh toán ngay']")).click();
            Thread.sleep(2000);

            //4 Enter Billing information.
            driver.findElement(By.xpath("//input[@id='ho_ten']")).sendKeys("PHAMVANA");
            Thread.sleep(1500);
            driver.findElement(By.xpath("//input[@id='so_dt']")).sendKeys("0123456767");
            Thread.sleep(1500);
            driver.findElement(By.xpath("//input[@id='dia_chi']")).sendKeys("111/1 TPA");
            Thread.sleep(1500);
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("phamvana123@gmail.com");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='field__input-btn-wrapper mt10']//input[@value='ĐẶT HÀNG']")).click();


        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}