package LuxTz.dao;


import LuxTz.model.RowFile;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class StatisticRowFileDAOImpl implements StatisticRowFileDAO {
    private static final String queryRow = "INSERT INTO statrow (ID, maxwordr, minwordr, averwordr, lenghtrow) VALUES (?, ?, ?, ?, ?)";
    private static final String queryList = "SELECT * FROM statRow";
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public StatisticRowFileDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<RowFile> list() {

        List<RowFile> listRowFile = jdbcTemplate.query(queryList, new RowMapper<RowFile>() {

            @Override
            public RowFile mapRow(ResultSet rs, int rowNum) throws SQLException {
                RowFile aRowFile = new RowFile();
                aRowFile.setId_row(rs.getString("id_row"));
                aRowFile.setId(rs.getString("id"));
                aRowFile.setMaxwordr(rs.getInt("maxWordr"));
                aRowFile.setMinwordr(rs.getInt("minWordr"));
                aRowFile.setAverwordr(rs.getFloat("averWordr"));
                aRowFile.setLenghtrow(rs.getInt("lenghtrow"));

                return aRowFile;
            }

        });
        return listRowFile;
    }

    @Override
    public void statRow(String newID, List<RowFile> rowStatistic) {
        jdbcTemplate.batchUpdate(queryRow, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                RowFile rowFile = rowStatistic.get(i);
                ps.setString(1, newID);
                ps.setInt(2, rowFile.getMaxwordr());
                ps.setInt(3, rowFile.getMinwordr());
                ps.setFloat(4, rowFile.getAverwordr());
                ps.setInt(5, rowFile.getLenghtrow());
                ps.addBatch();
            }

            @Override
            public int getBatchSize() {
                return rowStatistic.size();
            }
        });
    }
}
