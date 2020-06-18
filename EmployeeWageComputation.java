import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

interface EmpWageBuilder{
  public void calSalary(List<EmployeeBuilder> empBuild); //interface method
}

class ComanyWiseWage implements EmpWageBuilder{

    @Override
    public void calSalary(List<EmployeeBuilder> empBuild) {
     int i;
     List<String> dailySalaryWage = new ArrayList<>();
     HashMap<String,Integer> companyWage=new HashMap<>();
     Scanner sc = new Scanner(System.in);

       for(i=0;i<empBuild.size();i++)
       {
        int totalHr=0,numDays=0,dailyEmpSalary=0,empTotalSalary=0;
        int absentCount=0,partPresentCount=0,fullPresentCount=0,empHrs=1;

        System.out.println("Company Name: "+ empBuild.get(i).companyName);

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
         dailyEmpSalary=empHrs*empBuild.get(i).empWagePerHrs;
         //System.out.println("Day"+numDays+": Daily Wage:"+ dailyEmpSalary);
         empTotalSalary=empTotalSalary+dailyEmpSalary;
         String result=empBuild.get(i).companyName+" Day"+numDays+": Daily Wage:"+ dailyEmpSalary;
         dailySalaryWage.add(result);
        }
        String result1=empBuild.get(i).companyName+": TOTAL WAGE:"+ empTotalSalary;
        dailySalaryWage.add(result1);
        System.out.printf("Absent Days:%-5d PartTime Days:%-5d FullTimeDays:%d",absentCount,partPresentCount,fullPresentCount);
        System.out.println("\nTotal salary for "+numDays+" days or "+totalHr+" working hours is:"+ empTotalSalary);
        System.out.println("------------------------------------------------------------------------------");
        companyWage.put(empBuild.get(i).companyName, empTotalSalary);
       }
       System.out.println("\n--------------------- SEARCH RECORD BY COMANY NAME ---------------------------");
       System.out.println("Enter the Comapny Name for search:");
       String searchCompany=sc.next();

        if(companyWage.containsKey(searchCompany)){
            System.out.println("Company Name: "+ searchCompany);
            System.out.println("Total Employee Wage: "+companyWage.get(searchCompany));
        }else{
            System.out.println("Company "+searchCompany+" not found");
        }
       System.out.println("------------------------------------------------------------------------------");
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
