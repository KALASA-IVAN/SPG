package com.bcompany.mis.controller;

import com.bcompany.mis.model.Employee;
import com.bcompany.mis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:8080")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("app/employee")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> listAllEmployees() {
        return employeeService.listEmployee();
    }

    @PostMapping("/app/employee")
    @ResponseStatus(HttpStatus.OK)
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping("app/employee/{employeeid}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findEmployeeById(@PathVariable("employeeid") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("app/employee/{employeeid}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@RequestBody Employee employee, @PathVariable("employeeid") Long employeeid) {
        Employee emp = employeeService.getEmployeeById(employeeid);
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setTelePhone(employee.getTelePhone());
        emp.setEmail(employee.getEmail());
        emp.setUsername(employee.getUsername());
        emp.setPassword(employee.getPassword());
        emp.setDob(employee.getDob());
        emp.setAge(employee.getAge());
        emp.setGender(employee.getGender());

        employeeService.addEmployee(emp);
    }

    @DeleteMapping("app/employee/{employeeid}")
    public void deleteEmployee(@PathVariable("employeeid") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        employeeService.deleteEmployee(employee);
    }

    @GetMapping("app/employee/finder")
    public Optional<Employee> getEmployeeByEmail(@RequestParam String email) {
        return employeeService.findByEmail(email);
    }

//    Service Method
//    public Page<Student> getAllStudent(Integer pageNo, Integer pageSize, String sortBy){
//        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//        return studentRepository.findAll(paging);
//    }
//
//    Controller method
//    //Dynamic Pages
//    /* Sample calling
//     * http://localhost:8080/students/pages/?pageSize=10&pageNo=2&sortBy=email
//     * http://localhost:8080/students/pages/?pageSize=50&pageNo=1&sortBy=email
//     * http://localhost:8080/students/pages/?pageSize=10&pageNo=3&sortBy=firstName
//     */
//    @GetMapping("students/pages")
//    @ResponseStatus(HttpStatus.OK)
//    public Page<Employee> getPages(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "10") Integer pageSize,
//            @RequestParam(defaultValue = "id") String sortBy)
//    {
//        return employeeService.getAllStudent(pageNo, pageSize, sortBy);
//
//    }

}
