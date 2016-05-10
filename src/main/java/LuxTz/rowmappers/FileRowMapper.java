package LuxTz.rowmappers;

import LuxTz.model.StatFile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FileRowMapper implements RowMapper<StatFile> {
    @Override
    public StatFile mapRow(ResultSet resultSet, int i) throws SQLException {
        StatFile aStatFile = new StatFile();
        aStatFile.setId(resultSet.getString("id"));
        aStatFile.setName(resultSet.getString("name"));
        aStatFile.setMaxf(resultSet.getInt("maxf"));
        aStatFile.setMinf(resultSet.getInt("minf"));
        aStatFile.setAverf(resultSet.getFloat("averf"));
        aStatFile.setLenghtfile(resultSet.getInt("lenghtfile"));
        aStatFile.setKolrow(resultSet.getInt("kolRow"));

        return aStatFile;
    }
}
