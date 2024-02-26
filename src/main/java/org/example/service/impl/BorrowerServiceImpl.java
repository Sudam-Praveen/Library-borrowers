package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;
import org.example.repository.BorrowerRepo;
import org.example.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    BorrowerRepo borrowerRepo;
    @Autowired
    ObjectMapper objectMapper;

    public BorrowerEntity addBorrower(Borrower borrower){
        List<BorrowerEntity> all = borrowerRepo.findAll();
        for (BorrowerEntity theBorrower:all) {
            if(theBorrower.getContactNumber().equals(borrower.getContactNumber())
                    || borrower.getEmail().equals(theBorrower.getEmail())){
                return null;
            }
        }
        BorrowerEntity borrowerEntity = objectMapper.convertValue(borrower, BorrowerEntity.class);
        return borrowerRepo.save(borrowerEntity);
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
    public BorrowerEntity updateBorrower(Borrower borrower){
        BorrowerEntity borrowerEntity = objectMapper.convertValue(borrower, BorrowerEntity.class);
        return borrowerRepo.save(borrowerEntity);
    }

    @Override
    public BorrowerEntity findByUserName(String userName) {
        return  borrowerRepo.findByUserName(userName);

    }

    @Override
    public Boolean isExistsBorrower(String userName) {
        return  borrowerRepo.existsByUserName(userName);

    }

}
