package com.ezlearning.platform;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    @Order(2)
    public void testBrowseLinks() throws InterruptedException {
        setUp();
        String[] links = {"/index", "/discover", "/cursos"};
        for (String link : links) {
            driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com" + link);

        }
    }

    @Test
    @Order(2)
    public void testRegister(){
     setUp();
     driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/register");

   
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

     String actualUrl="https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/register";

     String expectedUrl= driver.getCurrentUrl();
     Assert.assertEquals(expectedUrl,actualUrl);
    }


    @Test
    @Order(4)
    public void testLogin(){

     driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/login");

     WebElement username=driver.findElement(By.id("username"));
     WebElement password=driver.findElement(By.id("password"));
     WebElement login=driver.findElement(By.name("submit"));

     username.sendKeys("GeorgeWilson01");
     password.sendKeys("test");
     login.click();

     String actualUrl="https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/";

     String expectedUrl= driver.getCurrentUrl();
     Assert.assertEquals(expectedUrl,actualUrl);
    } 


    @Test
    @Order(5)
    public void testListProfessors(){

    driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/profesores");

    WebElement chevron_right=driver.findElement(By.id("chevron_right"));
    chevron_right.click();
    WebElement curso=driver.findElement(By.id("curso"));
    curso.click();
    
    }

   @Test
   @Order(6)
   public void testLogout(){

    driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/logout-success");
 }



}
