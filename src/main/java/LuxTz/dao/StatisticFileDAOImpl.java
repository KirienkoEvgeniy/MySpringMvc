package LuxTz.dao;


import LuxTz.model.RowFile;
import LuxTz.model.StatFile;
import LuxTz.rowmappers.FileRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class StatisticFileDAOImpl implements StatisticFileDAO {
    private static final String SQL_ALL_FILE_STAT = "SELECT * FROM statFile";
    private static final String SQL_ALL_FILE_STAT_CONDITION = "SELECT * FROM statFile Where kolrow >= :kolrow";
    private static final String queryFile = "INSERT INTO statfile (id, name, maxf, minf, averf, lenghtfile, kolrow) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StatisticFileDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
            }

    @Override
    public List<StatFile> list() {
        return jdbcTemplate.query(SQL_ALL_FILE_STAT, new FileRowMapper());
      }

    @Override
    public List<StatFile> listCondition(Integer rowsNumber) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("kolrow", rowsNumber);
        return namedParameterJdbcTemplate.query(SQL_ALL_FILE_STAT_CONDITION, mapSqlParameterSource, new FileRowMapper());
    }

    @Override
    public void writeFileStatistic(StatFile statFile, String id, String fileName) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        mapSqlParameterSource.addValue("name", fileName);
        mapSqlParameterSource.addValue("maxf", statFile.getMaxf());
        mapSqlParameterSource.addValue("minf", statFile.getMinf());
        mapSqlParameterSource.addValue("averf", statFile.getAverf());
        mapSqlParameterSource.addValue("lenghtfile", statFile.getLenghtfile());
        mapSqlParameterSource.addValue("kolrow", statFile.getKolrow());
        namedParameterJdbcTemplate.update(queryFile, mapSqlParameterSource);
    }
}
