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
import mx.utng.s26.sesion26.model.entity.Building;
import mx.utng.s26.sesion26.model.service.IBuildingService;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
@Controller
@SessionAttributes("building")
public class BuildingController {
    @Autowired 
    private IBuildingService service;

    @GetMapping({"building", "/building", "/building/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de edificios");
        model.addAttribute("buildings", service.list());
        return "building-list";
    }

    @GetMapping("/building/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de edificios");
        model.addAttribute("building", new Building());
        return "building-form";
    }

    @PostMapping("/building/form")
    public String save(@Valid Building building, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de edificios");
            return "building-form";
        }
        service.save(building);
        return "redirect:/building/list";
    }

    @GetMapping("/building/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Building building = null;
        if(id > 0){
            building=service.getByID(id);
        }else{
            return "redirect:/building/list";
        }
        model.addAttribute("title", "Editar edificios");
        model.addAttribute("building", building);
        return "building-form";
    }
    @GetMapping("/building/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id>0){
            service.delete(id);
        }
        return "redirect:/building/list";
    }

}
