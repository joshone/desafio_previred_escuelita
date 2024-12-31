package cl.previred.desafio.repository;

import cl.previred.desafio.entity.TrabajadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrabajadorRepository extends JpaRepository<TrabajadorEntity, Long> {

    TrabajadorEntity findByTrabajadorId(String trabajadorId);
    TrabajadorEntity findByUid(UUID uid);
    List<TrabajadorEntity> findByNombreLikeAndApellidoPaternoLikeAndApellidoMaternoLike(String nombre, String apellidoPaterno, String apellidoMaterno);


}
