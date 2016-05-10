package LuxTz.dao;

import LuxTz.model.RowFile;

import java.util.List;

public interface StatisticRowFileDAO {

    public List<RowFile> list();
    public void statRow(String newID, List<RowFile> rowStatistic);
}
