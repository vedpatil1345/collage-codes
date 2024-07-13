
/*Define a class with the Name, Basic salary and dearness allowance as data 
members.Calculate and print the Name, Basic salary(yearly), dearness allowance and 
tax deduced at source(TDS) and net salary, where TDS is charged on gross salary  
which is basic salary + dearness allowance and TDS rate is as per following table. 
Gross Salary TDS 
Rs. 100000 and below NIL 
Above Rs. 100000 10% on excess over 100000 

DA is 74% of Basic Salary for all. Use appropriate member function.
*/
class Employee {
    private String name;
    private double basicSalary;
    private double dearnessAllowance;

    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.dearnessAllowance = 0.74 * basicSalary;
    }

    public void calculateSalary() {
        double grossSalary = basicSalary + dearnessAllowance;
        double tds;

        if (grossSalary <= 100000) {
            tds = 0;
        } else {
            tds = 0.1 * (grossSalary - 100000);
        }

        double netSalary = grossSalary - tds;

        System.out.println("Name: " + name);
        System.out.println("Basic Salary (Yearly): Rs. " + basicSalary);
        System.out.println("Dearness Allowance: Rs. " + dearnessAllowance);
        System.out.println("Tax Deducted at Source (TDS): Rs. " + tds);
        System.out.println("Net Salary: Rs. " + netSalary);
    }
}

public class Salarycalc {
    public static void main(String[] args) {
        Employee employee1 = new Employee("ved", 80000);
        employee1.calculateSalary();
        System.out.println();

        Employee employee2 = new Employee("khusmit", 150000);
        employee2.calculateSalary();
    }
}
