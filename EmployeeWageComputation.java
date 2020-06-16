import java.util.Random;

public class EmployeeWageComputation{

 EmployeeWageComputation()
 {
   System.out.println("Default Constructor called");
 }

 public void empAttendance()
 {
   Random myRan=new Random();
   int myRanVar=myRan.nextInt(2);
   System.out.println("Random Integers: "+myRanVar);

      if(myRanVar==0)
       {
         System.out.println("Employee Absent");
       }
      else
       {
         System.out.println("Employee Present");
       }
 }

 public static void main (String args[]){
     System.out.println("WELCOME TO EMPLOYEE WAGE PROBLEM");
     EmployeeWageComputation ewc=new EmployeeWageComputation();
     ewc.empAttendance();
 }

}
