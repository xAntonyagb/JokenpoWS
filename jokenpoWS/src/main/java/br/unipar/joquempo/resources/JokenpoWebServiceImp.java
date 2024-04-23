package br.unipar.joquempo.resources;

import br.unipar.joquempo.interfaces.JokenpoWebService;
import br.unipar.joquempo.service.JokenpoService;

public class JokenpoWebServiceImp implements JokenpoWebService {

    @Override
    public String insert(String jogada) {
        JokenpoService jokenpoService = new JokenpoService();
        return jokenpoService.insert(jogada);
    }
}
