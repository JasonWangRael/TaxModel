/**
 * @author
 *     Jason.w
 * @description
 *     create date:   2013-8-2
 *     last modified: 2013-8-2
 */
package com.taxmodel.sheethandle;

import org.rickysun.swingsheet.CellModel;
import org.rickysun.swingsheet.CellPanel;

import com.taxmodel.sheet.T101;

/**
 * 
 */
public class T101Handle {
	private T101	t101;
	private CellModel	cellModel;

	/**
	 * Constructor: T101Handle
	 */
	public T101Handle() {
		t101 = new T101();
		cellModel = t101.getCellModel();
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
}
