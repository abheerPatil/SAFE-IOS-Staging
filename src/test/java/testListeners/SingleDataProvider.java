package testListeners;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SingleDataProvider {

	private static XSSFSheet sheet;
	private static XSSFWorkbook ExcelWBook;
	
	public void setExcelFile(String FileName,String SheetName) throws Exception {

	try 
		{
			FileInputStream ExcelFile = new FileInputStream("src/test/resources/testData/"+FileName+".xlsx");
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			sheet = ExcelWBook.getSheet(SheetName);
		} 
	catch(Exception e)
	{
			throw (e);
	}

	}
	
	@DataProvider(name = "data")
	public String[][] dataProvider(Method m){
		String methodName = m.getName();
		String className = m.getDeclaringClass().getName();
		className = className.substring(className.indexOf(".")+1);
		try {
			setExcelFile(className, methodName);
		} catch (Exception e1) {
		}
		
		int rows = 0 , a = 0 , b = 0 , cols = 0;
		try{
			while(!sheet.getRow(a).getCell(0).toString().equals("")){
				rows++;
				a++;
			}
		}
		catch(Exception e){}
		try{
			while(!sheet.getRow(0).getCell(b).toString().equals("")){
				cols++;
				b++;
			}
			
		}
		catch(Exception e){}
		String ar[][] = new String[rows-1][cols-1];
		int k = 0 , l = 0;
		for(int i = 1 ; i < rows ; i++ , k++){
			l = 0;
			for(int j = 1 ; j < cols ; j++ , l++){
				try{
					ar[k][l] = sheet.getRow(i).getCell(j).toString();
				}
				catch(Exception e){}
			}
		}
		return ar;
	}
}
