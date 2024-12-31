package cl.previred.desafio.controller;

import cl.previred.desafio.controller.dto.BaseResponseDto;
import cl.previred.desafio.controller.dto.ResultCodeDto;
import cl.previred.desafio.exception.TrabajadorNotCreatedException;
import cl.previred.desafio.exception.TrabajadorNotFoundException;
import cl.previred.desafio.model.EmpresaModel;
import cl.previred.desafio.model.TrabajadorModel;
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
    public BaseResponseDto<EmpresaModel> createTrabajador(@RequestBody TrabajadorModel trabajadorModel) throws TrabajadorNotCreatedException, TrabajadorNotFoundException {
        return new BaseResponseDto(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                trabajadorService.create(trabajadorModel));
    }

    @Operation(summary = "Actualiza un trabajador")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<EmpresaModel> updateTrabajador(@RequestBody TrabajadorModel trabajadorModel) throws TrabajadorNotFoundException {
        return new BaseResponseDto(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                trabajadorService.updateTrabajador(trabajadorModel));
    }

    @Operation(summary = "Busca un trabajador con su UID")
    @GetMapping(value = "/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<TrabajadorModel> search(@PathVariable String uid) throws TrabajadorNotFoundException {

        return new BaseResponseDto<>(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                trabajadorService.search(uid));
    }

    @Operation(summary = "Desactiva un trabajador con su UID")
    @DeleteMapping(value = "/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Void> deleteEmpresa(@PathVariable String uid) throws TrabajadorNotFoundException {

        trabajadorService.deleteTrabajador(uid);
        return new BaseResponseDto<>(ResultCodeDto.SUCCESS,
                "Servicio ejecutado correctamente",
                null);
    }

}
