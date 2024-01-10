package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD_old {
    private static WebDriver driver;


    public static WebDriver getDriver(){

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (driver==null){

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        }
        return driver;




    }

    public static void quitDriver(){

        try {
            Thread.sleep(8000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        if (driver!=null){
            driver.quit();
            driver=null;
        }

    }

}
