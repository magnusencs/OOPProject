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
public class Tugas {
    //enkapsusi
    private String namaTugas;
    private boolean statusSudah = false;
    private LocalDate deadline;
    public Tugas(String namaTugas, LocalDate deadline) {
        this.deadline = deadline;
        this.namaTugas = namaTugas;
    }
    public void setTrue(boolean s) {
        this.statusSudah = s;
    }
    public String getNama(){
        return namaTugas;
    }
    public boolean getStatus(){
        return statusSudah;
    }
    public LocalDate     getDeadline() {
        return this.deadline;
    }
    public void tampilkanInfo() {
    System.out.println("Nama     : " + namaTugas);
    System.out.println("Deadline : " + deadline);
    System.out.println("Status   : " + (statusSudah ? "Selesai" : "Belum selesai"));
}
    
}

