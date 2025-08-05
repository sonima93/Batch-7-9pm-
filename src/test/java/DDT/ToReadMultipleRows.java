package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadMultipleRows {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Campaign.xlsx");
		 Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh=wb.getSheet("Phone");
		 int rowcount=sh.getLastRowNum();
		 
		 for(int i=1;i<=rowcount;i++)
		 {
		 Row r=sh.getRow(i);
		 String prodcat=r.getCell(0).getStringCellValue();
		 String prodname=r.getCell(1).getStringCellValue();
		 System.out.println(prodcat+"==="+prodname);
		 }
		
	}

}
