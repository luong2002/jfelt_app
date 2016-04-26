import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Coord {

	private Client test = new Client();
	private Client test2 = new Client();
	private Client test3 = new Client();
	private JFrame frame;
	private JTable Infotable;
	private DefaultTableModel InfoViewModel = new DefaultTableModel();
	private DefaultListModel Lmodel = new DefaultListModel();
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ArrayList<Client> clientees= new ArrayList<Client>();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coord window = new Coord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Coord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		test2.setName("Ada Fong");  // using it for tests
		test3.setName("wuing doig");
		clientees.add(test);
		clientees.add(test2);	
		clientees.add(test3);	//
		frame = new JFrame();
		frame.setBounds(100, 100, 1370, 746);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Main", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblClientees = new JLabel("Clientees");
		lblClientees.setBounds(20, 24, 209, 14);
		panel.add(lblClientees);
		
		final JButton AcceptButton = new JButton("Accept ");    				//accept button if clicked return nothing happen 
		AcceptButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		AcceptButton.setEnabled(false);		
		AcceptButton.setBounds(556, 471, 89, 23);
		panel.add(AcceptButton);
		
		final JButton DenyButton = new JButton("Deny");					// deny button if clicked return new InfoViewModel without the selected
		DenyButton.setEnabled(false);
	
		DenyButton.setBounds(682, 471, 89, 23);
		panel.add(DenyButton);
		
		JScrollPane scrollPane = new JScrollPane();   // infoview 
		scrollPane.setBounds(274, 36, 497, 435);
		panel.add(scrollPane);		
		Infotable = new JTable();
		scrollPane.setViewportView(Infotable);
		
		addtomodel(clientees);								 //test case
		final JList<String> ClientRequestList = new JList<String>(Lmodel);
		ClientRequestList.setBounds(20, 36, 209, 578);
		panel.add(ClientRequestList);
		
		ClientRequestList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
            	if (ClientRequestList.getSelectedValue() != null)
            	{
            
            		        
            	if (!arg0.getValueIsAdjusting()) 
            	{
            		final DefaultTableModel EmptyTableModel = new DefaultTableModel(); //  to clear inforview table everytime a different item is selected
            		InfoViewModel=            		EmptyTableModel;
            		Infotable.setModel(InfoViewModel);//    
            		
            		int index=0;
            		
            		
            	
            		for(int i =0; i <clientees.size(); i++ ){
            			if(clientees.get(i).getName()== ClientRequestList.getSelectedValue())
            			{
            				index=i;
            				break;
            			}}
            		final int index2=index;             	
                  if(ClientRequestList.getSelectedValue()==clientees.get(index2).getName())
                  {
                	  
                	InfoViewModel.addColumn("Client's Attribute");
              		InfoViewModel.addColumn("Client's Attribute Value");		
              		InfoViewModel.addRow(new Object[]{"Name", clientees.get(index2).getName()});
              		InfoViewModel.addRow(new Object[]{"Phone Number", clientees.get(index2).getPhone()});
                    InfoViewModel.addRow(new Object[]{"A/D",clientees.get(index2).GetADflag() });	
              		Infotable.setModel(InfoViewModel);
              		if(clientees.get(index2).GetADflag()=="Not Set")
              		{
              			DenyButton.setEnabled(true);      
              			DenyButton.addActionListener(new ActionListener() {
              				public void actionPerformed(ActionEvent e) {
              					clientees.get(index2).SetADflag("false");
              					 if(ClientRequestList.getSelectedIndex()>=0)
              		                Lmodel.remove(ClientRequestList.getSelectedIndex());       					            				              
              					ClientRequestList.setModel(Lmodel);

              				}
              			});
              			AcceptButton.setEnabled(true);
              			AcceptButton.addMouseListener(new MouseAdapter() {
    						public void mouseClicked(MouseEvent arg0) {
    	                         System.out.println("Current selection: " + 	clientees.get(index2));
    	                      	clientees.get(index2).SetADflag("true");
    							AcceptButton.setEnabled(false);
    							DenyButton.setEnabled(false);
    							    
    							    							
    						}
              			});
              		}
              		else{
              			AcceptButton.setEnabled(false);
						DenyButton.setEnabled(false);
              		
              		}
                  }
                }
            }}
        });
		
		AcceptButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		JLabel lblDriver = new JLabel("Available Driver");
		lblDriver.setBounds(781, 24, 247, 14);
		panel.add(lblDriver);
		
		JLabel lblClientsInfo = new JLabel("Client's Info");
		lblClientsInfo.setBounds(274, 24, 497, 14);
		panel.add(lblClientsInfo);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBounds(781, 37, 395, 578);
		panel.add(table);
				
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Driver", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnUpdateDriverList = new JButton("Add Driver");
		btnUpdateDriverList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateDriverList.setBounds(712, 540, 194, 48);
		panel_1.add(btnUpdateDriverList);
		
		JButton btnRemoveDriver = new JButton("Remove Driver ");
		btnRemoveDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveDriver.setBounds(10, 602, 194, 48);
		panel_1.add(btnRemoveDriver);
		
		JLabel lblNewLabel = new JLabel("Driver List");
		lblNewLabel.setBounds(10, 40, 238, 14);
		panel_1.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(10, 53, 238, 535);
		panel_1.add(list);
		
		table_1 = new JTable();
		table_1.setBounds(275, 54, 427, 535);
		panel_1.add(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Driver Info");
		lblNewLabel_1.setBounds(275, 40, 427, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(712, 480, 104, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(837, 477, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCarLicense = new JLabel("Car license");
		lblCarLicense.setBounds(712, 505, 104, 14);
		panel_1.add(lblCarLicense);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(837, 502, 86, 20);
		panel_1.add(textField_1);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(712, 455, 104, 14);
		panel_1.add(lblStudentId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(837, 452, 86, 20);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Statistic ", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Switch On/Off", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		JButton btnTurnOn = new JButton("Turn On");
		btnTurnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTurnOn.setBounds(79, 137, 782, 318);
		panel_3.add(btnTurnOn);
		
		
		
		
	}
	@SuppressWarnings("unchecked")
	public DefaultListModel addtomodel(ArrayList<Client> test)
	{
		for(int i =0; i <test.size(); i++ )
		Lmodel.addElement(test.get(i).getName());
		return Lmodel;
	}
}
