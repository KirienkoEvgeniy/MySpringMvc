package LuxTz.dao;

import LuxTz.model.RowFile;
import LuxTz.model.StatFile;

import java.util.List;

public interface StatisticFileDAO {

    public List<StatFile> list();
    public List<StatFile> listCondition(Integer rowsNumber);
    public void writeFileStatistic(StatFile statFile, String id, String fileName);

}
