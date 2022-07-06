package poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class POITest {

    String path = "C:\\Users\\wxf\\IdeaProjects\\demo_internships\\demo_excel\\src\\main\\resources\\static\\";

    @Test
    public void start() throws IOException {
        write(new HSSFWorkbook());
        bigWrite(new HSSFWorkbook(),1);
        bigWrite(new XSSFWorkbook(),2);
        bigWrite(new SXSSFWorkbook(),3);
    }

    public void write(Workbook workbook) throws IOException {
        Sheet sheet = workbook.createSheet();
        Row row1 = sheet.createRow(1);
        Cell cell11 = row1.createCell(1);
        cell11.setCellValue("1");
        Cell cell12 = row1.createCell(2);
        cell12.setCellValue("2");
        FileOutputStream fileOutputStream = new FileOutputStream(path+"写入表.xls");
        workbook.write(fileOutputStream);
    }

    public void bigWrite(Workbook workbook,int index) throws IOException {
        Sheet sheet = workbook.createSheet();
        double start = System.currentTimeMillis();
        for(int i=0;i<65536;i++){
            Row row = sheet.createRow(i);
            for(int j=1;j<=10;j++){
                Cell cell = row.createCell(j);
                cell.setCellValue(1);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path+"大数据写入表"+index+".xls");
        double end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
        workbook.write(fileOutputStream);
    }

    @Test
    public void read() throws IOException {
        FileInputStream inputStream = new FileInputStream(path+"写入表.xls");
        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row0 = sheet.getRow(1);
        Cell cell00 = row0.getCell(0);
        String comment = cell00.getStringCellValue();
        System.out.println(comment);
        inputStream.close();
    }

    @Test
    public void readDif() throws IOException {
        FileInputStream inputStream = new FileInputStream(path+"写入表.xls");
        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row0 = sheet.getRow(0);
        for(int i=0;i<row0.getPhysicalNumberOfCells();i++){
            Cell cell = row0.getCell(i);
            System.out.print(cell.getStringCellValue()+"|");
        }
        System.out.println();
        for(int i=1;i<sheet.getPhysicalNumberOfRows();i++){
            Row row = sheet.getRow(i);
            for(int j=0;j<row.getPhysicalNumberOfCells();j++){
                Cell cell = row.getCell(j);
//                CellType cellType = cell.getCellType();
//                switch (cellType){
//                    case HSSFCell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue()+" ");
//                        break;
//                    case  HSSFCell.CELL_TYPE_NUMERIC:
//                        if(HSSFDateUtil.isCellDateFormatted(cell)){
//                            System.out.print(cell.getDateCellValue());
//                        }
//                        else System.out.print(cell.getNumericCellValue()+" ");
//                        break;
//                }
            }
            System.out.println();
        }
        inputStream.close();
    }

}
