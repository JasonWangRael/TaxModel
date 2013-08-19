/**
 * @author
 *         Jason.w
 * @description
 *              create date: 2013-8-2
 *              last modified: 2013-8-5
 */
package com.taxmodel.sheet;

import java.awt.Font;

import org.rickysun.swingsheet.CellElement;
import org.rickysun.swingsheet.CellModel;
import org.rickysun.swingsheet.CellPanel;
import org.rickysun.swingsheet.CellStyle;
import org.rickysun.swingsheet.DefaultCellModel;

/**
 * 
 */
public class T101 {

	private CellPanel cellPanel;
	private CellModel cellModel;


	/**
	 * Constructor: T101
	 */
	public T101() {
		cellModel = new DefaultCellModel();

		/*----------------------------------------------------------------------------*/
		// Draw the empty form
		cellModel.setSelectElement(0, 0, 17, 0);
		cellModel.mergeCell();
		cellModel.setSelectElement(0, 1, 17, 1);
		cellModel.mergeCell();
		cellModel.setHeight(1, 45);

		cellModel.setSelectElement(0, 2, 5, 2);
		cellModel.mergeCell();
		cellModel.setSelectElement(6, 2, 11, 2);
		cellModel.mergeCell();
		cellModel.setSelectElement(12, 2, 17, 2);
		cellModel.mergeCell();

		cellModel.setSelectElement(0, 3, 0, 4);
		cellModel.mergeCell();
		cellModel.setSelectElement(1, 3, 4, 3);
		cellModel.mergeCell();
		cellModel.setSelectElement(5, 3, 12, 3);
		cellModel.mergeCell();
		cellModel.setSelectElement(13, 3, 15, 3);
		cellModel.mergeCell();
		cellModel.setSelectElement(16, 3, 16, 4);
		cellModel.mergeCell();
		cellModel.setSelectElement(17, 3, 17, 4);
		cellModel.mergeCell();

		/*----------------------------------------------------------------------------*/
		// 小类标题
		CellStyle headStyle2;
		headStyle2 = new CellStyle();
		headStyle2.setFontName("仿宋_GB2312");
		headStyle2.setFontSize(12);
		headStyle2.setTextHorAlign(CellStyle.ALIGN_CENTER);
		headStyle2.setTextVerAlign(CellStyle.ALIGN_RIGHT);
		headStyle2.setTopLine(CellStyle.LS_SINGLE);
		headStyle2.setBottomLine(CellStyle.LS_SINGLE);
		headStyle2.setLeftLine(CellStyle.LS_SINGLE);
		headStyle2.setRightLine(CellStyle.LS_SINGLE);
		for (int i = 1; i < 16; i++) {
			CellElement cellElement = new CellElement(i, 4);
			cellElement.setStyle(headStyle2);
			cellModel.addElement(cellElement);
		}

		// month column
		CellStyle colStyle = new CellStyle();
		colStyle.setFontName("宋体");
		colStyle.setFontSize(14);
		colStyle.setTextHorAlign(CellStyle.ALIGN_CENTER);
		colStyle.setTextVerAlign(CellStyle.ALIGN_RIGHT);
		colStyle.setTopLine(CellStyle.LS_SINGLE);
		colStyle.setBottomLine(CellStyle.LS_SINGLE);
		colStyle.setLeftLine(CellStyle.LS_SINGLE);
		colStyle.setRightLine(CellStyle.LS_SINGLE);
		for (int i = 5; i < 18; i++) {
			CellElement cellElement = new CellElement(0, i);
			cellElement.setStyle(colStyle);
			cellModel.addElement(cellElement);
		}

		// data area
		CellStyle cellStyle = new CellStyle();
		cellStyle.setFontName("Times New Roman");
		cellStyle.setFontSize(12);
		cellStyle.setTextHorAlign(CellStyle.ALIGN_CENTER);
		cellStyle.setTextVerAlign(CellStyle.ALIGN_RIGHT);
		cellStyle.setTopLine(CellStyle.LS_SINGLE);
		cellStyle.setBottomLine(CellStyle.LS_SINGLE);
		cellStyle.setLeftLine(CellStyle.LS_SINGLE);
		cellStyle.setRightLine(CellStyle.LS_SINGLE);
		
		for (int i = 1; i < 18; i++) {
			for (int j = 5; j < 18; j++) {
				CellElement cellElement = new CellElement(i, j);
				cellElement.setStyle(cellStyle);
				cellModel.addElement(cellElement);
			}
		}

		/*----------------------------------------------------------------------------*/
		// Fill the text
		cellModel.getElement(0, 1).setValue("当期各税种申报情况表                    ");

		cellModel.getElement(0, 2).setValue("纳税人名称:");
		cellModel.getElement(6, 2).setValue("所属日期:");
		cellModel.getElement(12, 2).setValue("编号:");

		cellModel.getElement(0, 3).setValue("月份\\税种");
		cellModel.getElement(1, 3).setValue("固定税额");
		cellModel.getElement(5, 3).setValue("变动税额");
		cellModel.getElement(13, 3).setValue("其它收入");
		cellModel.getElement(16, 3).setValue("个人所得税");
		cellModel.getElement(17, 3).setValue("合计");

		cellModel.getElement(1, 4).setValue("房产税");
		cellModel.getElement(2, 4).setValue("土地使用税");
		cellModel.getElement(3, 4).setValue("车船使用税");
		cellModel.getElement(4, 4).setValue("小计");
		cellModel.getElement(5, 4).setValue("营业税");
		cellModel.getElement(6, 4).setValue("城建税");
		cellModel.getElement(7, 4).setValue("教育费附加");
		cellModel.getElement(8, 4).setValue("资源税");
		cellModel.getElement(9, 4).setValue("土地增值税");
		cellModel.getElement(10, 4).setValue("印花税");
		cellModel.getElement(11, 4).setValue("企业所得税");
		cellModel.getElement(12, 4).setValue("小计 ");
		cellModel.getElement(13, 4).setValue("社会保险费");
		cellModel.getElement(14, 4).setValue("其它收入");
		cellModel.getElement(15, 4).setValue("小计");

		cellModel.getElement(0, 5).setValue("1月");
		cellModel.getElement(0, 6).setValue("2月");
		cellModel.getElement(0, 7).setValue("3月");
		cellModel.getElement(0, 8).setValue("4月");
		cellModel.getElement(0, 9).setValue("5月");
		cellModel.getElement(0, 10).setValue("6月");
		cellModel.getElement(0, 11).setValue("7月");
		cellModel.getElement(0, 12).setValue("8月");
		cellModel.getElement(0, 13).setValue("9月");
		cellModel.getElement(0, 14).setValue("10月");
		cellModel.getElement(0, 15).setValue("11月");
		cellModel.getElement(0, 16).setValue("12月");
		cellModel.getElement(0, 17).setValue("合计");

		/*----------------------------------------------------------------------------*/
		// Set cell style
		//Header
		CellStyle headStyle = new CellStyle();
		headStyle.setFontName("华文中宋");
		headStyle.setFontSize(24);
		headStyle.setFontStyle(Font.BOLD);
		headStyle.setTextHorAlign(CellStyle.ALIGN_CENTER);
		headStyle.setTextVerAlign(CellStyle.ALIGN_RIGHT);
		cellModel.getElement(0, 1).setStyle(headStyle);

		// 名称日期编号
		CellStyle headStyle1;
		headStyle1 = new CellStyle();
		headStyle1.setFontName("宋体");
		headStyle1.setFontSize(14);
		headStyle1.setTextHorAlign(CellStyle.ALIGN_LEFT);
		headStyle1.setTextVerAlign(CellStyle.ALIGN_RIGHT);
		// headStyle1.setTopLine(CellStyle.LS_THICK);
		cellModel.getElement(0, 2).setStyle(headStyle1);
		cellModel.getElement(6, 2).setStyle(headStyle1);
		cellModel.getElement(12, 2).setStyle(headStyle1);
		
		// 小类标题
		cellModel.getElement(0, 3).setStyle(headStyle2);
		cellModel.getElement(1, 3).setStyle(headStyle2);
		cellModel.getElement(5, 3).setStyle(headStyle2);
		cellModel.getElement(13, 3).setStyle(headStyle2);
		cellModel.getElement(16, 3).setStyle(headStyle2);
		cellModel.getElement(17, 3).setStyle(headStyle2);

		cellPanel = new CellPanel();
		cellPanel.setModel(cellModel);
		System.out.println("T101 constructed!");
	}

	/**
	 * @return the cellPanel
	 */
	public CellPanel getCellPanel() {
		return cellPanel;
	}

	/**
	 * @param cellPanel
	 *            the cellPanel to set
	 */
	public void setCellPanel(CellPanel cellPanel) {
		this.cellPanel = cellPanel;
	}

	/**
	 * @return the cellModel
	 */
	public CellModel getCellModel() {
		return cellModel;
	}

	/**
	 * @param cellModel
	 *            the cellModel to set
	 */
	public void setCellModel(CellModel cellModel) {
		this.cellModel = cellModel;
	}
}
