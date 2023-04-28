package com.citasmedicas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnosticos")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valoracionEspecialista;

    private String enfermedad;

    @OneToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;

    public Diagnostico(String valoracionEspecialista, String enfermedad) {
        this.valoracionEspecialista = valoracionEspecialista;
        this.enfermedad = enfermedad;
    }

    public Diagnostico() {
    }

    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }

    public void setValoracionEspecialista(String valoracionEspecialista) {
        this.valoracionEspecialista = valoracionEspecialista;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "valoracionEspecialista='" + valoracionEspecialista + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                '}';
    }
}
