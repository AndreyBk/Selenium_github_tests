package ru.mail.propre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    private WebDriver _driver_chrome;
    WebElement _text_hider,_filed_username_or_email,_filed_password,_button_sign_in,_error,_link_create_acc;

    public SignInPage(WebDriver _driver_chrome) {
        this._driver_chrome = _driver_chrome;

        _text_hider = _driver_chrome.findElement(By.xpath("//*[@id='login']/form/div[1]/h1"));
        _filed_username_or_email = _driver_chrome.findElement(By.xpath("//*[@id=\"login_field\"]"));
        _filed_password = _driver_chrome.findElement(By.xpath("//*[@id=\"password\"]"));
        _button_sign_in = _driver_chrome.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]"));
//        _error = _driver_chrome.findElement(By.xpath("//div[@id='js-flash-container']//*[@class='container']"));
        _link_create_acc = _driver_chrome.findElement(By.xpath("//*[@id=\"login\"]/p/a"));
    }

    public SignInPage typeUsername (String username){
        _filed_username_or_email.sendKeys(username);
        return this;
    }

    public SignInPage typePassword (String password){
        _filed_password.sendKeys(password);
        return this;
    }
    public String getHiderSignInPage (){
        return _text_hider.getText();
    }

    public SignInPage loginWithInvalidCreds(String username, String password){//для невалидных данных
        typeUsername(username);
        typePassword(password);
        _button_sign_in.click();
        return new SignInPage(_driver_chrome);
    }
    public String getErrorText (){
        return _error.getText();
    }

    public SignUpPage createAccount (){
        _link_create_acc.click();
        return new SignUpPage(_driver_chrome);
    }












}
