/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickdelivery_s.a;

/**
 *
 * @author yedel
 */
public class Vehiculo {
    private int idVehiculo;
    private String placa;
    private String tipoVehiculo;
    private String estado;

    public Vehiculo(int idVehiculo, String placa, String tipoVehiculo, String estado) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.estado = estado;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", placa=" + placa + ", tipoVehiculo=" + tipoVehiculo + ", estado=" + estado + '}';
    }
    
}
