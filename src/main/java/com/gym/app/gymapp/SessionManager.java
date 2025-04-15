package com.gym.app.gymapp;


import com.gym.app.gymapp.classes.Administrador;
import com.gym.app.gymapp.classes.Administrador;

public class SessionManager {
    private static SessionManager instance;
    private int userId;
    private String username;
    private boolean isAdmin;
    private Administrador adminData; // Nuevo campo para datos del administrador

    private SessionManager() {
        // Constructor privado para evitar instanciación directa
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Sobrecarga para administradores
    public void startAdminSession(Administrador admin) {
        this.userId = admin.getId_Administrador();
        this.username = admin.getNombre_Administrador();
        this.isAdmin = true;
        this.adminData = admin;
    }

    public void endSession() {
        this.userId = 0;
        this.username = null;
        this.isAdmin = false;
        this.adminData = null;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public Administrador getAdminData() {
        return adminData;
    }
}