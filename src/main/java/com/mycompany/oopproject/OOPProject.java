/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oopproject;

import java.util.Scanner;
import java.util.Vector;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
    Vector <Tugas> listTugas = new Vector <>();
    int inp;

    Scanner scan = new Scanner(System.in);

    while (true) {
        sout("TASKFLOW");
        sout("1. tambah tugas");
        sout("2. tunjukkan tugas");
        sout("3. Ubah status tugas");
        sout("4. tunjukkan tugas yang terlewat");
        sout("5. exit");

        inp = scan.nextInt();
        scan.nextLine();
       

        // sout(inp);
        switch (inp) {
            case 1:
                // tambah tugas
                //String nama;
                sout("nama tugas: ");
                String nama = scan.nextLine();
                System.out.print("Deadline (dd-MM-yyyy): ");
                String inputDeadline = scan.nextLine();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate deadline = LocalDate.parse(inputDeadline, format);

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
                    System.out.print("Kategori: ");
                    nama = scan.nextLine();
                    tugas = new TugasPribadi(nama, deadline);
                }

                if (tugas != null) {
                    listTugas.add(tugas);
                }

                break;

                
               

            case 2:
                // tampilkan tugas
                 if (listTugas.isEmpty()) {
                    System.out.println("Belum ada tugas.");
                } else {
                    for ( Tugas t : listTugas) {
                        t.tampilkanInfo();
                        System.out.println("--------------------");
                    }
                }
                break;
              

            case 3:
                // ubah status
                break;

            case 4:
                // tampilkan tugas terlewat
                break;

            case 5:
                sout("Program selesai.");
                scan.close();
                return;

            default:
                sout("Pilihan tidak valid.");
        }
        
    }

   
                    }
    }

