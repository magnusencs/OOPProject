/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;
import java.util.Vector; 
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author msi39
 */ 
public class ManajemenTugas {
    Scanner scan = new Scanner(System.in);
    private Vector<Tugas> listTugas;
    private Vector<Tugas> tugasTerlewat;
    public ManajemenTugas(){
        listTugas = new Vector<>();
        tugasTerlewat = new Vector<>();
    }
    
    public void tambahTugas(Tugas tugas) {
        listTugas.add(tugas);
    }
    
    Vector<Tugas> getListTugas(){
        return listTugas;
    }
    

    public void tampilkanTugas() {
        int count = 1;
        for (Tugas t : listTugas) {
            System.out.println(count); t.tampilkanInfo();
            System.out.println( "--------------------");
            count += 1;
        }
    }
    
    public void cekTugasTerlewat(){
        LocalDate hariIni = LocalDate.now();
        tugasTerlewat.clear();
        for (Tugas t: listTugas ) {
            if (t.getDeadline().isBefore(hariIni ) && !t.getStatus())
            {
                tugasTerlewat.add(t);
            }
        }
    }
    
    public void tampilkanTugasTerlewat() {
        for (Tugas t : tugasTerlewat) {
            t.tampilkanInfo();
            System.out.println("Tugas terlewat: ");
        }
    }
    
    public boolean ubahStatusTugas() {
        if (listTugas.isEmpty()) {
           System.out.println("tidak ada tugas yang disimpan");
           return false;
        }
        else {
           
           int pilihNomor;
           do {
            tampilkanTugas();
            System.out.println("mau tugas yang nomor berapa? ");
            pilihNomor = scan.nextInt();
            scan.nextLine();
            if (pilihNomor<1 || pilihNomor> listTugas.size()) {
                System.out.println("angka tidak valid, coba lagi.");
            }
           } while (pilihNomor > listTugas.size() || pilihNomor < 1);
           System.out.println("status sudah? (y/n)");
           char status = scan.next().charAt(0);
           boolean s = (status == 'y'); 
           listTugas.get(pilihNomor-1).setStatus(s);
           return true;
        }
    }
    
    
   
}
