package ru.mail.propre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class MainPage {
    private WebDriver _driver_chrome;
    private WebElement _button_sign_in, _button_sign_up, _button_sign_up_for_github, _filed_username, _filed_email,
            _filed_password, _text_hider, _hint_filed_username;

    public MainPage(WebDriver _chrome) {
        this._driver_chrome = _chrome;
        _button_sign_in = _driver_chrome.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]"));
        _button_sign_up = _driver_chrome.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[2]"));
        _button_sign_up_for_github = _driver_chrome.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button"));
        _filed_username = _driver_chrome.findElement(By.xpath("//*[@id=\"user[login]\"]"));
        _filed_email = _driver_chrome.findElement(By.xpath("//*[@id=\"user[email]\"]"));
        _filed_password = _driver_chrome.findElement(By.xpath("//*[@id=\"user[password]\"]"));
        _text_hider = _driver_chrome.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[1]/h1"));

    }


    public SignInPage clickSignIn() {//перейти на страницу входа для зарегистрированного пользователя
        _button_sign_in.click();
        return new SignInPage(_driver_chrome);
    }

    public SignUpPage clickSignUp() {
        _button_sign_up.click();
        return new SignUpPage(_driver_chrome);
    }

    public SignUpPage clickSignUpForGit() {
        _button_sign_up_for_github.click();
        return new SignUpPage(_driver_chrome);//
    }

    public MainPage typeUserName(String userName) {
        _filed_username.sendKeys(userName);
        return this;
    }

    public String getHintFiledUsername() {
        _hint_filed_username = _driver_chrome.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/dl[1]/dd[2]"));
        return _hint_filed_username.getText();
    }

    public Boolean verifiHintFiledUsername(){
        ArrayList <WebElement> _verifi = (ArrayList<WebElement>) _driver_chrome.findElements(By.xpath("//input[@class='form-control form-control-lg input-block is-autocheck-successful']"));
        return _verifi.size()==0;
    }

    public MainPage typeEmail(String e_mail) {
        _filed_email.sendKeys(e_mail);
        return this;
    }

    public MainPage typePassword(String pass) {
        _filed_password.sendKeys(pass);
        return this;
    }

    public String getHiderMainPage() {
        return _text_hider.getText();
    }

    public SignUpPage registreUser(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        typePassword(password);
        clickSignUpForGit();
        return new SignUpPage(_driver_chrome);
    }






}
