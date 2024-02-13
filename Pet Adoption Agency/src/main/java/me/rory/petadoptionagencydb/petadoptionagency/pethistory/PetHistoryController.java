package me.rory.petadoptionagencydb.petadoptionagency.pethistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class PetHistoryController {
    @Autowired
    private PetHistoryService service;

    @GetMapping("/PetAdoptionDB/pethistory")
    public String showPetHistoryList(Model model) {
        List<PetHistory> listPetHistory = service.listAll();
        model.addAttribute("listPetHistory", listPetHistory);
        return "PetHistory";
    }

    @GetMapping("/PetAdoptionDB/pethistory/new")
    public String showNewForm(Model model) {
        model.addAttribute("pethistory", new PetHistory());
        model.addAttribute("pageTitle", "Add New PetHistory");
        return "pethistory_form";
    }

    @PostMapping("/PetAdoptionDB/pethistory/save")
    public String savePet(PetHistory pethistory, RedirectAttributes ra) {
        service.save(pethistory);
        ra.addFlashAttribute("message", "The Pet History has been saved!");
        return "redirect:/PetAdoptionDB/pethistory";
    }
    @GetMapping("/PetAdoptionDB/pethistory/edit{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            PetHistory pethistory = service.get(id);
            model.addAttribute("pethistory", pethistory);
            model.addAttribute("pageTitle", "Edit Pet History (ID: " + id + ")");
            return "pethistory_form";
        } catch (PetHistoryService.PetHistoryNotFoundException e) {
            ra.addFlashAttribute("message", "The Pet History has been saved!");
            return "redirect:/PetAdoptionDB/pethistory";
        }
    }
    @GetMapping("PetAdoptionDB/pethistory/delete{id}")
    public String deletePet(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Pet History Deleted!");
        } catch (PetHistoryService.PetHistoryNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/PetAdoptionDB/pethistory";
    }
}
