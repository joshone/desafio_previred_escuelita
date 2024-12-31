package cl.previred.desafio.controller;

import cl.previred.desafio.controller.dto.BaseResponseDto;
import cl.previred.desafio.controller.dto.ResultCodeDto;
import cl.previred.desafio.exception.EmpresaAlreadyExistException;
import cl.previred.desafio.exception.EmpresaNotFoundException;
import cl.previred.desafio.exception.TrabajadorNotCreatedException;
import cl.previred.desafio.exception.TrabajadorNotFoundException;
import cl.previred.desafio.model.EmpresaModel;
import cl.previred.desafio.model.TrabajadorModel;
import cl.previred.desafio.service.EmpresaService;
import cl.previred.desafio.service.TrabajadorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trabajador")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;


    @Operation(summary = "Lista los trabajadores")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<List<TrabajadorModel>> listTrabajadores() {

        return new BaseResponseDto<>(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                trabajadorService.getAll());
    }

    @Operation(summary = "Crear un trabajador")
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<EmpresaModel> createEmpresa(@RequestBody TrabajadorModel trabajadorModel) throws TrabajadorNotCreatedException, TrabajadorNotFoundException {
        return new BaseResponseDto(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                trabajadorService.create(trabajadorModel));
    }

}
