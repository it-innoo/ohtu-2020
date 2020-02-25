package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new FirefoxDriver();
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    

    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    @Given("command logout is selected")
    public void commandLogoutIsSelected() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("logout"));       
        element.click();
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String username , String password) {
        // Write code here that turns the phrase above into concrete actions
        // throw new cucumber.api.PendingException();
        // createUser(username, password, password);
        // logInWith(username, password);
        // pageHasContent("Ohtu Application main page");
        commandNewUserIsSelected();
        // createUser(username, password, password);
        aValidUsernameAndPasswordAndInvalidPasswordConfirmationAreEntered(username, password, password);
        aNewUserIsCreated();
        pageHasButton("continue to application mainpage");

        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click();

        pageHasButton("logout");

        element = driver.findElement(By.linkText("logout"));       
        element.click();

    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        commandNewUserIsSelected();

        tooShortUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(username, password);
        WebElement element = driver.findElement(By.linkText("back to home"));
        element.click();
    }
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @When("incorrect username {string} and password {string} are given")
    public void inCorrectUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        String passwordConfirmation = driver.findElement(By.name("passwordConfirmation")).getText();
        createUser(username, password, password);
    }

    @When("too short username {string} and password {string} and matching password confirmation are entered")
    public void tooShortUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(
            String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        String passwordConfirmation = driver.findElement(By.name("passwordConfirmation")).getText();
        createUser(username, password, passwordConfirmation);
    }

    @When("a valid username {string} and too short password {string} are entered")
    public void aValidUsernameAndTooShortPasswordAreEntered(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        String passwordConfirmation = driver.findElement(By.name("passwordConfirmation")).getText();
        createUser(username, password, passwordConfirmation);
    }

    @When("a valid username {string} and password {string} and invalid passwordConfirmation {string} are entered")
    public void aValidUsernameAndPasswordAndInvalidPasswordConfirmationAreEntered(
            String username, String password, String passwordConfirmation) {
        // Write code here that turns the phrase above into concrete actions
        createUser(username, password, passwordConfirmation);
    }

    
    @Then("a new user is created")
    public void aNewUserIsCreated() {
        // Write code here that turns the phrase above into concrete actions
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String error) {
        // Write code here that turns the phrase above into concrete actions
        pageHasContent(error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void pageHasButton(String text) {
        assertTrue(driver.findElement(By.linkText(text)) != null);
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }

    private void createUser(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
        
    }

    private void logout() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("logout"));       
        element.click(); 
    }
}
