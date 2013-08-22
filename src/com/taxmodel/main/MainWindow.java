/**
 * @author
 *         Jason.w
 * @description
 *              create date: 2013-8-2
 *              last modified: 2013-8-2
 */
package com.taxmodel.main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.rickysun.swingsheet.CellPanel;

import com.taxmodel.sheethandle.T101Handle;
import com.taxmodel.sheethandle.T102Handle;

/**
 * 
 */
public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private CellPanel			contentPane;
	private JMenuBar			menuBar;
	private JMenu				newMenu;
	private JMenu				dataMenu;
	private JMenu				chartMenu;
	private JMenuItem			t101MenuItem;
	private JMenuItem			t102MenuItem;
	private JMenuItem			loadMenuItem;
	private JMenuItem			exportMenuItem;
	private JMenuItem			makeChartMenuItem;
	private JMenu				newMenuMenu_1;
	private JMenu				newMenuMenu_2;
	private JMenu				newMenuMenu_3;
	private JMenu				newMenuMenu_4;
	private JMenu				newMenuMenu_5;
	private JMenu				newMenuMenu_6;

	/*----------------------------------------------------------------------------*/
	//
	private JFileChooser		fileChooser;
	private String				currentSheet;

	/*----------------------------------------------------------------------------*/
	// All Handles
	private T101Handle			t101Handle;
	private T102Handle			t102Handle;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();

					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width - 300, screenSize.height - 300);
		// ------------------------------------------------------------------------------
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// ------------------------------------------------------------------------------
		newMenu = new JMenu("New");
		menuBar.add(newMenu);
		// ------------------------------------------------------------------------------
		newMenuMenu_1 = new JMenu("1.各税种申报情况表");
		newMenu.add(newMenuMenu_1);
		// ------------------------------------------------------------------------------
		t101MenuItem = new JMenuItem("当期");
		newMenuMenu_1.add(t101MenuItem);
		// ------------------------------------------------------------------------------
		t102MenuItem = new JMenuItem("基期");
		// ------------------------------------------------------------------------------
		fileChooser = new JFileChooser();


		newMenuMenu_1.add(t102MenuItem);
		t102MenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t102Handle = new T102Handle();
				// 设置相应系统属性
				currentSheet = "t102";
				fileChooser.setDialogTitle("请选择<各税种申报情况表>");

				setContentPane(t102Handle.getCellPanel());
				SwingUtilities.updateComponentTreeUI(t102Handle.getCellPanel());
			}
		});
		t101MenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t101Handle = new T101Handle();
				// 设置相应系统属性
				currentSheet = "t101";
				fileChooser.setDialogTitle("请选择<各税种申报情况表>");

				setContentPane(t101Handle.getCellPanel());
				SwingUtilities.updateComponentTreeUI(t101Handle.getCellPanel());
			}
		});
		// ------------------------------------------------------------------------------
		newMenuMenu_2 = new JMenu("2.各项主要评估指标数据");
		newMenu.add(newMenuMenu_2);
		// ------------------------------------------------------------------------------
		newMenuMenu_3 = new JMenu("3.产品销售分析表");
		newMenu.add(newMenuMenu_3);
		// ------------------------------------------------------------------------------
		newMenuMenu_4 = new JMenu("4.产品成本分析表");
		newMenu.add(newMenuMenu_4);
		// ------------------------------------------------------------------------------
		newMenuMenu_5 = new JMenu("5.产品成本指标采集表");
		newMenu.add(newMenuMenu_5);
		// ------------------------------------------------------------------------------
		newMenuMenu_6 = new JMenu("6.销售指标采集表");
		newMenu.add(newMenuMenu_6);
		// ------------------------------------------------------------------------------
		dataMenu = new JMenu("Data");
		menuBar.add(dataMenu);
		// ------------------------------------------------------------------------------
		loadMenuItem = new JMenuItem("Load");
		// Load按钮事件处理
		loadMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = fileChooser.showOpenDialog(MainWindow.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println(currentSheet);
					System.out.println(fileChooser.getSelectedFile().getName());
				}
			}
		});
		dataMenu.add(loadMenuItem);
		// ------------------------------------------------------------------------------
		exportMenuItem = new JMenuItem("Export");
		dataMenu.add(exportMenuItem);
		// ------------------------------------------------------------------------------
		chartMenu = new JMenu("Chart");
		menuBar.add(chartMenu);
		// ------------------------------------------------------------------------------
		makeChartMenuItem = new JMenuItem("Make Chart");
		chartMenu.add(makeChartMenuItem);
		// ------------------------------------------------------------------------------

		contentPane = new CellPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setContentPane(contentPane);
		SwingUtilities.updateComponentTreeUI(this);
		// contentPane.setLayout(new BorderLayout(0, 0));
	}
}
