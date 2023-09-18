package com.ezlearning.platform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(SpringRunner.class)
@SpringBootTest
public class E2eAutomatedTest {

    private static ChromeDriver driver;

    @Test
    @Order(1)
    public void setUp() {
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testBrowseLinks() throws InterruptedException {
        setUp();
        String[] links = {"/index", "/discover", "/cursos", "/profesores", "/profesores/add"};
        for (String link : links) {
            if(link != "/profesores" || link !="/profesores/add"){
            driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com" + link);}
            //driver.get("http://localhost:8080" + link);
            else
            testLogin();


        }
    }

    /*@Test
    @Order(3)
    public void testRegister(){
    //driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/register");
    //driver.get("http://localhost:8080/register");

    WebElement name=driver.findElement(By.id("nombre"));
    WebElement lastname=driver.findElement(By.id("apellido"));
    WebElement email=driver.findElement(By.id("email"));
    WebElement imgurl=driver.findElement(By.id("imgurl"));
    WebElement username=driver.findElement(By.id("username"));
    WebElement password=driver.findElement(By.id("password"));
    WebElement registerbtn=driver.findElement(By.id("register"));

    name.sendKeys("George");
    lastname.sendKeys("Wilson");
    email.sendKeys("george.wilson@gmail.com");
    imgurl.sendKeys("https://i.imgur.com/T0n0PH9.jpg");
    username.sendKeys("GeorgeWilson01");
    password.sendKeys("test");

    registerbtn.click();

     //String actualUrl="https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/register";
    
    driver.get("http://localhost:8080/profesores");
    
    }*/

    @Test
    public void testLogin(){
    

    WebElement username=driver.findElement(By.id("username"));
    WebElement password=driver.findElement(By.id("password"));
    WebElement login=driver.findElement(By.name("submit"));

    username.sendKeys("test");
    password.sendKeys("test");
    login.click();

    }

    
    @Test
    public void testJoinProfesores() {

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("namepr")));

    WebElement name=driver.findElement(By.name("namepr"));
    WebElement lastname=driver.findElement(By.name("lastnamepr"));
    WebElement email=driver.findElement(By.name("emailpr"));
    WebElement imgurl=driver.findElement(By.name("imgurlpr"));
    WebElement description=driver.findElement(By.name("descriptionpr"));

    WebElement registerbtn=driver.findElement(By.name("submitpr"));

    name.sendKeys("George");
    lastname.sendKeys("Wilson");
    email.sendKeys("george.wilson@gmail.com");
    description.sendKeys("Hi, my name is George Wilson and Iam a DevOps instructor with 10 years of experience.");
    imgurl.sendKeys("https://i.imgur.com/T0n0PH9.jpg");

    registerbtn.click();

    /*String actualUrl1="https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/profesores";
    String expectedUrl1= driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl1,actualUrl1);*/

    }




}
