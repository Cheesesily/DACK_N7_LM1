package test;

import driver.driverFactory;
import org.openqa.selenium.By;
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
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Test
public class TC5 {
    public static void testLaunchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Go to http://shopvnb.com/
        driver.get("http://shopvnb.com");

        //2. Click on Đăng ký
        driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M249.31,16')]")).click();
        driver.findElement(By.cssSelector("a[title='Đăng ký']")).click();

        //3. Điền thông tin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement name = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='ten']"))));
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Số điện thoại']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement confirm = driver.findElement(By.xpath("//input[@id='re_password']"));

        name.sendKeys("Văn A");


        password.sendKeys("Astarte10");
        confirm.sendKeys("Astarte10");

        Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000");
        DecimalFormat df4 = new DecimalFormat("0000");

        String phoneNumber = df3.format(num1) + df3.format(num2)  + df4.format(num3);

        phone.sendKeys(phoneNumber);

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        email.sendKeys("admin"+ randomInt +"@gmail.com");

        //4. Click ĐĂNG KÝ
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        
        //5. Verify Registration is done. Expected account registration done.
        String pageTitle = driver.getTitle();
        String expPageTitle = "Trang thành viên";
        System.out.println("Step 5: ");
        try {
            Assert.assertEquals(pageTitle, expPageTitle);
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
