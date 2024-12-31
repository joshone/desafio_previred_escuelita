package cl.previred.desafio.controller;

import cl.previred.desafio.controller.dto.BaseResponseDto;
import cl.previred.desafio.controller.dto.ResultCodeDto;
import cl.previred.desafio.exception.EmpresaAlreadyExistException;
import cl.previred.desafio.exception.EmpresaNotFoundException;
import cl.previred.desafio.exception.EmpresaNotModifiedException;
import cl.previred.desafio.model.EmpresaModel;
import cl.previred.desafio.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Operation(summary = "Obtener lista de empresas",
            description = "Devuelve todas las empresas registradas en el sistema.")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<List<EmpresaModel>> listEmpresa() {

        return new BaseResponseDto<>(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                empresaService.getAllEmpresas());
    }

    @Operation(summary = "Crear una nueva empresa")
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<EmpresaModel> createEmpresa(@RequestBody EmpresaModel empresaModel) throws EmpresaAlreadyExistException {
        return new BaseResponseDto(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                empresaService.createEmpresa(empresaModel));
    }

    @Operation(summary = "Actualiza una empresa")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<EmpresaModel> updateEmpresa(@RequestBody EmpresaModel empresaModel) throws EmpresaNotModifiedException, EmpresaNotFoundException {
        return new BaseResponseDto(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                empresaService.updateEmpresa(empresaModel));
    }

    @Operation(summary = "Busca una empresa con su UID")
    @GetMapping(value = "/{empresaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<EmpresaModel> findEmpresa(@PathVariable String uid) throws EmpresaNotFoundException {

        return new BaseResponseDto<>(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                empresaService.findEmpresa(uid));
    }

    @Operation(summary = "Desactiva una empresa con su UID")
    @DeleteMapping(value = "/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Void> deleteEmpresa(@PathVariable String uid) throws EmpresaNotFoundException {

        empresaService.deleteEmpresa(uid);
        return new BaseResponseDto<>(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                null);
    }
}
