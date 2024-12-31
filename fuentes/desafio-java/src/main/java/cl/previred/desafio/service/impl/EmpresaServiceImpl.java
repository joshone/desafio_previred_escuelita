package cl.previred.desafio.service.impl;

import cl.previred.desafio.entity.EmpresaEntity;
import cl.previred.desafio.entity.TrabajadorEntity;
import cl.previred.desafio.exception.EmpresaAlreadyExistException;
import cl.previred.desafio.exception.EmpresaNotFoundException;
import cl.previred.desafio.exception.EmpresaNotModifiedException;
import cl.previred.desafio.model.EmpresaModel;
import cl.previred.desafio.model.TrabajadorModel;
import cl.previred.desafio.repository.EmpresaRepository;
import cl.previred.desafio.service.EmpresaService;
import cl.previred.desafio.util.EntityUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public EmpresaModel createEmpresa(EmpresaModel empresaModel) throws EmpresaAlreadyExistException {
        EmpresaEntity empresaEntityToCreate = EntityUtilities.copyObjectFrom(empresaModel, EmpresaEntity.class);
        EmpresaEntity empresaEntityExist = empresaRepository.findByRutLikeAndRazonSocialLike(empresaEntityToCreate.getRut(), empresaEntityToCreate.getRazonSocial());

        if (empresaEntityExist != null) {
            throw new EmpresaAlreadyExistException("Empresa ya existe");
        } else {
            empresaEntityToCreate = empresaRepository.save(empresaEntityToCreate);
        }

        return EntityUtilities.copyObjectFrom(empresaEntityToCreate, EmpresaModel.class);
    }

    @Override
    public EmpresaModel updateEmpresa(EmpresaModel empresaModel) throws EmpresaNotModifiedException, EmpresaNotFoundException {

        EmpresaEntity empresaEntity = empresaRepository.findByRutLikeAndRazonSocialLike(empresaModel.getRut(), empresaModel.getRazonSocial());
        if (empresaEntity == null) {
            throw new EmpresaNotFoundException("Empresa no encontrado");
        }

        try {
            empresaEntity.setRazonSocial(empresaModel.getRazonSocial());
            empresaEntity.setRut(empresaModel.getRut());
            empresaEntity = empresaRepository.save(empresaEntity);
        } catch (Exception e) {
            throw new EmpresaNotModifiedException("No fue posible modificar la empresa");
        }

        return EntityUtilities.copyObjectFrom(empresaEntity, EmpresaModel.class);
    }

    @Override
    public boolean deleteEmpresa(EmpresaModel empresaModel) {
        // por lo general no borro, actualizo el status
        return false;
    }

    @Override
    public EmpresaModel findEmpresa(String empresaId) throws EmpresaNotFoundException {

        EmpresaEntity empresaEntity = empresaRepository.findByEmpresaId(empresaId);
        if(empresaEntity == null) {
            throw new EmpresaNotFoundException("Empresa no encontrado");
        }
        List<TrabajadorEntity> trabajadorEntities = empresaEntity.getTrabajadores();
        empresaEntity.setTrabajadores(null);
        List<TrabajadorModel> trabajadoresModel = trabajadorEntities.stream().map(t -> EntityUtilities.copyObjectFrom(t, TrabajadorModel.class)).collect(Collectors.toList());
        EmpresaModel empresaModel = EntityUtilities.copyObjectFrom(empresaEntity, EmpresaModel.class);
        empresaModel.setTrabajadores(trabajadoresModel);
        return empresaModel;
    }

    @Override
    public List<EmpresaModel> getAllEmpresas() {
        List<EmpresaEntity> list = empresaRepository.findAll();
        return list.stream()
                .map(l -> {
                    EmpresaModel empresaModel = new EmpresaModel();
                    empresaModel.setRut(l.getRut());
                    empresaModel.setCreatedAt(l.getCreatedAt());
                    empresaModel.setRazonSocial(l.getRazonSocial());
                    empresaModel.setUid(l.getUid());
                    empresaModel.setStatus(l.getStatus());
                    if (l.getTrabajadores().isEmpty()){
                        empresaModel.setTrabajadores(new ArrayList<>());
                    } else {
                        List<TrabajadorModel> trabajadorModels = l.getTrabajadores()
                                .stream()
                                .map(t -> {
                                    TrabajadorModel trabajadorModel = new TrabajadorModel();
                                    trabajadorModel.setRut(t.getRut());
                                    trabajadorModel.setApellidoPaterno(t.getApellidoPaterno());
                                    trabajadorModel.setApellidoMaterno(t.getApellidoMaterno());
                                    trabajadorModel.setNombre(t.getNombre());
                                    trabajadorModel.setDireccion(t.getDireccion());

                                    return trabajadorModel;
                                }).collect(Collectors.toList());
                        empresaModel.setTrabajadores(trabajadorModels);
                    }

                    return empresaModel;
                })
                .collect(Collectors.toList());
    }
}
