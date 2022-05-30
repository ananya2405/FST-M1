package activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity15 {
    private static String FILE_NAME = "TestSheet.xlsx";
    public static void main(String[] args) throws IOException {

        //Creating the excel file and worksheet
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("Datatypes in Java");

        //Cell values to be inserted in the file
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        //Inserting data in the cell
        for (Object[] datatype: datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum= 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

                //Writing the values in the excel cells using the FileOutputStream object
                try{
                    FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
                    workBook.write(outputStream);
                    workBook.close();
                }
                catch(FileNotFoundException e){
                    System.out.println("File not found exception");
                }
                catch(IOException e){
                    System.out.println("I/O exception");
                }
                System.out.println("Done");
            }

}
