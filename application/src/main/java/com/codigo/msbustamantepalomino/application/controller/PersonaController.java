package com.codigo.msbustamantepalomino.application.controller;


import com.codigo.msbustamantepalomino.domain.aggregates.dto.PersonaDTO;
import com.codigo.msbustamantepalomino.domain.aggregates.requests.RequestPersona;
import com.codigo.msbustamantepalomino.domain.ports.in.PersonServiceIn;
import feign.Response;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@OpenAPIDefinition(
        info = @Info(
                title = "API-PERSON",
                version =  "2.0",
                description = "Create,Update,Delete,Post of API PERSON"
        )
)

@RestController
@RequestMapping("/v2/persona")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonServiceIn personServiceIn;


    @Operation(summary = "Create a person",
    description = "To create a person with a body")
    @PostMapping
    public ResponseEntity<PersonaDTO> register(@RequestBody RequestPersona requestPersona)
    {
        return ResponseEntity.
                status(HttpStatus.CREATED).
                    body(personServiceIn.
                            crearPersonaIn(requestPersona));
    }


    @Operation(summary = "Get a person by DNI",
    description = "Get only a person by DNI")
    @GetMapping("/{dni}")
    public ResponseEntity<PersonaDTO> getPerson(@PathVariable String dni)
    {
        return ResponseEntity.
                status(HttpStatus.OK).
                    body(personServiceIn.obtenerPersonDocuIn(dni).get());
    }

    @Operation(summary = "Get a person by id"
    ,description = "Get only a person who has the same id")
    @GetMapping("/getid/{id}")
    public ResponseEntity<PersonaDTO> getPerson2(@PathVariable Long id)
    {
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(personServiceIn.obtenerPersonaIn(id).get());
    }

    @Operation(summary ="Get all the people",
    description = "Get all the people by Get Method")
    @GetMapping
    public ResponseEntity<List<PersonaDTO>> getAllEstateTrue()
    {
        return ResponseEntity.
                status(HttpStatus.OK).
                    body(personServiceIn.obtenerTodosEstadoIn());
    }


    @Operation(summary = "Update by Id",
    description = "Update a person by Id")
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> update(@PathVariable Long id,@RequestBody RequestPersona requestPersona)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                    .body(personServiceIn.actualizarIn(id,requestPersona));
    }

    @Operation(summary = "Delete a person by Id",
    description = "Delete a person by ID in our person database")
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaDTO> delete(@PathVariable Long id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personServiceIn.deleteIn(id));
    }

}
