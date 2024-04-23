package br.unipar.joquempo.service;
import br.unipar.joquempo.exceptions.DataBaseException;
import br.unipar.joquempo.exceptions.ValidationException;
import br.unipar.joquempo.repositories.JokenpoRepository;
import java.sql.SQLException;
import java.util.Random;

public class JokenpoService {

    public String insert(String jogada) {
        try {
            if(isInputValido(jogada)) {
                JokenpoRepository jokenpoRepository = new JokenpoRepository();
                String jogadaP2 = escolherJogadaP2();
                jokenpoRepository.insert(jogada, jogadaP2);

                return conferirVencedor(jogada.toLowerCase(), jogadaP2);
            }
            else
                throw new ValidationException("Escolha inválida");
        }
        catch(SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }
    
    
    private boolean isInputValido(String input) {
        return "tesoura".equals(input.toLowerCase()) || "pedra".equals(input.toLowerCase()) || "papel".equals(input.toLowerCase());
    }
    
    private String escolherJogadaP2() {
        Random r = new Random(); 
        int numRandom = r.nextInt(3);
        System.out.println(numRandom);
        
        String resultado = "";
        
        switch( numRandom ){
            case 0:
                resultado = "tesoura";
                break;
            case 1:
                resultado = "pedra";
                break;
            case 2:
                resultado = "papel";
                break;
        }
        
        return resultado;
    }
    
    private String conferirVencedor(String p1, String p2) {
        if("tesoura".equals(p1) && "papel".equals(p2))
            return "Você venceu! O outro jogador escolheu "+ p2;
        
        else if("papel".equals(p1) && "pedra".equals(p2))
            return "Você venceu! O outro jogador escolheu "+ p2;
        
        else if("pedra".equals(p1) && "tesoura".equals(p2))
            return "Você venceu! O outro jogador escolheu "+ p2;
        
        else if (p1.equals(p2))
            return "Epate! Ambos jogadores escolheram " + p2;
        
        return "Você perdeu! o outro jogador escolheu "+ p2;
    }
    
}
