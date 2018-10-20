/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author hanaa
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;
    
    public BasePlusCommissionEmployee(String firstName, String lastName,String socialSecurityNumber,  double grossSales, double commissionRate, double baseSalary){
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base Salary must be >= 0.0");
        this.baseSalary = baseSalary; 
    }
    //set base salary
    public void setBaseSalary(double baseSalary){
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base Salary must be >= 0.0");
        this.baseSalary = baseSalary;
    }
    
    public double getBaseSalary(){
        return baseSalary;
    }
    @Override
    public double getEarnings(){
        return getBaseSalary() + super.getEarnings();
    }
     @Override 
    public void raise(double percent){
        if (percent< 0.0)
            throw new IllegalArgumentException("Percent raise must be >= 0.0");
        setBaseSalary(baseSalary * (1 + percent));
        super.raise(percent);
        
    }
    public String toString(){
        return String.format("%s %s %s:$%.2f%n %s:$%.2f%n", "Base Salary Plus", super.sharedString(), "with Base Salary of", getBaseSalary(), "Earnings", getEarnings() );
    }
}
