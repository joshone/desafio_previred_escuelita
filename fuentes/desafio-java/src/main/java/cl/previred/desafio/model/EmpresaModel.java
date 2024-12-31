package cl.previred.desafio.model;

import cl.previred.desafio.status.StatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class EmpresaModel {

    @JsonProperty("rut")
    private String rut;
    @JsonProperty("uid")
    private UUID uid;
    @JsonProperty("razon_social")
    private String razonSocial;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("status")
    private StatusEnum status;

    @JsonProperty("trabajadores")
    private List<TrabajadorModel> trabajadores;

    public EmpresaModel() {
    }

    public EmpresaModel(String rut, UUID uid, String razonSocial, LocalDateTime createdAt, StatusEnum status, List<TrabajadorModel> trabajadores) {
        this.rut = rut;
        this.uid = uid;
        this.razonSocial = razonSocial;
        this.createdAt = createdAt;
        this.status = status;
        this.trabajadores = trabajadores;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<TrabajadorModel> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<TrabajadorModel> trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public String toString() {
        return "EmpresaModel{" +
                "rut='" + rut + '\'' +
                ", uid=" + uid +
                ", razonSocial='" + razonSocial + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", trabajadores=" + trabajadores +
                '}';
    }
}
