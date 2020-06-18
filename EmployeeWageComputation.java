import java.util.Random;
import java.util.Scanner;

interface EmpWageBuilder{
  public void calSalary(EmployeeBuilder[] empBuild); //interface method
}

class ComanyWiseWage implements EmpWageBuilder{

    @Override
    public void calSalary(EmployeeBuilder[] empBuild) {
    int i,empSalary,totalHr,numDays;
    int absentCount=0,partPresentCount=0,fullPresentCount=0,empHrs=1;

       for(i=0;i<empBuild.length;i++)
       {
        totalHr=0;
        numDays=0;
        empSalary=0;

        while(totalHr<=empBuild[i].totalMaxHr && numDays<empBuild[i].daysPerMonth)
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
        empSalary=empBuild[i].empWagePerHrs*totalHr;
        System.out.println("Company Name: "+ empBuild[i].companyName);
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

     Scanner sc = new Scanner(System.in);
     EmployeeBuilder empBuild[];

     System.out.println("Number of companies:");
     int num = sc.nextInt();
     empBuild=new EmployeeBuilder[num];

     for (int i=0; i<num; i++) {
            empBuild[i] = new EmployeeBuilder();
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
            empBuild[i]=ewcArr;
        }
      System.out.println("---------------------------- WAGE CALCULATION --------------------------------");
      ComanyWiseWage cw=new ComanyWiseWage();
      cw.calSalary(empBuild);
 }
}
