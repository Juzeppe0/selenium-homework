package CommandsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Java {



    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //გახსენით Chrome ბრაუზერი
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-example\"]/button")));

        //დააკლიკეთ ღილაკზე “Enable”
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        //გადაამოწმეთ, რომ შეყვანის ველი გააქტიურდა და ტექსტი "It's enabled!" ჩანს
        // → დაბეჭდეთ შეტყობინება: “შეყვანის ველი გააქტიურდა და ტექსტი ჩანს”
        if(driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).isEnabled() && driver.findElement(By.id("message")).isDisplayed() )
            System.out.println("შეყვანის ველი გააქტიურდა და ტექსტი ჩანს");
        else
            System.out.println("Error");

        //გადაამოწმეთ, რომ ღილაკის ტექსტი შეიცვალა “Enable”-დან “Disable”-ზე
        // → დაბეჭდეთ შეტყობინება: “ღილაკის ტექსტი წარმატებით შეიცვალა”
        wait.until(ExpectedConditions.attributeContains(By.xpath("//*[@id=\"input-example\"]/button"), "textContent", "Disable"));

        System.out.println("\nღილაკის ტექსტი წარმატებით შეიცვალა");




        //შეიყვანეთ ტექსტი "Bootcamp" შეყვანის ველში და შემდეგ გაასუფთავეთ იგი
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).sendKeys("Bootcamp");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-example\"]/input")));

        driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).clear();


        //გადადით მისამართზე http://the-internet.herokuapp.com/drag_and_drop
        driver.navigate().to("http://the-internet.herokuapp.com/drag_and_drop");


        //გადაამოწმეთ, რომ სვეტები A და B ერთსა და იმავე Y კოორდინატაზე არიან განლაგებული
        WebElement svetiA = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]"));
        WebElement svetiB = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[2]"));

        int yA = svetiA.getLocation().getY();
        int yB = svetiB.getLocation().getY();

        Assert.assertEquals(yA,yB);

        //დაბეჭდეთ შეტყობინება: “სვეტები A და B წარმატებით არიან გასწორებული”
        System.out.println("სვეტები A და B წარმატებით არიან გასწორებული");






    }
}