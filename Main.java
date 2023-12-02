import java.util.*;

abstract class Employee{
    private String name;

    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract  double calculateSalary();

    @Override
    public String toString(){
        return "Employee[name = "+ name+ " id ="+ id + " Salary = "+ calculateSalary()+"]";
    }
}

class fullTimeEmployee extends Employee{

    private double monthlySalary;

    public fullTimeEmployee(String name ,int id , double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    @Override

    public  double calculateSalary(){

        return monthlySalary;

    }
}

class partTimeEmployee extends Employee{

    private double hoursWorked;
    private double hourlyRate;

    public partTimeEmployee(String name,int id , double hoursWorked , double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override

    public double calculateSalary(){
        return hoursWorked*hourlyRate;

    }


}

class payrollSystem{
    private ArrayList<Employee> employeeList;

    public  payrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void  addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove =null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
        else{
            System.out.println("id not exist");
        }
    }
        public  void displayEmployee(){
             for(Employee employee : employeeList){
                System.out.println(employee);
             }
        }

    }


public class Main {
    public static void main(String [] args){
        payrollSystem PRS = new payrollSystem();
        int choice;
        String name;
        int id ;
        double monthlySalary;
        double hoursWorked;
        double hourlyRate;

        System.out.println("Welcome to our PAYROLL SYSTEM");
        do{
            System.out.println("-------------------------------------------------------");
            System.out.println("1 : Add FullTimeEmployee Details");
            System.out.println("2 : Add partTimeEmployee Details");
            System.out.println("3 : Display All Employee Details");
            System.out.println("4 : Remove Employee");
            System.out.println("5 : Exit");
            System.out.println("-------------------------------------------------------");
            System.out.println("Enter your choice");
            Scanner sc = new Scanner(System.in);
            choice =sc.nextInt();

            switch(choice){
                case 1:
                    sc.nextLine();
                     System.out.println("Enter the Name of the Employee");
                     name =sc.nextLine();
                     System.out.println("Enter the id ");
                     id=sc.nextInt();
                     System.out.println("Enter the monthly salary of Employee");
                     monthlySalary=sc.nextDouble();
                     fullTimeEmployee FTE = new fullTimeEmployee(name,id,monthlySalary);
                     PRS.addEmployee(FTE);
                     break;
                case 2:
                    sc.nextLine();
                     System.out.println("Enter the Name of the Employee");
                     name=sc.nextLine();
                     System.out.println("Enter the id ");
                     id=sc.nextInt();
                     System.out.println("Enter the hours Worked ");
                     hoursWorked=sc.nextDouble();
                     System.out.println("Enter the hourly rate");
                     hourlyRate=sc.nextDouble();
                     partTimeEmployee PTE = new partTimeEmployee(name,id,hoursWorked,hourlyRate);
                     PRS.addEmployee(PTE);
                     break;

                case 3:
                    System.out.println("Initial Employee Details");
                    PRS.displayEmployee();
                    break;
                case 4:
                    System.out.println("Enter the id of the Employee");
                    id=sc.nextInt();
                    System.out.println("Removing Employee");
                    PRS.removeEmployee(2);
                    System.out.println("Remaining Employee Details ");
                    PRS.displayEmployee();
                    break;
                case 5:
                    System.out.println("Exiting the program");
                    break;
                    
                    

                default: 
                    System.out.println("Invalid input");





            }
            
        }
        while(choice!=5);

        

    }
    
}
