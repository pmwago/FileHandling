public class Employee {
   private String fname;
    private  String surName;
   private double salary;

    public Employee(String fname,String surName,double salary){
        this.fname=fname;
        this.surName=surName;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return ""+fname+" "+surName+" "+salary+"\n";
    }
    public Employee() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
