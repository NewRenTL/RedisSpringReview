package com.codigo.msbustamantepalomino.infrastructure.rest;

import com.codigo.msbustamantepalomino.domain.aggregates.response.ResponseReniec;
import com.codigo.msbustamantepalomino.domain.ports.out.RestReniecOut;
import com.codigo.msbustamantepalomino.infrastructure.rest.client.ClientReniec;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RestReniecAdapter implements RestReniecOut {
    private final ClientReniec reniec;

    @Value("${token.api}")
    private String tokenApi;

    @Override
    public ResponseReniec getInfoReniec(String numDoc) {
        String authorization = "Bearer "+tokenApi;
        ResponseReniec responseReniec = reniec.getInfoReniec(numDoc,authorization);
        return responseReniec;
    }
}
