package cl.previred.desafio.repository;

import cl.previred.desafio.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, String> {

    EmpresaEntity findByRutLike(String rut);
    EmpresaEntity findByRazonSocialLike(String razonSocial);
    EmpresaEntity findByRutLikeAndRazonSocialLike(String rut, String razonSocial);
    EmpresaEntity findByEmpresaId(String empresaId);
}