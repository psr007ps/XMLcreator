package com.xml.file;

import java.io.File;
import java.io.FileInputStream;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelSheetRead {

	private static final String EXCEL_FILE_LOCATION = "C:\\csvfile\\Divest.xls";

    public static void main(String[] args) {

        Workbook workbook = null;
        try {
        	File inputWorkbook = new File(EXCEL_FILE_LOCATION);
            Workbook w;
            try {
                w = Workbook.getWorkbook(inputWorkbook);
                // Get the first sheet
                Sheet sheet = w.getSheet(0);
                // Loop over first 10 column and lines
System.out.println(sheet.getRows());
System.out.println(sheet.getColumns());
                for (int i = 0; i < sheet.getRows(); i++) {
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        Cell cell = sheet.getCell(j,i);
                     
                       
                            System.out.println(" "+i+","+j+" "+
                                    cell.getContents());
                        

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }

    }
	};

