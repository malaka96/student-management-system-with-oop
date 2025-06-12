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
