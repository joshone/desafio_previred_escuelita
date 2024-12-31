package cl.previred.desafio.service;

import cl.previred.desafio.exception.TrabajadorNotCreatedException;
import cl.previred.desafio.exception.TrabajadorNotFoundException;
import cl.previred.desafio.model.TrabajadorModel;

import java.util.List;

public interface TrabajadorService {
    List<TrabajadorModel> getAll();
    List<TrabajadorModel> getTrabajador(TrabajadorModel trabajadorModel);
    boolean deleteTTrabajador(TrabajadorModel trabajadorModel);
    TrabajadorModel updateTrabajador(TrabajadorModel trabajadorModel) throws TrabajadorNotFoundException;
    TrabajadorModel create(TrabajadorModel trabajadorModel) throws TrabajadorNotFoundException, TrabajadorNotCreatedException;
}
