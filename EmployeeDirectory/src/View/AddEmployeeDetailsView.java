package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Calendar;

import com.toedter.calendar.JDateChooser;

import Config.Checking;
//import Controller.EmployeeDetailAdminController;
//import Model.EmployeeDetailAdminModel;

public class AddEmployeeDetailsView extends JPanel {

    private static final long serialVersionUID = 1L;
    private static JTextField txtName;
    private static JTextField txtPhoneNumber;
    private static JTextField txtEmail;
    private static JTextField txtDepartment;
    private static JTextField txtJobTitle;
    private JTextField txtPassword;

    public AddEmployeeDetailsView() {
        setLayout(null);

        JLabel lblHeader = new JLabel("Employee Details");
        lblHeader.setBounds(40, 20, 300, 30);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblHeader);

        setPreferredSize(new Dimension(1000, 753));
        setBackground(new Color(245, 245, 245));
        
        JPanel panel = new JPanel();
        panel.setBounds(56, 89, 419, 635);
        add(panel);
        panel.setLayout(null);
        
      
        JLabel lblName = new JLabel("<html>Name <span style='color:red;'>*</span></html>");
        lblName.setBounds(10, 20, 54, 13);
        panel.add(lblName);
                
        txtName = new JTextField();
        txtName.setBounds(10, 46, 300, 25);
        panel.add(txtName);
        txtName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = txtName.getText();
                if (!Checking.IsValidName(input)) {
                    txtName.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    txtName.setBorder(UIManager.getBorder("TextField.border"));
                }
            }
        });
        
                        
        JLabel lblEmail = new JLabel("<html>Email <span style='color:red;'>*</span></html>");
        lblEmail.setBounds(10, 87, 100, 20);
        panel.add(lblEmail);
       
                                
        txtEmail = new JTextField();
        txtEmail.setBounds(10, 117, 300, 25);
        panel.add(txtEmail);
      
        txtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = txtEmail.getText();
                if (!Checking.IsEmailFormat(input)) {
                    txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    txtEmail.setBorder(UIManager.getBorder("TextField.border"));
                }
            }
        });
                                        
        JLabel lblPhone = new JLabel("<html>Phone Number <span style='color:red;'>*</span></html>");
        lblPhone.setBounds(10, 152, 100, 20);
        panel.add(lblPhone);
                                                
        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(10, 182, 300, 25);
        panel.add(txtPhoneNumber);
        
        txtPhoneNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = txtPhoneNumber.getText();
                if (!Checking.isPhoneNo(input)) {
                    txtPhoneNumber.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    txtPhoneNumber.setBorder(UIManager.getBorder("TextField.border"));
                }
            }
        });
                                                        
        JLabel lblHiringDate = new JLabel("<html>Hiring Date <span style='color:red;'>*</span></html>");
        lblHiringDate.setBounds(10, 217, 100, 20);
        panel.add(lblHiringDate);
                                                                        
       JLabel lblIsActive = new JLabel("Is Active");
       lblIsActive.setBounds(10, 287, 100, 20);
       panel.add(lblIsActive);
                                                                                
       JCheckBox chkIsActive = new JCheckBox();
       chkIsActive.setBounds(79, 282, 25, 25);
       panel.add(chkIsActive);
       chkIsActive.setBackground(Color.WHITE);
                                                                                        
       JLabel lblIsAgreement = new JLabel("Is Agreement");
       lblIsAgreement.setBounds(10, 317, 100, 20);
       panel.add(lblIsAgreement);
                                                                                                
       JCheckBox chkIsAgreement = new JCheckBox();
       chkIsAgreement.setBounds(79, 313, 25, 25);
       panel.add(chkIsAgreement);
       chkIsAgreement.setBackground(Color.WHITE);
       
       JLabel lblIsManager = new JLabel("Is Manager");
       lblIsManager.setBounds(10, 347, 100, 20);
       panel.add(lblIsManager);
                                                                                                                
       JCheckBox chkIsManager = new JCheckBox();
       chkIsManager.setBounds(79, 342, 25, 25);
       panel.add(chkIsManager);
       chkIsManager.setBackground(Color.WHITE);
                                                                                                                        
       JLabel lblDepartment = new JLabel("Department");
       lblDepartment.setBounds(10, 377, 100, 20);
       panel.add(lblDepartment);
                                                                                                                                
       txtDepartment = new JTextField();
       txtDepartment.setBounds(10, 408, 300, 25);
       panel.add(txtDepartment);
       
                                                                                                                                        
       JLabel lblJobTitle = new JLabel("Job Title");
       lblJobTitle.setBounds(10, 444, 100, 20);
       panel.add(lblJobTitle);
                                                                                                                                                
       txtJobTitle = new JTextField();
       txtJobTitle.setBounds(10, 467, 300, 25);
       panel.add(txtJobTitle);
                                                                                                                                                        
     
       JDateChooser dateChooser = new JDateChooser();
       dateChooser.setBounds(10, 248, 300, 20);
       panel.add(dateChooser);
       
       Calendar calendar = Calendar.getInstance();
       dateChooser.setMaxSelectableDate(calendar.getTime());
       
       JButton btnSave = new JButton("Save");
       btnSave.setBounds(10, 576, 100, 30);
       panel.add(btnSave);
       
       JLabel lblNewLabel = new JLabel("<html>Pasword <span style='color:red;'>*</span></html>");
       lblNewLabel.setBounds(10, 503, 100, 14);
       panel.add(lblNewLabel);
       
       txtPassword = new JTextField();
       txtPassword.setBounds(10, 528, 300, 25);
       panel.add(txtPassword);
       txtPassword.setColumns(10);
       
      

       
       btnSave.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        EmployeeDetailAdminModel pm = new EmployeeDetailAdminModel();
    	        EmployeeDetailAdminController pc = new EmployeeDetailAdminController();

    	        // Validate required fields
    	        if (txtName.getText().trim().isEmpty() ||
    	            txtEmail.getText().trim().isEmpty() ||
    	            txtPhoneNumber.getText().trim().isEmpty() ||
    	            txtPhoneNumber.getText().trim().isEmpty() ||
    	            dateChooser.getDate() == null || // Check if date is selected
    	            txtDepartment.getText().trim().isEmpty() ||
    	            txtJobTitle.getText().trim().isEmpty()) {
    	            
    	            JOptionPane.showMessageDialog(null, "There is a blank field!", "Fail", JOptionPane.ERROR_MESSAGE);
    	        } else {
    	            // Set values to EmployeeModel
    	            pm.setEmpName(txtName.getText().trim());
    	            pm.setEmail(txtEmail.getText().trim());
    	            pm.setPhone(txtPhoneNumber.getText().trim());
    	            pm.setHiringDate(new java.sql.Date(dateChooser.getDate().getTime())); // Convert to SQL Date
    	            pm.setDep_id(txtDepartment.getText().trim());
    	            pm.setPos_id(txtJobTitle.getText().trim());
    	            pm.setManager(chkIsManager.isSelected());
    	            pm.setActive(chkIsActive.isSelected());
    	            pm.setAgreement(chkIsAgreement.isSelected());

    	            // Perform validations
    	            if (Checking.IsValidName(pm.getEmpName()) ||
    	                !Checking.IsEmailformat(pm.getEmail()) ||
    	                !Checking.isPhoneNo(pm.getPhone())) {
    	                
    	                JOptionPane.showMessageDialog(null, "Invalid related field", "Invalid", JOptionPane.ERROR_MESSAGE);
    	            } else {
    	                try {
    	                	
    	                    int rs = pc.insert(pm);
	                        if (rs == 1) {
	                            JOptionPane.showMessageDialog(null, "Save Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
	                        }
	                
    	                } catch (Exception ex) {
    	                    ex.printStackTrace();
    	                    JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    	                }
    	            }
    	        }
    	    }
    	});


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("AddEmployeeDetails");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new JScrollPane(new AddEmployeeDetailsView()));
            frame.setSize(1000, 750);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
