package ru.ischenko.gui;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import ru.ischenko.logic.Network;

public class FilialGuiTable extends JPanel {
	private static final long serialVersionUID = -1672772373453643620L;
	private JTable table;
	public class NetTableModel extends AbstractTableModel{
		private final Vector<Network> networks;
		private final String[] columnNames = new String[] {"Filial","Location","Address","Devices found"};
		private final Class[] columnClass = new Class[] {String.class, String.class, String.class, Boolean.class};
		
		public NetTableModel(Vector<Network> network) {
			this.networks = network;
		}
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}
	}
		
	public FilialGuiTable(Vector<Vector<String>> networks){
		super(new BorderLayout());

		Vector<String> colNames = new Vector<String>();
		final String[] colStaticNames = {"Filial","Location","Address","Devices found"};
		for(int i = 0; i < colStaticNames.length; i++ ) colNames.add(colStaticNames[i]);
		DefaultTableModel tm = new DefaultTableModel(networks,colNames);
		table = new JTable(tm);
		table.setShowGrid(false);
		add(table, BorderLayout.CENTER);
		setVisible(true);
	}

	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
}
