package mx.utng.s26.sesion26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.s26.sesion26.model.entity.Student;
import mx.utng.s26.sesion26.model.service.IStudentService;

@Controller
@SessionAttributes("student")
public class StudentController {
    @Autowired //crea una instancia de la calse para no estar poniendo "new"
    //y poder inciarlizarla fuera de un constructor
    private IStudentService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de estudiantes");
        model.addAttribute("students", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de estudiantes");
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid Student student, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de estudiantes");
            return "form";
        }
        service.save(student);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Student student = null;
        if(id > 0){
            student=service.getByID(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar estudiante");
        model.addAttribute("student", student);
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id>0){
            service.delete(id);
        }
        return "redirect:/list";
    }

}
