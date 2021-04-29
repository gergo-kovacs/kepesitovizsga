package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

    private MariaDbDataSource dataSource;

    public JurassicPark(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation(){

        try(Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from dinosaur where expected < actual")){
            return getDino(preparedStatement);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can not read database");
        }

    }

    private List<String> getDino(PreparedStatement stmt) throws SQLException{
        List<String> dinos = new ArrayList<>();

        try(ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
             dinos.add(rs.getString("breed"));

            }
        }
        return dinos;
    }



}
