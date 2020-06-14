import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader {
	public static void main(String[] args) {
		XLSXReader obj = new XLSXReader();
		obj.getData("Excellent");
	}

	public void getData(String stuType) {
		try {
			File file = new File("C:\\Users\\HP\\Documents\\student_data2.xlsx"); // creating a new file instance
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
			// creating Workbook instance that refers to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			  
			int rowTotal = sheet.getLastRowNum();
			if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
			    rowTotal++;
			}
			
			for(int rowCount = 1; rowCount<=rowTotal; rowCount++) {
				Row row=sheet.getRow(rowCount); //returns the logical row  
				Cell cell=row.getCell(5); //getting the cell representing the given column  
				double value=cell.getNumericCellValue();    //getting cell value
				
				cell=row.getCell(0);
				String v0=cell.getStringCellValue();
				cell=row.getCell(1);
				double v1=cell.getNumericCellValue();
				cell=row.getCell(2);
				String v2=cell.getStringCellValue();
				cell=row.getCell(3);
				double v3=cell.getNumericCellValue();
				cell=row.getCell(4);
				String v4=cell.getStringCellValue();
				
				switch(stuType) {
				case "Excellent":
					if(value>=9.0) {
						System.out.println(v0+"\t\t"+v1+"\t\t"+v2+"\t\t"+
										   v3+"\t\t"+v4+"\t\t"+value);
					}
					break;
				case "Good":
					if(value<9.0 && value>=8.0) {
						System.out.println(v0+"\t\t"+v1+"\t\t"+v2+"\t\t"+
								   v3+"\t\t"+v4+"\t\t"+value);
					}
					break;
				case "Average":
					if(value<8.0 && value>=5.0) {
						System.out.println(v0+"\t\t"+v1+"\t\t"+v2+"\t\t"+
								   v3+"\t\t"+v4+"\t\t"+value);
					}
					break;
				case "Bad":
					if(value<5.0) {
						System.out.println(v0+"\t\t"+v1+"\t\t"+v2+"\t\t"+
								   v3+"\t\t"+v4+"\t\t"+value);
					}
					break;
				default:
					System.out.println("Not in any category!");
					break;
				}
			}
		} 
		catch (Exception e) {
			
		}
	}
}