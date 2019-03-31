package luxury.cars;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@RestController()
@RequestMapping("/")
public class CarController {
    private ArrayList<Car> cars =
            new ArrayList<Car>(
                    Arrays.asList(
                            new Car("Toyota", "Camry", 2018),
                            new Car("Jeep", "Grand Cherokee", 2012)
                    )
            );

    @GetMapping("/cars")
    public ArrayList<Car> carsInTheLot() {
        return cars;
    }

    @PostMapping("/cars")
    public void addCarToLot(@RequestBody Car car) {
        car.dateOfPurchase = new Date();
        cars.add(car);
    }
}
