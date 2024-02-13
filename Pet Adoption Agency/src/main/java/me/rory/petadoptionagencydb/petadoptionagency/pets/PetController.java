package me.rory.petadoptionagencydb.petadoptionagency.pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PetController {
    @Autowired
    private PetService service;

    @GetMapping("/PetAdoptionDB/pets")
    public String showPetList(Model model) {
        List<Pet> listPets = service.listAll();
        model.addAttribute("listPets", listPets);
        return "pets";
    }

    @GetMapping("/PetAdoptionDB/pets/new")
    public String showNewForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("pageTitle", "Add New Pet");
        return "pet_form";
    }

    @PostMapping("/PetAdoptionDB/pets/save")
    public String savePet(Pet pet, RedirectAttributes ra) {
        service.save(pet);
        ra.addFlashAttribute("message", "The pet has been saved!");
        return "redirect:/PetAdoptionDB/pets";
    }
    @GetMapping("/PetAdoptionDB/pets/edit{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Pet pet = service.get(id);
            model.addAttribute("pet", pet);
            model.addAttribute("pageTitle", "Edit Pet (ID: " + id + ")");
            return "pet_form";
        } catch (PetService.PetNotFoundException e) {
            ra.addFlashAttribute("message", "The pet has been saved!");
            return "redirect:/PetAdoptionDB/pets";
        }
    }
    @GetMapping("PetAdoptionDB/pets/delete{id}")
    public String deletePet(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Pet Deleted!");
        } catch (PetService.PetNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/PetAdoptionDB/pets";
    }
}
