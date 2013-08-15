/**
 * @author
 *     Jason.w
 * @description
 *     create date:   2013-8-2
 *     last modified: 2013-8-2
 */
package com.taxmodel.sheethandle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	 * 
	 * @wbp.parser.entryPoint
	 */
	public T101Handle() {
		t101 = new T101();
		cellModel = t101.getCellModel();
		t101.getCellPanel().getGrid().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		System.out.println("T101Handle constructed!");
	}

	/*----------------------------------------------------------------------------*/
	//
	/**
	 * @return the t101
	 * @wbp.parser.entryPoint
	 */
	public T101 getT101() {
		return t101;
	}

	/**
	 * @param t101
	 *            the t101 to set
	 * @wbp.parser.entryPoint
	 */
	public void setT101(T101 t101) {
		this.t101 = t101;
	}

	/**
	 * @return T101.cellPanel
	 * @description
	 * @wbp.parser.entryPoint
	 */
	public CellPanel getCellPanel() {
		return t101.getCellPanel();
	}
}
