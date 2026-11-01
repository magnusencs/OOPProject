package com.mycompany.oopproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Vector;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:taskflow.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTable() {

        String sql = """
            CREATE TABLE IF NOT EXISTS tugas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nama_tugas TEXT NOT NULL,
                deadline TEXT NOT NULL,
                status INTEGER NOT NULL,
                jenis TEXT NOT NULL,
                mata_kuliah TEXT
            );
            """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabel tugas berhasil dibuat.");

        } catch (SQLException e) {
            System.out.println("Gagal membuat tabel.");
            e.printStackTrace();
        }
    }

    public static void insertTugas(Tugas tugas) {

        String sql = """
            INSERT INTO tugas
            (nama_tugas, deadline, status, jenis, mata_kuliah)
            VALUES (?, ?, ?, ?, ?)
            """;

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tugas.getNama());
            stmt.setString(2, tugas.getDeadline().toString());
            stmt.setInt(3, tugas.getStatus() ? 1 : 0);

            if (tugas instanceof TugasKuliah) {

                TugasKuliah tugasKuliah = (TugasKuliah) tugas;

                stmt.setString(4, "kuliah");
                stmt.setString(5, tugasKuliah.getMataKuliah());

            } else {

                stmt.setString(4, "pribadi");
                stmt.setNull(5, java.sql.Types.VARCHAR);
            }

            stmt.executeUpdate();

            System.out.println("Tugas berhasil disimpan ke database.");

        } catch (SQLException e) {
            System.out.println("Gagal menyimpan tugas.");
            e.printStackTrace();
        }
    }
    
    
    public static Vector<Tugas> loadTugas() {

    Vector<Tugas> daftarTugas = new Vector<>();

    String sql = "SELECT * FROM tugas";

    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {

            String nama = rs.getString("nama_tugas");
            LocalDate deadline =
                    LocalDate.parse(rs.getString("deadline"));

            boolean status = rs.getInt("status") == 1;
            String jenis = rs.getString("jenis");

            Tugas tugas;

            if (jenis.equals("kuliah")) {

                String mataKuliah = rs.getString("mata_kuliah");

                tugas = new TugasKuliah(
                    nama,
                    deadline,
                    mataKuliah
                );

            } else {

                tugas = new TugasPribadi(
                    nama,
                    deadline
                );
            }

            tugas.setStatus(status);
            daftarTugas.add(tugas);
        }

        System.out.println("Data tugas berhasil dimuat.");

    } catch (SQLException e) {
        System.out.println("Gagal memuat data tugas.");
        e.printStackTrace();
    }
    
    

    return daftarTugas;
}
    
    public static void updateStatus(Tugas tugas) {

    String sql = """
        UPDATE tugas
        SET status = ?
        WHERE nama_tugas = ? AND deadline = ?
    """;

    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, tugas.getStatus() ? 1 : 0);
        stmt.setString(2, tugas.getNama());
        stmt.setString(3, tugas.getDeadline().toString());

        stmt.executeUpdate();

        System.out.println("Status berhasil diperbarui di database.");

    } catch (SQLException e) {
        System.out.println("Gagal memperbarui status.");
        e.printStackTrace();
    }
}
}