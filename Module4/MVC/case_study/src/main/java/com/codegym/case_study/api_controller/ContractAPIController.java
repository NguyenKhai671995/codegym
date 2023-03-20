package com.codegym.case_study.api_controller;
import com.codegym.case_study.dto.contract.ContractViewDTO;
import com.codegym.case_study.model.contract.Contract;
import com.codegym.case_study.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping("/cont")
@CrossOrigin("http://localhost:4200")
public class ContractAPIController {

    @Autowired
    IContractService contractService;


    @GetMapping("")
    public Page<ContractViewDTO> getListContract(@RequestParam(value = "nameSearch",defaultValue = "")String name) {
        return contractService.findAllByName(name, Pageable.unpaged());
    }

    @GetMapping("/{id}")
    public Contract findById(@PathVariable("id") Long id){
        return contractService.findById(id);
    }
    @PostMapping("")
    public ContractViewDTO saveContract(@Valid @RequestBody ContractViewDTO contractViewDTO) {
        return contractService.save(new Contract(contractViewDTO));
    }
    @PutMapping("/{id}")
    public ContractViewDTO updateContract(@Valid @RequestBody ContractViewDTO contractViewDTO) {
        return contractService.save(new Contract(contractViewDTO));
    }

    @DeleteMapping("/{id}")
    public Integer deleteByID(@PathVariable("id") Long id){
        return contractService.updateStatusById(id);
    }

}
