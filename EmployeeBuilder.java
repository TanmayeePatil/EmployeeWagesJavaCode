public class EmployeeBuilder{

 String companyName;
 int empWagePerHrs;
 int daysPerMonth;
 int totalMaxHr;
 int partTimeHrs;
 int fullTimeHrs;

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

	public int getPartTimeHrs(){
		return partTimeHrs;
	}

	public int getFullTimeHrs(){
		return fullTimeHrs;
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

	public void setPartTimeHrs(int partTimeHrs){
		this.partTimeHrs=partTimeHrs;
	}

	public void setFullTimeHrs(int fullTimeHrs){
		this.fullTimeHrs=fullTimeHrs;
	}
}
