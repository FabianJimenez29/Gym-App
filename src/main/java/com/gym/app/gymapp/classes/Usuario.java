/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.app.gymapp.classes;

/**
 *
 * @author fabi
 */
public class Usuario {
    
    private int Id_Cliente;
    private String nombre_Cliente;
    private String apellido_Cliente;
    private int edad_Cliente;
    private int numero_Cliente;
    private String correo_Cliente;

    public Usuario(int Id_Cliente, String nombre_Cliente, String apellido_Cliente, int edad_Cliente, int numero_Cliente, String correo_Cliente) {
        this.Id_Cliente = Id_Cliente;
        this.nombre_Cliente = nombre_Cliente;
        this.apellido_Cliente = apellido_Cliente;
        this.edad_Cliente = edad_Cliente;
        this.numero_Cliente = numero_Cliente;
        this.correo_Cliente = correo_Cliente;
    }

    public Usuario() {
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public String getNombre_Cliente() {
        return nombre_Cliente;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        this.nombre_Cliente = nombre_Cliente;
    }

    public String getApellido_Cliente() {
        return apellido_Cliente;
    }

    public void setApellido_Cliente(String apellido_Cliente) {
        this.apellido_Cliente = apellido_Cliente;
    }

    public int getEdad_Cliente() {
        return edad_Cliente;
    }

    public void setEdad_Cliente(int edad_Cliente) {
        this.edad_Cliente = edad_Cliente;
    }

    public int getNumero_Cliente() {
        return numero_Cliente;
    }

    public void setNumero_Cliente(int numero_Cliente) {
        this.numero_Cliente = numero_Cliente;
    }

    public String getCorreo_Cliente() {
        return correo_Cliente;
    }

    public void setCorreo_Cliente(String correo_Cliente) {
        this.correo_Cliente = correo_Cliente;
    }

    
    
}
