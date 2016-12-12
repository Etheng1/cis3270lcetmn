

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Database.DatabaseConnection;
import Database.DbInteraction;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Flight {

	private JFrame frame;
	private JTextField txtSearchFlight;

	/**
	 * Create the application.
	 */
	DefaultTableModel _flightModel = new DefaultTableModel(0, 0);
    final String [] _eventModel = {"Flight Name", "DepartTime", "ArrivalTime", "DepartureDate", "ArrivalDate", "From City", "To City"};
	
    public Flight() {
		initialize();
		_flightModel.setColumnIdentifiers(_eventModel);
        FillFlightInformation();
	}
    
    private void FillFlightInformation()
    {
        try {
            DbInteraction db = new DbInteraction();
            HashMap<Integer, ArrayList<String>> result = db.GetAllFlights();
            for(Integer s : result.keySet())
            {
                ArrayList<String> mapFlights = result.get(s);
                _flightModel.addRow(new Object[]{mapFlights.get(0),mapFlights.get(1),mapFlights.get(2),mapFlights.get(3),mapFlights.get(4),mapFlights.get(5),mapFlights.get(6)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		JTable tblAllFlights;
		tblAllFlights = new javax.swing.JTable(){
	            public boolean isCellEditable(int row, int column){
	                return false;
	            };
	        }
	        ;
	        
	    tblAllFlights.setModel(_flightModel);
		
		JPanel jPanel1 = new JPanel();
		frame.getContentPane().add(jPanel1, BorderLayout.CENTER);
		jPanel1.setLayout(null);
		
		JLabel jLabel1 = new JLabel("Search for Flight:");
		jLabel1.setBounds(277, 31, 83, 14);
		jPanel1.add(jLabel1);
		
		txtSearchFlight = new JTextField();
		txtSearchFlight.setBounds(371, 28, 150, 20);
		jPanel1.add(txtSearchFlight);
		txtSearchFlight.setColumns(10);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(10, 56, 511, 254);
		jPanel1.add(jScrollPane1);
		
		JMenuBar jMenuBar1 = new JMenuBar();
		jMenuBar1.setToolTipText("");
		jMenuBar1.setBounds(0, 0, 531, 21);
		jPanel1.add(jMenuBar1);
		
		JMenu jMenu1 = new JMenu("My Account");
		jMenuBar1.add(jMenu1);
		
		JMenuItem jMenuItem1 = new JMenuItem("My Flights");
		jMenu1.add(jMenuItem1);
		
		JMenu jMenu2 = new JMenu("Admin");
		jMenuBar1.add(jMenu2);
		
		JMenu jMenu3 = new JMenu("Flights");
		jMenu2.add(jMenu3);
		
		JMenuItem btnAddFlight = new JMenuItem("Add Flight");	
		jMenu3.add(btnAddFlight);
		btnAddFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  new AddFlight().setVisible(true);
			}
		});
		
		JMenuItem btnUpdateFlight = new JMenuItem("Update Flight");
		jMenu3.add(btnUpdateFlight);
		
		JMenuItem btnDeleteFlight = new JMenuItem("Delete Flight");
		jMenu3.add(btnDeleteFlight);
	}
}
