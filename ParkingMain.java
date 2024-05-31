package prk;

import java.sql.SQLException;
import java.util.Scanner;

public class ParkingMain {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Driver driver = new Driver();
        CarModel carModel = new CarModel();
        Color color = new Color();
        Car car = new Car();
        ParkingHistory park = new ParkingHistory();
        Floor floor = new Floor();
        DriverDB dDB = new DriverDB();
        CarModelDB cmDB = new CarModelDB();
        ColorDB cDB = new ColorDB();
        CarDB crDB = new CarDB();
        ParkingHistoryDB phDB = new ParkingHistoryDB();
        FloorDB fDB = new FloorDB();
        Scanner s = new Scanner(System.in);

        System.out.println("1. Add driver");
        System.out.println("2. Add Car model");
        System.out.println("3. Add Car color");
        System.out.println("4. Add Car");
        System.out.println("5. Add Parking history");
        System.out.println("6. Add floor");
        int choice = s.nextInt();
        s.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter first name driver");
                String firstName = s.nextLine();
                System.out.println("Enter last name driver");
                String lastName = s.nextLine();

                driver.setFirstName(firstName);
                driver.setLastName(lastName);
                dDB.saveDriver(driver);
                System.out.printf(driver.getFirstName() + " " + driver.getLastName());
                break;

            case 2:
                System.out.println("Enter name of Car model");
                String carModelName = s.nextLine();

                carModel.setName(carModelName);
                cmDB.saveCarModelDB(carModel);
                System.out.printf(carModel.getName());
                break;

            case 3:
                System.out.println("Enter Car color");
                String carColorName = s.nextLine();

                color.setName(carColorName);
                cDB.saveColor(color);
                System.out.printf(color.getName());
                break;

            case 4:
                System.out.println("Enter Driver Name");
                String driverName = s.nextLine();
                System.out.println("Enter Car Model Name");
                String carModelNameForCar = s.nextLine();
                System.out.println("Enter Car Color Name");
                String carColorNameForCar = s.nextLine();

                car.setDriverName(driverName);
                car.setCarModelName(carModelNameForCar);
                car.setColorName(carColorNameForCar);

                crDB.saveCar(car);
                System.out.println(car.getCarModelName() + " " + car.getColorName() + " " + car.getDriverName());
                break;

            case 5:
                System.out.println("Enter Car ID");
                int carId = s.nextInt();
                s.nextLine();
                System.out.println("Enter Parking date");
                String parkingDate = s.nextLine();
                System.out.println("Enter Floor ID");
                int floorId = s.nextInt();
                s.nextLine();

                park.setCarId(carId);
                park.setParkingDate(parkingDate);
                park.setFloorId(floorId);
                phDB.saveParkingHistory(park);
                System.out.println(park.getCarId() + " " + park.getParkingDate() + " " + park.getFloorId());
                break;

            case 6:
                System.out.println("Enter Floor number");
                int floorNumber = s.nextInt();
                s.nextLine();
                System.out.println("Enter controller name");
                String controller = s.nextLine();

                floor.setNumber(floorNumber);
                floor.setController(controller);
                fDB.saveFloor(floor);
                System.out.printf(floor.getNumber() + " " + floor.getController());
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }

        s.close();
    }
}
