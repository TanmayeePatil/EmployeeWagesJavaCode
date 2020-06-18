import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

interface EmpWageBuilder{
  public void calSalary(List<EmployeeBuilder> empBuild); //interface method
}

class ComanyWiseWage implements EmpWageBuilder{

    @Override
    public void calSalary(List<EmployeeBuilder> empBuild) {
    int i,empSalary;

       for(i=0;i<empBuild.size();i++)
       {
        int totalHr=0,numDays=0;
        int absentCount=0,partPresentCount=0,fullPresentCount=0,empHrs=1;

        while(totalHr<=empBuild.get(i).totalMaxHr && numDays<empBuild.get(i).daysPerMonth)
        {
          Random myRan=new Random();
          int resultAttendance=myRan.nextInt(3);
          numDays++;
          switch(resultAttendance){
               case 0://System.out.println("Employee is ABSENT");
                      empHrs=0;
                      absentCount++;
                      break;
               case 1://System.out.println("Employee is PRESENT: PART TIME");
                      empHrs=4;
                      partPresentCount++;
                      break;
               case 2://System.out.println("Employee is PRESENT: FULL TIME");
                      empHrs=8;
                      fullPresentCount++;
                      break;
              default : System.out.println("Invalid");
          }
         totalHr=totalHr+empHrs;
        }
        empSalary=empBuild.get(i).empWagePerHrs*totalHr;
        System.out.println("Company Name: "+ empBuild.get(i).companyName);
        System.out.printf("Absent Days:%-5d PartTime Days:%-5d FullTimeDays:%d",absentCount,partPresentCount,fullPresentCount);
        System.out.println("\nTotal salary for "+numDays+" days or "+totalHr+" working hours is:"+ empSalary);
        System.out.println("------------------------------------------------------------------------------");
       }
    }
}

public class EmployeeWageComputation {

 public static void main (String args[]){
     System.out.println("------------------------------------------------------------------------------");
     System.out.println("                        WELCOME TO EMPLOYEE WAGE PROBLEM                      ");
     System.out.println("------------------------------------------------------------------------------");

     List<EmployeeBuilder> empBuild = new ArrayList<>();

     Scanner sc = new Scanner(System.in);
     System.out.println("Number of companies:");
     int num = sc.nextInt();

     for (int i=0; i<num; i++) {
            System.out.println("\nCOMPANY RECORD: "+(i+1));
            System.out.println("Enter company name:");
            String comapanyName=sc.next();
            System.out.println("Enter employee wage/hour:");
            int empWagePerHrs=sc.nextInt();
            System.out.println("Enter days in month:");
            int daysPerMonth=sc.nextInt();
            System.out.println("Enter maximum hours:");
            int totalMaxHr=sc.nextInt();
            EmployeeBuilder ewcArr=new EmployeeBuilder(comapanyName,empWagePerHrs,daysPerMonth,totalMaxHr);
            empBuild.add(ewcArr);
        }
      System.out.println("---------------------------- WAGE CALCULATION --------------------------------");
      ComanyWiseWage cw=new ComanyWiseWage();
      cw.calSalary(empBuild);
 }
}
