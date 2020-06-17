
import java.util.Random;

public class EmployeeWageComputation{

 int empWagePerHrs,empHrs,empSalary,daysPerMonth,TotalEmpSalary,totalMaxHr,i,totalHr;

 //constructor
 public EmployeeWageComputation(int wagePerHrs, int monthDays, int maxHrs)
 {
   this.empWagePerHrs=wagePerHrs;
   this.daysPerMonth=monthDays;
   this.totalMaxHr=maxHrs;
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
    empHrs=0;
    empSalary=0;
    TotalEmpSalary=0;
    totalHr=0;
    i=0;

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
                  empHrs=4;
                  break;
           case 2:
                  System.out.println("Employee is Present: FULL TIME");
                  empHrs=8;
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
     EmployeeWageComputation ewc=new EmployeeWageComputation(20,20,100);
     ewc.calSalary();
 }

}

