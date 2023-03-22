package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class test3 {
    /*
Test Steps:
1. Goto https://shopvnb.com/
2. Click on Product menu
3. In the list of all badminton rackets,  then press the add to cart button. Expected to report an error
"This product only has [1] in stock".
4. Verify the error message
5. Then click the CART link. The product has been added to the CART, but with the available web quantity.

*/
    public  static WebDriver driver;
    public static void test3(){

        driver = driverFactory.getFireFoxDriver();
        Actions action;
        try{
            //1. Goto https://shopvnb.com/
            driver.get("https://shopvnb.com/");
            Thread.sleep(2000);

            //2. Click on Product --> Badminton Racket
            driver.findElement(By.xpath("//a[@title='Sản Phẩm']")).click();
            driver.findElement(By.cssSelector("li[class='level1 parent item fix-navs'] a[title='Vợt Cầu Lông']")).click();
            driver.findElement(By.xpath("//img[@alt='Vợt Cầu Lông Lining Windstorm 72 New (Mã CH)']")).click();
            Thread.sleep(2000);
            //3. In the list of all badminton rackets, click on product Lining Windstorm Badminton Rackets then press the add to cart button.

            driver.findElement(By.xpath("//span[@class='txt-main']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"Capa_1\"]")).click();
            Thread.sleep(2000);


            //4. Then click the CART link. Change the quantity to 8 for Lining Windstorm Badminton Rackets and Update

            driver.findElement(By.xpath("//a[@title='Giỏ hàng']//span[@class='box-icon']//*[name()='svg']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='CartPageContainer']//div[@class='ajaxcart__qty input-group-btn']//input[@name='updates[]']")).click();
            Thread.sleep(2000);
            action = new Actions(driver);
            action.sendKeys("8").sendKeys(Keys.ENTER).build().perform();
            Thread.sleep(2000);


            //5. Verify the error message
            Alert alert = driver.switchTo().alert();
            String alertMessage= driver.switchTo().alert().getText();
            System.out.println(alertMessage);
            alert.accept();
            Thread.sleep(2000);


        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}

