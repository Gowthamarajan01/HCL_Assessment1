import java.util.Scanner;

class Employee {
    protected String employeeName;

    Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public double calculateBonus() {
        return 0.0;
    }

    public double calculateBonus(double amount) {
        return 0.0;
    }
}

class TechnicalEmployee extends Employee {
    private double basicSalary;
    private int rating;

    TechnicalEmployee(String employeeName, double basicSalary, int rating) {
        super(employeeName);
        this.basicSalary = basicSalary;
        this.rating = rating;
    }

    @Override
    public double calculateBonus() {
        return calculateBonus(basicSalary, rating);
    }

    public double calculateBonus(double salary, int employeeRating) {
        return salary * employeeRating * 2.0 / 100.0;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}

class SalesEmployee extends Employee {
    private double salesAmount;

    SalesEmployee(String employeeName, double salesAmount) {
        super(employeeName);
        this.salesAmount = salesAmount;
    }

    @Override
    public double calculateBonus() {
        return calculateBonus(salesAmount);
    }

    @Override
    public double calculateBonus(double amount) {
        return amount * 3.0 / 100.0;
    }

    public double getSalesAmount() {
        return salesAmount;
    }
}

public class EmployeePerformanceBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int employeeType = sc.nextInt();
        String employeeName = sc.next();

        Employee employee;
        double earningsBase;

        if (employeeType == 1) {
            double basicSalary = sc.nextDouble();
            int rating = sc.nextInt();
            employee = new TechnicalEmployee(employeeName, basicSalary, rating);
            earningsBase = basicSalary;
        } else {
            double salesAmount = sc.nextDouble();
            employee = new SalesEmployee(employeeName, salesAmount);
            earningsBase = salesAmount;
        }

        double bonus = employee.calculateBonus();
        System.out.println("Employee Name: " + employeeName);
        System.out.printf("Bonus: %.2f%n", bonus);
        System.out.printf("Total Earnings: %.2f%n", earningsBase + bonus);

        sc.close();
    }
}
