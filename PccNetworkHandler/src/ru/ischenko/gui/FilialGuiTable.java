package ru.ischenko.gui;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import ru.ischenko.logic.Network;

public class FilialGuiTable extends JPanel {
	private static final long	serialVersionUID = -1672772373453643620L;
	private JTable				table;
/////////////////////////////////////////////////////////////////////////////////////////	
	public class NetTableModel extends AbstractTableModel{
		private final Vector<Network>	networks;
		private final String [ ]		columnNames = new String[ ] {	"Filial","Location","Address","Devices found"			};
		private final Class  [ ]		columnClass = new Class	[ ] {	String.class, String.class, String.class, Boolean.class	};
		/////////////////////////////////////////////////////////////////////////////////
		public	NetTableModel(Vector<Network> network) { this.networks = network; }
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Network row = networks.get(rowIndex);
	        if		( 0 == columnIndex ) return row.getFilial		( );
	        else if	( 1 == columnIndex ) return row.getLocation		( );
	        else if ( 2 == columnIndex ) return row.getAddress		( );
	        else if ( 3 == columnIndex ) return row.isDevicefull	( );
			return null;
		}
		@Override public Class<?>	getColumnClass	( int columnIndex )	{ return columnClass[ columnIndex ]; }
		@Override public String 	getColumnName	( int column ) 		{ return columnNames[ column ];		 }
		@Override public int 		getRowCount		( ) 				{ return networks.size( );			 }
		@Override public int 		getColumnCount	( )					{ return columnNames.length;		 }
	}
/////////////////////////////////////////////////////////////////////////////////////////		
	public FilialGuiTable( Vector<Network> networks ){
		super				( new BorderLayout( ) );
		NetTableModel tm	= new NetTableModel( networks );
		table				= new JTable( tm );
		table				.setShowGrid( false );
		add					( table, BorderLayout.CENTER );
		setVisible			( true );
	}
/////////////////////////////////////////////////////////////////////////////////////////
	public JTable 	getTable	( ) 				{ return table; }
	public void 	setTable	( JTable table )	{ this.table = table; }
}
