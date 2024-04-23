package br.unipar.joquempo.interfaces;

import br.unipar.joquempo.exceptions.DataBaseException;
import br.unipar.joquempo.exceptions.ValidationException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface JokenpoWebService {
    
    @WebMethod
    String insert(String jogada) throws ValidationException, DataBaseException;
    
}
