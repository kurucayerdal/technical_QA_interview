package utilities;

import cucumber.api.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    public static void writeToExcel(String path, Scenario scenario, String browserName, String time) {
        File file = new File(path);

        if (!file.exists()) {
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("Results");
            Row row = sheet.createRow(0);

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getId());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus());

            cell = row.createCell(2);
            cell.setCellValue(time);

            cell = row.createCell(3);
            cell.setCellValue(browserName);

            try {
                FileOutputStream os = new FileOutputStream(path);
                wb.write(os);
                wb.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileInputStream fis = null;
            Workbook wb = null;
            try {
                fis = new FileInputStream(path);
                wb = WorkbookFactory.create(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String sheetName = wb.getSheetName(0);
            Sheet sheet = wb.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(rowCount);

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getId());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus());

            cell = row.createCell(2);
            cell.setCellValue(time);

            cell = row.createCell(3);
            cell.setCellValue(browserName);

            try {
                FileOutputStream os = new FileOutputStream(path);
                wb.write(os);
                wb.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
