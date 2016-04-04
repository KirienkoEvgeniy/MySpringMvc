package MySpringMvc.dao;


import MySpringMvc.model.RowFile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StatisticRowFileDAOImpl implements StatisticRowFileDAO {
    private JdbcTemplate jdbcTemplate;
    public StatisticRowFileDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    @Override
//    public void saveOrUpdate(RowFile rowFile) {
//
//    }
//
//    @Override
//    public void delete(int rowId) {
//        String sql = "DELETE FROM statisticRow WHERE id_row=?";
//        jdbcTemplate.update(sql, rowId);
//
//    }
//
//    @Override
//    public RowFile get(int rowId) {
//        return null;
//    }

    @Override
    public List<RowFile> list() {
        String sql = "SELECT * FROM statRow";
        List<RowFile> listRowFile = jdbcTemplate.query(sql, new RowMapper<RowFile>() {

        @Override
            public RowFile mapRow(ResultSet rs, int rowNum) throws SQLException {
                RowFile aRowFile = new RowFile();

                aRowFile.setId_row(rs.getInt("id_row"));
                aRowFile.setId(rs.getInt("id"));
                aRowFile.setMaxwordr(rs.getInt("maxWordr"));
                aRowFile.setMinwordr(rs.getInt("minWordr"));
                aRowFile.setAverwordr(rs.getFloat("averWordr"));
                aRowFile.setLenghtrow(rs.getInt("lenghtrow"));

                return aRowFile;
            }

        });

        return listRowFile;
    }
}
