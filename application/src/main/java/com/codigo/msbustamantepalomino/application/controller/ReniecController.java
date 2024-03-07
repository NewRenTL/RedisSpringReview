package com.codigo.msbustamantepalomino.application.controller;


import com.codigo.msbustamantepalomino.domain.aggregates.response.ResponseReniec;
import com.codigo.msbustamantepalomino.domain.ports.in.RestReniecIn;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@OpenAPIDefinition(
        info = @Info(
                title = "API-RENIEC",
                version = "1.0",
                description = "To maintenance of a person"
        )
)
@RestController
@RequestMapping("/v1/reniec")
@RequiredArgsConstructor
public class ReniecController {

    private final RestReniecIn restReniecIn;

    @Operation(summary = "Get information of a number",
    description = "Get information of a person by DNI number")
    @GetMapping("/inforeniec/{numero}")
    public ResponseEntity<ResponseReniec> getInfo(@PathVariable String numero)
    {
        return ResponseEntity.status(HttpStatus.OK).body(restReniecIn.getInfoIn(numero));
    }

}
