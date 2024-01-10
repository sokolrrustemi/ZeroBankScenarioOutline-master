package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {
    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int numberOfColumns) {
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException exception) {
            System.out.println("exception = " + exception.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // each line
            ArrayList<String> row = new ArrayList<>();

            for (int j = 0; j < numberOfColumns; j++) {  // circulate as many columns as possible
                row.add(sheet.getRow(i).getCell(j).toString());
            }
            table.add(row);
        }
        return table;
    }

    public static void writeToExcel(String path, Scenario scenario, String browserName) {

        File file = new File(path);

        if (!file.exists()) // If the file does not exist, it runs first time and 1 time
        {
            // Create a workbook in memory, create a sheet in memory
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Scenario Results");

            // Perform operations in memory
            Row row = sheet.createRow(0);

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());

            cell = row.createCell(1);
            cell.setCellValue(String.valueOf(scenario.getStatus())); // scenario.toString();

            cell = row.createCell(2);
            cell.setCellValue(browserName);

            // Save
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception exception) {
                System.out.println("exception.getMessage() = " + exception.getMessage());
            }
        } else {
            FileInputStream inputStream = null;
            Workbook workbook = null;
            Sheet sheet = null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            } catch (Exception exception) {
                System.out.println("exception.getMessage() = " + exception.getMessage());
            }

            int lastRowIndex = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(lastRowIndex);

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus().toString());

            cell = row.createCell(2);
            cell.setCellValue(browserName);

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception exception) {
                System.out.println("exception.getMessage() = " + exception.getMessage());
            }
        }
    }

//    public static void writeToExcel(String path, String data) {
//        File file = new File(path);
//
//        if (!file.exists()) { // If the file does not exist, it runs first time and 1 time
//
//            // Create a workbook in memory, create a sheet in memory
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("Scenario Results");
//
//            // Perform operations in memory
//            Row newRow = sheet.createRow(0);
//            Cell cell = newRow.createCell(0);
//            cell.setCellValue(data + " was created");
//
//            // Save
//            try {
//                FileOutputStream outputStream = new FileOutputStream(path);
//                workbook.write(outputStream);
//                workbook.close();
//                outputStream.close();
//            } catch (Exception exception) {
//                System.out.println("exception.getMessage() = " + exception.getMessage());
//            }
//        } else {
//            FileInputStream inputStream = null;
//            Workbook workbook = null;
//            Sheet sheet = null;
//
//            try {
//                inputStream = new FileInputStream(path);
//                workbook = WorkbookFactory.create(inputStream);
//                sheet = workbook.getSheetAt(0);
//            } catch (Exception exception) {
//                System.out.println("exception.getMessage() = " + exception.getMessage());
//            }
//
//            int lastRowIndex = sheet.getPhysicalNumberOfRows();
//            Row newRow = sheet.createRow(lastRowIndex);
//            Cell newCell = newRow.createCell(0);
//            newCell.setCellValue(data);
//
//            try {
//                inputStream.close();
//                FileOutputStream outputStream = new FileOutputStream(path);
//                workbook.write(outputStream);
//                workbook.close();
//                outputStream.close();
//            } catch (Exception exception) {
//                System.out.println("exception.getMessage() = " + exception.getMessage());
//            }
//        }
//    }
}
