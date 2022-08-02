package com.bcompany.mis;

import com.bcompany.mis.model.Department;
import com.bcompany.mis.model.Employee;
import com.bcompany.mis.repos.DepartmentRepository;
import com.bcompany.mis.repos.EmployeeRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@SpringBootApplication
public class MisApplication {
    @GetMapping("bgroup/mis/api/v1")
    public String Hello() {
        return "Helloworld";
    }

    ;

    public static void main(String[] args) {

        SpringApplication.run(MisApplication.class, args);
    }

    //    @Bean
//    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
//        return args -> {
//
//            Employee emp = new Employee("Kalasa", "Ivan", "0780854075", "ivan@gmial.com", "monny", "ivan123", LocalDate.parse("2003-12-27"), "MALE");
//
//            employeeRepository.save(emp);
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//            String date = "16/08/2016";
//
//            //convert String to LocalDate
//            LocalDate localDate = LocalDate.parse(date, formatter);
//            Employee emp2 = new Employee("Kalisa", "Ivan", "0780854045", "ivann@gmial.com", "monn", "monn123", localDate, "FEMALE");
//            employeeRepository.save(emp2);
//
//        };
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {
            Department dp = new Department("Sales");
            departmentRepository.save(dp);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            String date = "16/08/2016";
//
//            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(date, formatter);

            Department department = departmentRepository.findById(1).get();
            Employee employee = new Employee("Mutoni", "Alice", "0780854049", "mutoni@gmial.com", "mutoni", "monn123", localDate.now(), "FEMALE", department);
            employeeRepository.save(employee);
//            Faker faker=new Faker();
//            for(int i=0; i<50;i++) {
//                String firstName=faker.name().firstName();
//                String lastName=faker.name().lastName();
//                String email=firstName+"."+lastName+"@gmail.com";
//                String telephone= String.valueOf(Math.toIntExact(faker.number().randomNumber(10, true)));
//                String username=faker.name().username();
//                String password=faker.name().toString();
//                String gender=faker.name().name();
//                int day=faker.number().numberBetween(10, 25);
//                int month=faker.number().numberBetween(10, 12);
//                int years=faker.number().numberBetween(2000, 2010);
//                int dp2=faker.number().numberBetween(1,3);
//                Department dpt2=departmentRepository.findById(dp2).get();
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//                String date = day+"/"+month+"/"+years;
//                //convert String to LocalDate
//                LocalDate dob = LocalDate.parse(date, formatter);
//                Employee employee=new Employee(firstName, lastName, email,telephone, username, password, dob, gender, dpt2);
//                employeeRepository.save(employee);
//            }
        };
    }
}

