/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickdelivery_s.a;

import java.util.Date;

/**
 *
 * @author yedel
 */
public class Incidencias {
    
    private int idIncidencia;
    private String descripcion;
    private Date fecha;

    public Incidencias(int idIncidencia, String descripcion, Date fecha) {
        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Incidencias{" + "idIncidencia=" + idIncidencia + ", descripcion=" + descripcion + ", fecha=" + fecha + '}';
    }
    
}
