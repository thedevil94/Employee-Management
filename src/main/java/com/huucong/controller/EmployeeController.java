package com.huucong.controller;


import com.huucong.model.Department;

import com.huucong.model.Employee;
import com.huucong.service.DepartmentService;
import com.huucong.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
    public ModelAndView listDepartment(@PageableDefault(size = 8) Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);
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

    @GetMapping("/searchByDepartment")
    public ModelAndView getEmployeeByDepartment(@RequestParam("srch") String search,@PageableDefault(size = 2) Pageable pageable){
        Department department = departmentService.findById(Integer.parseInt(search));
        Page<Employee> employees = employeeService.findAllByDepartment(department,pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees",employees);
        modelAndView.addObject("srch",search);
        return modelAndView;
    }

    @GetMapping("/sortBySalaryAsc")
    public ModelAndView getEmployeeSortBySalaryAsc(@PageableDefault(size = 8) Pageable pageable){
        Page<Employee> employees = employeeService.findAllByOrderBySalaryAsc(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }

    @GetMapping("/descBySalaryDesc")
    public ModelAndView getEmployeeSortBySalaryDesc(@PageableDefault(size = 8) Pageable pageable){
        Page<Employee> employees = employeeService.findAllByOrderBySalaryDesc(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }
}
