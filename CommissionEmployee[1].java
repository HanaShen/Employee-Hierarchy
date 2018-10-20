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
public class CommissionEmployee extends Employee {
    private double  grossSales;
    private double commissionRate;
   // private double percent; where to declare this variable
    public CommissionEmployee (String firstName, String lastName, String socialSecurityNumber,  double grossSales, double commissionRate){
        super(firstName, lastName, socialSecurityNumber);
        if(grossSales< 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
        //if (percent< 0.0)
          //  throw new IllegalArgumentException("Percent raise must be >= 0.0");
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
        //this.percent = percent;
            
    }
    // set gross sales amount
    public void setGrossSales(double grossSales){
        if(grossSales< 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        this.grossSales = grossSales;
    }
    public double getGrossSales(){
        return grossSales;
    }
    public void setCommissionRate(double commissionRate){
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
        this.commissionRate = commissionRate;
    }
    public double getCommissionRate(){
        return commissionRate;
    }
    
    @Override
    public double getEarnings(){
        return getCommissionRate() * getGrossSales();
    }
    @Override 
    public void raise(double percent){
        if (percent< 0.0)
            throw new IllegalArgumentException("Percent raise must be >= 0.0");
        setCommissionRate(percent * commissionRate + commissionRate);
    }
    
    
    public String sharedString(){
        return String.format("%s:%s %s:%.2f%n %s:%.4f%n", "Commissioned Employee", super.toString(),"Gross Sales", getGrossSales(),"Commission Rate", getCommissionRate());
    }
    @Override
    public String toString(){
        return String.format("%s %s:$%.2f%n", sharedString(),"Earnings", getEarnings() );

    }
}
