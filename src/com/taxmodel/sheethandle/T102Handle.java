/**
 * @author
 *         Jason.w
 * @description
 *              create date: 2013-8-6
 *              last modified: 2013-8-6
 */
package com.taxmodel.sheethandle;

import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import org.rickysun.swingsheet.CellElement;
import org.rickysun.swingsheet.CellModel;
import org.rickysun.swingsheet.CellPanel;

import com.taxmodel.sheet.T102;
import com.taxmodel.util.MyUtil;

/**
 * 
 */
public class T102Handle {
	private T102	t102;
	private CellModel	cellModel;
	private String		cellValue;		// 记录进入编辑前单元格的值
	private CellElement	currentCell;	// 记录正在编辑的单元格

	/**
	 * Constructor: t102Handle
	 */
	public T102Handle() {
		t102 = new T102();
		cellModel = t102.getCellModel();

		//监听单元格值变更
		t102.getCellPanel().getGrid().addContainerListener(new ContainerListener() {
			@Override
			public void componentRemoved(ContainerEvent e) {
				if (!cellValue.equals(currentCell.getValue().toString()))
					onCellValueChanged();
			}
			@Override
			public void componentAdded(ContainerEvent e) {
				currentCell = cellModel.getSelectElement()[0];
				cellValue = currentCell.getValue().toString();
			}
		});
		
		System.out.println("t102Handle constructed!");
	}

	/**
	 * @return the t102
	 */
	public T102 getT102() {
		return t102;
	}

	/**
	 * @param t102
	 *            the t102 to set
	 */
	public void setT102(T102 t102) {
		this.t102 = t102;
	}

	/**
	 * @return T102.cellPanel
	 * @description
	 */
	public CellPanel getCellPanel() {
		return t102.getCellPanel();
	}
	
	/**
	 * 
	 * @description
	 * 				单元格值变更触发函数
	 */
	public void onCellValueChanged() {
		int row;
		int column;
		
		row = currentCell.getRow();
		column = currentCell.getCol();
		
		if (4 < row && row < 18 && 0 < column && column < 4) {
			// 固定税额小计
			double sum1 = MyUtil.calRow(1, 3, row, cellModel);
			cellModel.getElement(4, row).setValue(MyUtil.formatDouble(sum1));
			
			double lastRowSum = MyUtil.toDouble(MyUtil.calCol(5, 16, 4, cellModel));
			cellModel.getElement(4, 17).setValue(MyUtil.formatDouble(lastRowSum));
		}
		else if (4 < row && row < 18 && 4 < column && column < 12) {
			// 变动税额小计
			double sum1 = MyUtil.calRow(5, 11, row, cellModel);
			cellModel.getElement(12, row).setValue(MyUtil.formatDouble(sum1));
			
			double lastRowSum = MyUtil.toDouble(MyUtil.calCol(5, 16, 12, cellModel));
			cellModel.getElement(12, 17).setValue(MyUtil.formatDouble(lastRowSum));
		}
		else if (4 < row && row < 18 && 12 < column && column < 15) {
			// 其他收入小计
			double sum1 = MyUtil.calRow(13, 14, row, cellModel);
			cellModel.getElement(15, row).setValue(MyUtil.formatDouble(sum1));
			
			double lastRowSum = MyUtil.toDouble(MyUtil.calCol(5, 16, 15, cellModel));
			cellModel.getElement(15, 17).setValue(MyUtil.formatDouble(lastRowSum));
		}
		else if (4 < row && row < 18 && column == 16) {
			double sum1 = MyUtil.calCol(5, 16, 16, cellModel);
			cellModel.getElement(16, 17).setValue(MyUtil.formatDouble(sum1));
		}
		else {
			// 非数据单元格修改
			return;
		}
		
		// 末列合计
		double sum1 = MyUtil.toDouble(cellModel.getElement(4, row).getValue()) 
				+ MyUtil.toDouble(cellModel.getElement(12, row).getValue()) 
				+ MyUtil.toDouble(cellModel.getElement(15, row).getValue()) 
				+ MyUtil.toDouble(cellModel.getElement(16, row).getValue());
		cellModel.getElement(17, row).setValue(MyUtil.formatDouble(sum1));
		//末行合计
		double sum2 = MyUtil.calCol(5, 16, column, cellModel);
		cellModel.getElement(column, 17).setValue(MyUtil.formatDouble(sum2));
		
		double sum3 = MyUtil.calCol(5, 16, 17, cellModel);
		cellModel.getElement(17, 17).setValue(MyUtil.formatDouble(sum3));
		
		//format current cell
		double currentValue = MyUtil.toDouble(currentCell.getValue());
		currentCell.setValue(MyUtil.formatDouble(currentValue));
	}
}
