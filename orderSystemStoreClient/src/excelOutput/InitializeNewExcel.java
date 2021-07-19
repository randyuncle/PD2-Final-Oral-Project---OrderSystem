package excelOutput;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class InitializeNewExcel {
	
	public InitializeNewExcel() throws IOException, WriteException 
	{
		WritableWorkbook workbook = Workbook.createWorkbook(new File("Daily.xls"));
		
		WritableSheet sheet = workbook.createSheet("My Sheet", 0);
		
		WritableFont myFont = new WritableFont(WritableFont.createFont("�з���"), 14);
		
		WritableCellFormat cellFormat = new WritableCellFormat ();
		cellFormat.setFont(myFont); // ���w�r��
		
		Label label1 = new Label(0, 0, "�W���ͷΥ]", cellFormat);
		sheet.addCell(label1);
		
		Label label2 = new Label(1, 0, "�K�_��", cellFormat);
		sheet.addCell(label2);
		
		Label label3 = new Label(2, 0, "�M�]�����j�h��", cellFormat);
		sheet.addCell(label3);
		
		Label label4 = new Label(3, 0, "�o���G������", cellFormat);
		sheet.addCell(label4);
		
		Label label5 = new Label(4, 0, "�M�\�@", cellFormat);
		sheet.addCell(label5);
		
		Label label6 = new Label(5, 0, "�M�\�G", cellFormat);
		sheet.addCell(label6);
		
		Label label7 = new Label(6, 0, "�`�M", cellFormat);
		sheet.addCell(label7);
		
		workbook.write();
		workbook.close();
		
	}
	
}
