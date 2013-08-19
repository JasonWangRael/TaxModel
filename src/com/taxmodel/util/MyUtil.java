/**
 * @author
 *         Jason.w
 * @description
 *              create date: 2013-8-5
 *              last modified: 2013-8-5
 */
package com.taxmodel.util;

import java.util.Formatter;
import java.util.Locale;

import org.rickysun.swingsheet.CellModel;
import org.rickysun.swingsheet.CellStyle;

/**
 * 
 */
public class MyUtil {
	/**
	 * @param cellModel
	 * @param cellStyle
	 * @param startCol
	 * @param startRow
	 * @param endCol
	 * @param endRow
	 * @description
	 *              批量设置单元格格式
	 */
	public static void BatchSetCellStyle(CellModel cellModel, CellStyle cellStyle, int startCol, int startRow, int endCol, int endRow) {
		for (int i = startCol; i <= endCol; i++) {
			for (int j = startRow; j <= endRow; j++) {
				cellModel.getElement(i, j).setStyle(cellStyle);
			}
		}
	}

	/**
	 * @param cellModel
	 * @param lightStyle
	 * @param startCol
	 * @param startRow
	 * @param endCol
	 * @param endRow
	 * @description
	 *              设置外边框样式
	 */
	public static void SetOuterBorder(CellModel cellModel, int lightStyle, int startCol, int startRow, int endCol, int endRow) {
		// Set top
		for (int i = startCol; i <= endCol; i++) {
			cellModel.getElement(i, startRow).getStyle().setTopLine(lightStyle);
			cellModel.getElement(i, endRow).getStyle().setBottomLine(lightStyle);
		}

		// Set right
		for (int i = startRow; i <= endRow; i++) {
			cellModel.getElement(endCol, i).getStyle().setRightLine(lightStyle);
		}
	}
	
	/**
	 * @param o
	 * @return
	 * @description
	 * 				返回Double类型的数值
	 */
	public static String formatDouble (double d) {
		Formatter fm = new Formatter(Locale.CHINA);
		String result;

		result = fm.format("%1$,.2f", d).toString();
		fm.close();
		
		return result;
	}
	
	/**
	 * @param o
	 * @return
	 * @description
	 * 				返回o的double值
	 */
	public static double toDouble (Object o) {
		if (o.toString().isEmpty()) {
			return 0.00;
		}

		return new Double(o.toString()).doubleValue();
	}
	
	
	/**
	 * @param col1
	 * @param col2
	 * @param row
	 * @param model
	 * @return
	 * @description
	 * 				计算第row行的col1 到col2之和
	 */
	public static double calRow(int col1, int col2, int row, CellModel model) {
		double sum = 0.00;

		for (int i = col1; i <= col2; i++) {
			sum += MyUtil.toDouble(model.getElement(i, row).getValue());
		}

		return sum;
	}

	/**
	 * @param row1
	 * @param row2
	 * @param column
	 * @param model
	 * @return
	 * @description
	 * 				计算第column列的row1到row2之和
	 */
	public static double calCol(int row1, int row2, int column, CellModel model) {
		double sum = 0.00;

		for (int i = row1; i <= row2; i++) {
			sum += MyUtil.toDouble(model.getElement(column, i).getValue());
		}

		return sum;
	}
}
