package me.rory.petadoptionagencydb.petadoptionagency.staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class StaffController {
    @Autowired
    private StaffService service;

    @GetMapping("/PetAdoptionDB/staff")
    public String showStaffList(Model model) {
        List<Staff> listStaff = service.listAll();
        model.addAttribute("listStaff", listStaff);
        return "staff";
    }

    @GetMapping("/PetAdoptionDB/staff/new")
    public String showNewForm(Model model) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("pageTitle", "Add New Staff");
        return "staff_form";
    }

    @PostMapping("/PetAdoptionDB/staff/save")
    public String savePet(Staff staff, RedirectAttributes ra) {
        service.save(staff);
        ra.addFlashAttribute("message", "The staff has been saved!");
        return "redirect:/PetAdoptionDB/staff";
    }
    @GetMapping("/PetAdoptionDB/staff/edit{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Staff staff = service.get(id);
            model.addAttribute("staff", staff);
            model.addAttribute("pageTitle", "Edit staff (ID: " + id + ")");
            return "staff_form";
        } catch (StaffService.StaffNotFoundException e) {
            ra.addFlashAttribute("message", "The staff has been saved!");
            return "redirect:/PetAdoptionDB/staff";
        }
    }
    @GetMapping("PetAdoptionDB/staff/delete{id}")
    public String deletePet(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Staff Deleted!");
        } catch (StaffService.StaffNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/PetAdoptionDB/staff";
    }
}
