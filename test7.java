package test;

import driver.driverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

@Test
public class test7 {

    /*
1. Go to https://shopvnb.com//
2. Click on Order Check.
3.Enter your phone number in Check your order and Click Check your order.
4. Verify Order.
    */
    public static WebDriver driver;

    public static void tc7(){
        driver = driverFactory.getFireFoxDriver();
        Actions action;
        try{
            //1. Go to https://shopvnb.com//

            driver.get("https://shopvnb.com/");
            Thread.sleep(2000);
            //2. Click on Order Check
            action = new Actions(driver);
            WebElement menu = driver.findElement(By.xpath("//a[@title='Kiểm tra đơn hàng / bảo hành']//span[@class='box-icon']//*[name()='svg']"));
            action.moveToElement(menu);
            Thread.sleep(2000);
            WebElement menu_on = driver.findElement(By.xpath("//a[@title='Kiểm tra đơn hàng']"));
            action.moveToElement(menu_on);// move mouse in Tra Cuu and click kiem tra don hang
            action.click().build().perform();// cú thực thi
            Thread.sleep(2000);
            //3.Enter your phone number in Check your order and Click Check your order.
            driver.findElement(By.xpath("//input[@class='form-control form-control-lg']")).sendKeys("0123456767");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[contains(text(),'Tra cứu đơn hàng')]")).click();
            //4. Verify Order.
            String hoten = driver.findElement(By.xpath("//p[contains(text(),'Họ tên:')]")).getText();
            String diachi = driver.findElement(By.xpath("//p[contains(text(),'Địa chỉ:')]")).getText();
            String tinhtrang = driver.findElement(By.xpath("//p[contains(text(),'Tình trạng:')]")).getText();
            String sdt = driver.findElement(By.xpath("//p[contains(text(),'Số điện thoại:')]")).getText();
            String table = driver.findElement(By.xpath("//div[@class='col-12']")).getText();
            System.out.println(hoten);
            System.out.println(diachi);
            System.out.println(tinhtrang);
            System.out.println(sdt);
            System.out.println(table);
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("Test SUCCESSFULLY");
    }
}

