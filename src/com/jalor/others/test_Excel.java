package com.jalor.others;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test_Excel {

	public static void main(String[] args) {
		tabImpExcel();
	}

	private final static String XLS = "xls";
	private final static String XLSX = "xlsx";

	/**
	 * @author lenian
	 * @Description:工作量、诚信导入（趋向单表导入）+ 技术业务考核、两纪及作业标准、个人荣誉导入
	 * @date lenian 2018 06 07
	 * @return
	 * @throws Exception
	 *             String
	 */
	@SuppressWarnings({ "unused" })
	public static String tabImpExcel() {

		String path = "D:\\A.xlsx";

		BufferedInputStream bis;
		Workbook wb = null;

		File file = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			if (path.endsWith(XLS)) { // 2003
				wb = new HSSFWorkbook(fis);
			} else if (path.endsWith(XLSX)) { // 2007
				wb = new XSSFWorkbook(fis);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 总共有多少张sheet表
		int sheetnum = wb.getNumberOfSheets();

		for (int i = 0; i < sheetnum; i++) {
			Sheet sheet = wb.getSheetAt(i);
			// 表头数据
			Row namerow = sheet.getRow(0);

			// 表头数据
			Row headrow = sheet.getRow(1);

			if (null != headrow) {

				// 总行数
				int rowNum = sheet.getPhysicalNumberOfRows();
				// int rowNum = sheet.getLastRowNum();
				System.out.println(path + "共：" + rowNum + " 行！");
				System.out.println("=============判断空行start============");
				for (int k = 0; k < rowNum + 1; k++) {
					Row row = sheet.getRow(k);
					if (row == null) {
						System.out.println("this row is null ----------------------");
						continue;

					} else {
						for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
							XSSFCell cell = (XSSFCell) row.getCell(j);
							System.out.print("| ");
							if (cell != null) {
								getType(cell);
							} else {

								continue;

							}
						}
						System.out.println();

					}

				}
				System.out.println("=============判断空行end============");

				// 总列数
				int colNum = headrow.getPhysicalNumberOfCells();

				if (rowNum == 0) { // 判断工作表是否为空
					continue;
				}

				// 循环行
				for (int j = 1; j <= rowNum; j++) {
					Row row = sheet.getRow(j);
					if (null == row) {
						continue;
					}
				}
			}
		}
		return null;
	}

	// public static getExcwlRow(int row){
	//
	// }

	public static void getType(XSSFCell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			System.out.print(cell.getRichStringCellValue().getString() + "|");
			// System.out.print("|");
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				System.out.print(String.valueOf(cell.getDateCellValue()) + "|");
			} else {
				System.out.print(cell.getNumericCellValue() + "|");
			}
			// System.out.print("|");
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			System.out.print(cell.getBooleanCellValue() + "|");
			// System.out.print("|");
			break;
		default:
		}

	}

}
