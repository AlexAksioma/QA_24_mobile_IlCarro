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

    @FindBy(xpath = "//*[@text='Registration success!']")
    MobileElement popUpMessageRegSuccess;


    public SearchScreen clickBtnDots() {
        btnDots.click();
        return this;
    }

    public RegistrationScreen clickBtnRegistration(){
        btnRegistration.click();
        return new RegistrationScreen(driver);
    }

    public boolean isElementPresent_popUpMessageRegSuccess(){
        return isElementPresentWithWait(popUpMessageRegSuccess, 5);
    }
}
