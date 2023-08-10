package com.ezlearning.platform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class E2eTestAutomation {

    @Test
    public void automatedTest() {

    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://ez-learning-git-amd-med-aziz-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/");

    
}


}
