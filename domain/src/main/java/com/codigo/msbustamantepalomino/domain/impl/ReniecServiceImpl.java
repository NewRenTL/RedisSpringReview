package com.codigo.msbustamantepalomino.domain.impl;


import com.codigo.msbustamantepalomino.domain.aggregates.response.ResponseReniec;
import com.codigo.msbustamantepalomino.domain.ports.in.RestReniecIn;
import com.codigo.msbustamantepalomino.domain.ports.out.RestReniecOut;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReniecServiceImpl implements RestReniecIn {
    private final RestReniecOut restReniecOut;

    @Override
    public ResponseReniec getInfoIn(String numDoc) {
        return restReniecOut.getInfoReniec(numDoc);
    }
}
