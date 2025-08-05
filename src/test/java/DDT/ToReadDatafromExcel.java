package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDatafromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("hi");
 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Campaign.xlsx");
 Workbook wb=WorkbookFactory.create(fis);
 Sheet sh=wb.getSheet("Campaign");
 Row r=sh.getRow(1);
 String Campname=r.getCell(2).getStringCellValue();
 String target=r.getCell(3).getStringCellValue();
 System.out.println(Campname);
 
	}

}
