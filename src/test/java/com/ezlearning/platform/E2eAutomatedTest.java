package com.ezlearning.platform;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(JUnit4.class)
@SpringBootTest
public class E2eAutomatedTest {

    private static ChromeDriver driver;

    @Test
    public void setUp() {
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void testBrowseLinks() throws InterruptedException {
        setUp();
        String[] links = {"/index", "/discover", "/cursos"};
        for (String link : links) {
            driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com" + link);
            //driver.get("http://localhost:8080" + link);

        }
    }

    @Test
    public void testLogin(){

     driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/login");
     //driver.get("http://localhost:8080/login");

     WebElement username=driver.findElement(By.id("username"));
     WebElement password=driver.findElement(By.id("password"));
     WebElement login=driver.findElement(By.name("submit"));
     username.sendKeys("test");
     password.sendKeys("test");
     login.click();

     //String actualUrl="http://localhost:8080/";
     String actualUrl="https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/";

     String expectedUrl= driver.getCurrentUrl();
     Assert.assertEquals(expectedUrl,actualUrl);
    } 


@Test
    public void testListProfessors(){

    //driver.get("http://localhost:8080/profesores");
    driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/profesores");

    WebElement chevron_right=driver.findElement(By.id("chevron_right"));
    chevron_right.click();
    WebElement curso=driver.findElement(By.id("curso"));
    curso.click();
    WebElement mtr=driver.findElement(By.id("modal-matricula"));
    mtr.click();
    driver.findElement(By.name("modal"));
    driver.findElement(By.name("modal-footer"));
    driver.findElement(By.name("confirmar")).click();
    WebElement confirm=driver.findElement(By.name("confirmar"));
    confirm.click();
     
    }



}
