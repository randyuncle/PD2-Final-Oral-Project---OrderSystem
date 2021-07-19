package excelOutput;

import java.io.IOException;
import java.io.File;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import clientServer.*;
import properties.DailyIncomeHolder;

public class OutputNewData {
	
	private static int counter = 1;
	
	public OutputNewData(String command) throws BiffException, IOException, RowsExceededException, WriteException
	{
		if(command.equals("update")) 
		{
			Workbook workbook = Workbook.getWorkbook(new File("Daily.xls"));
			WritableWorkbook book = Workbook.createWorkbook( new File("Daily.xls"),workbook);
			
			WritableSheet sheet = book.getSheet("My Sheet");
			
			
			sheet.addCell( new Label( 0 , counter , ClientServer.panFriedBun ));
			sheet.addCell( new Label( 1 , counter , ClientServer.eightTreasureRice));
			sheet.addCell( new Label( 2 , counter , ClientServer.crab ));
			sheet.addCell( new Label( 3 , counter , ClientServer.soup ));
			sheet.addCell( new Label( 4 , counter , ClientServer.setOne));
			sheet.addCell( new Label( 5 , counter , ClientServer.setTwo));
			sheet.addCell( new Label( 6 , counter , ClientServer.total));
			
			book.write();
			book.close();
			workbook.close();
			
			counter++;
		}
		else if(command.equals("end")) 
		{
			Workbook workbook = Workbook.getWorkbook(new File("Daily.xls"));
			WritableWorkbook book = Workbook.createWorkbook( new File("Daily.xls"),workbook);
			
			WritableSheet sheet = book.getSheet("My Sheet");
			
			String income = String.valueOf(DailyIncomeHolder.Income);
			
			sheet.addCell( new Label( 0 , counter+1 , "今日的收入：" ));
			sheet.addCell( new Label( 1 , counter+1 , income));
			
			book.write();
			book.close();
			workbook.close();
			
			counter = 1;
		}
		
	}

}
