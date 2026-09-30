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
public class TugasKuliah extends Tugas {

    // ENCAPSULATION:
    // Atribut khusus TugasKuliah dibuat private
    private String mataKuliah;

    // INHERITANCE:
    // TugasKuliah mewarisi class Tugas menggunakan extends
    //
    // super():
    // Memanggil constructor milik superclass Tugas
    public TugasKuliah(String namaTugas, LocalDate deadline, String mataKuliah) {
        super(namaTugas, deadline);
        this.mataKuliah = mataKuliah;
    }

    // ENCAPSULATION:
    // Getter untuk mengakses atribut private
    public String getMataKuliah() {
        return mataKuliah;
    }

    // METHOD OVERRIDING:
    // Method ini memiliki nama dan parameter yang sama
    // dengan method di superclass.
    //
    // POLYMORPHISM:
    // Ketika object TugasKuliah disimpan sebagai reference Tugas
    // lalu method ini dipanggil, Java akan menjalankan versi
    // TugasKuliah ini.
    @Override
    public void tampilkanInfo() {
        System.out.println("Tugas Kuliah");
        System.out.println("Nama       : " + getNama());
        System.out.println("Mata Kuliah: " + mataKuliah);
        System.out.println("Deadline   : " + getDeadline());
        System.out.println("Status     : " + (getStatus() ? "Selesai" : "Belum selesai"));
    }
}
