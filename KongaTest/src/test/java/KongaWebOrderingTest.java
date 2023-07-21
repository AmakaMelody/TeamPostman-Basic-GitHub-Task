import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebOrderingTest {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the Chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open the Chrome browser
        driver = new ChromeDriver();
        //2. Visit the Url of Konga
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
    }
    @Test
    public void LoginPage() throws InterruptedException {
        //3. Click on Login/Signup button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //4. Input email address in the Username field
        driver.findElement(By.id("username")).sendKeys("chiamakamel@gmail.com");
        //5. Input valid password in the Password field
        driver.findElement(By.id("password")).sendKeys("ihuomaaa4evame");
        Thread.sleep(2000);
        //6. Click on the Login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }
     @Test
     public void categoryPage() throws InterruptedException {
         //7. Locate Computers and Accessories and click on it
         driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
         Thread.sleep(5000);
         //8. Select Laptops subcategory
         driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a")).click();
         Thread.sleep(2000);
         //9. Select Apple MacBooks
         driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
         Thread.sleep(2000);
         //10. Add an item to cart
         driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[3]/form/div[4]/button")).click();
         Thread.sleep(2000);
         //11. Locate My Cart and click on it
         driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
         Thread.sleep(2000);

     }
     @Test
     public void payment() throws InterruptedException {
        //12. Locate Checkout button and click on it
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(4000);
        //13. Add an Address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
       Thread.sleep(4000);
        //14. Continue to Payment
        driver.findElement(By.name("placeOrder")).click();
        Thread.sleep(5000);

        //15. Switch to iframe
         By locIframe = By.xpath("//*[@id=\"kpg-frame-component\"]");
         driver.switchTo().frame(driver.findElement(locIframe));

        //16. Select a card payment method
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/div/div[2]/div/div[2]/button")).click();
        Thread.sleep(5000);
        //17. Input invalid card details
        driver.findElement(By.id("card-number")).sendKeys("5432198067854343");
        driver.findElement(By.id("expiry")).sendKeys("03/24");
        driver.findElement(By.id("cvv")).sendKeys("254");
        driver.findElement(By.id("card-pin-new")).sendKeys("3078");
        //18. locate Pay now and click on it
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(3000);
        //shows invalid card number

    }
    @AfterTest
    public void close() {
        driver.quit();
        //Quit browser
    }

}
