/**
 * @author
 *         Jason.w
 * @description
 *              create date: 2013-8-6
 *              last modified: 2013-8-6
 */
package com.taxmodel.sheethandle;

import org.rickysun.swingsheet.CellPanel;

import com.taxmodel.sheet.T102;

/**
 * 
 */
public class T102Handle {
	private T102	t102;

	/**
	 * Constructor: t102Handle
	 */
	public T102Handle() {
		t102 = new T102();
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
}
