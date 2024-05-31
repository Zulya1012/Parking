package prk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarModelDB {
    private ParkingDB parkingDB;

    public CarModelDB() throws SQLException, ClassNotFoundException {
        parkingDB = new ParkingDB();
    }

    public void saveCarModelDB(CarModel carModel) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO CarModel (name) VALUES (?)";
        System.out.println(sql); 
        try (Connection conn = parkingDB.connectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, carModel.getName());
            pstmt.executeUpdate();
        }
    }
}
