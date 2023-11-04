import java.util.*;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name , int id){
        this.name = name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();
    @Override

    public String toString(){
        return "Employee [name ="+name+" , id ="+id+" , salary ="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name ,int id, double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private double hourlyRate ;
    private int hoursWorked ;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return (double)hoursWorked * hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeesList;

    public PayrollSystem(){
        employeesList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeesList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeesList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeesList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee : employeesList){
            System.out.println(employee);
        }
    }
}

public class Employ {
    public static void main(String[] args) {
        PayrollSystem  payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Aditya kumar", 1, 70000);
        FullTimeEmployee emp2 = new FullTimeEmployee("Shovan kumar", 2, 70000);
        PartTimeEmployee emp3 = new PartTimeEmployee("Rahul jha", 3, 40, 100);

         payrollSystem.addEmployee(emp1);
         payrollSystem.addEmployee(emp2);
         payrollSystem.addEmployee(emp3);

         System.out.println("\nInitial Employee details:\n");

         payrollSystem.displayEmployee();

         System.out.println("\nRemoving employee....." );
         payrollSystem.removeEmployee(3);

         System.out.println("\nRemaining Employee detail\n");
         payrollSystem.displayEmployee();       
    }
}
