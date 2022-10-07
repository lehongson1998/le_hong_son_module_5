package com.case_study.controlleer;

import com.case_study.dto.facility.FacilityDto;
import com.case_study.dto.facility.FacilityTypeDto;
import com.case_study.model.customer.TypeCustomer;
import com.case_study.model.facility.Facility;
import com.case_study.model.facility.FacilityType;
import com.case_study.model.facility.RentType;
import com.case_study.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("layout/home");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listFacility(@PageableDefault(size = 5) Pageable pageable,
                                     @RequestParam Optional<String> name){
        ModelAndView modelAndView = new ModelAndView("facility/list");
        String keyName = name.orElse("");
        Page<Facility> facilityPage = facilityService.listFacility(keyName, pageable);
        modelAndView.addObject("facilityPage", facilityPage);
        modelAndView.addObject("keyName", keyName);
        return modelAndView;
    }

    @GetMapping("/formCreate")
    public String showFormFacility(Model model){
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityType", facilityService.listFacilityType());
        model.addAttribute("rentType", facilityService.listRentType());
        return "facility/create";
    }

    @PostMapping("/create")
    public String createFacility(@ModelAttribute @Valid FacilityDto facilityDto, BindingResult bindingResult,
                                 Model model ){
        model.addAttribute("facilityDto", facilityDto);
        if(bindingResult.hasErrors()){
            model.addAttribute("facilityType", facilityService.listFacilityType());
            model.addAttribute("rentType", facilityService.listRentType());
            return "facility/create";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);

        FacilityType facilityType = new FacilityType();
        facilityType.setId(facilityDto.getFacilityId().getId());
        facility.setFacilityId(facilityType);

        RentType rentType = new RentType();
        rentType.setId(facilityDto.getRentType().getId());
        facility.setRentType(rentType);

        facilityService.saveFacility(facility);
        return "redirect:/facility/list";
    }

    @GetMapping("/delete")
    public String deleteFacility(@RequestParam Long id, RedirectAttributes redirectAttributes){
        facilityService.deleteFacility(id);
        redirectAttributes.addFlashAttribute("msg", "xóa thành công");
        return "redirect:/facility/list";
    }

    @GetMapping("/formEdit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        Facility facility = facilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityType", facilityService.listFacilityType());
        model.addAttribute("rentType", facilityService.listRentType());
        return "facility/edit";
    }
}
