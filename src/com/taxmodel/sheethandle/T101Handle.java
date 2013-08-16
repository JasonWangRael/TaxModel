/**
 * @author
 *     Jason.w
 * @description
 *     create date:   2013-8-2
 *     last modified: 2013-8-2
 */
package com.taxmodel.sheethandle;

import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import org.rickysun.swingsheet.CellElement;
import org.rickysun.swingsheet.CellModel;
import org.rickysun.swingsheet.CellPanel;

import com.taxmodel.sheet.T101;
import com.taxmodel.util.MyUtil;

/**
 * 
 */
public class T101Handle {
	private T101	t101;
	private CellModel	cellModel;
	private String		cellValue;		// 记录进入编辑前单元格的值
	private CellElement	currentCell;	// 记录正在编辑的单元格

	/**
	 * Constructor: T101Handle
	 */
	public T101Handle() {
		t101 = new T101();
		cellModel = t101.getCellModel();

		//监听单元格值变更
		t101.getCellPanel().getGrid().addContainerListener(new ContainerListener() {
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

		System.out.println("T101Handle constructed!");
	}

	/*----------------------------------------------------------------------------*/
	//
	/**
	 * @return the t101
	 */
	public T101 getT101() {
		return t101;
	}

	/**
	 * @param t101
	 *            the t101 to set
	 */
	public void setT101(T101 t101) {
		this.t101 = t101;
	}

	/**
	 * @return T101.cellPanel
	 * @description
	 */
	public CellPanel getCellPanel() {
		return t101.getCellPanel();
	}

	/**
	 * 
	 * @description
	 * 				单元格值变更触发函数
	 */
	public void onCellValueChanged() {
		System.out.println("row: " + currentCell.getRow());
		System.out.println("col: " + currentCell.getCol());
		System.out.println("value: " + MyUtil.toDouble(currentCell.getValue()));
	}
}
