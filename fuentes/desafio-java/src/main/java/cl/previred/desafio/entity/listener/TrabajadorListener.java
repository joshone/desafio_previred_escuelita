package cl.previred.desafio.entity.listener;

import cl.previred.desafio.entity.TrabajadorEntity;
import cl.previred.desafio.util.Util;
import jakarta.persistence.PrePersist;

public class TrabajadorListener {

    @PrePersist
    public void prePersist(TrabajadorEntity trabajador) {

        if (!Util.validarRut(trabajador.getRut())) {
            throw new IllegalArgumentException("RUT no es válido.");
        }

        if (trabajador.getTrabajadorId() == null || trabajador.getTrabajadorId().isEmpty()) {
            String idGenerado = Util.generarIdentificadorUnico();
            trabajador.setTrabajadorId(idGenerado);
        }
    }
}
