/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author yedel
 */
public class PaqueteDAO {
    private int idPaquete;
    private String descripcion;
    private String estado;

    public PaqueteDAO(int idPaquete, String descripcion, String estado) {
        this.idPaquete = idPaquete;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paquete{" + "idPaquete=" + idPaquete + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }
}
