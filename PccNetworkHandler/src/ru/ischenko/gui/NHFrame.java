package ru.ischenko.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import ru.ischenko.logic.Network;

import java.awt.BorderLayout;
import java.util.Vector;

public class NHFrame extends JFrame{
/** 
 * 	NHFrame class contains definitions for GUI
 */
	private static final long serialVersionUID = -7081735279000940204L;
	
	public NHFrame(String title, Vector<Network> networks) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(600, 400);
		FilialGuiTable table = new FilialGuiTable(networks);
		JScrollPane scr = new JScrollPane(table);
		scr.setWheelScrollingEnabled(true);
		scr.getVerticalScrollBar().setUnitIncrement(20);
		add(table.getTable().getTableHeader(), BorderLayout.PAGE_START);
		add(scr, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
