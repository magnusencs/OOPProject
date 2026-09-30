/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;
import java.time.LocalDate;

/**
 *
 * @author msi39
 */
public class TugasPribadi extends Tugas {
   
    //constructor yang memanggil definisi constructor dari superclass
    public TugasPribadi(String namaTugas, LocalDate deadline) {
        //
        super(namaTugas, deadline);
        
    }
   
    //polymorphism 
     @Override
    public void tampilkanInfo() {
        System.out.println("Tugas Pribadi");
        System.out.println("Nama     : " + getNama());
        System.out.println("Deadline : " + getDeadline());
        System.out.println("Status   : " + (getStatus() ? "Selesai" : "Belum selesai"));
    }
    
    
    
}
