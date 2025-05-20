import java.util.*;

class StudentManagementSystem {
    // Batch status
    public static final int ENROLLMENTOPEN = 1;
    public static final int ENROLLMENTCLOSED = 0;

    // Batch data
    static int[] batchNameArray = { 105, 106, 107, 108, 109, 110 };
    static int[] batchStatusArray = { 0, 0, 0, 0, 1, 1 };
    static int[] batchStudentCountArray = { 25, 25, 25, 25, 25, 25 };
    
    // Student data
    static String[] regNoArray = {
            "PR24105001", "PR24105002", "PR24105003", "PR24105004", "PR24105005",
            "PR24105006", "PR24105007", "PR24105008", "PR24105009", "PR24105010",
            "OR24105011", "OR24105012", "OR24105013", "OR24105014", "OR24105015",
            "PR24105016", "PR24105017", "PR24105018", "OR24105019", "OR24105020",
            "PR24105021", "PR24105022", "OR24105023", "OR24105024", "PR24105025",
            "PR24106001", "PR24106002", "PR24106003", "PR24106004", "PR24106005",
            "PR24106006", "PR24106007", "PR24106008", "PR24106009", "PR24106010",
            "OR24106011", "OR24106012", "OR24106013", "OR24106014", "OR24106015",
            "PR24106016", "PR24106017", "PR24106018", "OR24106019", "OR24106020",
            "PR24106021", "PR24106022", "OR24106023", "OR24106024", "PR24106025",
            "PR24107001", "PR24107002", "PR24107003", "PR24107004", "PR24107005",
            "PR24107006", "PR24107007", "PR24107008", "PR24107009", "PR24107010",
            "OR24107011", "OR24107012", "OR24107013", "OR24107014", "OR24107015",
            "PR24107016", "PR24107017", "PR24107018", "OR24107019", "OR24107020",
            "PR24107021", "PR24107022", "OR24107023", "OR24107024", "PR24107025",
            "PR24108001", "PR24108002", "PR24108003", "PR24108004", "PR24108005",
            "PR24108006", "PR24108007", "PR24108008", "PR24108009", "PR24108010",
            "OR24108011", "OR24108012", "OR24108013", "OR24108014", "OR24108015",
            "PR24108016", "PR24108017", "PR24108018", "OR24108019", "OR24108020",
            "PR24108021", "PR24108022", "OR24108023", "OR24108024", "PR24108025",
            "PR24109001", "PR24109002", "PR24109003", "PR24109004", "PR24109005",
            "PR24109006", "PR24109007", "PR24109008", "PR24109009", "PR24109010",
            "OR24109011", "OR24109012", "OR24109013", "OR24109014", "OR24109015",
            "PR24109016", "PR24109017", "PR24109018", "OR24109019", "OR24109020",
            "PR24109021", "PR24109022", "OR24109023", "OR24109024", "PR24109025",
            "PR24110001", "PR24110002", "PR24110003", "PR24110004", "PR24110005",
            "PR24110006", "PR24110007", "PR24110008", "PR24110009", "PR24110010",
            "OR24110011", "OR24110012", "OR24110013", "OR24110014", "OR24110015",
            "PR24110016", "PR24110017", "PR24110018", "OR24110019", "OR24110020",
            "PR24110021", "PR24110022", "OR24110023", "OR24110024", "PR24110025"

    };

    static String[] nicArray = {
            "199501012345", "199503153872", "199506202198", "199509102983", "199511258739",
            "199512303498", "199502183764", "199504223198", "199508153210", "199510293417",
            "199601102375", "199604182938", "199606243879", "199608142178", "199610312475",
            "199611173452", "199603293481", "199605083217", "199607232198", "199609192375",
            "199701212483", "199703132487", "199706253478", "199708083298", "199710243651",
            "199712152983", "199702182734", "199704293187", "199705142375", "199709083751",
            "199801032874", "199803232871", "199806193428", "199808013764", "199810242374",
            "199812302984", "199802152348", "199805213471", "199807172398", "199811283472",
            "199901122471", "199903052984", "199906213874", "199908093412", "199910273894",
            "199912153482", "199902202394", "199904163874", "199907293481", "199911083479",
            "200001112374", "200003143478", "200006293874", "200008103471", "200010252984",
            "200012043894", "200002193874", "200004212374", "200005183492", "200007153871",
            "200101232984", "200103083471", "200106273894", "200108123984", "200110043728",
            "200112213874", "200102253471", "200104103874", "200105293784", "200107202983",
            "200201013874", "200203253471", "200206143874", "200208083471", "200210293874",
            "200212183471", "200202103874", "200204123894", "200205283471", "200207153874",
            "200301093874", "200303283471", "200306153874", "200308123471", "200310083874",
            "200312243471", "200302273874", "200304203471", "200305123874", "200307213471",
            "200401153874", "200403123471", "200406293874", "200408083471", "200410213874",
            "200412153471", "200402203874", "200404273471", "200405143874", "200407183471",
            "200501023874", "200503193471", "200506153874", "200508213471", "200510083874",
            "200512293471", "200502123874", "200504153471", "200505283874", "200507173471"
            ,"200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678"
        };

    static String[] nameArray = {
            "Gunawardena Weerasinghe", "Senanayake Silva", "Silva Kumara", "Kumara Herath", "Rathnayake Herath",
            "Wijesinghe Bandara", "Rajapaksha Herath", "Senanayake Karunaratne", "Karunaratne Jayasinghe",
            "Gunawardena Silva",
            "Weerasinghe Rajapaksha", "Silva Rathnayake", "Fernando Perera", "Kumara Abeysekera",
            "Ekanayake Rathnayake",
            "Herath Gunawardena", "Abeysekera Silva", "Weerasinghe Silva", "Jayasinghe Dias", "Bandara Rathnayake",
            "Silva Perera", "De Silva Dias", "Abeysekera Jayasinghe", "Rajapaksha Senanayake", "Kumara Karunaratne",
            "Silva Abeysekera", "Jayasinghe Bandara", "Rathnayake Kumara", "Weerasinghe Rajapaksha",
            "Senanayake Herath",
            "Perera Ekanayake", "Herath Jayasinghe", "Kumara Gunawardena", "Abeysekera Silva", "Dias Fernando",
            "Karunaratne Weerasinghe", "Ekanayake Bandara", "Rajapaksha Kumara", "Silva De Silva",
            "Gunawardena Rathnayake",
            "Bandara Karunaratne", "Fernando Perera", "De Silva Silva", "Rajapaksha Gunawardena", "Herath Weerasinghe",
            "Karunaratne Dias", "Jayasinghe Silva", "Senanayake Abeysekera", "Silva Jayasinghe", "Rathnayake Kumara",
            "Gunawardena Kumara", "Rajapaksha Silva", "Perera Jayasinghe", "Silva Ekanayake", "Dias Senanayake",
            "Herath Abeysekera", "Rathnayake Fernando", "Kumara Herath", "Weerasinghe Silva", "Senanayake Karunaratne",
            "Abeysekera Silva", "Bandara Gunawardena", "Karunaratne Weerasinghe", "Perera Herath", "Fernando Dias",
            "Weerasinghe Gunawardena", "Rathnayake Kumara", "Senanayake Fernando", "Silva Bandara", "Herath Rajapaksha",
            "Kumara Jayasinghe", "Abeysekera Perera", "Rathnayake Jayasinghe", "Kumara Weerasinghe",
            "Rajapaksha Ekanayake",
            "Fernando Rajapaksha", "Silva Gunawardena", "Perera Wijesinghe", "Herath Abeysekera",
            "Rajapaksha Ekanayake",
            "Karunaratne Silva", "Weerasinghe Fernando", "Silva Bandara", "Abeysekera Weerasinghe",
            "Kumara Karunaratne",
            "Dias Rajapaksha", "Herath Perera", "Rathnayake Gunawardena", "Ekanayake Jayasinghe", "Gunawardena Silva",
            "Rajapaksha Perera", "Karunaratne Jayasinghe", "Weerasinghe Abeysekera", "Rathnayake Fernando",
            "Kumara Herath",
            "Silva Weerasinghe", "Herath Karunaratne", "Abeysekera Silva", "Gunawardena Ekanayake",
            "Weerasinghe Kumara",
            "Weerasinghe Kumara", "Rajapaksha Abeysekera", "Gunawardena Perera", "Karunaratne Silva",
            "Herath Wijesinghe",
            "Rathnayake Ekanayake", "Silva Fernando", "Abeysekera Rajapaksha", "Fernando Bandara", "Perera Herath",
            "Weerasinghe Jayasinghe", "Silva Karunaratne", "Rathnayake Gunawardena", "Herath Kumara",
            "Abeysekera Silva",
            "Ekanayake Bandara", "Rajapaksha Fernando", "Gunawardena Weerasinghe", "Kumara Karunaratne", "Silva Dias",
            "Perera Weerasinghe", "Karunaratne Rajapaksha", "Jayasinghe Silva", "Rathnayake Perera", "Silva Ekanayake",
            "Silva Karunaratne", "Herath Fernando", "Kumara Jayasinghe", "Weerasinghe Perera", "Abeysekera Rajapaksha",
            "Rathnayake Karunaratne", "Ekanayake Bandara", "Gunawardena Perera", "Silva Wijesinghe",
            "Rajapaksha Jayasinghe",
            "Rathnayake Fernando", "Karunaratne Kumara", "Perera Silva", "Gunawardena Ekanayake", "Bandara Rajapaksha",
            "Silva Herath", "Rathnayake Weerasinghe", "Perera Gunawardena", "Herath Karunaratne", "Silva Rajapaksha",
            "Ekanayake Kumara", "Bandara Herath", "Weerasinghe Rajapaksha", "Karunaratne Abeysekera", "Perera Dias",

    };

    static int[] prfArray = {
            85, 39, -1, 72, 44,
            91, 60, 38, 95, 49,
            -1, 67, 23, 58, 88,
            81, 73, 29, 62, -1,
            79, 53, 94, 47, 35,
            93, 15, -1, 82, 45,
            88, 23, 79, 37, -1,
            68, 100, 59, 29, 92,
            12, 77, 38, 66, 9,
            84, 51, 32, -1, 97,
            95, -1, 63, 88, 32,
            76, 97, 54, -1, 23,
            90, 35, 81, 61, 44,
            67, 100, 17, 85, 29,
            70, 42, -1, 60, 86,
            86, 57, 91, 35, -1,
            76, 48, 94, 23, 69,
            -1, 80, 55, 88, 32,
            100, 67, 43, -1, 90,
            60, 77, 25, 71, 84,
            92, 68, 59, 85, 63,
            76, 91, 70, 84, 63,
            72, 89, 45, 81, 77,
            68, 63, 88, 75, 90,
            57, 79, 92, 62, 100,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2

    };

    static int[] dbmsArray = {
            66, 45, 93, 58, -1,
            37, 88, 21, 79, 40,
            76, 54, -1, 69, 92,
            25, 84, 33, 60, 71,
            59, -1, 98, 27, 48,
            35, 91, 60, -1, 72,
            49, 26, 80, 14, 89,
            67, -1, 31, 94, 53,
            78, 5, 90, 24, 86,
            39, -1, 61, 73, 100,
            38, 91, -1, 74, 55,
            82, 66, 49, 99, 13,
            80, 70, 93, 36, 59,
            85, 47, 90, -1, 22,
            77, 34, 63, 100, 29,
            79, 62, 87, -1, 54,
            46, 99, 39, 70, -1,
            75, 83, 58, 92, 30,
            91, 40, 63, 95, 68,
            -1, 66, 21, 88, 37,
            67, 91, 85, 73, 70,
            63, 76, 88, 55, 64,
            79, 80, 59, 92, 68,
            100, 77, 83, 45, 62,
            66, 59, 78, 85, 56,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2
    };

    

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
		boolean isContinue = false;
		
		do{
			isContinue = true;
			
			drawBox("Home > Report Generator");
			System.out.println("\t[1] Student Registration Report");
			System.out.println("\t[2] Batch — wise Student Report");
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
					
					int checkNic = findIndexInArray(nicArray,nic);
					if(checkNic == -1){
						System.out.print("Enter Student Name : ");
						String name = scanner.next();
						                                
						System.out.print("Enter Lecturer Mode (1 - PHYSICAL 0 - ONLINE) : ");
						int lectureMode = scanner.nextInt();
						
						String generatedRegNo = generateRegistrationNumber(lectureMode,batchName);
						nicArray = extendArray(nicArray,nic);
						nameArray = extendArray(nameArray,name);
						regNoArray = extendArray(regNoArray,generatedRegNo);
						prfArray = extendArray(prfArray,-2);
						dbmsArray = extendArray(dbmsArray,-2);
						
						
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

			int regNoIndex = findIndexInArray(regNoArray,regNumber);
			if(regNoIndex != -1){
				
				System.out.println("\tStudent Name : "+findValueInArray(nameArray,regNoIndex));
				System.out.println("\tStudent Nic : "+findValueInArray(nicArray,regNoIndex));
				
				System.out.print("What do you want to update ? \n\t(01) Student Name\n\t(01) Student Nic\n\nEnter an option : ");
				int option = scanner.nextInt();
				switch(option){
						case 1:
							System.out.println("\tRegistration No : "+regNumber);
							System.out.println("\tStudent Nic : "+findValueInArray(nicArray,regNoIndex));
							System.out.println("\tStudnet Current Name : "+findValueInArray(nameArray,regNoIndex));
							System.out.println();
							
							System.out.print("Enter Student Name to Update : ");
							String name = scanner.next();
							updateArrayValue(nameArray,regNoIndex,name);
							
							System.out.println(Arrays.toString(nameArray));
							if(isInvalidOption('t',"\tStudent name was successfully added to the system.\nDo you want to add another student (Y/N) : "))clearConsole();
							else {isContinue = false; clearConsole();}
							
							break;
						case 2:
							System.out.println("\tRegistration No : "+regNumber);
							System.out.println("\tStudnet Name : "+findValueInArray(nameArray,regNoIndex));
							System.out.println("\tStudent Current Nic : "+findValueInArray(nicArray,regNoIndex));
							System.out.println();
							
							System.out.print("Enter Student nic to Update : ");
							String nic = scanner.next();
							updateArrayValue(nicArray,regNoIndex,nic);
							
							System.out.println(Arrays.toString(nameArray));
							if(isInvalidOption('t',"\tStudent name was successfully added to the system.\nDo you want to add another student (Y/N) : "))clearConsole();
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
			
			int regNoIndex = findIndexInArray(regNoArray,regNumber);
			if(regNoIndex != -1){
				System.out.println("\tRegistration No : "+regNumber);
				System.out.println("\tStudent Name : "+nameArray[regNoIndex]);
				System.out.println("\tStudent Nic : "+nicArray[regNoIndex]);
				System.out.println("\tStudent PRF Marks : "+prfArray[regNoIndex]);
				System.out.println("\tStudent DBMS Marks : "+dbmsArray[regNoIndex]);
				System.out.println("\tStudent GPA : ");
				
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
			
			int regNoIndex = findIndexInArray(regNoArray,regNumber);
			if(regNoIndex != -1){
				System.out.println("\tRegistration No : "+regNumber);
				System.out.println("\tStudent Name : "+nameArray[regNoIndex]);
				System.out.println("\tStudent Nic : "+nicArray[regNoIndex]);
				System.out.println("\tStudent PRF Marks : "+prfArray[regNoIndex]);
				System.out.println("\tStudent DBMS Marks : "+dbmsArray[regNoIndex]);
				System.out.println("\tStudent GPA : ");
				
				if(isInvalidOption('t',"Do you want to delete this student profile (Y/N) : ")){
					
					regNoArray = shrinkArray(regNoArray,regNoIndex);
					nameArray = shrinkArray(nameArray,regNoIndex);
					nicArray = shrinkArray(nicArray,regNoIndex);
					prfArray = shrinkArray(prfArray,regNoIndex);
					dbmsArray = shrinkArray(dbmsArray,regNoIndex);
					
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
			
			int regNoIndex = findIndexInArray(regNoArray,regNumber);
			if(regNoIndex != -1){
				System.out.println("\tStudent Name : "+nameArray[regNoIndex]);
				System.out.println("\tStudent Nic : "+nicArray[regNoIndex]);
				
				if(prfArray[regNoIndex] > -1){
					if(isInvalidOption('t',"This student has already completed the PRF module.\n\t PRF Marks : "+prfArray[regNoIndex]+"\nDo you want to update PRF Marks (Y/N) : ")){
						
						System.out.print("\tEnter PRF Makrs : ");
						updateArrayValue(prfArray,regNoIndex,scanner.nextInt());
						
						if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
						else {isContinue = false; clearConsole();}
						
					}else {isContinue = false; clearConsole();}
					
				}else if(prfArray[regNoIndex] == -2){
						System.out.print("\tEnter PRF Makrs : ");
						updateArrayValue(prfArray,regNoIndex,scanner.nextInt());
						
						if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
						else {isContinue = false; clearConsole();}
				}else{
					System.out.println("This student was absent from the exam. You can update the narks if they participate in it...");
					System.out.print("\tEnter PRF Makrs : ");
					updateArrayValue(prfArray,regNoIndex,scanner.nextInt());
						
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
			
			int regNoIndex = findIndexInArray(regNoArray,regNumber);
			if(regNoIndex != -1){
				System.out.println("\tStudent Name : "+nameArray[regNoIndex]);
				System.out.println("\tStudent Nic : "+nicArray[regNoIndex]);
				
				if(dbmsArray[regNoIndex] > -1){
					if(isInvalidOption('t',"This student has already completed the DBMS module.\n\t DBMS Marks : "+dbmsArray[regNoIndex]+"\nDo you want to update DBMS Marks (Y/N) : ")){
						
						System.out.print("\tEnter DBMS Makrs : ");
						updateArrayValue(dbmsArray,regNoIndex,scanner.nextInt());
						
						if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
						else {isContinue = false; clearConsole();}
						
					}else {isContinue = false; clearConsole();}
					
				}else if(dbmsArray[regNoIndex] == -2){
						System.out.print("\tEnter DBMS Makrs : ");
						updateArrayValue(dbmsArray,regNoIndex,scanner.nextInt());
						
						if(isInvalidOption('t',"\tMarks were successfully updated.\nDo you want to update another student marks (Y/N): ")) clearConsole();
						else {isContinue = false; clearConsole();}
				}else{
					System.out.println("This student was absent from the exam. You can update the narks if they participate in it...");
					System.out.print("\tEnter DBMS Makrs : ");
					updateArrayValue(dbmsArray,regNoIndex,scanner.nextInt());
						
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
		String line = "---------------------------------------------------------------------------------------------------------------------------------------------------";
		do{
			isContinue = true;
			
			drawBox("Home > Report Management > Student Registration Report");
			System.out.println();
			
			System.out.println(line);
			System.out.printf("%-10s %-25s %-25s %-20s %-20s %-20s %-20s%n","No","Registration No","Student Name","NIC","PRF Marks","DBMS Marks","GPA");
			System.out.println(line);
			
			for (int i = 0; i < nameArray.length; i++)
			{
				System.out.printf("%-10d %-25s %-25s %-20s %-20d %-20d %-20f%n",i+1,regNoArray[i],nameArray[i],nicArray[i],prfArray[i],dbmsArray[i],0f);
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
					for (int i = 0; i < regNoArray.length; i++)
					{
						String spliteBatchName = regNoArray[i].substring(4,7);
						int batchNameInt = Integer.parseInt(spliteBatchName);
						if(batchNameInt == batchName){
							//int batchIndex = findIndexInArray(regNoArray,regNoArray[i]);
							System.out.printf("%-10d %-25s %-25s %-20s %-20d %-20d %-20f%n",no++,regNoArray[i],nameArray[i],nicArray[i],prfArray[i],dbmsArray[i],0f);
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
	
	
	// update array value
	public static void updateArrayValue(String[] array,int index, String value){
		array[index] = value;
	}
	public static void updateArrayValue(int[] array,int index, int value){
		array[index] = value;
	}
    
    // find index in array of given value
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
		for (int i = 0; i < regNoArray.length; i++)
		{
			String batchNoStr = regNoArray[i].substring(4,7);
			int batchNum = Integer.parseInt(batchNoStr);
			if(batchNum == num) count++;
			
		}
		return count;
		
	}
	
    //extend arrays
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

