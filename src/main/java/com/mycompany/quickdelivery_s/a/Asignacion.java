/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickdelivery_s.a;

/**
 *
 * @author yedel
 */
public class Asignacion {
    private int idAsignacion;
    private Paquete paquete;
    private Vehiculo vehiculo;

    public Asignacion(int idAsignacion, Paquete paquete, Vehiculo vehiculo) {
        this.idAsignacion = idAsignacion;
        this.paquete = paquete;
        this.vehiculo = vehiculo;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Asignacion{" + "idAsignacion=" + idAsignacion + ", paquete=" + paquete + ", vehiculo=" + vehiculo + '}';
    }
    
}
