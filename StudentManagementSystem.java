import java.util.*;

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
	
	String getRegId(){return this.regId;}
	String getNic(){return this.nic;}
	String getName(){return this.name;}
	int getPrfMarks(){return this.prfMarks;}
	int getDbmsMarks(){return this.dbmsMarks;}
}

class StudentManagementSystem {
    // Batch status
    public static final int ENROLLMENTOPEN = 1;
    public static final int ENROLLMENTCLOSED = 0;

    // Batch data
    static int[] batchNameArray = { 105, 106, 107, 108, 109, 110 };
    static int[] batchStatusArray = { 0, 0, 0, 0, 1, 1 };
    static int[] batchStudentCountArray = { 25, 25, 25, 25, 25, 25 };
    
    // student object array
    static Student[] studentsArray = {
		new Student("PR24110001","20402443","Nirmal",-2,-2),
	};
	
	static Student[] sortedStudentsArray = {};
    
   

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
						addStudent();
						break;
					case 2:
						clearConsole();
						updateStudent();
						break;
					case 3:
						clearConsole();
						viewStudentProfile();
						break;
					case 4:
						clearConsole();
						deleteStudentProfile();
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
						addBatch();
						break;
					case 2:
						clearConsole();
						updateBatch();
						break;
					case 3:
						clearConsole();
						viewBatches();
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
						prfMarksUpdate();
						break;
					case 2:
						clearConsole();
						dbmsMakrsUpdate();
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
    public static void addStudent(){
		Scanner scanner = new Scanner(System.in);
		
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Student Management > Add Student");
			System.out.print("Enter Batch Number (Students should be added) : ");
			int batchName = scanner.nextInt();
			
			int batchIndex = findIndexInArray(batchNameArray,batchName);
			if(batchIndex != -1){
				int batchStatus = findValueInArray(batchStatusArray,batchIndex);
				if(batchStatus == 1){
					
					System.out.print("Enter Student Nic : ");
					String nic = scanner.next();
					
					int checkNic = findIndexInArray(studentsArray,nic,'n');
					if(checkNic == -1){
						System.out.print("Enter Student Name : ");
						String name = scanner.next();
						                                
						System.out.print("Enter Lecturer Mode (1 - PHYSICAL 0 - ONLINE) : ");
						int lectureMode = scanner.nextInt();
						
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
						
						if(isInvalidOption('t',"\tStudent was successfully added to the system.\nDo you want to add another student (Y/N) : "))clearConsole();
						else {isContinue = false; clearConsole();}
						
						
					}else{
						if(isInvalidOption('t',"\t Nic already exist.\nDo you want to try again (Y/N) : ")) clearConsole();
						else {isContinue = false; clearConsole();}
					}
					
					
				}else{
					if(isInvalidOption('t',"\tStudents cannot be added to this batch because enrollment is closed.\nDo you want to add student to another Batch (Y/N):")) clearConsole();
					else{ isContinue = false; clearConsole();}
				}
			}else{
				if(isInvalidOption('t',"\tBatch number does not exist\nDo you want to enter again (Y/N) : ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}
			
			//int temp = scanner.nextInt();
			
		}while(isContinue);
	}
	
	// update students
	public static void updateStudent(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Student Management > Update Student");
			System.out.print("Enter Student Registration No : ");
			String regNumber = scanner.next();

			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				
				System.out.print("What do you want to update ? \n\t(01) Student Name\n\t(02) Student Nic\n\nEnter an option : ");
				int option = scanner.nextInt();
				switch(option){
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
				}
			}else{
				if(isInvalidOption('t',"\tThis student not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}
		}while(isContinue);
	}
	
	// view student profile
	public static void viewStudentProfile(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Student Management > View Student Profile");
			System.out.print("Enter Student Registration No : ");
			String regNumber = scanner.next();
			
			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				System.out.println("\tRegistration No : "+regNumber);
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				System.out.println("\tStudent PRF Marks : "+studentsArray[regNoIndex].getPrfMarks());
				System.out.println("\tStudent DBMS Marks : "+studentsArray[regNoIndex].getDbmsMarks());
				System.out.println("\tStudent GPA : " + calculateGPA(studentsArray[regNoIndex].getDbmsMarks(),studentsArray[regNoIndex].getPrfMarks()));
				
				if(isInvalidOption('t',"Do you want to search another student details (Y/N) : "))clearConsole();
				else {isContinue = false; clearConsole();}
						
			}else{
				if(isInvalidOption('t',"\tThis student does not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}
		}while(isContinue);
	}
	
	//Delete student profile
	public static void deleteStudentProfile(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Student Management > Delete Student Profile");
			System.out.print("Enter Student Registration No : ");
			String regNumber = scanner.next();
			
			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				System.out.println("\tRegistration No : "+regNumber);
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				System.out.println("\tStudent PRF Marks : "+studentsArray[regNoIndex].getPrfMarks());
				System.out.println("\tStudent DBMS Marks : "+studentsArray[regNoIndex].getDbmsMarks());
				System.out.println("\tStudent GPA : " + calculateGPA(studentsArray[regNoIndex].getDbmsMarks(),studentsArray[regNoIndex].getPrfMarks()));
				
				if(isInvalidOption('t',"Do you want to delete this student profile (Y/N) : ")){
					
					/*regNoArray = shrinkArray(regNoArray,regNoIndex);
					nameArray = shrinkArray(nameArray,regNoIndex);
					nicArray = shrinkArray(nicArray,regNoIndex);
					prfArray = shrinkArray(prfArray,regNoIndex);
					dbmsArray = shrinkArray(dbmsArray,regNoIndex); */
					
					studentsArray = shrinkArray(studentsArray, regNoIndex);
					
					if(isInvalidOption('t',"\tStudent was successfully deleted from the system.\nDo you want to delete another student profile (Y/N) : ")) clearConsole();
					else {isContinue = false; clearConsole();}
					
				}
				else {isContinue = false; clearConsole();}
				
			}else{
				if(isInvalidOption('t',"\tThis student does not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}
			
		}while(isContinue);
	}
	
    
    //generate registration number
    public static String generateRegistrationNumber(int lectureMode,int batchNo){
		String regNumber = String.format("%s24%d%03d",lectureMode == 1 ? "PR" : "OR",batchNo,(findNumberOfStudent(batchNo))+1);
		return regNumber;
	}
    
    
    ///////////////////////////////  BATCH MANAGEMENT ///////////////////////////////////////
    
    // Add batch
    public static void addBatch(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Batch Management > Add Student");
			System.out.print("Enter Batch Number : ");
			int batchNum = scanner.nextInt();
			
			int batchIndex = findIndexInArray(batchNameArray,batchNum);
			if(batchIndex != -1){
				if(isInvalidOption('t',"\tBatch is already added to the system.\nDo you want to add another batch to system (Y/N): ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}else{
				if(batchNum > 104){
					batchNameArray = extendArray(batchNameArray,batchNum);
					batchStatusArray = extendArray(batchStatusArray,1);
					
					if(isInvalidOption('t',"\tBatch was successfully added to the system.\nDo you want to add another batch to system (Y/N): ")) clearConsole();
					else {isContinue = false; clearConsole();}
					
				}else{
					if(isInvalidOption('t',"\tInvalid Option. The batch must be greater than 100.\nDo you want to add another batch to system (Y/N): ")) clearConsole();
					else {isContinue = false; clearConsole();}
				}
			}
			
		}while(isContinue);
	}
	
	// update batch
	public static void updateBatch(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Batch Management > Update Studnent");
			System.out.print("Enter Batch Number : ");
			int batchNum = scanner.nextInt();
			
			int batchIndex = findIndexInArray(batchNameArray,batchNum);
			if(batchIndex != -1){
				
				if(isInvalidOption('t',"\tCurrent Status : " + (findValueInArray(batchStatusArray,batchIndex) == 1 ? "ENCROLLMENT OPEN" : "ENCROLLMENT CLOSED")+"\nDo you want to change it to "+(findValueInArray(batchStatusArray,batchIndex) == 0 ? "ENCROLLMENT OPEN" : "ENCROLLMENT CLOSED")+" (Y/N) : ")){
					updateArrayValue(batchStatusArray,batchIndex,(findValueInArray(batchStatusArray,batchIndex) == 1 ? 0 : 1));
					if(isInvalidOption('t',"\tBatch was successfully updated.\nDo you want to add another batch to system (Y/N): ")) clearConsole();
					else {isContinue = false; clearConsole();}
				}else {isContinue = false; clearConsole();}
				
			}else{
				if(isInvalidOption('t',"\tThis batch does not exist in the system.\nDo you want to enter batch again (Y/N) : ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}
			
			
		}while(isContinue);
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
    public static void prfMarksUpdate(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Grade Management > PRF Marks Update");
			System.out.print("Enter Student Registration No : ");
			String regNumber = scanner.next();
			
			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				
				if(studentsArray[regNoIndex].getPrfMarks() > -1){
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
					
				}
				
			}else{
				if(isInvalidOption('t',"\tThis student not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}
		}while(isContinue);
	}
	
	
	// dbms makrs update
	public static void dbmsMakrsUpdate(){
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		do{
			isContinue = true;
			
			drawBox("Home > Grade Management > DBMS Marks Update");
			System.out.print("Enter Student Registration No : ");
			String regNumber = scanner.next();
			
			int regNoIndex = findIndexInArray(studentsArray,regNumber,'r');
			if(regNoIndex != -1){
				System.out.println("\tStudent Name : "+studentsArray[regNoIndex].getName());
				System.out.println("\tStudent Nic : "+studentsArray[regNoIndex].getNic());
				
				if(studentsArray[regNoIndex].getDbmsMarks() > -1){
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
					
				}
			}else{
				if(isInvalidOption('t',"\tThis student not exist in the system.\nDo you want to enter again (Y/N) : ")) clearConsole();
				else {isContinue = false; clearConsole();}
			}
		}while(isContinue);
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
    public static void main(String args[]) {
        homePage();
       //System.out.printf("%d",4);
    }

}

