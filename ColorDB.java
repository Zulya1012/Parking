package prk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ColorDB {
    private ParkingDB parkingDB;

    public ColorDB() throws SQLException, ClassNotFoundException {
        this.parkingDB = new ParkingDB(); 
    }

    public void saveColor(Color color) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Color (name) VALUES (?)"; 
        System.out.println(sql);
        try (Connection conn = parkingDB.connectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, color.getName());
            pstmt.executeUpdate();
        }
    }
}
