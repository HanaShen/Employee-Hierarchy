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
public class HourlyEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;
    
    public HourlyEmployee (String firstName, String lastName, String socialSecurityNumber,  double hourlyWage, double hoursWorked){
        super(firstName, lastName, socialSecurityNumber);
        if(hourlyWage< 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        if (hoursWorked < 1.0 || hoursWorked > 168.0)
            throw new IllegalArgumentException(
            "Hours worked must be <= 168.0 and >= 1.0");
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }
    //set hourlyWage
    public void setHourlyWage(double hourlyWage){
        if(hourlyWage< 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        this.hourlyWage = hourlyWage;
    }
    public double getHourlyWage(){
        return hourlyWage;
    }
    //set hours worked
    public void setHoursWorked(){
        if (hoursWorked < 1.0 || hoursWorked > 168.0)
            throw new IllegalArgumentException(
            "Hours worked must be <= 168.0 and >= 1.0");
        this.hoursWorked = hoursWorked;
    }
    public double getHoursWorked(){
        return hoursWorked;
    }
   @Override
    public double getEarnings(){
        double multiple = 1.5;
        double regularHours = 40;//should I put these hear
        if (getHoursWorked() > regularHours)
            return regularHours * getHourlyWage() + (getHoursWorked() - regularHours) * (multiple * getHourlyWage());
        return getHourlyWage() * getHoursWorked();
    }
    @Override 
    public void raise(double percent){
        if (percent< 0.0)
            throw new IllegalArgumentException("Percent raise must be >= 0.0");
        setHourlyWage(hourlyWage * (1 + percent));
    }
    @Override
    public String toString(){
        return String.format("%s:%s %s:%.2f%n %s:%.2f%n %s:$%.2f%n", "Hourly Employee",super.toString(),"Hourly Wage",getHourlyWage(), "Hours Worked", getHoursWorked(), "Earnings", getEarnings());
    }
            
            
        
    }
    

