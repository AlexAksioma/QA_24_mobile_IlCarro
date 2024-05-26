import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .name(i + "Bob")
                .lastName(i+ "Baggins")
                .email(i + "bagginsbob@mail.com")
                .password("Qwerty123!")
                .build();
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .typeRegistrationForm(user)
                .clickCheckBoxIAgree()
                .clickBtnYallaPositive()
                .isElementPresent_popUpMessageSuccess("Registration success!")
        );
    }

    @Test
    public void registrationNegativeTest_wrongEmail() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .name(i + "Bob")
                .lastName(i + "Baggins")
                .email(i + "bagginsbobmail.com")
                .password("Qwerty123!")
                .build();
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .typeRegistrationForm(user)
                .clickCheckBoxIAgree()
                .clickBtnYallaNegative()
                .validateErrorMessage("username=must be a well-formed email address")
        )
        ;
    }
    @Test
    public void registrationNegativeTest_WOCheckBox() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .name(i + "Bob")
                .lastName(i + "Baggins")
                .email(i + "bagginsbob@mail.com")
                .password("Qwerty123!")
                .build();
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnRegistration()
                .typeRegistrationForm(user)
                .clickBtnYallaNegative()
                .validateErrorMessage("All fields must be filled and agree terms")
        )
        ;
    }

//    @AfterMethod
//    public void afterTest(){
//        new ErrorScreen(driver).clickBtnOkReturnRegScreen();
//    }
}
