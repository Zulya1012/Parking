package prk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DriverDB {
    private ParkingDB parkingDB;

    public DriverDB() throws SQLException, ClassNotFoundException {
        parkingDB = new ParkingDB();
    }

    public void saveDriver(Driver driver) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Driver (firstName, lastName) VALUES (?, ?)";
        try (Connection conn = parkingDB.connectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, driver.getFirstName());
            pstmt.setString(2, driver.getLastName());
            pstmt.executeUpdate();
        }
    }
}
