import org.junit.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mail.propre.MainPage;
import ru.mail.propre.SignInPage;
import ru.mail.propre.SignUpPage;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver _driver;
    private MainPage _main_page;

    @BeforeClass
    public static void setUpTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\BK\\JavaProjects\\web_drivers\\chromedriver_win32\\chromedriver.exe");
    }

    @Before
    public void setUpStep() {
        _driver = new ChromeDriver();
        _driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        _driver.manage().window().setPosition(new Point(800,0));
        _driver.manage().window().maximize();
        _driver.get("https://github.com");
        _main_page = new MainPage(_driver);
    }

    @Test
    public void SignIn() {
        SignInPage _login_page = _main_page.clickSignIn();
        System.out.println(_login_page.getHiderSignInPage());
        Assert.assertTrue(_login_page.getHiderSignInPage().equals("Sign in to GitHub"));
    }

    @Test
    public void sign_up_big_green_button() {
        SignUpPage _sign_up_page = _main_page.clickSignUpForGit();//
        Assert.assertTrue(_sign_up_page.get_hider_sign_up_page().equals("Join GitHub"));
    }

    @Test
    public void sign_up_smile_button() {
        SignUpPage _sign_up_page = _main_page.clickSignUp();
        Assert.assertTrue(_sign_up_page.get_hider_sign_up_page().equals("Join GitHub"));
    }

    @Test
    public void entered_bad_username() {
        _main_page.typeUserName("12");
        Assert.assertTrue(_main_page.getHintFiledUsername().equals("Username is already taken"));
    }

    @Test
    public void entered_correct_username(){
        _main_page.typeUserName("KapitonSergeevichKuznecov");
        Assert.assertFalse(_main_page.verifiHintFiledUsername());
    }

    @After
    public void tearDown() {
        _driver.quit();
    }


}
