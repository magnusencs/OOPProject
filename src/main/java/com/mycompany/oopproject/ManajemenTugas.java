/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;
import java.util.Vector;
/**
 *
 * @author msi39
 */
public class ManajemenTugas {
    Vector<Tugas> listTugas;
    public ManajemenTugas(){
        listTugas = new Vector<>();
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
}
