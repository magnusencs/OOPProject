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
public abstract class Tugas implements DapatDitandai{
    //enkapsulasi
    private String namaTugas;
    private boolean statusSudah = false;
    private LocalDate deadline;
    public Tugas(String namaTugas, LocalDate deadline) {
        
        this.deadline = deadline;
        this.namaTugas = namaTugas;
    }
    public void setStatus(boolean s) {
        this.statusSudah = s;
    }
    public String getNama(){
        return namaTugas;
    }
    public boolean getStatus(){
        return statusSudah;
    }
    public LocalDate getDeadline() {
        return this.deadline;
    }
    public void setNama(String namaTugas) {
    if (namaTugas == null || namaTugas.isBlank()) {
        return;
    }
    this.namaTugas = namaTugas;
}

public void setDeadline(LocalDate deadline) {
    if (deadline == null) {
        return;
    }
    this.deadline = deadline;
}
public abstract void tampilkanInfo();
    
}

