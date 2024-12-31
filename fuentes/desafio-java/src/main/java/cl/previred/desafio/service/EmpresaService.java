package cl.previred.desafio.service;

import cl.previred.desafio.exception.EmpresaAlreadyExistException;
import cl.previred.desafio.exception.EmpresaNotFoundException;
import cl.previred.desafio.exception.EmpresaNotModifiedException;
import cl.previred.desafio.model.EmpresaModel;

import java.util.List;

public interface EmpresaService {

    EmpresaModel createEmpresa(EmpresaModel empresaModel) throws EmpresaAlreadyExistException;
    EmpresaModel updateEmpresa(EmpresaModel empresaModel) throws EmpresaNotModifiedException, EmpresaNotFoundException;
    EmpresaModel findEmpresa(String empresaId) throws EmpresaNotFoundException;
    List<EmpresaModel> getAllEmpresas();
    void deleteEmpresa(String uid) throws EmpresaNotFoundException;
}
