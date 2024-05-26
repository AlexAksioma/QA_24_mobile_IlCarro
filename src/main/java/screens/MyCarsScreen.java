package screens;

import dto.CarDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class MyCarsScreen extends BaseScreen{
    public MyCarsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/addCarBtn']")
    MobileElement btnAddNewCar;



    public AddNewCarScreen clickBtnAddNewCar(){
        btnAddNewCar.click();
        return new AddNewCarScreen(driver);
    }


}
