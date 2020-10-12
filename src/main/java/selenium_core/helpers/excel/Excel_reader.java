package selenium_core.helpers.excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import selenium_core.helpers.resource.ResourceHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel_reader
{
    public void getExcelData(String excelLocation, String sheetName) throws IOException
    {
        //------------------------------------------------------------------------------------------------------------||
        FileInputStream file = new FileInputStream(new File(excelLocation));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        // Sheet count
        //------------------------------------------------------------------------------------------------------------||
        int rowCount = sheet.getLastRowNum()+1; // Row count +1 [it is started from 0]
        System.out.println("Row count: " + rowCount);
        int columnCount = sheet.getRow(0).getLastCellNum(); // Column count
        System.out.println("Column count: " + columnCount);
        // Getting value from the row --> cell
        //------------------------------------------------------------------------------------------------------------||
        for(int i = 0; i < rowCount; i++) // Focusing on 1 rst row
        {
            XSSFRow currentRow = sheet.getRow(i); // Getting particular row and putting it into a variable

            for(int j = 0; j < columnCount; j++) // Focusing on 1 rst cell
            {
                String currentCellValue = currentRow.getCell(j).toString(); // Getting value from the cell
                System.out.print("[ " + currentCellValue + " ]");
            }
            System.out.println();
        }
    }
        //------------------------------------------------------------------------------------------------------------||
        public static void main(String[] args) throws IOException
        {
            Excel_reader reader = new Excel_reader();
            String excelSheet = ResourceHelper.getRecoursePath("/src/main/java/selenium_core/excel_sheets_data/selenium_test_data_2.xlsx");
            reader.getExcelData(excelSheet, "data_2");
        }
        //------------------------------------------------------------------------------------------------------------||

}
