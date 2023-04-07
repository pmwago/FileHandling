import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        double total = 0,average,newSalary;
        int count=0;
        Scanner input = new Scanner(System.in);
        String filename = "EmployDB.txt";
        List<Employee> employees=new ArrayList<>();
        //read the text file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
                    while ((line = reader.readLine())!=null) {
                        String[] parts = line.split(" ");

                        Employee emp=new Employee();
                        emp.setFname(parts[0]);
                        emp.setSurName(parts[1]);
                        emp.setSalary(Double.parseDouble(parts[2]));
                        //add the employee data to a data structure
                        employees.add(emp);
                    }
                         reader.close();
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                }

        for (Employee s : employees) {
            total+=s.getSalary();
        }
        //average salary of all employees
        average=total/ employees.size();
        System.out.println("Average salary is : "+average);

        //all employees eligible for a bonus
        System.out.println("Employees eligible for a bonus (salary<average salary)");
        for (Employee s : employees) {
            if (s.getSalary()<average) {
                count++;
                System.out.println(s.getFname() + " " + s.getSurName() + " " + s.getSalary());
            }
        }
        System.out.println("Total number : "+count);

        //updated list with salary+bonus for eligible employees
        System.out.println("Updated employees  with a 10% bonus..........");
        for (Employee s : employees) {
            if (s.getSalary()<average) {
                newSalary=((s.getSalary()*.1)+s.getSalary());
                s.setSalary(newSalary);
            }
            System.out.println(s.getFname() + " " + s.getSurName() + " " + s.getSalary());
        }

        //write the updated employee data to a different text file while preserving the format of the original data
        BufferedWriter output = null;
        try {
            File file = new File("EmployDB_bonus.txt");
            output = new BufferedWriter(new FileWriter(file));
            for (Employee s : employees){
                output.write(s.toString());
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                try {
                    output.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

            }
    }