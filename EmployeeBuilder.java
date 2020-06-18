public class EmployeeBuilder{

 String companyName;
 int empWagePerHrs;
 int daysPerMonth;
 int totalMaxHr;

        //Setters and Getters
	public String getCompanyName(){
		return companyName;
	}

	public int getEmpWagePerHrs(){
		return empWagePerHrs;
	}

	public int getDaysPerMonth(){
		return daysPerMonth;
	}

	public int getTotalMaxHr(){
		return totalMaxHr;
	}

	public void setCompanyName(String companyName){
		this.companyName=companyName;
	}

	public void setEmpWagePerHrs(int empWagePerHrs){
		this.empWagePerHrs=empWagePerHrs;
	}

	public void setDaysPerMonth(int daysPerMonth){
		this.daysPerMonth=daysPerMonth;
	}

	public void setTotalMaxHr(int totalMaxHr){
		this.totalMaxHr=totalMaxHr;
	}

    public EmployeeBuilder(String cName, int ewph,int monthDays,int tmh) {
    super();
    companyName=cName;
    empWagePerHrs=ewph;
    daysPerMonth=monthDays;
    totalMaxHr=tmh;
   }
   public EmployeeBuilder(){}
}
