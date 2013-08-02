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

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.rickysun.swingsheet.CellPanel;

/**
 * 
 */
public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CellPanel contentPane;
	private JMenuBar menuBar;
	private JMenu newMenu;
	private JMenu dataMenu;
	private JMenu chartMenu;
	private JMenuItem tMenuItem;
	private JMenuItem loadMenuItem;
	private JMenuItem exportMenuItem;
	private JMenuItem makeChartMenuItem;

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
		Dimension screenSize =
				java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width - 5, screenSize.height - 80);
		// ------------------------------------------------------------------------------
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// ------------------------------------------------------------------------------
		newMenu = new JMenu("New");
		menuBar.add(newMenu);
		// ------------------------------------------------------------------------------
		tMenuItem = new JMenuItem("T101");
		newMenu.add(tMenuItem);
		// ------------------------------------------------------------------------------
		dataMenu = new JMenu("Data");
		menuBar.add(dataMenu);
		// ------------------------------------------------------------------------------
		loadMenuItem = new JMenuItem("Load");
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
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		// contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
