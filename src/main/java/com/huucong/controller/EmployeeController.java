package com.huucong.controller;


import com.huucong.model.Department;

import com.huucong.model.Employee;
import com.huucong.service.DepartmentService;
import com.huucong.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @ModelAttribute("departments")
    public Iterable<Department> departments () {
        return departmentService.findAll();
    }

    @GetMapping("/employee")
    public ModelAndView listDepartment(){
        Iterable<Employee> employees = employeeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView createFormEmployee(){
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView crateEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView editFormEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }
    @PostMapping("/edit-employee")
    public ModelAndView editEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.remove(id);
        return "redirect:/employee";
    }
}
