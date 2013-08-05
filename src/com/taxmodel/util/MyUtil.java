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
			int StartRow,
			int EndCol,
			int EndRow) {
		for (int i = startCol; i <= EndCol; i++) {
			for (int j = StartRow; j <= EndRow; j++) {
				cellModel.getElement(i, j).setStyle(cellStyle);
			}
		}
	}
}
