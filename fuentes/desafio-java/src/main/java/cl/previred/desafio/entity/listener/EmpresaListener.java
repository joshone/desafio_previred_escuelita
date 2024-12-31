package cl.previred.desafio.entity.listener;


import cl.previred.desafio.entity.EmpresaEntity;
import cl.previred.desafio.status.StatusEnum;
import cl.previred.desafio.util.Util;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;
import java.util.UUID;

public class EmpresaListener {
    @PrePersist
    public void prePersist(EmpresaEntity empresa) {

        if (!Util.validarRut(empresa.getRut())) {
            throw new IllegalArgumentException("RUT de la empresa no es válido.");
        }
        empresa.setUid(UUID.randomUUID());
        empresa.setCreatedAt(LocalDateTime.now());
        empresa.setStatus(StatusEnum.ACTIVE);

        if (empresa.getEmpresaId() == null || empresa.getEmpresaId().isEmpty()) {
            String idGenerado = Util.generarIdentificadorUnico();
            empresa.setEmpresaId(idGenerado);
        }
    }


}
