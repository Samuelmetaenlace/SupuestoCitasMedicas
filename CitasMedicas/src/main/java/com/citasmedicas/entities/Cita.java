package com.citasmedicas.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fechaHora")
    private Date fechaHora;

    @Column(name = "motivoCita")
    private String motivoCita;

    @Column(name = "attribute11")
    private Integer attribute11;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "diagnostico_id")
    private Diagnostico diagnostico;

    public Cita(Date fechaHora, String motivoCita, Integer attribute11) {
        this.fechaHora = fechaHora;
        this.motivoCita = motivoCita;
        this.attribute11 = attribute11;

    }

    public Cita() {
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Integer getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(Integer attribute11) {
        this.attribute11 = attribute11;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fechaHora=" + fechaHora +
                ", motivoCita='" + motivoCita + '\'' +
                ", attribute11=" + attribute11 +
                '}';
    }
}
