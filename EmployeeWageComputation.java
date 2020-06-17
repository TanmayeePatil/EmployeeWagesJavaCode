
import java.util.Random;

public class EmployeeWageComputation{

 private final int empWagePerHrs;
 private final int daysPerMonth;
 private final int totalMaxHr;
 private final int partTimeHrs;
 private final int fullTimeHrs;

 //constructor
 public EmployeeWageComputation(int empWagePerHrs, int daysPerMonth, int totalMaxHr, int partTimeHrs, int fullTimeHrs)
 {
   this.empWagePerHrs=empWagePerHrs;
   this.daysPerMonth=daysPerMonth;
   this.totalMaxHr=totalMaxHr;
   this.partTimeHrs=partTimeHrs;
   this.fullTimeHrs=fullTimeHrs;
 }

 public int empAttendance()
 {
   Random myRan=new Random();
   int myRanVar=myRan.nextInt(3);
   System.out.println("\nRandom Integers: "+myRanVar);
   return myRanVar;
 }

 public void calSalary()
 {
    int empHrs=0,empSalary=0,TotalEmpSalary=0,totalHr=0,i=0;

    while(totalHr <= totalMaxHr && i < daysPerMonth)
    {
      int resultAttendance=empAttendance();
      i++;
      switch(resultAttendance){
           case 0:
                  System.out.println("Employee is Absent");
                  empHrs=0;
                  break;
           case 1:
                  System.out.println("Employee is Present: PART TIME");
                  empHrs=partTimeHrs;
                  break;
           case 2:
                  System.out.println("Employee is Present: FULL TIME");
                  empHrs=fullTimeHrs;
                  break;
          default : System.out.println("Invalid");
      }
     totalHr=totalHr+empHrs;
     System.out.println("DAY"+i+" : Empolyee Hours: "+empHrs);
     //empSalary=empWagePerHrs*totalHr;
     //TotalEmpSalary=empSalary+TotalEmpSalary;
    }
    empSalary=empWagePerHrs*totalHr;
    System.out.println("----------------------------------------------");
    System.out.println("Total Hours: "+ totalHr);
    System.out.println("Total Salary: "+ empSalary);
 }

 public static void main (String args[]){
     System.out.println("---------------------------------------------------");
     System.out.println("WELCOME TO EMPLOYEE WAGE PROBLEM");
     System.out.println("---------------------------------------------------");
     EmployeeWageComputation ewc=new EmployeeWageComputation(20,20,100,4,8);
     ewc.calSalary();
 }

}

