package mx.utng.s26.sesion26.controller;

/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.s26.sesion26.model.entity.Secretary;
import mx.utng.s26.sesion26.model.service.ISecretaryService;

@Controller
@SessionAttributes("secretary")
public class SecretaryController {
    @Autowired 
    private ISecretaryService service;

    @GetMapping({"secretary", "/secretary", "/secretary/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de secretarios");
        model.addAttribute("secretarys", service.list());
        return "secretary-list";
    }

    @GetMapping("/secretary/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de secretarios");
        model.addAttribute("secretary", new Secretary());
        return "secretary-form";
    }

    @PostMapping("/secretary/form")
    public String save(@Valid Secretary secretary, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de secretarios");
            return "secretary-form";
        }
        service.save(secretary);
        return "redirect:/secretary/list";
    }

    @GetMapping("/secretary/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Secretary secretary = null;
        if(id > 0){
            secretary=service.getByID(id);
        }else{
            return "redirect:/secretary/list";
        }
        model.addAttribute("title", "Editar secretarios");
        model.addAttribute("secretary", secretary);
        return "secretary-form";
    }
    @GetMapping("/secretary/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id>0){
            service.delete(id);
        }
        return "redirect:/secretary/list";
    }

}
