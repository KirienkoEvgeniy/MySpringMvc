package MySpringMvc.dao;


import MySpringMvc.model.StatFile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StatisticFileDAOImpl implements StatisticFileDAO {
    private JdbcTemplate jdbcTemplate;

    public StatisticFileDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
            }

//    @Override
//    public void saveOrUpdate(StatFile statFile) {
//
//    }
//
//    @Override
//    public void delete(int fileId) {
//        String sql = "DELETE FROM statisticFile WHERE id=?";
//        jdbcTemplate.update(sql, fileId);
//    }
//
//    @Override
//    public StatFile get(int fileId) {
//        return null;
//    }

    @Override
    public List<StatFile> list() {
        String sql = "SELECT * FROM statFile";
        List<StatFile> listStatFile = jdbcTemplate.query(sql, new RowMapper<StatFile>() {

            @Override
            public StatFile mapRow(ResultSet rs, int fileNum) throws SQLException {
                StatFile aStatFile = new StatFile();

        aStatFile.setId(rs.getInt("id"));
        aStatFile.setName(rs.getString("name"));
                aStatFile.setMaxf(rs.getInt("maxf"));
                aStatFile.setMinf(rs.getInt("minf"));
                aStatFile.setAverf(rs.getFloat("averf"));
                aStatFile.setLenghtfile(rs.getInt("lenghtfile"));

        return aStatFile;
    }

});

        return listStatFile;
//        return null;
    }
}
