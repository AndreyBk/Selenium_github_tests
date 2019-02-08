package ru.mail.propre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\BK\\JavaProjects\\web_drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver _driver_chr = new ChromeDriver();
        _driver_chr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        _driver_chr.get("https://github.com/join?source=header-home");
        SignUpPage _s=new SignUpPage(_driver_chr);
        _s.verifi_correct_lengh_password_greentrue("123456789123456789");

    }
}
