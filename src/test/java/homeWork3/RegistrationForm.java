package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;

public class RegistrationForm {

    private WebDriver driver;
    private String url = "https://practice-cybertekschool.herokuapp.com/";
    private By firstNameBy  = (By.xpath("//input[@name='firstname']"));
    private By lastNameBy  = (By.name("lastname"));
    private By userNameBy  = (By.xpath("//input[@name='username']"));
    private By emailBy  = (By.xpath("//input[@name='email']"));
    private By password  = (By.name("password"));
    private By phoneBy  = (By.xpath("//input[@name='phone']"));
    private By maleGender  = (By.xpath("//input[@value='male']"));
    private By FemaleGender  = (By.xpath("//input[@value='Female']"));
    private By dateBirthBy  = (By.cssSelector("[name='birthday']"));
    private By departmentBy  = (By.cssSelector("[name='department']"));
    private By jobTitleBY  = (By.xpath("[@name='job_title']"));
    private By javaBY  = (By.cssSelector("[value='java']"));
    private By  javaScriptBy = (By.xpath("[value='javascript']"));
    private By submit  = (By.id("wooden_spoon"));

@Test
public void dateOfBirthWarningMessage(){

    driver.findElement(By.linkText("Registration Form")).click();

    driver.findElement(dateBirthBy).sendKeys("wrong_dob");
    String expected = "The date of birth is not valid";
    String actual = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']")).getText();
    WebElement warningMesage =driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));
    Assert.assertTrue(warningMesage.isDisplayed());
    Assert.assertEquals(actual,expected);

}
@Test
public void programmingLanguages() throws InterruptedException {
    driver.findElement(By.linkText("Registration Form")).click();
    Thread.sleep(3000);
    WebElement javaScript = driver.findElement(By.cssSelector("#inlineCheckbox3"));
    Assert.assertTrue(javaScript.isDisplayed());

    WebElement java = driver.findElement(By.id("inlineCheckbox2"));
    String javatext = java.getText();

    Assert.assertTrue(java.isDisplayed());

    WebElement cpluss = driver.findElement(By.cssSelector("[id='inlineCheckbox1']"));
    Assert.assertTrue(cpluss.isDisplayed());


}











    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}