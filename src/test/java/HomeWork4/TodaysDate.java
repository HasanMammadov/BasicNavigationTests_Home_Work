package HomeWork4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TodaysDate {

   private WebDriver driver;

@Test
   public void toDayDateVerify(){



       WebElement year = driver.findElement(By.xpath("//select//option[@value='2020']"));
       WebElement month = driver.findElement(By.xpath("//select//option[text()='March']"));
       WebElement day=  driver.findElement(By.xpath("//select//option[text()='24']"));



       String actualYear = year.getText();
    String actualMonth = month.getText();
    String actualDay = day.getText();

    //Read more: https://www.java67.com/2016/12/how-to-get-current-day-month-year-from-date-in-java8.html#ixzz6He3wEPLP
    String expectedYear = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"));
    String expectedMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM"));
    String expectedDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));

    Assert.assertEquals(actualDay,expectedDay);
    Assert.assertEquals(actualMonth,expectedMonth);
    Assert.assertEquals(actualYear,expectedYear);


}








 @AfterMethod
public void tearDown(){
    driver.quit();
}

   @BeforeMethod
   public void setDriver(){
       WebDriverManager.chromedriver().version("79").setup();
       driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://practice.cybertekschool.com/dropdown");
   }
}