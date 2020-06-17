import java.util.Random;

public class EmployeeWageComputation{

 private final String companyName;
 private final int empWagePerHrs;
 private final int daysPerMonth;
 private final int totalMaxHr;
 private final int partTimeHrs;
 private final int fullTimeHrs;

 //constructor
 public EmployeeWageComputation(int empWagePerHrs, int daysPerMonth, int totalMaxHr, int partTimeHrs, int fullTimeHrs, String companyName)
 {
   this.empWagePerHrs=empWagePerHrs;
   this.daysPerMonth=daysPerMonth;
   this.totalMaxHr=totalMaxHr;
   this.partTimeHrs=partTimeHrs;
   this.fullTimeHrs=fullTimeHrs;
   this.companyName=companyName;
 }

 public int empAttendance()
 {
   Random myRan=new Random();
   int myRanVar=myRan.nextInt(3);
   //System.out.println("\nRandom Integers: "+myRanVar);
   return myRanVar;
 }

 public int calSalary()
 {
    int empHrs=0,empSalary=0,TotalEmpSalary=0,totalHr=0,i=0;

    while(totalHr <= totalMaxHr && i < daysPerMonth)
    {
      int resultAttendance=empAttendance();
      i++;
      switch(resultAttendance){
           case 0:
                  //System.out.println("Employee is Absent");
                  empHrs=0;
                  break;
           case 1:
                  //System.out.println("Employee is Present: PART TIME");
                  empHrs=partTimeHrs;
                  break;
           case 2:
                  //System.out.println("Employee is Present: FULL TIME");
                  empHrs=fullTimeHrs;
                  break;
          default : System.out.println("Invalid");
      }
     totalHr=totalHr+empHrs;
    }
    empSalary=empWagePerHrs*totalHr;
    return empSalary;
 }

 public static void main (String args[]){
     System.out.println("------------------------------------------------------------------------------");
     System.out.println("                        WELCOME TO EMPLOYEE WAGE PROBLEM                      ");
     System.out.println("------------------------------------------------------------------------------");

     EmployeeWageComputation relianceCompany=new EmployeeWageComputation(20,20,100,4,8,"Reliance Smart");
     int result1=relianceCompany.calSalary();
     System.out.println("Company Name: "+relianceCompany.companyName);
     System.out.println("The Employee Wage for company: "+result1);
     System.out.println("------------------------------------------------------------------------------");

     EmployeeWageComputation dmartCompany=new EmployeeWageComputation(22,22,100,5,9,"Dmart");
     int result2=dmartCompany.calSalary();
     System.out.println("Company Name: "+dmartCompany.companyName);
     System.out.println("The Employee Wage for company: "+result2);
     System.out.println("------------------------------------------------------------------------------");
 }

}

