package LuxTz.service;

import LuxTz.dao.StatisticRowFileDAO;
import LuxTz.model.RowFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evgeniy
 */
@Service
public class RowStatisticService {
    @Autowired
    private StatisticRowFileDAO rowDAO;

    public List<RowFile> getAllStringsStatistic(){
        return rowDAO.list();
    }
}
