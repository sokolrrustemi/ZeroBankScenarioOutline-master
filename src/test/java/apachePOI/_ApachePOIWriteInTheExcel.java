package apachePOI;

import io.cucumber.java.sl.Ce;
import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class _ApachePOIWriteInTheExcel {
    public static void main(String[] args) throws IOException {

        String path="src/test/java/apachePOI/resource/_ApachePOIWriteInTheExcel.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet= workbook.getSheet("Apache POI");

        int lastWowIndex=sheet.getPhysicalNumberOfRows();
        Row row=sheet.createRow(lastWowIndex);
        Cell cell=row.createCell(23);
        cell.setCellValue("Apache POI");
        fileInputStream.close();

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

        System.out.println(" The process is over.");




    }
}
