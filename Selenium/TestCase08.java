package test;

/*
Test Steps:
1. Go to https://shopvnb.com/
2. Scroll down to "Sản Phẩm Mới" and click the first item
3. Choose size then click "THÊM VÀO GIỎ HÀNG"
4. Repeat step 2 & 3 with 2nd item
5. Click on "Giỏ hàng" link
6. Delete 1st item
7. Wait for 3 seconds, verify total price is updated

Expected outcomes:
1) Grand Total is Changed
2) Second item is removed from "Giỏ hàng"
 */


import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class VerifyChangeProducts {

    public void Verify_Change_Reorder() {

        //1. Go to https://shopvnb.com/
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://shopvnb.com/");

        try {

            List<WebElement> spm;
            List<WebElement> size;
            WebElement add;

            // Step 2, 3 & 4 below

            // Do this twice
            for (int j = 0; j < 2; j++) {

                // get the "Sản phẩm mới" list
                spm = driver.findElements(By.xpath("//*[@id=\"tab-dm-0div\"]/div/div/div[1]/div"));

                // click the item at 'i' index
                spm.get(j).click();

                Thread.sleep(1000);

                // if there's "size" options --> choose else --> skip this and add to cart
                if (!driver.findElements(By.xpath("//*[@id=\"add-to-cart-form\"]/div[2]/div[1]/div/div")).isEmpty()) {

                    // get the list of "size"
                    size = driver.findElements(By.xpath("//*[@id=\"add-to-cart-form\"]/div[2]/div[1]/div/div"));

                    // find the first (clickable) size in list
                    for (WebElement webElement : size) {

                        // class name determine if radio is clickable
                        String atr = webElement.getAttribute("class");

                        if (!atr.contains(" ")) {// if class name doesn't have space --> not a size button
                            continue;
                        }

                        // check if class name is long enough
                        if (atr.length() > atr.indexOf(" ") + 8) {
                            String isSoldout = atr.substring(atr.indexOf(" ") + 1, atr.indexOf(" ") + 8);
                            if (isSoldout.matches("soldout")) continue;// if name have the word "soldout" --> skip
                        }

                        webElement.click();// click first clickable "size"
                        break;

                    }
                }

                // get the "Thêm vào giỏ hàng" button
                add = driver.findElement(By.xpath("//*[@id=\"add-to-cart-form\"]/div[2]/div[2]/div/div/div[2]"));
                add.click();

                // go back to main page
                driver.get("https://shopvnb.com/");

                // wait for reload then repeat if not done
                Thread.sleep(1000);

            }

            // 5. Click on "Giỏ hàng" link
            driver.findElement(By.xpath("/html/body/header/div/div[1]/div/div/div[4]/div[3]")).click();
            Thread.sleep(1000);

            WebElement total = driver.findElement(By.xpath("//div[@class='CartPageContainer']//span[@class='total-price']"));
            String oriTotal = total.getText();
            // 6. Delete 1st item
            driver.findElement(By.xpath("//div[@class='CartPageContainer']//a[@title='Xóa']")).click();

            // 7. Wait for 2 seconds, verify total price is updated
            Thread.sleep(3000);

            total = driver.findElement(By.xpath("//div[@class='CartPageContainer']//span[@class='total-price']"));
            String udtTotal = total.getText();

            Assert.assertNotEquals(udtTotal, oriTotal);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }

    }

}
