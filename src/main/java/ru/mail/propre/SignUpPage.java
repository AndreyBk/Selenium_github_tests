package ru.mail.propre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    private WebDriver _driver_chr;
    private WebElement _filed_username, _text_hint_username,_filed_email,_text_hint_email,_filed_password,_text_fragment_hint_password,_hider_sign_up_page,_text_hider;
//<span class="js-more-than-n-chars text-green">more than 15 characters</span>
//<span class="js-more-than-n-chars text-red">more than 15 characters</span>

    public SignUpPage(WebDriver _driver_chrome) {
        this._driver_chr = _driver_chrome;
        _filed_username = _driver_chr.findElement(By.xpath("//*[@id='user_login']"));
//        _text_hint_username = _driver_chr.findElement(By.xpath("//*[@id='signup-form']/auto-check[1]/dl/dd/p"));

        _filed_email = _driver_chr.findElement(By.xpath("//*[@id=\"user_email\"]"));
//        _text_hint_email = _driver_chr.findElement(By.xpath("//*[@id=\"signup-form\"]/auto-check[2]/dl/dd/p"));

        _filed_password = _driver_chr.findElement(By.xpath("//*[@id=\"user_password\"]"));
//        _text_fragment_hint_password = _driver_chr.findElement(By.xpath("//*[text()='more than 15 characters']"));//"js-more-than-n-chars text-red"

        _hider_sign_up_page = _driver_chr.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/h1"));

    }



    public SignUpPage typeUsername(String username) {
        _filed_username.sendKeys(username);
        return this;
    }

    public String getHintFiledUsername(){
        return _text_hint_username.getText();
    }

    public SignUpPage typeEmail(String email) {
        _filed_email.sendKeys(email);
        return this;
    }

    public String getHintEmail(){
        return _text_hint_email.getText();
    }

    public SignUpPage typePassword (String password){
        _filed_password.sendKeys(password);
        return this;
    }

    public String getFragmentHintEmail(){
        return _text_fragment_hint_password.getText();
    }

    public Boolean verifi_correct_lengh_password_greentrue(String password) {
        typePassword(password);
        return _text_fragment_hint_password.getAttribute("class").toString().equals("js-more-than-n-chars text-green");
    }

    public String get_hider_sign_up_page(){
        return _hider_sign_up_page.getText();
    }

}
