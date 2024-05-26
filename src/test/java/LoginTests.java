import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {
    @Test
    public void loginPositiveTest() {
        UserDTO user = UserDTO.builder()
                .email("0bagginsbob@mail.com")
                .password("Qwerty123!")
                .build();
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaPositive()
                .isElementPresent_popUpMessageSuccess("Login success!")
        )
        ;
    }

    @Test
    public void loginNegativeTest_wrongEmail() {
        UserDTO user = UserDTO.builder()
                .email("gginsbob@mail.com")
                .password("Qwerty123!")
                .build();
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaNegative()
                .validateErrorMessage("Login or Password incorrect")
        )
        ;
    }
    @Test
    public void loginNegativeTest_wrongPassword() {
        UserDTO user = UserDTO.builder()
                .email("0bagginsbob@mail.com")
                .password("Qwerty123")
                .build();
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaNegative()
                .validateErrorMessage("Login or Password incorrect")
        )
        ;
    }
}
