package ai;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadData
{

    public static class finalData 
    {
        public double[][] properties;
        public int[] labels;

        public finalData(double[][] properties, int[] labels)
        {
            this.properties = properties;
            this.labels = labels;
        }
    }

    public static finalData loadData(String filePath) 
    {
        List<double[]> propertiesList = new ArrayList<>();
        List<Integer> labelList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                double[] properties = new double[3];
                properties[0] = row.getCell(0).getNumericCellValue();
                properties[1] = row.getCell(1).getNumericCellValue();
                properties[2] = row.getCell(2).getNumericCellValue();

                int label = (int) row.getCell(3).getNumericCellValue();

                propertiesList.add(properties);
                labelList.add(label);
            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        double[][] properties = propertiesList.toArray(new double[0][]);
        int[] labels = labelList.stream().mapToInt(i -> i).toArray();

        return new finalData(properties, labels);
    }
}
