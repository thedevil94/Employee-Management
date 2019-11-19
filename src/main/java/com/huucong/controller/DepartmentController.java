package com.huucong.controller;


import com.huucong.model.Department;
import com.huucong.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public ModelAndView listDepartment(){
        Iterable<Department> departments = departmentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/department/list");
        modelAndView.addObject("departments", departments);
        return modelAndView;
    }

    @GetMapping("/create-department")
    public ModelAndView createFormDepartment(){
        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }

    @PostMapping("/create-department")
    public ModelAndView crateDepartment(@ModelAttribute("department") Department department){
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("redirect:/departments");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }

    @GetMapping("/edit-department/{id}")
    public ModelAndView editFormDepartment(@PathVariable int id){
        Department department = departmentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/department/edit");
        modelAndView.addObject("department", department);
        return modelAndView;
    }
    @PostMapping("/edit-department")
    public ModelAndView editDepartment(@ModelAttribute("department") Department department){
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("redirect:/departments");
        modelAndView.addObject("department", department);
        return modelAndView;
    }

    @GetMapping("/delete-department/{id}")
    public String deleteDepartment(@PathVariable int id){
        departmentService.remove(id);
        return "redirect:/departments";
    }
}
