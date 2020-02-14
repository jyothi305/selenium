package pack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.spi.ErrorCode;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class dataprovider {
	
	@DataProvider(name = "dp1")
	  public static Object[][] dp1() throws IOException, MyException {
		  XSSFRow Row=null;
		
		  XSSFSheet sheet = null;
		  int rowcount = 0,colcount=0;
		  
		  try {
			  			FileInputStream fileInput = new FileInputStream("E:\\Projct\\src\\testdata\\data.xlsx");
			  			XSSFWorkbook wb = new XSSFWorkbook(fileInput);
			  			sheet = wb.getSheetAt(0);
			  			Row =sheet.getRow(0);
			  			rowcount  = sheet.getLastRowNum();
			  			colcount = Row.getLastCellNum();
			  			
			  			
		  }catch(FileNotFoundException e)
		  {
			  //e.printStackTrace();
			  			throw new MyException("No file found",e,ErrorCode.FILE_OPEN_FAILURE);
		  }
		  
		  	Object Data[][]= new Object[rowcount][1]; // pass my  count data in array
	      
	      for(int i=0; i<rowcount; i++) //Loop work for Rows
	      {  
	    	   Map<Object, Object> datamap = new HashMap<>();
	           for (int j=0;j<colcount;j++)
	           {
	        	   datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
	              }
	           Data[i][0] = datamap;
	           }
	           
	      Reporter.log("DAta provider");
	    return (Data); 
	  }


}
