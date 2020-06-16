import java.util.Random;

public class EmployeeWageComputation{

 int empWagePerHrs,empHrs,empSalary;

 //Default Constructor
 public EmployeeWageComputation()
 { }

 //Parameterized constructor
 public EmployeeWageComputation(int wagePerHrs, int Hrs)
 {
      empWagePerHrs=wagePerHrs;
      empHrs=Hrs;
      empSalary=0;
 }

 public int empAttendance()
 {
   Random myRan=new Random();
   int myRanVar=myRan.nextInt(3);
   System.out.println("Random Integers: "+myRanVar);
   return myRanVar;
 }

 public void calSalary()
 {
   empSalary=empWagePerHrs*empHrs;
   System.out.println("Salary of the employee:" + empSalary);
 }

 public static void main (String args[]){
     System.out.println("---------------------------------------------------");
     System.out.println("WELCOME TO EMPLOYEE WAGE PROBLEM");
     System.out.println("---------------------------------------------------");
     EmployeeWageComputation ewc=new EmployeeWageComputation();
     int resultAttendance=ewc.empAttendance();
     if(resultAttendance==0)
       {
         System.out.println("Employee is Absent");
         EmployeeWageComputation ewc1=new EmployeeWageComputation(20,0);
         ewc1.calSalary();
       }
    if(resultAttendance==1)
       {
         System.out.println("Employee is Present: PART TIME");
         EmployeeWageComputation ewc1=new EmployeeWageComputation(20,4);
         ewc1.calSalary();
       }
   if(resultAttendance==2)
       {
         System.out.println("Employee is Present: FULL TIME");
         EmployeeWageComputation ewc1=new EmployeeWageComputation(20,8);
         ewc1.calSalary();
       }
 }

}

