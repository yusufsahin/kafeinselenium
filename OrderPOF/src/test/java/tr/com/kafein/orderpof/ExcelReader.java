package tr.com.kafein.orderpof;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public static List<Object[]> readExcel(String filePath) {
        List<Object[]> testData = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(new File(filePath))) {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                List<Object> rowData = new ArrayList<>();
                Iterator<Cell> cells = currentRow.iterator();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            // Force numeric values to be strings
                            rowData.add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        case BOOLEAN:
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        default:
                            rowData.add(cell.toString());
                    }
                }
                testData.add(rowData.toArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;

    }
}
