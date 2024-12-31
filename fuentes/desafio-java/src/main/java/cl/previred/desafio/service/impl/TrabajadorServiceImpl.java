package cl.previred.desafio.service.impl;

import cl.previred.desafio.entity.TrabajadorEntity;
import cl.previred.desafio.exception.TrabajadorNotCreatedException;
import cl.previred.desafio.exception.TrabajadorNotFoundException;
import cl.previred.desafio.model.TrabajadorModel;
import cl.previred.desafio.repository.TrabajadorRepository;
import cl.previred.desafio.service.TrabajadorService;
import cl.previred.desafio.status.StatusEnum;
import cl.previred.desafio.util.EntityUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public List<TrabajadorModel> getAll() {
        List<TrabajadorEntity> list = trabajadorRepository.findAll();

        return list.stream()
                .map(l -> {
                    TrabajadorModel m = new TrabajadorModel();
                    m.setNombre(l.getNombre());
                    m.setApellidoPaterno(l.getApellidoPaterno());
                    m.setApellidoMaterno(l.getApellidoMaterno());
                    m.setRut(l.getRut());
                    m.setDireccion(l.getDireccion());
                    return m;
                })
                .collect(Collectors.toList());
    }

    @Override
    public TrabajadorModel search(String uid) throws TrabajadorNotFoundException {

        TrabajadorEntity trabajador = trabajadorRepository.findByUid(UUID.fromString(uid));
        if (trabajador == null) {
            throw new TrabajadorNotFoundException("Trabajador no encontrado");
        }

        return EntityUtilities.copyObjectFrom(trabajador, TrabajadorModel.class);
    }

    @Override
    public List<TrabajadorModel> getTrabajador(TrabajadorModel trabajadorModel) {
        List<TrabajadorEntity> trabajadorEntityList = trabajadorRepository.findByNombreLikeAndApellidoPaternoLikeAndApellidoMaternoLike(trabajadorModel.getNombre(), trabajadorModel.getApellidoPaterno(), trabajadorModel.getApellidoMaterno());

        return trabajadorEntityList.stream()
                .map(t -> EntityUtilities.copyObjectFrom(t, TrabajadorModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTrabajador(String uid) throws TrabajadorNotFoundException {
        TrabajadorEntity trabajadorEntity = trabajadorRepository.findByUid(UUID.fromString(uid));

        if (trabajadorEntity == null) {
            throw new TrabajadorNotFoundException("Trabajador no encontrado");
        }
        trabajadorEntity.setStatus(StatusEnum.DELETED);
        trabajadorRepository.save(trabajadorEntity);
    }

    @Override
    public TrabajadorModel updateTrabajador(TrabajadorModel trabajadorModel) throws TrabajadorNotFoundException {
        List<TrabajadorEntity> trabajadorEntityList = trabajadorRepository
                .findByNombreLikeAndApellidoPaternoLikeAndApellidoMaternoLike(
                        trabajadorModel.getNombre(),
                        trabajadorModel.getApellidoPaterno(),
                        trabajadorModel.getApellidoMaterno());

        if (trabajadorEntityList.isEmpty()) {
            throw new TrabajadorNotFoundException("No se encontró el trabajador");
        }
        List<TrabajadorModel> trabajadorModelList = trabajadorEntityList.stream()
                .map(t -> EntityUtilities.copyObjectFrom(t, TrabajadorModel.class))
                .collect(Collectors.toList());

        return trabajadorModelList.get(0);
    }

    @Override
    public TrabajadorModel create(TrabajadorModel trabajadorModel) throws TrabajadorNotFoundException, TrabajadorNotCreatedException {
        TrabajadorEntity trabajadorToCreate = EntityUtilities.copyObjectFrom(trabajadorModel, TrabajadorEntity.class);
        List<TrabajadorEntity> trabajadorExist = trabajadorRepository.findByNombreLikeAndApellidoPaternoLikeAndApellidoMaternoLike(trabajadorModel.getNombre(),
                trabajadorModel.getApellidoPaterno(),
                trabajadorModel.getApellidoMaterno());

        if(trabajadorExist.isEmpty()) {
            throw new TrabajadorNotFoundException("Trabajador no encontrado");
        }
        try {
            trabajadorToCreate = trabajadorRepository.save(trabajadorToCreate);
        } catch (Exception e) {
            throw new TrabajadorNotCreatedException("No fue posible crear el trabajador");
        }

        return EntityUtilities.copyObjectFrom(trabajadorToCreate, TrabajadorModel.class);
    }
}
