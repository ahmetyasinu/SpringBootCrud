package Byau.Thymeleaf.controller;

import Byau.Thymeleaf.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    //load employee data
    private List<Employee> theEmployee;
    @PostConstruct
    private void loadData(){
        //create employees
        Employee emp1=new Employee(1,"Sefa","Cihangir","kafkascihangir@gmail.com");
        Employee emp2=new Employee(2,"Ahmet","Yasin","ahmetyasin@gmail.com");
        Employee emp3=new Employee(3,"Şeyh","Şamil","Şamil@gmail.com");
        //create list
        theEmployee= new ArrayList<>();
        //add to list
        theEmployee.add(emp1);
        theEmployee.add(emp2);
        theEmployee.add(emp3);

    }
    //add mapping for "/list"
    @RequestMapping("/list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees",theEmployee);
        return "list-employees";
    }


}
