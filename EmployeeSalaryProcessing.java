import java.util.Scanner;

abstract class Employee {
    private int employeeId;
    private String employeeName;

    Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class ContractEmployee extends Employee {
    private int workingDays;
    private double dailyRate;

    ContractEmployee(int id, String name, int workingDays, double dailyRate) {
        super(id, name);
        this.workingDays = workingDays;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateSalary() {
        return workingDays * dailyRate;
    }
}

public class EmployeeSalaryProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int employeeType = sc.nextInt();
        int employeeId = sc.nextInt();
        String employeeName = sc.next();

        Employee employee;
        if (employeeType == 1) {
            double monthlySalary = sc.nextDouble();
            employee = new FullTimeEmployee(employeeId, employeeName, monthlySalary);
        } else {
            int workingDays = sc.nextInt();
            double dailyRate = sc.nextDouble();
            employee = new ContractEmployee(employeeId, employeeName, workingDays, dailyRate);
        }

        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getEmployeeName());
        System.out.printf("Salary: %.2f%n", employee.calculateSalary());

        sc.close();
    }
}

