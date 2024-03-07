package com.codigo.msbustamantepalomino.domain.ports.in;

import com.codigo.msbustamantepalomino.domain.aggregates.response.ResponseReniec;
import org.apache.coyote.Response;

public interface RestReniecIn {
    ResponseReniec getInfoIn(String numDoc);
}
