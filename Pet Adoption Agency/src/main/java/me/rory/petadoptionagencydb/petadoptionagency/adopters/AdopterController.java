package me.rory.petadoptionagencydb.petadoptionagency.adopters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class AdopterController {
    @Autowired
    private AdopterService service;

    @GetMapping("/PetAdoptionDB/adopters")
    public String showAdoptersList(Model model) {
        List<Adopter> listAdopters = service.listAll();
        model.addAttribute("listAdopters", listAdopters);
        return "adopters";
    }

    @GetMapping("/PetAdoptionDB/adopters/new")
    public String showNewForm(Model model) {
        model.addAttribute("adopter", new Adopter());
        model.addAttribute("pageTitle", "Add New Adopter");
        return "adopter_form";
    }

    @PostMapping("/PetAdoptionDB/adopters/save")
    public String savePet(Adopter adopter, RedirectAttributes ra) {
        service.save(adopter);
        ra.addFlashAttribute("message", "The adopter has been saved!");
        return "redirect:/PetAdoptionDB/adopters";
    }
    @GetMapping("/PetAdoptionDB/adopters/edit{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Adopter adopter = service.get(id);
            model.addAttribute("adopter", adopter);
            model.addAttribute("pageTitle", "Edit Adopter (ID: " + id + ")");
            return "adopter_form";
        } catch (AdopterService.AdopterNotFoundException e) {
            ra.addFlashAttribute("message", "The adopter has been saved!");
            return "redirect:/PetAdoptionDB/adopters";
        }
    }
    @GetMapping("PetAdoptionDB/adopters/delete{id}")
    public String deletePet(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Adopter Deleted!");
        } catch (AdopterService.AdopterNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/PetAdoptionDB/adopters";
    }
}
