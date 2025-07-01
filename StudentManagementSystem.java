import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
import java.io.*;

class Student{
	private String regId;
	private String nic;
	private String name;
	
	private int prfMarks;
	private int dbmsMarks;
	
	Student(String regId, String nic, String name, int prfMarks, int dbmsMarks){
		this.regId = regId;
		this.nic = nic;
		this.name = name;
		this.prfMarks = prfMarks;
		this.dbmsMarks = dbmsMarks;
	}
	
	void setRegId(String regId){this.regId = regId;}
	void setNic(String nic){this.nic = nic;}
	void setName(String name){this.name = name;}
	void setPrfMarks(int prfMarks){this.prfMarks = prfMarks;}
	void setDbmsMarks(int dbmsMarks){this.dbmsMarks = dbmsMarks;}
	
	public String toString(){
		return regId+","+nic+","+name+","+String.valueOf(prfMarks)+","+String.valueOf(dbmsMarks);
	}
	
	String getRegId(){return this.regId;}
	String getNic(){return this.nic;}
	String getName(){return this.name;}
	int getPrfMarks(){return this.prfMarks;}
	int getDbmsMarks(){return this.dbmsMarks;}
}

class HomePage extends JPanel{
	JLabel homeTitle;
	JButton smButton;
	JButton bmButton;
	JButton gmButton;
	JButton rgButton;
	JButton exitButton;
	
	
	
	public HomePage(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel homeTitlePanel = new JPanel(new GridLayout(6,1,0,0));
        homeTitle = new JLabel("Home");
        homeTitle.setHorizontalAlignment(JLabel.CENTER);
        homeTitlePanel.add(homeTitle);
        
        JLabel  spacer = new JLabel(" ");
        	
        homeTitlePanel.add(spacer);
        homeTitlePanel.add(spacer);
        homeTitlePanel.add(spacer);
        homeTitlePanel.add(spacer);
        homeTitlePanel.add(spacer);
        add("North",homeTitlePanel);
        
        JPanel homeButtonPanel = new JPanel(new GridLayout(6,1,0,0));
        
        homeTitlePanel.add(spacer);
                
        JPanel smButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        smButton = new JButton("Student Management");
        smButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				layout.show(parentPanel,"smPage");
			}
		});
        smButtonPanel.add(smButton);
        homeButtonPanel.add(smButtonPanel);
        
        JPanel bmButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bmButton = new JButton("Batch Management");
        bmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				layout.show(parentPanel,"bmPage");
			}
		});
        bmButtonPanel.add(bmButton);
        homeButtonPanel.add(bmButtonPanel);
        
        JPanel gmButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        gmButton = new JButton("Grade Management");
        gmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				layout.show(parentPanel,"gmPage");
			}
		});
        gmButtonPanel.add(gmButton);
        homeButtonPanel.add(gmButtonPanel);
        
        JPanel rgButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rgButton = new JButton("Report Generator");
        rgButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				layout.show(parentPanel,"rgPage");
			}
		});
        rgButtonPanel.add(rgButton);
        homeButtonPanel.add(rgButtonPanel);
        
        JPanel exitButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        exitButton = new JButton("Exit");
        exitButtonPanel.add(exitButton);
        homeButtonPanel.add(exitButtonPanel);

		add("Center",homeButtonPanel);
        
	}
}

class StudentManagement extends JPanel{
	JLabel smTitle;
	JButton addSButton;
	JButton updateSButton;
	JButton viewSButton;
	JButton deleteSButton;
	JButton backToHomeButton;
	
	StudentManagement(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel smTitlePanel = new JPanel(new GridLayout(4,1,0,0));
        smTitle = new JLabel("Home > Student Management");
        smTitle.setHorizontalAlignment(JLabel.CENTER);
        smTitlePanel.add(smTitle);
        
        JLabel  spacer = new JLabel(" ");
        	
        smTitlePanel.add(spacer);
        smTitlePanel.add(spacer);
        smTitlePanel.add(spacer);
        //smTitlePanel.add(spacer);
        //smTitlePanel.add(spacer);
        add("North",smTitlePanel);
        
        JPanel smButtonsPanel = new JPanel(new GridLayout(5,1,1,1));
		
		add(spacer);
		
		JPanel addSButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		addSButton = new JButton("Add Student");
		addSButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					//AddStudent.LoadData(StudentManagementSystembatch.NameArray);
					AddStudent.setBatchArray(StudentManagementSystem.batchNameArray);
					layout.show(parentPanel,"addStudent");
				}
		});
		addSButtonPanel.add(addSButton);
		smButtonsPanel.add(addSButtonPanel);
		
		JPanel updateSButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		updateSButton = new JButton("Update Student");
		updateSButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"updateStudent");
				}
		});
		updateSButtonPanel.add(updateSButton);
		smButtonsPanel.add(updateSButtonPanel);
		
		JPanel viewSButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		viewSButton = new JButton("View Button");
		viewSButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"updateStudent");
				}
		});
		viewSButtonPanel.add(viewSButton);
		smButtonsPanel.add(viewSButtonPanel);
		
		JPanel deleteSButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		deleteSButton = new JButton("Delete Student");
		deleteSButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"updateStudent");
				}
		});
		deleteSButtonPanel.add(deleteSButton);
		smButtonsPanel.add(deleteSButtonPanel);
		
		JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    backToHomeButton = new JButton("Back");
	    backToHomeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"homepage");
				}
		});
		backButtonPanel.add(backToHomeButton);
		
		smButtonsPanel.add(backButtonPanel);
		//smButtonsPanel.add(backButtonPanel);
		
		add("Center",smButtonsPanel);
	}
}

class BatchManagement extends JPanel{
	JLabel bmTitle;
	JButton addButton;
	JButton updateButton;
	JButton viewButton;
	JButton backToHomeButton;
	
	BatchManagement(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel bmTitlePanel = new JPanel(new GridLayout(6,1,1,1));
		bmTitle = new JLabel("Home > Batch Management");
		bmTitle.setHorizontalAlignment(JLabel.CENTER);
		bmTitlePanel.add(bmTitle);
		
		JLabel  spacer = new JLabel(" ");
        	
        bmTitlePanel.add(spacer);
        bmTitlePanel.add(spacer);
        bmTitlePanel.add(spacer);
        bmTitlePanel.add(spacer);
        bmTitlePanel.add(spacer);
        add("North",bmTitlePanel);
        
        JPanel bmButtonPanel = new JPanel(new GridLayout(5,1,1,1));
        
        add(spacer);
        
        JPanel addButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("Add Batch");
        addButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"addBatch");
				}
		});
        addButtonPanel.add(addButton);
        bmButtonPanel.add(addButtonPanel);
        
        JPanel updateButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        updateButton = new JButton("Update Batch");
        updateButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"updateBatch");
				}
		});
        updateButtonPanel.add(updateButton);
        bmButtonPanel.add(updateButtonPanel);
        
        JPanel viewButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        viewButton = new JButton("View Batches");
        viewButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					ViewBatch.loadBatchData();
					layout.show(parentPanel,"viewBatch");
				}
		});
        viewButtonPanel.add(viewButton);
        bmButtonPanel.add(viewButtonPanel);
        
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    backToHomeButton = new JButton("Back");
	    backToHomeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"homepage");
				}
		});
		backButtonPanel.add(backToHomeButton);
		bmButtonPanel.add(backButtonPanel);
		
		add("Center",bmButtonPanel);
		
	}
}


class GradeManagement extends JPanel{
	JLabel title;
	JButton prfUpdateButton;
	JButton dbmsUpdateButton;
	JButton backToHomeButton;
	
	GradeManagement(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel titlePanel = new JPanel(new GridLayout(6,1,1,1));
		title = new JLabel("Home > GradeManagement");
		title.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(title);
		
		JLabel  spacer = new JLabel(" ");
        	
        titlePanel.add(spacer);
        titlePanel.add(spacer);
        titlePanel.add(spacer);
        titlePanel.add(spacer);
        titlePanel.add(spacer);
        add("North",titlePanel);
        
        JPanel buttonPanel = new JPanel(new GridLayout(4,1,1,1));
        add(spacer);
        
        JPanel prfUpdateButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        prfUpdateButton = new JButton("Update PRF Marks");
        prfUpdateButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"marksUpdate");
				}
		});
        prfUpdateButtonPanel.add(prfUpdateButton);
        buttonPanel.add(prfUpdateButtonPanel);
        
        JPanel dbmsUpdateButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dbmsUpdateButton = new JButton("Update DBMS Marks");
        dbmsUpdateButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"marksUpdate");
				}
		});
        dbmsUpdateButtonPanel.add(dbmsUpdateButton);
        buttonPanel.add(dbmsUpdateButtonPanel);
        
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    backToHomeButton = new JButton("Back");
	    backToHomeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"homepage");
				}
		});
		backButtonPanel.add(backToHomeButton);
		buttonPanel.add(backButtonPanel);
		
		add("Center",buttonPanel);
        
	}
}

class ReportGenerator extends JPanel{
	JLabel title;
	JButton srrButton;
	JButton bsrButton;
	JButton ietrButton;
	JButton backToHomeButton;
	
	ReportGenerator(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel titlePanel = new JPanel(new GridLayout(6,1,1,1));
		title = new JLabel("Home > Report Generator");
		title.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(title);
		
		JLabel  spacer = new JLabel(" ");
        	
        titlePanel.add(spacer);
        titlePanel.add(spacer);
        titlePanel.add(spacer);
        titlePanel.add(spacer);
        titlePanel.add(spacer);
        add("North",titlePanel);
        
        JPanel buttonPanel = new JPanel(new GridLayout(4,1,1,1));
        add(spacer);
        
        JPanel srrButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        srrButton = new JButton("Student Registration Report");
        srrButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					StudentRegistrationReport.loadStudentData();
					layout.show(parentPanel,"srrPage");
				}
		});
        srrButtonPanel.add(srrButton);
        buttonPanel.add(srrButtonPanel);
        
        JPanel bsrButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bsrButton = new JButton("Batch wise Student Report");
        bsrButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					BatchWiseStudentReport.setBatchArray(StudentManagementSystem.batchNameArray);
					layout.show(parentPanel,"bsrPage");
				}
		});
        bsrButtonPanel.add(bsrButton);
        buttonPanel.add(bsrButtonPanel);
        
        JPanel ietrButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ietrButton = new JButton("Industry Training Eligibility Report");
        ietrButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				IndustryTrainigEligibilityReport.loadStudentData();
				layout.show(parentPanel,"iterPage");
			}
		});
        ietrButtonPanel.add(ietrButton);
        buttonPanel.add(ietrButtonPanel);
        
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    backToHomeButton = new JButton("Back");
	    backToHomeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					layout.show(parentPanel,"homepage");
				}
		});
		backButtonPanel.add(backToHomeButton);
		buttonPanel.add(backButtonPanel);
		
		add("Center",buttonPanel);
	}
}

class AddStudent extends JPanel {
    JLabel title, batch, nic, name, lectureMode;
    JTextField nicTf, nameTf;
    static JComboBox<Integer> dropdown;
    static DefaultComboBoxModel<Integer> batchModel = new DefaultComboBoxModel<>();
    JButton addButton, cancelButton;
    String[] lecModeoptions = {"Online", "Physical"};
    static boolean hasBatchError = false;
    static boolean hasNicError = false;
    static String regNo = "";

    public static void setBatchArray(int[] ar) {
        batchModel.removeAllElements();
        for (int value : ar) {
            batchModel.addElement(value);
        }
    }

    public static void setBatchError(boolean newState) { hasBatchError = newState; }
    public static void setNicError(boolean newState) { hasNicError = newState; }
    public static void setRegNo(String value) { regNo = value; }

    AddStudent(CardLayout layout, JPanel parentPanel) {
        setLayout(new BorderLayout());

        // Title
        JPanel titlePanel = new JPanel(new GridLayout(4, 1, 1, 1));
        title = new JLabel("Home > Student Management > Add Student");
        title.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        // West labels
        JPanel westPanel = new JPanel(new GridLayout(4, 1, 1, 1));
        westPanel.add(centerLabel("Batch"));
        westPanel.add(centerLabel("NIC"));
        westPanel.add(centerLabel("Name"));
        westPanel.add(centerLabel("Lecture Mode"));
        add(westPanel, BorderLayout.WEST);

        // Center fields
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 1, 1));

        JPanel dropdownPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dropdown = new JComboBox<>(batchModel);
        dropdownPanel.add(dropdown);
        centerPanel.add(dropdownPanel);

        JPanel nicTfPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nicTf = new JTextField(15);
        nicTfPanel.add(nicTf);
        centerPanel.add(nicTfPanel);

        JPanel nameTfPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nameTf = new JTextField(20);
        nameTfPanel.add(nameTf);
        centerPanel.add(nameTfPanel);

        JPanel dropdownLecPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JComboBox<String> dropdownLecMode = new JComboBox<>(lecModeoptions);
        dropdownLecPanel.add(dropdownLecMode);
        centerPanel.add(dropdownLecPanel);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom buttons
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        addButton.addActionListener(e -> {
            String nicStr = nicTf.getText();
            String nameStr = nameTf.getText();
            Integer batchInt = (Integer) dropdown.getSelectedItem();
            int lecModeInt = dropdownLecMode.getSelectedItem().equals("Online") ? 0 : 1;

            if (nameStr != null && !nameStr.isBlank() && nicStr != null && !nicStr.isBlank()) {
                StudentManagementSystem.addStudent(nicStr, nameStr, batchInt, lecModeInt);
                if (!hasBatchError) {
                    if (!hasNicError) {
                        JOptionPane.showMessageDialog(AddStudent.this,
                            "Student was successfully added to the system.\nRegister Id: " + regNo,
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                        nicTf.setText("");
                        nameTf.setText("");
                        dropdown.setSelectedIndex(0);
                        dropdownLecMode.setSelectedIndex(0);
                        regNo = null;
                    } else {
                        JOptionPane.showMessageDialog(AddStudent.this,
                            "Students cannot be added. NIC already exists.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(AddStudent.this,
                        "Students cannot be added to this batch because enrollment is closed.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(AddStudent.this,
                    "Please fill in both NIC and Name fields.",
                    "Missing Input", JOptionPane.WARNING_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> {
            layout.show(parentPanel, "smPage");
            nicTf.setText("");
            nameTf.setText("");
            dropdown.setSelectedIndex(0);
            dropdownLecMode.setSelectedIndex(0);
            regNo = null;
        });

        southPanel.add(addButton);
        southPanel.add(cancelButton);
        add(southPanel, BorderLayout.SOUTH);
    }

    private JLabel centerLabel(String text) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        return label;
    }
}

class UpdateStudent extends JPanel{
	JLabel title;
	JLabel regNo;
	JLabel description;
	JLabel name;
	JLabel nic;
	JLabel prf;
	JLabel dbms;
	JLabel gpa;
	
	JTextField regNoTf;
	JTextField nameTf;
	JTextField nicTf;
	JTextField prfTf;
	JTextField dbmsTf;
	JTextField gpaTf;
	
	JButton enterButton;
	JButton cancelButton;
	JButton updateButton;
	JButton deleteButton;
	
	static boolean hasRegNoError = false;
	static String[] recivedData;
	
	UpdateStudent(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new GridLayout(4,1,1,1));
		title = new JLabel("Home > Student Management > Update Students");
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.add(title);
		
		add("North",northPanel);
		
		JPanel centerPanel = new JPanel(new GridLayout(8,1,1,1));
		
		description = new JLabel("<html>View details, update details and <br>students delete can be done here</html>");
		description.setHorizontalAlignment(JLabel.CENTER);
		description.setForeground(Color.RED);
		centerPanel.add(description);
		
		JPanel regNoTfPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		regNo = new JLabel("Student Register Id");
		regNoTfPanel.add(regNo);
		
		regNoTf = new JTextField(15);
		regNoTfPanel.add(regNoTf);
		
		centerPanel.add(regNoTfPanel);
		
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		name = new JLabel("Name");
		namePanel.add(name);
		
		nameTf = new JTextField(15);
		nameTf.setEditable(false);
		namePanel.add(nameTf);
		
		centerPanel.add(namePanel);
		
		JPanel nicPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		nic = new JLabel("Nic");
		nicPanel.add(nic);
		
		nicTf = new JTextField(15);
		nicTf.setEditable(false);
		nicPanel.add(nicTf);
		
		centerPanel.add(nicPanel);
		
		JPanel prfPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		prf = new JLabel("PRF Marks");
		prfPanel.add(prf);
		
		prfTf = new JTextField(15);
		prfTf.setEditable(false); 
		prfPanel.add(prfTf);
		
		centerPanel.add(prfPanel);
		
		JPanel dbmsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		dbms = new JLabel("DBMS Marks");
		dbmsPanel.add(dbms);
		
		dbmsTf = new JTextField(15);
		dbmsTf.setEditable(false);
		dbmsPanel.add(dbmsTf);
		
		centerPanel.add(dbmsPanel);
		
		JPanel gpaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		gpa = new JLabel("GPA");
		gpaPanel.add(gpa);
		
		gpaTf = new JTextField(15);
		gpaTf.setEditable(false);
		gpaPanel.add(gpaTf);
		
		centerPanel.add(gpaPanel);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
				String regNoStr = regNoTf.getText();
				StudentManagementSystem.viewStudentProfile(regNoStr);
				if(regNoStr != null && !regNoStr.isBlank()){
					if(!hasRegNoError){
						nameTf.setText(recivedData[0]);
						nicTf.setText(recivedData[1]);
						prfTf.setText(recivedData[2]);
						dbmsTf.setText(recivedData[3]);
						gpaTf.setText(recivedData[4]);
						
						regNoTf.setEditable(false);
						nameTf.setEditable(true);
						nicTf.setEditable(true);
						
						updateButton.setEnabled(true);
						deleteButton.setEnabled(true);
					}else{
						JOptionPane.showMessageDialog(UpdateStudent.this,"Students cannot be found.","Error",JOptionPane.ERROR_MESSAGE);
						regNoTf.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(UpdateStudent.this,"Please fill fields.","Missing Input",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		buttonPanel.add(enterButton);
		
		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(regNoTf.getText() != null && !regNoTf.getText().isBlank() && nameTf.getText() != null && !nameTf.getText().isBlank() && nicTf.getText() != null && !nicTf.getText().isBlank()){
					if(!hasRegNoError){
						StudentManagementSystem.updateStudent(regNoTf.getText(),nicTf.getText(),nameTf.getText());
						JOptionPane.showMessageDialog(UpdateStudent.this,"Student details were successfully updated.","Success",JOptionPane.INFORMATION_MESSAGE);
						
						regNoTf.setText("");
						nameTf.setText("");
						nicTf.setText("");
						prfTf.setText("");
						dbmsTf.setText("");
						gpaTf.setText("");
						nameTf.setEditable(false);
						nicTf.setEditable(false);
						
						updateButton.setEnabled(false);
						deleteButton.setEnabled(false);
						regNoTf.setEditable(true);
						
						recivedData = null;
					}else{
						JOptionPane.showMessageDialog(UpdateStudent.this,"Students cannot be found.","Error",JOptionPane.ERROR_MESSAGE);
						regNoTf.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(UpdateStudent.this,"Please fill fields.","Missing Input",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		buttonPanel.add(updateButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(regNoTf.getText() != null && !regNoTf.getText().isBlank() && nameTf.getText() != null && !nameTf.getText().isBlank() && nicTf.getText() != null && !nicTf.getText().isBlank()){
					if(!hasRegNoError){
						StudentManagementSystem.deleteStudentProfile(regNoTf.getText());
						JOptionPane.showMessageDialog(UpdateStudent.this,"Student wasvsuccessfully deleted.","Success",JOptionPane.INFORMATION_MESSAGE);
						
						regNoTf.setText("");
						nameTf.setText("");
						nicTf.setText("");
						prfTf.setText("");
						dbmsTf.setText("");
						gpaTf.setText("");
						nameTf.setEditable(false);
						nicTf.setEditable(false);
						
						updateButton.setEnabled(false);
						deleteButton.setEnabled(false);
						regNoTf.setEditable(true);
						
						recivedData = null;
					}else{
						JOptionPane.showMessageDialog(UpdateStudent.this,"Students cannot be found.","Error",JOptionPane.ERROR_MESSAGE);
						regNoTf.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(UpdateStudent.this,"Please fill fields.","Missing Input",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
			}
		});
		buttonPanel.add(deleteButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				regNoTf.setText("");
				nameTf.setText("");
				nicTf.setText("");
				prfTf.setText("");
				dbmsTf.setText("");
				gpaTf.setText("");
				nameTf.setEditable(false);
				nicTf.setEditable(false);
				
				updateButton.setEnabled(false);
				deleteButton.setEnabled(false);
				regNoTf.setEditable(true);
				
				recivedData = null;
				layout.show(parentPanel,"smPage");
			}
		});
		buttonPanel.add(cancelButton);
		
		centerPanel.add(buttonPanel);
		
		add("Center",centerPanel);
		
		
	}
	
		
	public static void setRegNoError(boolean newState){hasRegNoError = newState;}
	public static void setData(String[] newData){ recivedData = newData;}
}

class AddBatch extends JPanel{
	JLabel title;
	JLabel batch;
	JLabel description;
	
	JTextField batchTf;
	
	JButton enterButton;
	JButton cancelButton;
	
	static boolean hasBatchError = false;
	static boolean hasBatchNoError = false;
	
	AddBatch(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new GridLayout(4,1,1,1));
		title = new JLabel("Home > Student Management > Add Batch");
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.add(title);
		
		add("North",northPanel);
		
		JPanel centerPanel = new JPanel(new GridLayout(4,1,1,1));
		
		description = new JLabel("<html>Batch Number should be greater than 100 and <br> doesn't exists in system<html>");
		description.setHorizontalAlignment(JLabel.CENTER);
		description.setForeground(Color.RED);
		centerPanel.add(description);
		
		JPanel batchTfPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		batch = new JLabel("Batch Number");
		batchTfPanel.add(batch);
		
		batchTf = new JTextField(15);
		batchTfPanel.add(batchTf);
		
		centerPanel.add(batchTfPanel);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				int batchInt = Integer.parseInt(batchTf.getText());
				
				if(batchTf.getText() != null && !batchTf.getText().isBlank()){
					StudentManagementSystem.addBatch(batchInt);
					if(!hasBatchNoError){
						if(!hasBatchError){
							JOptionPane.showMessageDialog(AddBatch.this,
                            "Batch was successfully added to the system.",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                            batchTf.setText("");
						}else{
							JOptionPane.showMessageDialog(AddBatch.this,"Batch already exists.","Error",JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(AddBatch.this,"Batch Number should be greater than 100","Missing Input",JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(AddBatch.this,"Please fill fields.","Missing Input",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		buttonPanel.add(enterButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				batchTf.setText("");
				hasBatchError = false;
				hasBatchNoError = false;
				layout.show(parentPanel,"bmPage");
			}
		});
		buttonPanel.add(cancelButton);
		
		centerPanel.add(buttonPanel);
		
		add("Center",centerPanel);
		
	}
	public static void setBatchError(boolean newState){hasBatchError = newState;}
	public static void setBatchNoError(boolean newState){hasBatchNoError = newState;}
}

class UpdateBatch extends JPanel{
	JLabel title;
	JLabel batch;
	JLabel description;
	
	JTextField batchTf;
	
	JButton enterButton;
	JButton updateButton;
	JButton cancelButton;
	
	static boolean hasBatchError = false;
	
	static String[] options = {"Close","Open"};
	static JComboBox<String> batchStatus = new JComboBox<>(options);
	
	UpdateBatch(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new GridLayout(4,1,1,1));
		title = new JLabel("Home > Student Management > Update Batch");
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.add(title);
		
		add("North",northPanel);
		
		JPanel centerPanel = new JPanel(new GridLayout(4,1,1,1));
		
		description = new JLabel("<html>This page only shows batches <br>that can be updated.<html>");
		description.setHorizontalAlignment(JLabel.CENTER);
		description.setForeground(Color.RED);
		centerPanel.add(description);
		
		JPanel batchTfPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		batch = new JLabel("Batch Number");
		batchTfPanel.add(batch);
		
		batchTf = new JTextField(15);
		batchTfPanel.add(batchTf);
		
		batchTfPanel.add(batchStatus);
		
		centerPanel.add(batchTfPanel);
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(batchTf.getText() != null && !batchTf.getText().isBlank()){
					StudentManagementSystem.updateBatch(Integer.parseInt(batchTf.getText()));
					if(!hasBatchError){
						updateButton.setEnabled(true);
						batchTf.setEditable(false);
						enterButton.setEnabled(false);
					}else{
						JOptionPane.showMessageDialog(UpdateBatch.this,"batch doesn't exists","Error",JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(UpdateBatch.this,"Please fill the field","Missing Input",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		buttonPanel.add(enterButton);
		
		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					StudentManagementSystem.updateBatch(Integer.parseInt(batchTf.getText()),(batchStatus.getSelectedItem()).equals("Close") ? 0 : 1);
					JOptionPane.showMessageDialog(UpdateBatch.this,"Batch is successfully updated","Success",JOptionPane.INFORMATION_MESSAGE);
					batchTf.setText("");
					batchStatus.setSelectedIndex(0);
					batchTf.setEditable(true);
					enterButton.setEnabled(true);
				}
		});
		buttonPanel.add(updateButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				batchTf.setText("");
				batchStatus.setSelectedIndex(0);
				layout.show(parentPanel,"bmPage");
				batchTf.setEditable(true);
				enterButton.setEnabled(true);
			}
		});
		buttonPanel.add(cancelButton);
		
		centerPanel.add(buttonPanel);
		
		add("Center",centerPanel);
		
	}
	
	public static void setBatchNoError(boolean newState){hasBatchError = newState;}
	public static void setBatchStatus(int value){batchStatus.setSelectedIndex(value);}
	
}

class ViewBatch extends JPanel{
	JLabel title;
	
	static DefaultTableModel dtb;
	JTable tbl;
	JScrollPane tablePane;
	
	JButton cancelButton;
	
	ViewBatch(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new GridLayout(4,1,1,1));
		title = new JLabel("Home > Student Management > Update Batch");
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.add(title);
		
		add("North",northPanel);
		
		String[] columns = {"No","Batch No", "Student Count", "Status"};
		dtb = new DefaultTableModel(columns,0);
		tbl = new JTable(dtb);
		tablePane = new JScrollPane(tbl);
		
		add("Center",tablePane);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				layout.show(parentPanel,"bmPage");
				//loadBatchData();
				dtb.setRowCount(0);
			}
		});
		
		add("South",cancelButton);
		
		
	}
	//System.out.printf("%-5d %-10d %-20d %-35s%n",i+1,batchNameArray[i],findNumberOfStudent(batchNameArray[i]),(batchStatusArray[i] == 0 ? "ECROLLMENT CLOSED" : "ENCROLLMENT OPEN" ));
	public static void loadBatchData(){
		for (int i = 0; i < StudentManagementSystem.batchNameArray.length; i++)
		{
			String[] data = {String.valueOf(i+1),String.valueOf(StudentManagementSystem.batchNameArray[i]),String.valueOf(StudentManagementSystem.findNumberOfStudent(StudentManagementSystem.batchNameArray[i])),(StudentManagementSystem.batchStatusArray[i] == 0 ? "ECROLLMENT CLOSED" : "ENCROLLMENT OPEN" )};
			dtb.addRow(data);
		}
		
	}
}

class MarksUpdate extends JPanel{
	JLabel title;
	JLabel prfMarks;
	JLabel dbmsMarks;
	JLabel regNo;
	
	JLabel description;
	
	JTextField regNoTf;
	
	JButton enterButton;
	JButton updateButton;
	JButton cancelButton;
	
	static boolean hasRegNoError = false;
	static String prfMarksStr = "";
	static String dbmsMarksStr = "";
	
	MarksUpdate(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new GridLayout(4,1,1,1));
		title = new JLabel("Home > Student Management > Marks Update");
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.add(title);
		
		add("North",northPanel);
		
		JPanel centerPanel = new JPanel(new GridLayout(5,1,1,1));
		
		description = new JLabel("<html>Boths marks can be updated here</html>");
		description.setHorizontalAlignment(JLabel.CENTER);
		description.setForeground(Color.RED);
		centerPanel.add(description);
		
		JPanel regNoTfPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		regNo = new JLabel("Student Register Id");
		regNoTfPanel.add(regNo);
		
		regNoTf = new JTextField(15);
		regNoTfPanel.add(regNoTf);
		
		centerPanel.add(regNoTfPanel);
		
		JPanel prfPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField prfMarksTf = new JTextField(15);
        prfPanel.add(new JLabel("PRF Marks"));
        prfPanel.add(prfMarksTf);
        
        JPanel dbmsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField dbmsMarksTf = new JTextField(15);
        dbmsPanel.add(new JLabel("DBMS Marks"));
        dbmsPanel.add(dbmsMarksTf);
        
        centerPanel.add(prfPanel);
        centerPanel.add(dbmsPanel);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(regNoTf.getText() != null && !regNoTf.getText().isBlank()){
					//StudentManagementSystemupdateBatch(Integer.parseInt(batchTf.getText()));
					StudentManagementSystem.prfMarksUpdate(regNoTf.getText());
					if(!hasRegNoError){
						prfMarksTf.setText(prfMarksStr);
						dbmsMarksTf.setText(dbmsMarksStr);
						
						updateButton.setEnabled(true);
						regNoTf.setEditable(false);
						enterButton.setEnabled(false);
					}else{
						JOptionPane.showMessageDialog(MarksUpdate.this,"Student doesn't exists","Error",JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(MarksUpdate.this,"Please fill the field","Missing Input",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		buttonPanel.add(enterButton);
        
		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					//StudentManagementSystemupdateBatch(Integer.parseInt(batchTf.getText()),(batchStatus.getSelectedItem()).equals("Close") ? 0 : 1);
					StudentManagementSystem.dbmsMakrsUpdate(regNoTf.getText(),Integer.parseInt(prfMarksTf.getText()),Integer.parseInt(dbmsMarksTf.getText()));
					JOptionPane.showMessageDialog(MarksUpdate.this,"Marks are successfully updated","Success",JOptionPane.INFORMATION_MESSAGE);
					regNoTf.setText("");
					prfMarksTf.setText("");
					dbmsMarksTf.setText("");
					//batchStatus.setSelectedIndex(0);
					regNoTf.setEditable(true);
					enterButton.setEnabled(true);
					updateButton.setEnabled(false);
				}
		});
		buttonPanel.add(updateButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				regNoTf.setText("");
				//batchStatus.setSelectedIndex(0);
				regNoTf.setEditable(true);
				prfMarksTf.setText("");
				dbmsMarksTf.setText("");
				enterButton.setEnabled(true);
				layout.show(parentPanel,"gmPage");
			}
		});
		buttonPanel.add(cancelButton);
		
		centerPanel.add(buttonPanel);
		
		add("Center",centerPanel);
        
        
	}
	public static void setRegNoError(boolean newState){hasRegNoError = newState;}
	public static void setPrfMarks(int value){prfMarksStr = String.valueOf(value);System.out.println(prfMarksStr);}
	public static void setDbmsMarks(int value){dbmsMarksStr = String.valueOf(value);}
	
}

class StudentRegistrationReport extends JPanel{
	JLabel title;
	
	static DefaultTableModel dtb;
	JTable tbl;
	JScrollPane tablePane;
	
	JButton cancelButton;
	StudentRegistrationReport(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new GridLayout(4,1,1,1));
		title = new JLabel("Home > Student Management > Report Generator > Student Registration Report");
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.add(title);
		
		add("North",northPanel);
		
		String[] columns = {"No","Restration ID", "Student Name", "Nic", "PRF Marks", "DBMS Marks","GPA"};
		dtb = new DefaultTableModel(columns,0);
		tbl = new JTable(dtb);
		tablePane = new JScrollPane(tbl);
		
		add("Center",tablePane);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//loadStudentData();
				dtb.setRowCount(0);
				layout.show(parentPanel,"rgPage");
			}
		});
		
		add("South",cancelButton);
	}
	
	//System.out.printf("%-10d %-25s %-25s %-20s %-20d %-20d %-20.1f%n",i+1,sortedStudentsArray[i].getRegId(),sortedStudentsArray[i].getName(),sortedStudentsArray[i].getNic(),sortedStudentsArray[i].getPrfMarks(),sortedStudentsArray[i].getDbmsMarks(),calculateGPA(sortedStudentsArray[i].getDbmsMarks(),sortedStudentsArray[i].getPrfMarks()));
	public static void loadStudentData(){
		StudentManagementSystem.sortArrayAscending();
		for (int i = 0; i < StudentManagementSystem.sortedStudentsArray.length; i++)
		{
			//System.out.println("called from load student data");
			String[] data = {String.valueOf(i+1),StudentManagementSystem.sortedStudentsArray[i].getRegId(),StudentManagementSystem.sortedStudentsArray[i].getName(),StudentManagementSystem.sortedStudentsArray[i].getNic(),String.valueOf(StudentManagementSystem.sortedStudentsArray[i].getPrfMarks()),String.valueOf(StudentManagementSystem.sortedStudentsArray[i].getDbmsMarks()),String.valueOf(StudentManagementSystem.calculateGPA(StudentManagementSystem.sortedStudentsArray[i].getDbmsMarks(),StudentManagementSystem.sortedStudentsArray[i].getPrfMarks()))};
			dtb.addRow(data);
		}
		
	}
}

class IndustryTrainigEligibilityReport extends JPanel{
	JLabel title;
	
	static DefaultTableModel dtb;
	JTable tbl;
	JScrollPane tablePane;
	
	JButton cancelButton;
	
	IndustryTrainigEligibilityReport(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new GridLayout(4,1,1,1));
		title = new JLabel("Home > Student Management > Report Generator > Industry Trainig Eligibility Report");
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.add(title);
		
		add("North",northPanel);
		
		String[] columns = {"No","Restration ID", "Student Name", "NIC", "PRF Marks", "DBMS Marks","GPA"};
		dtb = new DefaultTableModel(columns,0);
		tbl = new JTable(dtb);
		tablePane = new JScrollPane(tbl);
		
		add("Center",tablePane);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtb.setRowCount(0);
				layout.show(parentPanel,"rgPage");
			}
		});
		
		add("South",cancelButton);
	}
	
	public static void loadStudentData(){
		StudentManagementSystem.sortArrayAscending();
		System.out.println("Called");
		int no = 1;
		for (int i = 0; i < StudentManagementSystem.sortedStudentsArray.length; i++)
		{
			//index = findIndexInArray(regNoArray,sortedRegNoArray[i]);
			System.out.println("called from inside for loop");
			if(StudentManagementSystem.calculateGPA(StudentManagementSystem.sortedStudentsArray[i].getDbmsMarks(),StudentManagementSystem.sortedStudentsArray[i].getPrfMarks()) > 3.25 && StudentManagementSystem.sortedStudentsArray[i].getPrfMarks() > 50 && StudentManagementSystem.sortedStudentsArray[i].getDbmsMarks() > 50){
				//System.out.printf("%-10d %-25s %-25s %-20s %-20d %-20d %-20.1f%n",no++,sortedStudentsArray[i].getRegId(),sortedStudentsArray[i].getName(),sortedStudentsArray[i].getNic(),sortedStudentsArray[i].getPrfMarks(),sortedStudentsArray[i].getDbmsMarks(),calculateGPA(sortedStudentsArray[i].getDbmsMarks(),sortedStudentsArray[i].getPrfMarks()));
				//System.out.println(regNoArray[index] +" "+ nameArray[index]+" "+nicArray[index]);
				System.out.println("called from inside condition of forloop");
				String[] data = {String.valueOf(i+1),StudentManagementSystem.sortedStudentsArray[i].getRegId(),StudentManagementSystem.sortedStudentsArray[i].getName(),StudentManagementSystem.sortedStudentsArray[i].getNic(),String.valueOf(StudentManagementSystem.sortedStudentsArray[i].getPrfMarks()),String.valueOf(StudentManagementSystem.sortedStudentsArray[i].getDbmsMarks()),String.valueOf(StudentManagementSystem.calculateGPA(StudentManagementSystem.sortedStudentsArray[i].getDbmsMarks(),StudentManagementSystem.sortedStudentsArray[i].getPrfMarks()))};
				dtb.addRow(data);
			}
		}
		
	}
}

class BatchWiseStudentReport extends JPanel{
	JLabel title;
	
	static DefaultTableModel dtb;
	JTable tbl;
	JScrollPane tablePane;
	
	static JComboBox<Integer> dropdown;
    static DefaultComboBoxModel<Integer> batchModel = new DefaultComboBoxModel<>();
	
	JButton loadButton;
	JButton cancelButton;
	
	String[] options = {"105","106","107","108","109","110"};
	
	public static void setBatchArray(int[] ar) {
        batchModel.removeAllElements();
        for (int value : ar) {
            batchModel.addElement(value);
        }
    }
	
	BatchWiseStudentReport(CardLayout layout, JPanel parentPanel){
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new GridLayout(2,1,1,1));
		title = new JLabel("Home > Student Management > Report Generator > Industry Trainig Eligibility Report");
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.add(title);
		
		//JComboBox<String> dropdownList = new JComboBox<>(options);
		JPanel dropdownPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dropdown = new JComboBox<>(batchModel);
		dropdown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtb.setRowCount(0);
			}
		});
		dropdownPanel.add(dropdown);
		
		loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(dtb.getRowCount() == 0) loadStudentData();
			}
		});
		dropdownPanel.add(loadButton);
		
		northPanel.add(dropdownPanel);
		
		add("North",northPanel);
		
		String[] columns = {"No","Restration ID", "Student Name", "Nic", "PRF Marks", "DBMS Marks","GPA"};
		dtb = new DefaultTableModel(columns,0);
		tbl = new JTable(dtb);
		tablePane = new JScrollPane(tbl);
		
		add("Center",tablePane);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtb.setRowCount(0);
				layout.show(parentPanel,"rgPage");
				//loadStudentData();
			}
		});
		
		add("South",cancelButton);
		
	}
	public static void loadStudentData(){
		StudentManagementSystem.sortArrayAscending();
		int no = 1;
		for (int i = 0; i < StudentManagementSystem.sortedStudentsArray.length; i++)
		{
			//index = findIndexInArray(regNoArray, sortedRegNoArray[i]);
						
			String spliteBatchName = StudentManagementSystem.sortedStudentsArray[i].getRegId().substring(4,7);
			int batchNameInt = Integer.parseInt(spliteBatchName);
			if(batchNameInt == ((Integer) dropdown.getSelectedItem())){
				//int batchIndex = findIndexInArray(regNoArray,regNoArray[i]);
			//System.out.printf("%-10d %-25s %-25s %-20s %-20d %-20d %-20.1f%n",no++,sortedStudentsArray[i].getRegId(),sortedStudentsArray[i].getName(),sortedStudentsArray[i].getNic(),sortedStudentsArray[i].getPrfMarks(),sortedStudentsArray[i].getDbmsMarks(),calculateGPA(sortedStudentsArray[i].getDbmsMarks(),sortedStudentsArray[i].getPrfMarks()));
			String data[] = {String.valueOf(no++),StudentManagementSystem.sortedStudentsArray[i].getRegId(),StudentManagementSystem.sortedStudentsArray[i].getName(),StudentManagementSystem.sortedStudentsArray[i].getNic(),String.valueOf(StudentManagementSystem.sortedStudentsArray[i].getPrfMarks()),String.valueOf(StudentManagementSystem.sortedStudentsArray[i].getDbmsMarks()),String.valueOf(StudentManagementSystem.calculateGPA(StudentManagementSystem.sortedStudentsArray[i].getDbmsMarks(),StudentManagementSystem.sortedStudentsArray[i].getPrfMarks()))};
			dtb.addRow(data);
			}
		}
	}
}


class StudentManagementSystem {
    // Batch status
    public static final int ENROLLMENTOPEN = 1;
    public static final int ENROLLMENTCLOSED = 0;

    // Batch data
    static int[] batchNameArray = {};
    static int[] batchStatusArray = {};
    static int[] batchStudentCountArray = { 25, 25, 25, 25, 25, 25 };
    
    // student object array
    static Student[] studentsArray = {};
	
	static Student[] sortedStudentsArray = {};
    
    // this method use to load data from computer local file to program's arrays
	public static void loadData(){
		try{
			Scanner scannerForStudent = new Scanner(new File("student_data_set.txt"));
			while(scannerForStudent.hasNext()){
				String line = scannerForStudent.nextLine();
				String[] data = line.split(",");
				Student studentData = new Student(data[0],data[1],data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4]));
				studentsArray = extendArray(studentsArray,studentData);
			}
			
			Scanner scannerForBatch = new Scanner(new File("batch_details.txt"));
			while(scannerForBatch.hasNext()){
				String line = scannerForBatch.nextLine();
				String[] batchData = line.split(",");
				batchNameArray = extendArray(batchNameArray,Integer.parseInt(batchData[0]));
				batchStatusArray = extendArray(batchStatusArray,Integer.parseInt(batchData[1]));
			}
		}catch(IOException e){
			
		}
	}
	
	public static void saveData(){
		try{
			clearFile();
			FileWriter fw1 = new FileWriter("student_data_set.txt",true);
			for (int i = 0; i < studentsArray.length; i++)
			{
				fw1.write(studentsArray[i]+"\n");
			}
			fw1.close();
			
			FileWriter fw2 = new FileWriter("batch_details.txt");
			for (int i = 0; i < batchNameArray.length; i++)
			{
				String data = String.valueOf(batchNameArray[i]+","+batchStatusArray[i]);
				fw2.write(data+"\n");
			}
			fw2.close();
		}catch(IOException e){
			//
		}
	}
	
	public static void clearFile(){
		try{
			FileWriter fw = new FileWriter("student_data_set.txt",false);
			fw.write("");
			fw.close();
		}catch(IOException e){
			//
		}
	}

    // console clear
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

     // Exit
    public static void exit() {
        clearConsole();
        System.out.println("\n\t\tYou left the program...\n");
        System.exit(0);
    }


    // home page
    public static void homePage() {
        do {
			
			drawBox("ICET Student Management System : Home");
			System.out.println("\t[1] Student Management");
			System.out.println("\n\t[2] Batch Management ");
			System.out.println("\n\t[3] Grade Management");
			System.out.println("\n\t[4] Report Generator");
			System.out.println("\n\t[5] Exit");

            int option = getOption();
			
			if(option >= 1 && option <=5){
				switch (option) {
					case 1:
						clearConsole();
						studentManagement();
						break;
					case 2:
						clearConsole();
						batchManagement();
						break;
					case 3:
						clearConsole();
						gradeManagement();
						break;
					case 4:
						clearConsole();
						reportGenerator();
						break;
					case 5:
						exit();
						break;
				}
			}else{
				if(isInvalidOption('e',""))exit();
				else clearConsole();
			}
        } while (true);
    }

    // Student Management
    public static void studentManagement() {
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Student Management");
			System.out.println("\t[1] Add Student");
			System.out.println("\n\t[2] Update Student ");
			System.out.println("\n\t[3] View Student Profile");
			System.out.println("\n\t[4] Delete Student Profile");
			System.out.println("\n\t[5] Exit");
			
            int option = getOption();
            
            if(option >= 1 && option <= 5){
				switch(option){
					case 1:
						clearConsole();
						//addStudent();
						break;
					case 2:
						clearConsole();
						//updateStudent();
						break;
					case 3:
						clearConsole();
						//viewStudentProfile();
						break;
					case 4:
						clearConsole();
						//deleteStudentProfile();
						break;
					case 5:
						clearConsole();
						isContinue = false;
						break;
				}
			}else{
				if(isInvalidOption('m',"")) {isContinue = false; clearConsole();}
				else clearConsole();
			}
            
		}while(isContinue);

    }

    
    // Batch Management
    public static void batchManagement() {
		boolean isContinue = false;
		
		do{
			isContinue = true;

			drawBox("Home > Batch Management");
			System.out.println("\t[1] Add Batch");
			System.out.println("\n\t[2] Update Batch ");
			System.out.println("\n\t[3] View Batches");
			System.out.println("\n\t[4] Exit");
			
			int option = getOption();
			
			if(option >= 1 && option <= 4){
				switch(option){
					case 1:
						clearConsole();
						//addBatch();
						break;
					case 2:
						clearConsole();
						//updateBatch();
						break;
					case 3:
						clearConsole();
						//viewBatches();
						break;
					case 4:
						clearConsole();
						isContinue = false;
						break;
				}
			}else{
				if(isInvalidOption('m',"")){ isContinue = false; clearConsole();}
				else clearConsole();
			}
			
		}while(isContinue);

    }

   

    // Grade Management
    public static void gradeManagement() {
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Grade Management");
			System.out.println("\t[1] PRF Marks Update");
			System.out.println("\n\t[2] DBMS Marks Update ");
			System.out.println("\n\t[3] Exit");
			
			int option = getOption();
			
			if(option >= 1 && option <= 3){
				switch(option){
					case 1:
						clearConsole();
						//prfMarksUpdate();
						break;
					case 2:
						clearConsole();
						//dbmsMakrsUpdate();
						break;
					case 3:
						clearConsole();
						isContinue = false;
						break;
				}
			}else{
				if(isInvalidOption('m',"")){ isContinue = false; clearConsole();}
				else clearConsole();
			}
			
		}while(isContinue);

    }

    
    // Report Generator
    public static void reportGenerator() {
		//sortArrayAscending(nameArray,sortedNameArray);
		sortArrayAscending();
		
		boolean isContinue = false;
		
		do{
			isContinue = true;
			
			drawBox("Home > Report Generator");
			System.out.println("\t[1] Student Registration Report");
			System.out.println("\t[2] Batch wise Student Report");
			System.out.println("\t[3] Industry Training Eligibility Report");
			System.out.println("\t[4] Exit");
			
			int option = getOption();
			
			if(option >= 1 && option <= 4){
				switch(option){
					case 1:
						clearConsole();
						studentRegistrationReport();
						break;
					case 2:
						clearConsole();
						batchWiseStudentReport();
						break;
					case 3:
						clearConsole();
						industryTrainingEligibility();
						break;
					case 4:
						clearConsole();
						isContinue = false;
						break;
				}
			}else{
				if(isInvalidOption('m',"")){isContinue = false; clearConsole();}
				else clearConsole();
			}
        
		}while(isContinue);

    }
    
    
    ///////////////////////////////  STUDENT MANAGEMENT ///////////////////////////////////////
    
    // Add student
    public static void addStudent(String nicFromSwing, String nameFromSwing, int batchFromSwing, int lecModeFromSwing){
		//Scanner scanner = new Scanner(System.in);
		
		boolean isContinue = false;
		//do{
			isContinue = true;
			
			drawBox("Home > Student Management > Add Student");
			System.out.print("Enter Batch Number (Students should be added) : ");
			int batchName = batchFromSwing;
			
			int batchIndex = findIndexInArray(batchNameArray,batchName);
			if(batchIndex != -1){
				int batchStatus = findValueInArray(batchStatusArray,batchIndex);
				if(batchStatus == 1){
					
					System.out.print("Enter Student Nic : ");
					String nic = nicFromSwing;
					
					int checkNic = findIndexInArray(studentsArray,nic,'n');
					if(checkNic == -1){
						System.out.print("Enter Student Name : ");
						String name = nameFromSwing;
						                                
						System.out.print("Enter Lecturer Mode (1 - PHYSICAL 0 - ONLINE) : ");
						int lectureMode = lecModeFromSwing;
						
						String generatedRegNo = generateRegistrationNumber(lectureMode,batchName);
						
						Student student = new Student(generatedRegNo,nic,name,-2,-2);
						for(Student ns : studentsArray){
							System.out.println(ns.getName() + " before");
						}
						studentsArray = extendArray(studentsArray, student);
						student = null;
						for(Student ns : studentsArray){
							System.out.println(ns.getName()+ " after");
						}
						
						//nicArray = extendArray(nicArray,nic);
						//nameArray = extendArray(nameArray,name);
						//regNoArray = extendArray(regNoArray,generatedRegNo);
						//prfArray = extendArray(prfArray,-2);
						//dbmsArray = extendArray(dbmsArray,-2);
						
						
						System.out.println("\tStudent Registration No - "+generatedRegNo);
						AddStudent.setRegNo(generatedRegNo);
						AddStudent.setNicError(false);
						AddStudent.setBatchError(false);
						System.out.println("Student was successfully added to the system.");
						
						// save data to computer loca file
						saveData();
						
						//if(isInvalidOption('t',"\tStudent was successfully added to the system.\nDo you want to add another student (Y/N) : "))clearConsole();
						//else {isContinue = false; clearConsole();}
						
						
					}else{
						//if(isInvalidOption('t',"\t Nic already exist.\nDo you want to try again (Y/N) : ")) clearConsole();
						//else {isContinue = false; clearConsole();}
						AddStudent.setNicError(true);
					}
					
					
				}else{
					//if(isInvalidOption('t',"\tStudents cannot be added to this batch because enrollment is closed.\nDo you want to add student to another Batch (Y/N):")) clearConsole();
					//else{ isContinue = false; clearConsole();}
					AddStudent.setBatchError(true);
				}
			}else{
				//if(isInvalidOption('t',"\tBatch number does not exist\nDo you want to enter again (Y/N) : ")) clearConsole();
				//else {isContinue = false; clearConsole();}
				
			}
			
			//int temp = scanner.nextInt();
			
		//}while(isContinue);
	}
	
	// update students
	public static void updateStudent(String regNoFromSwing, String nicFromSwing, String nameFromSwing){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		//do{
			isContinue = true;
			
			drawBox("Home > Student Management > Update Student");
			System.out.print("Enter Student Registration No : ");
			String regNumber = regNoFromSwing;

			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				
				System.out.print("What do you want to update ? \n\t(01) Student Name\n\t(02) Student Nic\n\nEnter an option : ");
				//int option = scanner.nextInt();
			/*	switch(option){
						case 1:
							System.out.println("\tRegistration No : "+regNumber);
							System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
							System.out.println("\tStudnet Current Name : "+studentsArray[regNoIndex].getName());
							System.out.println();
							
							System.out.print("Enter Student Name to Update : ");
							String name = scanner.next();
							//updateArrayValue(nameArray,regNoIndex,name);
							studentsArray[regNoIndex].setName(name);
							
							//System.out.println(Arrays.toString(nameArray));
							if(isInvalidOption('t',"\tStudent name was successfully added to the system.\nDo you want to update another student (Y/N) : "))clearConsole();
							else {isContinue = false; clearConsole();}
							
							break;
						case 2:
							System.out.println("\tRegistration No : "+regNumber);
							System.out.println("\tStudnet Name : "+studentsArray[regNoIndex].getName());
							System.out.println("\tStudent Current Nic : "+studentsArray[regNoIndex].getNic());
							System.out.println();
							
							System.out.print("Enter Student nic to Update : ");
							String nic = scanner.next();
							//updateArrayValue(nicArray,regNoIndex,nic);
							studentsArray[regNoIndex].setNic(nic);
							
							if(isInvalidOption('t',"\tStudent name was successfully added to the system.\nDo you want to add update student (Y/N) : "))clearConsole();
							else {isContinue = false; clearConsole();}
							break;
				}  */
				studentsArray[regNoIndex].setName(nameFromSwing);
				studentsArray[regNoIndex].setNic(nicFromSwing);
				
				// save data to computer loca file
				saveData();
				
				//String passingPrf = String.valueOf(studentsArray[regNoIndex].getPrfMarks());
				//String passingDbms = String.valueOf(studentsArray[regNoIndex].getDbmsMarks());
				//String passingGpa = String.valueOf(calculateGPA(studentsArray[regNoIndex].getDbmsMarks(),studentsArray[regNoIndex].getPrfMarks()));
				//String[] passingData = {studentsArray[regNoIndex].getNic(),studentsArray[regNoIndex].getName(),passingPrf,passingDbms,passingGpa};
				
				//UpdateStudent.setData(passingData);
				
			}else{
				//if(isInvalidOption('t',"\tThis student not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				//else {isContinue = false; clearConsole();}
				UpdateStudent.setRegNoError(true);
			}
		//}while(isContinue);
	}
	
	// view student profile
	public static void viewStudentProfile(String regNoFromSwing){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		//do{
			isContinue = true;
			
			drawBox("Home > Student Management > View Student Profile");
			System.out.print("Enter Student Registration No : ");
			String regNumber = regNoFromSwing;
			
			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				/*System.out.println("\tRegistration No : "+regNumber);
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				System.out.println("\tStudent PRF Marks : "+studentsArray[regNoIndex].getPrfMarks());
				System.out.println("\tStudent DBMS Marks : "+studentsArray[regNoIndex].getDbmsMarks());
				System.out.println("\tStudent GPA : " + calculateGPA(studentsArray[regNoIndex].getDbmsMarks(),studentsArray[regNoIndex].getPrfMarks()));
				
				if(isInvalidOption('t',"Do you want to search another student details (Y/N) : "))clearConsole();
				else {isContinue = false; clearConsole();} */
				String passingPrf = String.valueOf(studentsArray[regNoIndex].getPrfMarks());
				String passingDbms = String.valueOf(studentsArray[regNoIndex].getDbmsMarks());
				String passingGpa = String.valueOf(calculateGPA(studentsArray[regNoIndex].getDbmsMarks(),studentsArray[regNoIndex].getPrfMarks()));
				String[] passingData = {studentsArray[regNoIndex].getNic(),studentsArray[regNoIndex].getName(),passingPrf,passingDbms,passingGpa};
				
				UpdateStudent.setData(passingData);
						
			}else{
				//if(isInvalidOption('t',"\tThis student does not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				//else {isContinue = false; clearConsole();}
				UpdateStudent.setRegNoError(true);
			}
		//}while(isContinue);
	}
	
	//Delete student profile
	public static void deleteStudentProfile(String regNoFromSwing){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
	//	do{
			isContinue = true;
			
			drawBox("Home > Student Management > Delete Student Profile");
			System.out.print("Enter Student Registration No : ");
			String regNumber = regNoFromSwing;
			
			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				/*System.out.println("\tRegistration No : "+regNumber);
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				System.out.println("\tStudent PRF Marks : "+studentsArray[regNoIndex].getPrfMarks());
				System.out.println("\tStudent DBMS Marks : "+studentsArray[regNoIndex].getDbmsMarks());
				System.out.println("\tStudent GPA : " + calculateGPA(studentsArray[regNoIndex].getDbmsMarks(),studentsArray[regNoIndex].getPrfMarks()));
				*/
				//if(isInvalidOption('t',"Do you want to delete this student profile (Y/N) : ")){
					
					/*regNoArray = shrinkArray(regNoArray,regNoIndex);
					nameArray = shrinkArray(nameArray,regNoIndex);
					nicArray = shrinkArray(nicArray,regNoIndex);
					prfArray = shrinkArray(prfArray,regNoIndex);
					dbmsArray = shrinkArray(dbmsArray,regNoIndex); */
					
					studentsArray = shrinkArray(studentsArray, regNoIndex);
					
					// save data to computer loca file
					saveData();
					
					//if(isInvalidOption('t',"\tStudent was successfully deleted from the system.\nDo you want to delete another student profile (Y/N) : ")) clearConsole();
					//else {isContinue = false; clearConsole();}
					
				//}
				//else {isContinue = false; clearConsole();}
				
			}else{
				if(isInvalidOption('t',"\tThis student does not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}
			
		//}while(isContinue);
	}
	
    
    //generate registration number
    public static String generateRegistrationNumber(int lectureMode,int batchNo){
		String regNumber = String.format("%s24%d%03d",lectureMode == 1 ? "PR" : "OR",batchNo,(findNumberOfStudent(batchNo))+1);
		return regNumber;
	}
    
    
    ///////////////////////////////  BATCH MANAGEMENT ///////////////////////////////////////
    
    // Add batch
    public static void addBatch(int batchFromSwing){
		Scanner scanner = new Scanner(System.in);
		System.out.println(batchFromSwing);
		boolean isContinue = false;
		AddBatch.setBatchError(false);
		AddBatch.setBatchNoError(false);
		//do{
			isContinue = true;
			
			drawBox("Home > Batch Management > Add Student");
			System.out.print("Enter Batch Number : ");
			int batchNum = batchFromSwing;
			
			int batchIndex = findIndexInArray(batchNameArray,batchNum);
			if(batchIndex != -1){
				//if(isInvalidOption('t',"\tBatch is already added to the system.\nDo you want to add another batch to system (Y/N): ")) clearConsole();
				//else {isContinue = false; clearConsole();}
				AddBatch.setBatchError(true);
			}else{
				if(batchNum > 104){
					batchNameArray = extendArray(batchNameArray,batchNum);
					batchStatusArray = extendArray(batchStatusArray,1);
					
					//save data in computer local file
					saveData();
					
					//if(isInvalidOption('t',"\tBatch was successfully added to the system.\nDo you want to add another batch to system (Y/N): ")) clearConsole();
					//else {isContinue = false; clearConsole();}
					
				}else{
					//if(isInvalidOption('t',"\tInvalid Option. The batch must be greater than 100.\nDo you want to add another batch to system (Y/N): ")) clearConsole();
					//else {isContinue = false; clearConsole();}
					AddBatch.setBatchNoError(true);
				}
			}
			
		//}while(isContinue);
	}
	
	// update batch
	public static void updateBatch(int batchFromSwing){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		UpdateBatch.setBatchNoError(false);
		//do{
			isContinue = true;
			
			drawBox("Home > Batch Management > Update Studnent");
			System.out.print("Enter Batch Number : ");
			int batchNum = batchFromSwing;
			
			int batchIndex = findIndexInArray(batchNameArray,batchNum);
			if(batchIndex != -1){
				
				//if(isInvalidOption('t',"\tCurrent Status : " + (findValueInArray(batchStatusArray,batchIndex) == 1 ? "ENCROLLMENT OPEN" : "ENCROLLMENT CLOSED")+"\nDo you want to change it to "+(findValueInArray(batchStatusArray,batchIndex) == 0 ? "ENCROLLMENT OPEN" : "ENCROLLMENT CLOSED")+" (Y/N) : ")){
					//updateArrayValue(batchStatusArray,batchIndex,(findValueInArray(batchStatusArray,batchIndex) == 1 ? 0 : 1));
					//if(isInvalidOption('t',"\tBatch was successfully updated.\nDo you want to add another batch to system (Y/N): ")) clearConsole();
				//	else {isContinue = false; clearConsole();}
				//}else {isContinue = false; clearConsole();}
				UpdateBatch.setBatchStatus(findValueInArray(batchStatusArray,batchIndex));
				
				
			}else{
				//if(isInvalidOption('t',"\tThis batch does not exist in the system.\nDo you want to enter batch again (Y/N) : ")) clearConsole();
				//else {isContinue = false; clearConsole();}
				UpdateBatch.setBatchNoError(true);
			}
			
			
		//}while(isContinue);
	}
	public static void updateBatch(int batchFromSwing, int batchStatus){
		int batchNum = batchFromSwing;
			
		int batchIndex = findIndexInArray(batchNameArray,batchNum);
		updateArrayValue(batchStatusArray,batchIndex,batchStatus);
		
		//save data in computer local file
		saveData();
	}
	
	// view batches
	public static void viewBatches(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		String line = "----------------------------------------------------------------";
		
		do{
			isContinue = true;
			
			drawBox("Home > Batch Management > View Batches");
			
			System.out.println(line);
			System.out.printf("%-5S %-10S %-20s %-35s%n","No","Batch No","Student Count","Status");
			System.out.println(line);
			for (int i = 0; i < batchNameArray.length; i++)
			{
				System.out.printf("%-5d %-10d %-20d %-35s%n",i+1,batchNameArray[i],findNumberOfStudent(batchNameArray[i]),(batchStatusArray[i] == 0 ? "ECROLLMENT CLOSED" : "ENCROLLMENT OPEN" ));
				System.out.println(line);
			}
			
			
			if(isInvalidOption('t',"Do you want to go to home page (Y/N) : ")) {isContinue = false; clearConsole();}
			else clearConsole();
		}while(isContinue);
	}
    
    
    /////////////////////////////// GRADE MANAGEMENT //////////////////////////////////////////
    
    // prf marks update
    public static void prfMarksUpdate(String regNoFromSwing){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		MarksUpdate.setRegNoError(false);
		//do{
			isContinue = true;
			
			drawBox("Home > Grade Management > PRF Marks Update");
			System.out.print("Enter Student Registration No : ");
			String regNumber = regNoFromSwing;
			
			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				
				/*if(studentsArray[regNoIndex].getPrfMarks() > -1){
					if(isInvalidOption('t',"This student has already completed the PRF module.\n\t PRF Marks : "+studentsArray[regNoIndex].getPrfMarks()+"\nDo you want to update PRF Marks (Y/N) : ")){
						
						System.out.print("\tEnter PRF Makrs : ");
						//updateArrayValue(prfArray,regNoIndex,scanner.nextInt());
						studentsArray[regNoIndex].setPrfMarks(scanner.nextInt());
						
						if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
						else {isContinue = false; clearConsole();}
						
					}else {isContinue = false; clearConsole();}
					
				}else if(studentsArray[regNoIndex].getPrfMarks() == -2){
						System.out.print("\tEnter PRF Makrs : ");
						//updateArrayValue(prfArray,regNoIndex,scanner.nextInt());
						studentsArray[regNoIndex].setPrfMarks(scanner.nextInt());
						
						if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
						else {isContinue = false; clearConsole();}
				}else{
					System.out.println("This student was absent from the exam. You can update the narks if they participate in it...");
					System.out.print("\tEnter PRF Makrs : ");
					//updateArrayValue(prfArray,regNoIndex,scanner.nextInt());
					studentsArray[regNoIndex].setPrfMarks(scanner.nextInt());
						
					if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
					else {isContinue = false; clearConsole();}
					
				}  */
				MarksUpdate.setPrfMarks(studentsArray[regNoIndex].getPrfMarks());
				MarksUpdate.setDbmsMarks(studentsArray[regNoIndex].getDbmsMarks());
			}else{
				//if(isInvalidOption('t',"\tThis student not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				//else {isContinue = false; clearConsole();}
				MarksUpdate.setRegNoError(true);
			}
		//}while(isContinue);
	}
	
	
	// dbms makrs update
	public static void dbmsMakrsUpdate(String regNoFromSwing, int prfMarksFromSwing, int dbmsMarksFromSwing){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		//do{
			isContinue = true;
			
			drawBox("Home > Grade Management > DBMS Marks Update");
			System.out.print("Enter Student Registration No : ");
			String regNumber = regNoFromSwing;
			
			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				
				/*if(studentsArray[regNoIndex].getDbmsMarks() > -1){
					if(isInvalidOption('t',"This student has already completed the DBMS module.\n\t DBMS Marks : "+studentsArray[regNoIndex].getDbmsMarks()+"\nDo you want to update DBMS Marks (Y/N) : ")){
						
						System.out.print("\tEnter DBMS Makrs : ");
						//updateArrayValue(dbmsArray,regNoIndex,scanner.nextInt());
						studentsArray[regNoIndex].setDbmsMarks(scanner.nextInt());
						
						if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
						else {isContinue = false; clearConsole();}
						
					}else {isContinue = false; clearConsole();}
					
				}else if(studentsArray[regNoIndex].getDbmsMarks() == -2){
						System.out.print("\tEnter DBMS Makrs : ");
						//updateArrayValue(dbmsArray,regNoIndex,scanner.nextInt());
						studentsArray[regNoIndex].setDbmsMarks(scanner.nextInt());
						
						if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
						else {isContinue = false; clearConsole();}
				}else{
					System.out.println("This student was absent from the exam. You can update the narks if they participate in it...");
					System.out.print("\tEnter DBMS Makrs : ");
					//updateArrayValue(dbmsArray,regNoIndex,scanner.nextInt());
					studentsArray[regNoIndex].setDbmsMarks(scanner.nextInt());
						
					if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
					else {isContinue = false; clearConsole();}
					
				} */
				studentsArray[regNoIndex].setDbmsMarks(dbmsMarksFromSwing);
				studentsArray[regNoIndex].setPrfMarks(prfMarksFromSwing);
				
				// save data to computer loca file
				saveData();
				
			}else{
				if(isInvalidOption('t',"\tThis student not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}
	//	}while(isContinue);
	}
	
	//////////////////////////////////// REPORT MANAGEMENT ////////////////////////////////////
	
	// student registration report
	public static void studentRegistrationReport(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		int index = 0;
		
		//System.out.println(Arrays.toString(sortedNameArray));
		
		String line = "---------------------------------------------------------------------------------------------------------------------------------------------------";
		do{
			isContinue = true;
			
			drawBox("Home > Report Management > Student Registration Report");
			System.out.println();
			
			System.out.println(line);
			System.out.printf("%-10s %-25s %-25s %-20s %-20s %-20s %-20s%n","No","Registration No","Student Name","NIC","PRF Marks","DBMS Marks","GPA");
			System.out.println(line);
			
			for (int i = 0; i < sortedStudentsArray.length; i++)
			{
				//index = findIndexInArray(studentsArray,sortedRegNoArray[i]);
				
				System.out.printf("%-10d %-25s %-25s %-20s %-20d %-20d %-20.1f%n",i+1,sortedStudentsArray[i].getRegId(),sortedStudentsArray[i].getName(),sortedStudentsArray[i].getNic(),sortedStudentsArray[i].getPrfMarks(),sortedStudentsArray[i].getDbmsMarks(),calculateGPA(sortedStudentsArray[i].getDbmsMarks(),sortedStudentsArray[i].getPrfMarks()));
				//System.out.println(regNoArray[index] +" "+ nameArray[index]+" "+nicArray[index]);
			}
			System.out.println();
			
			if(isInvalidOption('t',"Do you want to go to home page (Y/N) : ")) {isContinue = false; clearConsole();}
			else clearConsole();
			
		}while(isContinue);
	}
	
	// batch wise student report
	public static void batchWiseStudentReport(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		int index = 0;
		String line = "---------------------------------------------------------------------------------------------------------------------------------------------------";
		do{
			isContinue = true;
			
			drawBox("Home > Report Management > Batch wise Student Report");
			int k = 0;
			int exitOption = 0;
			for (; k < batchNameArray.length; k++)
			{
				System.out.println("\t["+(k+1)+"] "+batchNameArray[k]);
				
			}
			System.out.println("\t["+(exitOption = k+1)+"] Exit");
			
			System.out.print("Enter an option : ");
			int option = scanner.nextInt();
			
			if(option > 0 && option <= k+1){
				clearConsole();
				
				if(option != k+1){
					int batchName = batchNameArray[option-1];
					
					drawBox("\b\b\bHome > Report Management > Batch wise Student Report > "+batchName);
					System.out.println();
					
					System.out.println(line);
					System.out.printf("%-10s %-25s %-25s %-20s %-20s %-20s %-20s%n","No","Registration No","Student Name","NIC","PRF Marks","DBMS Marks","GPA");
					System.out.println(line);
					
					
					int no = 1;
					for (int i = 0; i < sortedStudentsArray.length; i++)
					{
						//index = findIndexInArray(regNoArray, sortedRegNoArray[i]);
						
						String spliteBatchName = sortedStudentsArray[i].getRegId().substring(4,7);
						int batchNameInt = Integer.parseInt(spliteBatchName);
						if(batchNameInt == batchName){
							//int batchIndex = findIndexInArray(regNoArray,regNoArray[i]);
							System.out.printf("%-10d %-25s %-25s %-20s %-20d %-20d %-20.1f%n",no++,sortedStudentsArray[i].getRegId(),sortedStudentsArray[i].getName(),sortedStudentsArray[i].getNic(),sortedStudentsArray[i].getPrfMarks(),sortedStudentsArray[i].getDbmsMarks(),calculateGPA(sortedStudentsArray[i].getDbmsMarks(),sortedStudentsArray[i].getPrfMarks()));
						}
					}
					
					
					if(isInvalidOption('t',"Do you want to go to home page (Y/N) : ")) {isContinue = false; clearConsole();}
					else clearConsole();
				}else{isContinue = false; clearConsole();}
			}else{
				if(isInvalidOption('e',"")) {isContinue = false; clearConsole();}
				else clearConsole();
			}
			
		}while(isContinue); 
	}
	
	// Industry Training Eligibility Report
	public static void industryTrainingEligibility(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		//int index = 0;
		
		//System.out.println(Arrays.toString(sortedNameArray));
		
		String line = "---------------------------------------------------------------------------------------------------------------------------------------------------";
		do{
			isContinue = true;
			
			drawBox("\b\b\bHome > Report Management > Industry Training Eligibility Report");
			System.out.println();
			
			System.out.println(line);
			System.out.printf("%-10s %-25s %-25s %-20s %-20s %-20s %-20s%n","No","Registration No","Student Name","NIC","PRF Marks","DBMS Marks","GPA");
			System.out.println(line);
			
			int no = 1;
			for (int i = 0; i < sortedStudentsArray.length; i++)
			{
				//index = findIndexInArray(regNoArray,sortedRegNoArray[i]);
				
				if(calculateGPA(sortedStudentsArray[i].getDbmsMarks(),sortedStudentsArray[i].getPrfMarks()) > 3.25 && sortedStudentsArray[i].getPrfMarks() > 50 && sortedStudentsArray[i].getDbmsMarks() > 50){
					System.out.printf("%-10d %-25s %-25s %-20s %-20d %-20d %-20.1f%n",no++,sortedStudentsArray[i].getRegId(),sortedStudentsArray[i].getName(),sortedStudentsArray[i].getNic(),sortedStudentsArray[i].getPrfMarks(),sortedStudentsArray[i].getDbmsMarks(),calculateGPA(sortedStudentsArray[i].getDbmsMarks(),sortedStudentsArray[i].getPrfMarks()));
					//System.out.println(regNoArray[index] +" "+ nameArray[index]+" "+nicArray[index]);
				}
			}
			System.out.println();
			
			if(isInvalidOption('t',"Do you want to go to home page (Y/N) : ")) {isContinue = false; clearConsole();}
			else clearConsole();
			
		}while(isContinue);
	}
	
	
	// update array value
	public static void updateArrayValue(String[] array,int index, String value){
		array[index] = value;
	}
	public static void updateArrayValue(int[] array,int index, int value){
		array[index] = value;
	}
    
    // find index in array of given value
    public static int findIndexInArray(Student[] objArray, String value,char type){
		int index = -1;
		for (int i = 0; i < objArray.length; i++)
		{
			if(type == 'n'){
				if(objArray[i].getNic().equals(value)) index = i;
			}else if(type == 'r'){
				if(objArray[i].getRegId().equals(value)) index = i;
			}
		}
		return index;
	}
    
    public static int findIndexInArray(int[] array, int value){
		int index = -1;
		for (int i = 0; i < array.length; i++)
		{
			if(array[i] == value) index =  i;
		}
		return index;
	}
	public static int findIndexInArray(String[] array, String value){
		int index = -1;
		for (int i = 0; i < array.length; i++)
		{
			if(array[i].equals(value)) index = i;
		}
		return index;
	}
	
	// find value in arrya of given index
	
	public static int findValueInArray(int[] array, int index){
		if(index >= 0 && index < array.length) return array[index];
		else return -1;
	}
	
	public static String findValueInArray(String[] array, int index){
		if(index >= 0 && index < array.length) return array[index];
		else return "";
	}
	
	// find number of student in each batch
    public static int findNumberOfStudent(int num){
		int count = 0;
		/*for (int i = 0; i < regNoArray.length; i++)
		{
			String batchNoStr = regNoArray[i].substring(4,7);
			int batchNum = Integer.parseInt(batchNoStr);
			if(batchNum == num) count++;
			
		} */
		
		for(Student s : studentsArray){
			String batchNoStr = s.getRegId().substring(4,7);
			int batchNum = Integer.parseInt(batchNoStr);
			if(batchNum == num) count++;
		}
		
		return count;
		
	}
	
    //extend arrays
    
    public static Student[] extendArray(Student[] objArray, Student newStudent){
		Student[] tempStudentArray = new Student[objArray.length + 1];
		for (int i = 0; i < objArray.length; i++)
		{
			tempStudentArray[i] = objArray[i];
		}
		tempStudentArray[tempStudentArray.length - 1] = newStudent;
		
		return tempStudentArray;
		
	}
    
    public static String[] extendArray(String[] array, String newValue){
		String[] tempArray = new String[array.length+1];
		for (int i = 0; i < array.length; i++)
		{
			tempArray[i] = array[i];
		}
		tempArray[tempArray.length - 1] = newValue;
		
		return tempArray;
	}
	
	public static int[] extendArray(int[] array, int newValue){
		int[] tempArray = new int[array.length+1];
		for (int i = 0; i < array.length; i++)
		{
			tempArray[i] = array[i];
		}
		tempArray[tempArray.length -1] = newValue;
		return tempArray;
		
	}
	
	// shrink array
	public static Student[] shrinkArray(Student[] objArray, int index){
		Student[] tempObjArray = new Student[objArray.length - 1];
		for (int i = 0,j = 0; i < objArray.length; i++)
		{
			if(i != index) tempObjArray[j++] = objArray[i];
		}
		return tempObjArray;
		
	}
	
	public static int[] shrinkArray(int[] array, int index){
		int[] tempArray = new int[array.length - 1 ];
		for (int i = 0,j= 0; i < array.length; i++)
		{
			if(i != index) tempArray[j++] = array[i];
		}
		return tempArray;
	}
	public static String[] shrinkArray(String[] array, int index){
		String[] tempArray = new String[array.length - 1];
		for (int i = 0,j=0; i < array.length; i++)
		{
			if(i != index) tempArray[j++] = array[i];
		}
		return tempArray;
	}
    
    //get option from user
    public static int getOption(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n\nEnter an option to continue > ");
        return scanner.nextInt();
	}
    
    // check invalid option
    public static boolean isInvalidOption(char ch,String text){
		Scanner scanner = new Scanner(System.in);
		System.out.print((ch == 'e')? ("\tInvalid input.\nDo you want to exit(Y/N) : "):(ch == 'm')?("\tInvalid input.\nDo you want go to main menu(Y/N) : "):(text));
		char answer = scanner.next().toLowerCase().charAt(0);
		if(answer == 'y') return true;
		return false;
		
	}
	
	
    public static double calculateGPA(int marksDBMS, int marksPRF) {
		
		if(marksDBMS <= -1 || marksPRF <= -1) return 0;
		
        double gradePointDBMS;
        String gradeDBMS;
        
        if (marksDBMS >= 75) {
            gradeDBMS = "A";
            gradePointDBMS = 4.0;
        } else if (marksDBMS >= 65) {
            gradeDBMS = "B";
            gradePointDBMS = 3.0;
        } else if (marksDBMS >= 55) {
            gradeDBMS = "C";
            gradePointDBMS = 2.0;
        } else if (marksDBMS >= 45) {
            gradeDBMS = "S";
            gradePointDBMS = 1.0;
        } else {
            gradeDBMS = "F";
            gradePointDBMS = 0.0;
        }

        double gradePointPRF;
        String gradePRF;

        if (marksPRF >= 90) {
            gradePRF = "A";
            gradePointPRF = 4.0;
        } else if (marksPRF >= 80) {
            gradePRF = "B";
            gradePointPRF = 3.0;
        } else if (marksPRF >= 70) {
            gradePRF = "C";
            gradePointPRF = 2.0;
        } else if (marksPRF >= 60) {
            gradePRF = "S";
            gradePointPRF = 1.0;
        } else {
            gradePRF = "F";
            gradePointPRF = 0.0;
        }

        double gpa = (gradePointDBMS + gradePointPRF) / 2.0;
        return gpa;
    }
	
	
	
	public static void sortArrayAscending(){
		Student[] originalArray = Arrays.copyOf(studentsArray, studentsArray.length);
		for (int i = 0; i < studentsArray.length - 1; i++)
		{
			for (int j = 0; j < studentsArray.length - 1; j++) {
                if (studentsArray[j].getName().compareTo(studentsArray[j + 1].getName()) > 0) {
                    Student temp = studentsArray[j];
                    studentsArray[j] = studentsArray[j + 1];
                    studentsArray[j + 1] = temp;
                }
            }
			
		}
		sortedStudentsArray = Arrays.copyOf(studentsArray, studentsArray.length);
		studentsArray = Arrays.copyOf(originalArray, originalArray.length);
		
	}
    
    //draw asscii box
    public static void drawBox(String title){
		System.out.println("-------------------------------------------------------------------------");
        //System.out.println("|\t\t\t\t"+title+"\t\t\t\t|");
        System.out.printf("|\t\t%-56s|%n",title);
        System.out.println("-------------------------------------------------------------------------\n");
	}
	

      
    // main method
    //public static void main(String args[]) {
       // homePage();
       //System.out.printf("%d",4);
    //}
    public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Add Student");
		frame.setSize(700,500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		CardLayout c1 = new CardLayout();
		JPanel p = new JPanel(c1);
		
		//addStudent s = new addStudent(c1,p);
		
		// loads data from computer local files
		loadData();
		
		
		p.add(new HomePage(c1,p),"homepage");
		p.add(new StudentManagement(c1,p), "smPage");
		p.add(new BatchManagement(c1,p), "bmPage");
		p.add(new GradeManagement(c1,p),"gmPage");
		p.add(new ReportGenerator(c1,p),"rgPage");
		
		p.add(new AddStudent(c1,p), "addStudent");
		p.add(new UpdateStudent(c1,p),"updateStudent");
		
		p.add(new AddBatch(c1,p),"addBatch");
		p.add(new UpdateBatch(c1,p),"updateBatch");
		p.add(new ViewBatch(c1,p),"viewBatch");
		
		p.add(new MarksUpdate(c1,p),"marksUpdate");
		
		p.add(new StudentRegistrationReport(c1,p),"srrPage");
		p.add(new IndustryTrainigEligibilityReport(c1,p),"iterPage");
		p.add(new BatchWiseStudentReport(c1,p),"bsrPage");
		//p.add(new HomePage(c1,p),"homepage");
		//c1.show(p,"homepage");
		
		frame.add(p);
		frame.setVisible(true);
		
	}


}
