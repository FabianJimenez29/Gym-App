/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.app.gymapp.features;

import com.gym.app.gymapp.TipoDePago;
import com.gym.app.gymapp.classes.Pagos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabi
 */
public class PagosDAO {

    public boolean insertarPago(Pagos pago) {
        String sql = "{CALL InsertPayment(?, ?, ?, ?)}"; // Procedimiento sin ID de pago ni fecha (la BD lo maneja)

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, pago.getId_Administrador());
            stmt.setInt(2, pago.getId_Cliente());
            stmt.setString(3, pago.getTipo_Pago().name());
            stmt.setString(4, pago.getTipo_Membresia());// Convertir ENUM a String

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar pago: " + e.getMessage() + e.getSQLState() + e.getCause());
            e.printStackTrace();
            return false;
        }
    }

    // Método para editar un pago
    public boolean editarPago(Pagos pago) {
        String sql = "{CALL UpdatePayment(?, ?, ?, ?, ?, ?)}"; // Llamada al procedimiento almacenado

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, pago.getId_Pago());
            stmt.setInt(2, pago.getId_Administrador());
            stmt.setInt(3, pago.getId_Cliente());
            stmt.setString(4, pago.getTipo_Pago().name()); // Convertir ENUM a String
            stmt.setDate(5, pago.getFecha_Pago());
            stmt.setString(6, pago.getTipo_Membresia());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al editar pago: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un pago
    public boolean eliminarPago(int idPago) {
        String sql = "{CALL DeletePayment(?)}"; // Llamada al procedimiento almacenado

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idPago);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar pago: " + e.getMessage());
            return false;
        }
    }


    public List<Pagos> obtenerPagos() {
        List<Pagos> lista = new ArrayList<>();
        String sql = "SELECT * FROM payment";

        try (Connection conn = ConexionBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idPago = rs.getInt("Id_Payment");
                int idAdmin = rs.getInt("Id_Admin");
                int idCliente = rs.getInt("Id_Client");
                TipoDePago tipoPago = TipoDePago.valueOf(rs.getString("Pay_Type"));
                Date fecha = rs.getDate("Pay_date");
                String membresia = rs.getString("Name_Membership");

                lista.add(new Pagos(idPago, idAdmin, idCliente, tipoPago, fecha, membresia));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
