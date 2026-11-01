/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oopproject;

import java.util.Scanner;
//import java.util.Vector;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author msi39
 */
public class OOPProject {
    //method overloading
    static public void sout (String c) {
        System.out.println(c);
    }
    static public void sout (int c) {
        System.out.println(c);
    }
    
    public static void main(String[] args) {
   DatabaseManager.createTable();

    System.out.println(
        "Database location: "
        + new java.io.File("taskflow.db").getAbsolutePath()
    );
        
   Connection conn = null;

    try {
        conn = DatabaseManager.connect();
        System.out.println("Database berhasil terhubung.");

    } catch (SQLException e) {
        System.out.println("Database gagal terhubung.");
        e.printStackTrace();

    } finally {

        try {
            if (conn != null) {
                conn.close();
                System.out.println("Koneksi database ditutup.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menutup koneksi database.");
        }
    }
        
    ManajemenTugas manager = new ManajemenTugas();
    manager.muatTugasDariDatabase();
   // Vector <Tugas> listTugas = new Vector <>();
    int inp;

    Scanner scan = new Scanner(System.in);

    while (true) {
        sout("TASKFLOW");
        String[] menu = {
        "Tambah tugas",
        "Tampilkan tugas",
        "Ubah status tugas",
        "Tampilkan tugas terlewat",
        "Rekap Tugas Mata Kuliah",
        "Exit"
        };
        for (int i = 0; i < menu.length; i++) {
        System.out.println((i + 1) + ". " + menu[i]);
        }

        inp = scan.nextInt();
        scan.nextLine();
       

        // sout(inp);
        switch (inp) {
            case 1:
            LocalDate deadline = null;
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            //boolean correct = false;
            sout("nama tugas: ");
            String nama = scan.nextLine();
            while (true) {
                System.out.print("Deadline (dd-MM-yyyy): ");
                String inputDeadline = scan.nextLine();

                
                try {
                    deadline = LocalDate.parse(inputDeadline, format);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Format deadline tidak valid. Gunakan dd-MM-yyyy.");
                   
                } 
            }

            System.out.println("1. Kuliah");
            System.out.println("2. Pribadi");
            System.out.print("Jenis tugas: ");
            int jenis = scan.nextInt();
            scan.nextLine();

            Tugas tugas = null;

            if (jenis == 1) {
                System.out.print("Mata kuliah: ");
                String mataKuliah = scan.nextLine();
                tugas = new TugasKuliah(nama, deadline, mataKuliah);

            } else if (jenis == 2) {
                System.out.print("kerjaan: ");
                nama = scan.nextLine();
                tugas = new TugasPribadi(nama, deadline);
            }

           try {
                manager.tambahTugas(tugas);
                System.out.println("Tugas berhasil ditambahkan!");

            } catch (IllegalArgumentException e) {
                System.out.println("Gagal menambahkan tugas: " + e.getMessage());
            }

            break;




            case 2:
                // tampilkan tugas
                 manager.tampilkanTugas();
                break;
            case 3:
                manager.ubahStatusTugas();
                manager.cekTugasTerlewat();
                // ubah status
                                 
                break;

            case 4:
                manager.tampilkanTugasTerlewat();
                // tampilkan tugas terlewat
                break;
            case 5: 
                manager.rekapTugasPerMataKuliah();
                break;
            case 6:
                sout("Program selesai.");
                scan.close();
                return;

            default:
                sout("Pilihan tidak valid.");
        }
        
    }

   
                    }
    }

