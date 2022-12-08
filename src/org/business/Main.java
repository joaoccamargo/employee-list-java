package org.business;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        System.out.print("How many employees will be registered? ");
        int n = scan.nextInt();
        // List
        List<Employee> list = new ArrayList<>();

        for(Integer i = 0; i < n; i++){
            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            Integer id = scan.nextInt();
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Salary: ");
            Double salary = scan.nextDouble();
            list.add(new Employee(id, name, salary));
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = scan.nextInt();
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percentage = scan.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of employees: ");

        //List of employees
        for(Employee e : list){
            System.out.println(e);
        }

        scan.close();
    }
    public static Integer position(List<Employee> list, int id) {
        list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return null;
    }
}