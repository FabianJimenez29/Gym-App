/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.app.gymapp.classes;

/**
 *
 * @author fabi
 */
public class Administrador {
    
    private int Id_Administrador;
    private String nombre_Administrador;
    private String apellido_Administrador;
    private int edad_Administrador;
    private int numero_Administrador;
    private String correo_Administrador;
    private String contrasena_Administrador;

    public Administrador(int Id_Administrador, String nombre_Administrador, String apellido_Administrador, int edad_Administrador, int numero_Administrador, String correo_Administrador, String contrasena_Administrador) {
        this.Id_Administrador = Id_Administrador;
        this.nombre_Administrador = nombre_Administrador;
        this.apellido_Administrador = apellido_Administrador;
        this.edad_Administrador = edad_Administrador;
        this.numero_Administrador = numero_Administrador;
        this.correo_Administrador = correo_Administrador;
        this.contrasena_Administrador = contrasena_Administrador;
    }

    public int getId_Administrador() {
        return Id_Administrador;
    }

    public void setId_Administrador(int Id_Administrador) {
        this.Id_Administrador = Id_Administrador;
    }

    public String getNombre_Administrador() {
        return nombre_Administrador;
    }

    public void setNombre_Administrador(String nombre_Administrador) {
        this.nombre_Administrador = nombre_Administrador;
    }

    public String getApellido_Administrador() {
        return apellido_Administrador;
    }

    public void setApellido_Administrador(String apellido_Administrador) {
        this.apellido_Administrador = apellido_Administrador;
    }

    public int getEdad_Administrador() {
        return edad_Administrador;
    }

    public void setEdad_Administrador(int edad_Administrador) {
        this.edad_Administrador = edad_Administrador;
    }

    public int getNumero_Administrador() {
        return numero_Administrador;
    }

    public void setNumero_Administrador(int numero_Administrador) {
        this.numero_Administrador = numero_Administrador;
    }

    public String getCorreo_Administrador() {
        return correo_Administrador;
    }

    public void setCorreo_Administrador(String correo_Administrador) {
        this.correo_Administrador = correo_Administrador;
    }

    public String getContrasena_Administrador() {
        return contrasena_Administrador;
    }

    public void setContrasena_Administrador(String contrasena_Administrador) {
        this.contrasena_Administrador = contrasena_Administrador;
    }
    
    
    
    

    
}