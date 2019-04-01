package luxury.cars.controller;

import org.springframework.web.bind.annotation.*;
import luxury.cars.Car;

import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/search")
    public List<Car> searchForCars(@RequestParam(required = false) String make,
                                   @RequestParam(required = false) String model,
                                   @RequestParam(required = false) Integer year) {
        return cars
                .stream()
                .filter(car -> {
                    ArrayList<String> conditionals = new ArrayList<>(3);

                    if (year != null) {
                        conditionals.add("year");
                    }

                    if (make != null) {
                        conditionals.add("make");
                    }

                    if (model != null) {
                        conditionals.add("model");
                    }

                    return conditionals
                            .stream()
                            .filter(conditional -> {
                                if (conditional.equals("make")) {
                                    return car.make.equals(make);
                                }

                                if (conditional.equals("model")) {
                                    return car.model.equals(model);
                                }

                                if (conditional.equals("year")) {
                                    return car.year.equals(year);
                                }

                                return true;
                            })
                            .collect(Collectors.toList())
                            .size() == conditionals.size();
                })
                .collect(Collectors.toList());
    }

    @PostMapping("/cars")
    public void addCarToLot(@RequestBody Car car) {
        car.dateOfPurchase = new Date();
        cars.add(car);
    }
}
