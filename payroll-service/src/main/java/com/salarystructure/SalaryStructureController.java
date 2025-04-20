package com.salarystructure;

import com.model.SalaryStructure;
import com.salarystructure.service.SalaryStructureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/salary-structure")
public class SalaryStructureController {

    private final SalaryStructureService salaryStructureService;

    public SalaryStructureController(SalaryStructureService salaryStructureService) {
        this.salaryStructureService = salaryStructureService;
    }

    @GetMapping
    public String viewAll(Model model) {
        List<SalaryStructure> structures = salaryStructureService.getAll();
        model.addAttribute("structures", structures);
        return "salary-structure/list";
    }

    @GetMapping("/employee/{id}")
    public String viewByEmployee(@PathVariable Long id, Model model) {
        SalaryStructure structure = salaryStructureService.getByEmployeeId(id);
        model.addAttribute("structure", structure);
        return "salary-structure/detail";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("structure", new SalaryStructure());
       // model.addAttribute("employees", employeeService.getAll());
        return "salary-structure/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SalaryStructure structure) {
        salaryStructureService.save(structure);
        return "redirect:/salary-structure";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        SalaryStructure structure = salaryStructureService.getByEmployeeId(id);
        model.addAttribute("structure", structure);
//        model.addAttribute("employees", employeeService.getAll());
        return "salary-structure/form";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        salaryStructureService.deleteByEmployeeId(id);
        return "redirect:/salary-structure";
    }
}
