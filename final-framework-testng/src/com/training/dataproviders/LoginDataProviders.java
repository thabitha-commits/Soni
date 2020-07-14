package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastname(); 
			obj[2] = temp.getEmail();
			obj[3] = temp.getPhone();
			obj[4] = temp.getLogin();
			obj[5] = temp.getUserpassword();

			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\SONI\\ScreenshotPath_Manipal\\TestData.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	//@DataProvider(name = "xls-inputs")
	//public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		//return new ReadExcel().getExcelData("C:\\SONI\\ScreenshotPath_Manipal\\TestData.xlsx", "Sheet1"); 
	//}
}
