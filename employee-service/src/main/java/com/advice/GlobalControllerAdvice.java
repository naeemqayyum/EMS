package com.advice;

import com.dto.Module;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addPinnedModules(Model model) {
        List<Module> pinnedModules = List.of(
                new Module("Employees", "/employees-view"),
                new Module("Payroll", "/payroll")
        );
        model.addAttribute("pinnedModules", pinnedModules);
    }

    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {
        model.addAttribute("currentUrl", request.getRequestURI());
    }


}
