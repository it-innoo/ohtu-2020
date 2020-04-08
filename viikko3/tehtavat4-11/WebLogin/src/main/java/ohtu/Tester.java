package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tester {

    public static void main(String[] args) {
        // WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        /*
        * onnistunut kirjautuminen
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        */
        /*
        epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkuj");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        */

        /*
        uuden käyttäjätunnuksen luominen
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        Random r = new Random();
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("otra");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("otra");

        sleep(2);

        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        */


        
        /*
        uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta
        */
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        Random r = new Random();
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("otra");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("otra");

        sleep(2);

        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();


        sleep(3);
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
