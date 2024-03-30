import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class smokeTest {
    private WebDriver driver;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    private void setUp(@Optional("chrome") String browser) {
        // Create driver
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            default:
                System.out.println("Do not know how to start " + browser + ", starting chrome instead");
                driver = new ChromeDriver();
                break;
        }


        System.out.println("Browser started");
        // Maximize browser window
        driver.manage().window().maximize();
        System.out.println("Page is opened");

    }

    @Test
    public void webTest0() {
//Open the web site(cookies)
        String url = "https://m.skelbiu.lt/";
        driver.get(url);
        //Accept with cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[1]/div/div[2]/div/button[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//html/body/div[6]/div[2]/div/div[1]/div/div[1]/div[2]/h2")));
        Assert.assertTrue(isElementInvisible);


    }
}
