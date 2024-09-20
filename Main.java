// import java.io.FileOutputStream;
// import java.io.IOException;

// import org.apache.poi.ss.usermodel.Sheet;  // Correct import for Sheet
// import org.apache.poi.ss.usermodel.Workbook;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// public class Main {
//     public static void main(String[] args) {
//         // Using try-with-resources to ensure the workbook is properly closed
//         try (Workbook workbook = new XSSFWorkbook()) {
            
//             // Assuming ExcelSheet class has a method to create a sheet and generate data and charts
//             Sheet combinedSheet = ExcelSheet.createNewSheet(workbook);  // Correct sheet type
//             ExcelSheet.generateDataAndCharts(combinedSheet);

//             // Writing the workbook data to an Excel file
//             try (FileOutputStream fileOut = new FileOutputStream("output.xlsx")) {
//                 workbook.write(fileOut);
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }








// // Prototype of generating Bar Graphs with Java and it's solution

// // After running the script we can generate 200 different bar graphs and a question with it which will be exported to an Excel Sheet

// // This is just the prototype version other features can be added in the further version with GUI (if required)

// // 'Output.xlsx will be generated at the root dire



import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
    public static void main(String[] args) {
        Workbook workbook = null;
        FileOutputStream fileOut = null;

        try {
            // Create the workbook object (XSSFWorkbook for .xlsx files)
            workbook = new XSSFWorkbook();
            
            // Assuming ExcelSheet class has a method to create a sheet and generate data and charts
            Sheet combinedSheet = ExcelSheet.createNewSheet(workbook);
            ExcelSheet.generateDataAndCharts(combinedSheet);

            // Writing the workbook data to an Excel file
            fileOut = new FileOutputStream("output.xlsx");
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure resources are closed properly
            // try {
            //     if (fileOut != null) {
            //         fileOut.close();
            //     }
            //     if (workbook != null) {
            //         workbook.close();
            //     }
            // } catch (IOException e) {
            //     e.printStackTrace();
            // }
        }
    }
}


