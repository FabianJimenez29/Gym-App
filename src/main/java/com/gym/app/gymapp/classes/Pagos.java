/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.app.gymapp.classes;

import com.gym.app.gymapp.TipoDePago;
import java.sql.Date;

/**
 *
 * @author fabi
 */
public class Pagos {
    
    private int Id_Pago;
    private int Id_Administrador;
    private int Id_Cliente;
    private TipoDePago Tipo_Pago;
    private Date Fecha_Pago;

    public Pagos(int Id_Pago, int Id_Administrador, int Id_Cliente, TipoDePago Tipo_Pago, Date Fecha_Pago) {
        this.Id_Pago = Id_Pago;
        this.Id_Administrador = Id_Administrador;
        this.Id_Cliente = Id_Cliente;
        this.Tipo_Pago = Tipo_Pago;
        this.Fecha_Pago = Fecha_Pago;
    }

    public int getId_Pago() {
        return Id_Pago;
    }

    public void setId_Pago(int Id_Pago) {
        this.Id_Pago = Id_Pago;
    }

    public int getId_Administrador() {
        return Id_Administrador;
    }

    public void setId_Administrador(int Id_Administrador) {
        this.Id_Administrador = Id_Administrador;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public TipoDePago getTipo_Pago() {
        return Tipo_Pago;
    }

    public void setTipo_Pago(TipoDePago Tipo_Pago) {
        this.Tipo_Pago = Tipo_Pago;
    }

    public Date getFecha_Pago() {
        return Fecha_Pago;
    }

    public void setFecha_Pago(Date Fecha_Pago) {
        this.Fecha_Pago = Fecha_Pago;
    }
    
    
    
    
}
