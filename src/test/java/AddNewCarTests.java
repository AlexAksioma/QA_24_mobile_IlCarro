import api.CarController;
import dto.CarDto;
import dto.CarsDto;
import dto.UserDTO;
import enumclasses.Fuel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class AddNewCarTests extends AppiumConfig {
    @Test
    public void addNewCarPositiveTest() {
        UserDTO user = UserDTO.builder()
                .email("0bagginsbob@mail.com")
                .password("Qwerty123!")
                .build();
        int i = new Random().nextInt(1000) + 1000;
        CarDto car = CarDto.builder()
                .serialNumber("333-" + i)
                .manufacture("Opel")
                .model("Z")
                .year("2020")
                .fuel(Fuel.DIESEL.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(100.23)
                .city("Haifa")
                .build();
        System.out.println(car.toString());
        new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnDots()
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYallaPositive()
                .clickBtnDots()
                .clickBtnMyCarPositive()
                .clickBtnAddNewCar()
                .typeAddNewCarForm(car)
                .clickBtnAddCarPositive()
        ;
        boolean flagEquals = false;
        CarController carController = new CarController();
        carController.getTokenForCarController();
        CarsDto carsDto = carController.bodyGetAllUserCarResponse();
        for (CarDto car1 : carsDto.getCars()) {
            System.out.println(car1.toString());
            if (car.equals(car1)) {
                System.out.println("equals !!!! " + car1.toString());
                flagEquals = true;
            } else
                System.out.println("not equals !!!!!");
        }
        Assert.assertTrue(flagEquals);
    }
}
