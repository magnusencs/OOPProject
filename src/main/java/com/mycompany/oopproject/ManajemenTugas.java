/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;
import java.util.Vector; 
import java.time.LocalDate;
/**
 *
 * @author msi39
 */
public class ManajemenTugas {
    private Vector<Tugas> listTugas;
    private Vector<Tugas> tugasTerlewat;
    public ManajemenTugas(){
        listTugas = new Vector<>();
        tugasTerlewat = new Vector<>();
    }
    
    public void tambahTugas(Tugas tugas) {
        listTugas.add(tugas);
    }

    public void tampilkanTugas() {
        for (Tugas t : listTugas) {
            t.tampilkanInfo();
            System.out.println("--------------------");
        }
    }
    
    public void cekTugasTerlewat(){
        LocalDate hariIni = LocalDate.now();
        tugasTerlewat.clear();
        for (Tugas t: listTugas ) {
            if (t.getDeadline().isBefore(hariIni ) && t.getStatus() == false)
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
}
