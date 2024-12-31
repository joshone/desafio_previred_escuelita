package cl.previred.desafio.model;

import cl.previred.desafio.status.StatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class TrabajadorModel {

    @JsonProperty("rut")
    private String rut;
    @JsonProperty("uid")
    private UUID uid;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;
    @JsonProperty("apellido_materno")
    private String apellidoMaterno;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("empresa_uid")
    private String empresaUid;
    @JsonProperty("status")
    private StatusEnum status;

    public TrabajadorModel() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmpresaUid() {
        return empresaUid;
    }

    public void setEmpresaUid(String empresaUid) {
        this.empresaUid = empresaUid;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TrabajadorModel{" +
                "rut='" + rut + '\'' +
                ", uid=" + uid +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", direccion='" + direccion + '\'' +
                ", empresaUid='" + empresaUid + '\'' +
                ", status=" + status +
                '}';
    }
}
