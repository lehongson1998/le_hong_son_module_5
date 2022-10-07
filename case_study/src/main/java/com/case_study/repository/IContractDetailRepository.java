package com.case_study.repository;

import com.case_study.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Long> {
    List<ContractDetail> findByContract_Id(Long contractId);
}
