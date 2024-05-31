package prk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParkingHistoryDB {
    private ParkingDB parkingDB;

    public ParkingHistoryDB() throws SQLException, ClassNotFoundException {
        parkingDB = new ParkingDB();
    }

    public synchronized void saveParkingHistory(ParkingHistory park) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO ParkingHistory (carId, parkingDate, floorId) VALUES (?, ?, ?)";
        System.out.println(sql);
        
        try (Connection conn = parkingDB.connectionDB()) {
            conn.setAutoCommit(false); // Начать транзакцию
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, park.getCarId());
                pstmt.setString(2, park.getParkingDate());
                pstmt.setInt(3, park.getFloorId());
                pstmt.executeUpdate();
                conn.commit(); // Закончить транзакцию
            } catch (SQLException e) {
                conn.rollback(); // Откатить транзакцию в случае ошибки
                throw e;
            }
        }
    }
}
