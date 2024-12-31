package cl.previred.desafio.controller;

import cl.previred.desafio.controller.dto.BaseResponseDto;
import cl.previred.desafio.controller.dto.ResultCodeDto;
import cl.previred.desafio.exception.EmpresaAlreadyExistException;
import cl.previred.desafio.exception.EmpresaNotFoundException;
import cl.previred.desafio.model.EmpresaModel;
import cl.previred.desafio.service.EmpresaService;
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

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<List<EmpresaModel>> listEmpresa() {

        return new BaseResponseDto<>(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                empresaService.getAllEmpresas());
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<EmpresaModel> createEmpresa(@RequestBody EmpresaModel empresaModel) throws EmpresaAlreadyExistException {
        return new BaseResponseDto(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                empresaService.createEmpresa(empresaModel));
    }

    @GetMapping(value = "/{empresaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<EmpresaModel> findEmpresa(@PathVariable String empresaId) throws EmpresaNotFoundException {

        return new BaseResponseDto<>(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                empresaService.findEmpresa(empresaId));
    }
}
