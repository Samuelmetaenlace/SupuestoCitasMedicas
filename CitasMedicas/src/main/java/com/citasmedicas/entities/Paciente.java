package com.citasmedicas.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente extends Usuario{


    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;

    @ManyToMany
    @JoinColumn(name = "medicos_id")
    private List<Medico> medicos;

    @ManyToMany
    @JoinColumn(name = "citas_id")
    private List<Cita> citas;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellidos, String usuario, String clave, String NSS, String numTarjeta, String telefono, String direccion) {
        super(id, nombre, apellidos, usuario, clave);
        this.NSS = NSS;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
    }


    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "NSS='" + NSS + '\'' +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
