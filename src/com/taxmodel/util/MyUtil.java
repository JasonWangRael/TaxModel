/**
 * @author
 *     Jason.w
 * @description
 *     create date:   2013-8-5
 *     last modified: 2013-8-5
 */
package com.taxmodel.util;

import org.rickysun.swingsheet.CellModel;
import org.rickysun.swingsheet.CellStyle;

/**
 * 
 */
public class MyUtil {
	public static void BatchSetCellStyle(CellModel cellModel,
			CellStyle cellStyle,
			int startCol,
			int startRow,
			int endCol,
			int endRow) {
		for (int i = startCol; i <= endCol; i++) {
			for (int j = startRow; j <= endRow; j++) {
				cellModel.getElement(i, j).setStyle(cellStyle);
			}
		}
	}

	public static void SetOuterBorder(CellModel cellModel,
			int lightStyle,
			int startCol,
			int startRow,
			int endCol,
			int endRow) {
		// Set top
		for (int i = startCol; i <= endCol; i++) {
			cellModel.getElement(i, startRow).getStyle().setTopLine(lightStyle);
			cellModel.getElement(i, endRow).getStyle()
					.setBottomLine(lightStyle);
		}

		// Set right
		for (int i = startRow; i <= endRow; i++) {
			cellModel.getElement(endCol, i).getStyle().setRightLine(lightStyle);
		}

	}
}
