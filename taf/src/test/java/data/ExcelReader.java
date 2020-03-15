package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;

	public FileInputStream getFileInputStream() {

		String fileString  = System.getProperty("user.dir")+"/src/main/java/properties/TestData.xlsx";
		File src = new File(fileString);


		try {
			fis = new FileInputStream(src);



		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return fis;

	}

	public Object[][] getDataExcel() throws IOException{


		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sh = wb.getSheet("Sheet1");
		int NoRow = sh.getLastRowNum()+1;
		int NoColomn = 4;

		String [] [] ExcelarrayData =  new String [NoRow][NoColomn];

		for (int i = 0; i < NoRow; i++) {

			for (int j = 0; j < NoColomn; j++) {
				XSSFRow row = sh.getRow(i);
				ExcelarrayData[i][j] = row.getCell(j).toString();	
			}


		}

		wb.close();
		return ExcelarrayData;


	}

}
