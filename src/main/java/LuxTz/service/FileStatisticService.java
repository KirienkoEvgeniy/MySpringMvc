package LuxTz.service;

import LuxTz.dao.StatisticFileDAO;
import LuxTz.dao.StatisticRowFileDAO;
import LuxTz.model.RowFile;
import LuxTz.model.StatFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Evgeniy
 */
@Service
public class FileStatisticService {
    private static AtomicLong ref = new AtomicLong(System.currentTimeMillis());
    private static String DEFAULT_REFERENCE = "0000000000000";

    @Autowired
    private StatisticFileDAO fileDAO;
    @Autowired
    private StatisticRowFileDAO rowFileDAO;

    public List<StatFile> getAllFilesStatistic(){
        return fileDAO.list();
    }
    public List<StatFile> getAllFilesStatisticCondition(Integer rowsNumber){
        return fileDAO.listCondition(rowsNumber);
    }
    public void calculateStatistic(File file, Charset charset) throws Exception {
        if(charset == null){
            charset = Charset.forName("ISO-8859-1");
        }
        String newID = Long.toString(ref.getAndIncrement(), 36)
                .toUpperCase();
        newID = DEFAULT_REFERENCE.replace(
                DEFAULT_REFERENCE.substring(0, newID.length()),
                newID);

        List<RowFile> listResultRows = new LinkedList<RowFile>();
        List<String> lines = new LinkedList<String>();
        try {
            lines.addAll(Files.readAllLines(Paths.get(file.getCanonicalPath()), charset));
        } catch (IOException e) {
            System.out.println("Ошибка при получении строк файла");
            throw new Exception("Ошибка при получении строк файла", e);
        }
        for (String line : lines) {
            RowFile rowStatistic = new RowFile();
            int count = 0;
            float sum = 0;
            float average = 0;
            String[] res = line.split(" ");
            String max = res[0];
            String min = res[0];
            for (String word : res) {
                double wordLength = word.length();
                sum += wordLength;
                count++;
                if (max.length() < word.length())
                    max = word;
                if (min.length() > word.length())
                    min = word;
            }
            if (count > 0) {
                average = sum / count;
            }
            rowStatistic.setMaxwordr(Integer.parseInt(max));
            rowStatistic.setMinwordr(Integer.parseInt(min));
            rowStatistic.setAverwordr(average);
            rowStatistic.setLenghtrow(line.length());
            listResultRows.add(rowStatistic);
        }
        rowFileDAO.statRow(newID, listResultRows);

        StatFile result = new StatFile();
        int lenghtFile = 0;
        int countLines = listResultRows.size();
        float averf = 0;
        List<Integer> maxf = new ArrayList<Integer>();
        List<Integer> minf = new ArrayList<Integer>();

        for (RowFile line : listResultRows) {
            lenghtFile += line.getLenghtrow();
            averf = line.getAverwordr();
            maxf.add(line.getMaxwordr());
            minf.add(line.getMinwordr());
        }
        result.setMinf(Collections.min(minf));
        result.setMaxf(Collections.max(maxf));
        result.setAverf(averf);
        result.setLenghtfile(lenghtFile);
        result.setKolrow(countLines);
        fileDAO.writeFileStatistic(result, newID, file.getName());
    }
}
