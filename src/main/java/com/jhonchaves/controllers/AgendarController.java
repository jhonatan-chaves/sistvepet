package com.jhonchaves.controllers;
import com.jhonchaves.RecordsDTO.AgendarRequestDTO;
import com.jhonchaves.enums.StatusEnum;
import com.jhonchaves.models.AgendarModel;
import com.jhonchaves.repository.AgendarRepository;
import com.jhonchaves.services.AgendarService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/agendar")
public class AgendarController {

    @Autowired
    private AgendarService agendarService;

    @Autowired
    private AgendarRepository agendarRepository;

    @Operation(summary = "Agendar consulta", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição invalidos"),
            @ApiResponse(responseCode = "400", description = "Parametros invalidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),

    })
    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody  AgendarRequestDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(agendarService.save(data));
    }

   /* @GetMapping("/")
    public List<AgendarResponseDTO> getAll(){
        List<AgendarResponseDTO> lista = agendarRepository.findAll().stream().map(AgendarResponseDTO::new).toList();
        return lista;
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<AgendarModel> gatAgendamento(@PathVariable(value = "id") Long id){
        return agendarRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


    @GetMapping("/")
    public List<AgendarModel> listarConsultasPorStatus(@RequestParam(required = false) StatusEnum status,
                                                       @RequestParam(required = true)
                                                       @DateTimeFormat(pattern = "yyyy-MM-dd")Date dataHoraConsulta,
                                                       @RequestParam(required = false) String cpf) {
        if (status != null || dataHoraConsulta != null) {
            return agendarService.listarConsultasPorStatus(status, dataHoraConsulta, cpf);
        } else {
            return agendarRepository.findAll();
        }
    }
}
