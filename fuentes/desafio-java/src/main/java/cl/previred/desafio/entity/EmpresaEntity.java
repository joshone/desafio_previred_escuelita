package cl.previred.desafio.entity;

import cl.previred.desafio.entity.listener.EmpresaListener;
import cl.previred.desafio.status.StatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Empresa")
@EntityListeners({AuditingEntityListener.class, EmpresaListener.class})
public class EmpresaEntity {

    @Id
    @Column(name = "empresa_id", length = 50, nullable = false, unique = true)
    private String empresaId;

    @JdbcTypeCode(Types.CHAR)
    @Column(name = "uid", nullable = false)
    private UUID uid;

    @Column(name = "rut")
    private String rut;

    @Column(name = "razon_social")
    @JsonProperty("razon_social")
    private String razonSocial;

    @CreatedDate
    @JsonProperty("created_at")
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrabajadorEntity> trabajadores;

    public String getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public List<TrabajadorEntity> getTrabajadores() {
        return trabajadores;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum sttus) {
        this.status = sttus;
    }

    public void setTrabajadores(List<TrabajadorEntity> trabajadores) {
        this.trabajadores = trabajadores;
    }
}
