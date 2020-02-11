package Byau.Thymeleaf.controller;

import Byau.Thymeleaf.entity.Employee;
import Byau.Thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";

    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        //save Employee
        employeeService.save(theEmployee);
        //use a redirect to prevent dublicate submission
        return "redirect:/employees/list";

    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId")int theId,Model theModel){
        //get the  employee from the service
        Employee theEmployee=employeeService.findById(theId);
        //set  employee add model  service
        theModel.addAttribute("employee",theEmployee);
        //send over to our form
        return "employees/employee-form";

    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        //delete the Employee
        employeeService.deleteById(theId);
        //redirect to /employees/list
        return "redirect:/employees/list";
    }

}


