package prk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FloorDB {
    private ParkingDB parkingDB;

    public FloorDB() throws SQLException, ClassNotFoundException {
        this.parkingDB = new ParkingDB(); 
    }

    public void saveFloor(Floor floor) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Floor (number, controller) VALUES (?, ?)"; 
        System.out.println(sql);
        try (Connection conn = parkingDB.connectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, floor.getNumber());
            pstmt.setString(2, floor.getController());
            pstmt.executeUpdate();
        }
    }
}
