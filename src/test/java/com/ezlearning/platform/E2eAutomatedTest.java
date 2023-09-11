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
        String[] links = {"/index", "/discover", "/cursos", "/register"};
        for (String link : links) {
            //driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com" + link);
            driver.get("http://localhost:8080" + link);


        }
    }

    @Test
    @Order(3)
    public void testRegister(){
    //driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/register");
    driver.get("http://localhost:8080/register");

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
    
    }

    @Test
    @Order(5)
    public void testLogin(){
    
    testRegister();
    driver.get("http://localhost:8080/login");
    //driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/login");


    WebElement username1=driver.findElement(By.id("username"));
    WebElement password1=driver.findElement(By.id("password"));
    WebElement login=driver.findElement(By.name("submit"));

    username1.sendKeys("GeorgeWilson01");
    password1.sendKeys("test");
    login.click();

     //String actualUrl="https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/";
    String actualUrl1="http://localhost:8080/";


    String expectedUrl1= driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl1,actualUrl1);

    }

    
    @Test
    @Order(4)
    public void testProfessorDetail() throws InterruptedException{

    //driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/profesores");

    WebElement chevron_right=driver.findElement(By.id("chevron_right"));
    chevron_right.click();

    driver.get("http://localhost:8080/cursos/1");

    }




}
