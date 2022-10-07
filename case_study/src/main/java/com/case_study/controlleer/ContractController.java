package com.case_study.controlleer;

import com.case_study.dto.contract.ContractDetailDto;
import com.case_study.dto.contract.ContractDto;
import com.case_study.model.contract.Contract;
import com.case_study.model.contract.ContractDetail;
import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;
import com.case_study.service.IContractService;
import com.case_study.service.ICustomerService;
import com.case_study.service.IEmployeeService;
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
import java.util.*;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("contract/list");
        return modelAndView;
    }

    @GetMapping("/list")
    public String listFacility(@PageableDefault(size = 5) Pageable pageable,
                               @RequestParam Optional<String> facilityName,
                               @RequestParam Optional<String> customerName,
                               Model model) {
        String keyName = facilityName.orElse("");
        String keyCus = customerName.orElse("");
        Page<Contract> contractPage = contractService.listContract(keyName, keyCus, pageable);
        Map<Long, Double> map = new HashMap<>();
        List<Contract> contractList = contractService.findAll();
        double totalMoney;
        for (Contract c : contractList) {
            totalMoney = 0;
            for (ContractDetail cd : c.getContractDetail()) {
                totalMoney += cd.getQuantity() * cd.getAttachFacility().getCost();
            }
            map.put(c.getId(), totalMoney);
        }
        model.addAttribute("total", map);
        model.addAttribute("attachFacility", contractService.listAttachFacility());
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("keyName", keyName);
        model.addAttribute("keyCus", keyCus);

        model.addAttribute("contractDetailDto", new ContractDetailDto());
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customer", customerService.findAllCustomer());
        model.addAttribute("facility", facilityService.listFacility());
        model.addAttribute("employee", employeeService.listEmployee());
        return "contract/list";
    }

    @PostMapping("/createContractDetail")
    public String createContractDetail(@ModelAttribute @Valid ContractDetailDto contractDetailDto,
                                       BindingResult bindingResult,
                                       RedirectAttributes rd) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/contract/list";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractService.saveContractDetail(contractDetail);
        rd.addFlashAttribute("msg", "thêm dịch vụ đi kèm thành công");
        return "redirect:/contract/list";
    }

    @PostMapping("/createContract")
    public String createContract(@ModelAttribute @Valid ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes rd) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "redirect:/contract/list";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        Facility facility = new Facility();
        facility.setId(contractDto.getFacility().getId());
        contract.setFacility(facility);

        Customer customer = new Customer();
        customer.setId(contractDto.getCustomer().getId());
        contract.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(contractDto.getEmployee().getId());
        contract.setEmployee(employee);

        contractService.saveContract(contract);
        rd.addFlashAttribute("msg", "thêm hợp đồng thành công");
        return "redirect:/contract/list";
    }

    @GetMapping("/listContractDetail/{id}")
    public String listContractDetail(@PathVariable Long id, RedirectAttributes rd){
        rd.addFlashAttribute("contractDetail", contractService.listContractDetail(id));
        return "redirect:/contract/list";
    }
}
