package br.unipar.joquempo.repositories;

import br.unipar.joquempo.infrastructure.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JokenpoRepository {
    Connection connection = null;
    
    public JokenpoRepository() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void insert(String p1, String p2) throws SQLException {
        String sql = "INSERT INTO tb_jokenpo (jogadaP1, jogadaP2) "
                + "VALUES (?, ?)";
        
        try (PreparedStatement ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p1);
            ps.setString(2, p2);
            ps.executeUpdate();
        }
    }
}
