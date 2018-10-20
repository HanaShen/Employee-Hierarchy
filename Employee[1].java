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
public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    
    
    public Employee(String firstName, String lastName, String socialSecurityNumber){ 
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        
    }
    
    public String getFirstName(){
        return  firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }
    
    
    public abstract double getEarnings();
    public abstract void raise(double percent);
    
    @Override
    public String toString(){
        return  String.format("%s %s %s: %s%n",  getFirstName(),getLastName(), "with ssn",getSocialSecurityNumber() );

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        System.out.printf("Employee information. %n");
         CommissionEmployee employee1 = new CommissionEmployee("Fred", "Jones", "111-11-1111", 2000.0, .05);
         BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee("Sue", "Smith", "222-22-2222", 3000.0, .05, 300);
         SalariedEmployee employee3 = new SalariedEmployee("Sha", "Yang", "333-33-3333", 1150.0);
         HourlyEmployee employee4 = new HourlyEmployee("Ian", "Tanning", "444-44-4444", 15.0, 50);
         HourlyEmployee employee5 = new HourlyEmployee("Angela", "Domchek", "555-55-5555", 20.0, 40);
         System.out.printf("%s%s%s%s%s", employee1,employee2,employee3,employee4, employee5);
         
         Employee[] employees = new Employee[5];
         employees[0] = employee1;
         employees[1] = employee2;
         employees[2] = employee3;
         employees[3] = employee4;
         employees[4] = employee5; 
          System.out.printf("Employee information after raises. %n");
         for (Employee currentEmployee : employees){
             if (currentEmployee instanceof SalariedEmployee){
                 SalariedEmployee employee = (SalariedEmployee) currentEmployee;
                 employee.raise(0.04);}
             
             else{
                 currentEmployee.raise(0.02);
             }
             System.out.printf("%s", currentEmployee);
             
         
         }
     }
    
}
