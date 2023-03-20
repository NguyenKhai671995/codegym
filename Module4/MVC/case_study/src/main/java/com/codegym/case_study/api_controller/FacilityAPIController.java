package com.codegym.case_study.api_controller;
import com.codegym.case_study.dto.facility.FacilityViewDTO;
import com.codegym.case_study.service.facility.impl.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fac")
@CrossOrigin("http://localhost:4200")
public class FacilityAPIController {
    @Autowired
    FacilityService facilityService;

    @GetMapping("")
    public Page<FacilityViewDTO> getListContract(@RequestParam(value = "nameSearch",defaultValue = "")String name) {
        return facilityService.findAllByName(name, Pageable.unpaged());
    }

}
