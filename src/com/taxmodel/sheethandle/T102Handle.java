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
		System.out.println("row: " + currentCell.getRow());
		System.out.println("col: " + currentCell.getCol());
		System.out.println("value: " + currentCell.getValue().toString());
	}
}
