package testing;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.List;

public class CSV {

    public static Object[][] getCSVData(String path) throws Exception {

        CSVReader reader = new CSVReader(new FileReader(path));
        List<String[]> allData = reader.readAll();
        reader.close();

        int rowCount = allData.size();
        int colCount = allData.get(0).length;

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {   // skip header
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = allData.get(i)[j];
            }
        }

        return data;
    }
}
