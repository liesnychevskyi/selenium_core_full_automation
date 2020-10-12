package selenium_core.helpers.excel;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import selenium_core.helpers.logger.MyLogger;
import selenium_core.helpers.resource.ResourceHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class ExcelHelper
{
    //----------------------------------------------------------------------------------------------------------------||
    private Logger log = MyLogger.getLogger(selenium_core.helpers.excel.ExcelHelper.class);
    //----------------------------------------------------------------------------------------------------------------||
    public Object[][] getExcelData(String excelLocation, String sheetName)
    {
        try
        {
            Object dataSets[][] = null;
            FileInputStream file = new FileInputStream(new File(excelLocation));
            //Create workbook instance
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int totalRow = sheet.getLastRowNum();
            System.out.println("Total row is: " + totalRow);

            int totalColumn = sheet.getRow(0).getLastCellNum();
            System.out.println("Total column is: " + totalColumn);

            dataSets = new Object[totalRow+1][totalColumn];
            //Iterate through each Row one by one
            //////////////////////////////////////////////
            Iterator<Row> rowIterator = sheet.iterator();
            int i = 0;
            while (rowIterator.hasNext())
            {
                i++;
                //for every row, we need to iterate over columns
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int j = 0;
                while (cellIterator.hasNext())
                {
                    j++;
                    Cell cell = cellIterator.next();

                    switch(cell.getCellTypeEnum())
                    {
                        case STRING:
                            dataSets[i-1][j-1] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            dataSets[i-1][j-1] = cell.getNumericCellValue();
                            break;
                        case BOOLEAN:
                            dataSets[i-1][j-1] = cell.getBooleanCellValue();
                            break;
                        case FORMULA:
                            dataSets[i-1][j-1] = cell.getCellFormula();
                            break;
                        default:
                            System.out.println("No matching DATA TYPE FOUND..");
                            break;
                    }
                }
            }
            return dataSets;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus)
    {
        try
        {
            FileInputStream file = new FileInputStream(new File(excelLocation));
            //Create Workbook instance
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get sheet name from Workbook
            XSSFSheet sheet = workbook.getSheet(sheetName);
            //Count number of active rows in excel sheet
            int totalRow = sheet.getLastRowNum()+1; // it starts from - 0

            for(int i = 1; i < totalRow; i++)
            {
                XSSFRow row = sheet.getRow(i); // we get row from the sheet and keep it in a variable
                String cellData = row.getCell(0).getStringCellValue(); // we get data from the cell
                if(cellData.contains(testCaseName))
                {
                    row.createCell(1).setCellValue(testStatus); // we create cell and write into the the cell data
                    file.close();
                    log.info("Result updated..");
                    FileOutputStream out = new FileOutputStream(new File(excelLocation));
                    workbook.write(out);
                    out.close();
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void main(String[] args)
    {
        ExcelHelper excelHelper = new ExcelHelper();
        String excelLocation = ResourceHelper.getRecoursePath("/src/main/java/selenium_core/excel_sheets_data/selenium_test_data.xlsx");
        Object[][] data = excelHelper.getExcelData(excelLocation, "data");
        for(Object obj: data)
        {
            System.out.println(obj);
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
//    public static void main(String[] args)
//    {
//        selenium_core.helpers.excel.ExcelHelper excelHelper = new selenium_core.helpers.excel.ExcelHelper();
//        String excelLocation = ResourceHelper.getRecoursePath("\\src\\main\\java\\selenium_core\\excel_sheets_data\\selenium_test_data.xlsx");
//        //excelHelper.updateResult(excelLocation, "TestScripts", "Login", "PASS");
//        //excelHelper.updateResult(excelLocation, "TestScripts", "Registration", "FAIL");
//        //excelHelper.updateResult(excelLocation, "TestScripts", "Add to cart", "PASS");
//    }
    //----------------------------------------------------------------------------------------------------------------||
}
