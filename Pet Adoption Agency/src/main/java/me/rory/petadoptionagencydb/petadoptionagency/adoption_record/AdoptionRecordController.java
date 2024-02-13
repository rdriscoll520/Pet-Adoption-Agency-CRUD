package me.rory.petadoptionagencydb.petadoptionagency.adoption_record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class AdoptionRecordController {
    @Autowired
    private AdoptionRecordService service;

    @GetMapping("/PetAdoptionDB/adoptionrecord")
    public String showAdoptersList(Model model) {
        List<AdoptionRecord> listAdoptionRecords = service.listAll();
        model.addAttribute("listAdoptionRecords", listAdoptionRecords);
        return "adoption_record";
    }

    @GetMapping("/PetAdoptionDB/adoptionrecord/new")
    public String showNewForm(Model model) {
        model.addAttribute("adoptionrecord", new AdoptionRecord());
        model.addAttribute("pageTitle", "Add New Adoption Record");
        return "adoptionrecord_form";
    }

    @PostMapping("/PetAdoptionDB/adoptionrecord/save")
    public String savePet(AdoptionRecord adoptionRecord, RedirectAttributes ra) {
        service.save(adoptionRecord);
        ra.addFlashAttribute("message", "The adoption record has been saved!");
        return "redirect:/PetAdoptionDB/adoptionrecord";
    }
    @GetMapping("/PetAdoptionDB/adoptionrecord/edit{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            AdoptionRecord adoptionRecord = service.get(id);
            model.addAttribute("adoptionrecord", adoptionRecord);
            model.addAttribute("pageTitle", "Edit adoption record (ID: " + id + ")");
            return "adoptionrecord_form";
        } catch (AdoptionRecordService.AdoptionRecordNotFoundException e) {
            ra.addFlashAttribute("message", "The adoption record has been saved!");
            return "redirect:/PetAdoptionDB/adoptionrecord";
        }
    }
    @GetMapping("PetAdoptionDB/adoptionrecord/delete{id}")
    public String deletePet(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Adoption Record Deleted!");
        } catch (AdoptionRecordService.AdoptionRecordNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/PetAdoptionDB/adoptionrecord";
    }
}

