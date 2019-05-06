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
	 * @Description:�����������ŵ��루���򵥱��룩+ ����ҵ�񿼺ˡ����ͼ���ҵ��׼��������������
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

		// �ܹ��ж�����sheet��
		int sheetnum = wb.getNumberOfSheets();

		for (int i = 0; i < sheetnum; i++) {
			Sheet sheet = wb.getSheetAt(i);
			// ��ͷ����
			Row namerow = sheet.getRow(0);

			// ��ͷ����
			Row headrow = sheet.getRow(1);

			if (null != headrow) {

				// ������
				int rowNum = sheet.getPhysicalNumberOfRows();
				// int rowNum = sheet.getLastRowNum();
				System.out.println(path + "����" + rowNum + " �У�");
				System.out.println("=============�жϿ���start============");
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
				System.out.println("=============�жϿ���end============");

				// ������
				int colNum = headrow.getPhysicalNumberOfCells();

				if (rowNum == 0) { // �жϹ������Ƿ�Ϊ��
					continue;
				}

				// ѭ����
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
