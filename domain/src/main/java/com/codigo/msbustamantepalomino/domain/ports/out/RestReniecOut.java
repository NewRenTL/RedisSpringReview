package com.codigo.msbustamantepalomino.domain.ports.out;

import com.codigo.msbustamantepalomino.domain.aggregates.response.ResponseReniec;

public interface RestReniecOut {
    ResponseReniec getInfoReniec(String numDoc);
 }
