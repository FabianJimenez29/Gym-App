
package com.gym.app.gymapp.classes;

import com.gym.app.gymapp.TipoMembresia;
import java.sql.Date;

/**
 *
 * @author fabi
 */
public class Membresias {
    private int Id_Membresia;
    private String Nombre_Membresia;
    private String Duracion_Membresia;
    private float Precio_Membresia;
    private TipoMembresia Tipo_Membresia;

    public Membresias(int Id_Membresia, String Nombre_Membresia, String Duracion_Membresia, float Precio_Membresia, TipoMembresia Tipo_Membresia) {
        this.Id_Membresia = Id_Membresia;
        this.Nombre_Membresia = Nombre_Membresia;
        this.Duracion_Membresia = Duracion_Membresia;
        this.Precio_Membresia = Precio_Membresia;
        this.Tipo_Membresia = Tipo_Membresia;
    }

    public int getId_Membresia() {
        return Id_Membresia;
    }

    public void setId_Membresia(int Id_Membresia) {
        this.Id_Membresia = Id_Membresia;
    }

    public String getNombre_Membresia() {
        return Nombre_Membresia;
    }

    public void setNombre_Membresia(String Nombre_Membresia) {
        this.Nombre_Membresia = Nombre_Membresia;
    }

    public String getDuracion_Membresia() {
        return Duracion_Membresia;
    }

    public void setDuracion_Membresia(String Duracion_Membresia) {
        this.Duracion_Membresia = Duracion_Membresia;
    }

    public float getPrecio_Membresia() {
        return Precio_Membresia;
    }

    public void setPrecio_Membresia(float Precio_Membresia) {
        this.Precio_Membresia = Precio_Membresia;
    }

    public TipoMembresia getTipo_Membresia() {
        return Tipo_Membresia;
    }

    public void setTipo_Membresia(TipoMembresia Tipo_Membresia) {
        this.Tipo_Membresia = Tipo_Membresia;
    }
    
    
    
    
    
}
