package com.Test.TestSpring.controller;

import com.Test.TestSpring.dto.ClubDto;
import com.Test.TestSpring.models.Club;
import com.Test.TestSpring.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClubController {
    private final ClubService clubService;
    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") long clubId,
                             @Valid @ModelAttribute("club") ClubDto club,
                             BindingResult result){
        if (result.hasErrors()){
            return "clubs-edit";
        }
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model) {
        ClubDto club = this.clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }


    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDto> clubs = this.clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(/*@Valid*/ @ModelAttribute("club") Club club/* BindingResult result, Model model*/) {
//        if(result.hasErrors()) {
//            model.addAttribute("club", clubDto);
//            return "clubs-create";
//        }
        clubService.saveClub(club);
        return "redirect:/clubs";
    }
}
