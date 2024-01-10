package apachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;


public class _ApachePOINewExcelWrite {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("New Sheet");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("New cell has created.");


        String path ="src/test/java/apachePOI/resource/_ApachePOINewExcel.xlsx";
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

        System.out.println("The process is over");
    }
}
