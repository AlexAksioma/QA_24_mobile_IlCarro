package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    MobileElement btnDots;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Registration']")
    MobileElement btnRegistration;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Login']")
    MobileElement btnLogin;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='My Cars']")
    MobileElement btnMyCars;

//    @FindBy(xpath = "//*[@text='Registration success!']")
//    MobileElement popUpMessageRegSuccess;
    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    MobileElement popUpMessageSuccess;


    public SearchScreen clickBtnDots() {
        pause(3);
        btnDots.click();
        return this;
    }

    public RegistrationScreen clickBtnRegistration(){
        btnRegistration.click();
        return new RegistrationScreen(driver);
    }

    public LoginScreen clickBtnLogin() {
        btnLogin.click();
        return new LoginScreen(driver);
    }

    public boolean isElementPresent_popUpMessageSuccess(String text){
        return textInElementPresent(popUpMessageSuccess, text, 5);
    }

    public MyCarsScreen clickBtnMyCarPositive() {
        btnMyCars.click();
        return new MyCarsScreen(driver);
    }
}
