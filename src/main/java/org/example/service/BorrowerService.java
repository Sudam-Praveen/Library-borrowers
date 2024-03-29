package org.example.service;

import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;

import java.util.List;

public interface BorrowerService {
    public BorrowerEntity addBorrower(Borrower borrower);
    public List<BorrowerEntity> getAllBorrowers();
    public boolean deleteBorrower(Long id);
    public BorrowerEntity updateBorrower(Borrower borrower);
    public BorrowerEntity findByUserName(String userName);
    public Boolean isExistsBorrower(String userName);
}
