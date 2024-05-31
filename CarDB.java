package prk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDB {
    private ParkingDB parkingDB;

    public CarDB() throws SQLException, ClassNotFoundException {
        this.parkingDB = new ParkingDB();
    }

    public void saveCar(Car car) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Car (driverName, carModelName, colorName) VALUES (?, ?, ?)";
        System.out.println(sql);
        try (Connection conn = parkingDB.connectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, car.getDriverName());
            pstmt.setString(2, car.getCarModelName());
            pstmt.setString(3, car.getColorName());
            pstmt.executeUpdate();
        }
    }
}
