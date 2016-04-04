package MySpringMvc.dao;

import MySpringMvc.model.StatFile;

import java.util.List;

public interface StatisticFileDAO {

//    public void saveOrUpdate(StatFile statFile);
//
//    public void delete(int fileId);
//
//    public StatFile get(int contactId);

    public List<StatFile> list();
}
