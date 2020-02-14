package pack1;



public class MyException extends Exception{
	
	private  int code ;
	
	
	public MyException(String messsage,int code)
	{
		super(messsage);
		this.code = code;
	}
	public MyException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}
	
	public MyException(String message, Throwable cause, int fileOpenFailure) {
		super(message, cause);
		this.code = fileOpenFailure;
	}
	public MyException(String string) {
		// TODO Auto-generated constructor stub
	}
	
//	Reporter.log("In Test1");
//	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isDisplayed();
//	Reporter.log("Click radio button");
//	
//	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();
	
//	List<WebElement> desCitys = driver.findElements(By.id("dropdownGroup1"));
//	for (WebElement desCity:desCitys)
//	{
//		desCity.findElements(By.ByXPath)
//	}
		
//	Select arrCity = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1")));
//	arrCity.selectByIndex(0);
	
	
	
//	driver.findElement(By.id("divpaxinfo")).click();
//	 System.out.println(driver.findElement(By.id("divpaxOptions")).getAttribute("Style").contains("block"));
//	 driver.findElement(By.id("hrefIncAdt")).click();
//	 driver.findElement(By.id("btnclosepaxoption")).click();
	
//  @DataProvider(name = "dp")
//  public Object[][] dp() throws IOException, MyException {
//	  XSSFRow row = null ,Row=null;
//	  XSSFCell cell =null;
//	  XSSFSheet sheet = null;
//	  int rowcount = 0,colcount=0;
//	  DataFormatter format = new DataFormatter();
//	  try {
//		  			FileInputStream fileInput = new FileInputStream("E:\\Projct\\src\\testdata\\data.xlsx");
//		  			XSSFWorkbook wb = new XSSFWorkbook(fileInput);
//		  			sheet = wb.getSheetAt(0);
//		  			Row =sheet.getRow(0);
//		  			rowcount  = sheet.getPhysicalNumberOfRows();
//		  			colcount = Row.getLastCellNum();
//	  }catch(FileNotFoundException e)
//	  {
//		  //e.printStackTrace();
//		  			throw new MyException("No file found",e,ErrorCode.FILE_OPEN_FAILURE);
//	  }
//	  
//	  				Object Data[][]= new Object[rowcount-1][colcount]; // pass my  count data in array
//      
//      for(int i=0; i<rowcount-1; i++) //Loop work for Rows
//      {  
//           			row= sheet.getRow(i+1);
//           for (int j=0;j<colcount;j++)
//           {
//           
//              if(row==null)
//                  		Data[i][j]= "";
//              else
//              {
//                  		cell= row.getCell(j);
//                  if(cell==null)
//                      Data[i][j]= ""; //if it get Null value it pass no data 
//                  else
//               {
//                      String value=format.formatCellValue(cell);
//                      Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
//               }
//              }
//           }
//          } 
//      Reporter.log("DAta provider");
//    return (Data); 
//  }
	 
}