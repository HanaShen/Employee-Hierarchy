/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author hana
 */
public class SalariedEmployee extends Employee {
    private double salary;
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber,double salary){
        super(firstName, lastName, socialSecurityNumber);
         if(salary< 0.0)
            throw new IllegalArgumentException("Salary must be >= 0.0");
         this.salary = salary;
    }
    public void setSalary(double salary){
        if(salary< 0.0)
            throw new IllegalArgumentException("Salary must be >= 0.0");
         this.salary = salary;
        
    }
    public double getSalary(){
        return salary;
    }
    @Override
    public double getEarnings(){
        return salary;
    }
    @Override
    public void raise(double percent){
        if (percent< 0.0)
            throw new IllegalArgumentException("Percent raise must be >= 0.0");
        setSalary(percent * salary + salary);
    }
    @Override
    public String toString(){
        return String.format("%s:%s %s:$%.2f%n %s: $%.2f%n","Salaried Employee",super.toString(), "Salary",getSalary(),"Earnings", getEarnings());
    }
}
