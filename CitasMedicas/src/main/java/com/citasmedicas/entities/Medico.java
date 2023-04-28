package com.citasmedicas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "medicos")
public class Medico extends Usuario{

    private String numColegiado;

    @ManyToMany
    @JoinColumn(name = "pacientes_id")
    private List<Paciente> pacientes;

    @ManyToMany
    @JoinColumn(name = "citas_id")
    private List<Cita> citas;


    public Medico() {
    }

    public Medico(Long id, String nombre, String apellidos, String usuario, String clave, String numColegiado) {
        super(id, nombre, apellidos, usuario, clave);
        this.numColegiado = numColegiado;
    }


    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "numColegiado='" + numColegiado + '\'' +
                '}';
    }
}
