package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;
import org.example.repository.BorrowerRepo;
import org.example.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BorrowerServiceImpl implements BorrowerService {
    
    @Autowired
    BorrowerRepo borrowerRepo;
    @Autowired
    ObjectMapper objectMapper;
    
    public BorrowerEntity addBorrower(Borrower borrower){
        BorrowerEntity borrowerEntity = objectMapper.convertValue(borrower, BorrowerEntity.class);

        String registerNumber = getRegisterNumber(borrowerEntity);
        borrowerEntity.setRegisterNo(registerNumber);
        return borrowerRepo.save(borrowerEntity);

    }

    private String getRegisterNumber(BorrowerEntity borrowerEntity) {
        Random input = new Random();
        int num = input.nextInt(1000);
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dateString = format.substring(2, 10);
        String registerNumber = "RN#"+dateString+"-"+num;
        return registerNumber;
    }

    public List<BorrowerEntity> getAllBorrowers(){
        return borrowerRepo.findAll();

    }

    public boolean deleteBorrower(Long id){

        Optional<BorrowerEntity> byId = borrowerRepo.findById(id);
        if(byId.isPresent()){
            borrowerRepo.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
}
