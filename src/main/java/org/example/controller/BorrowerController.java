package org.example.controller;

import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;
import org.example.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrower")
@CrossOrigin
public class BorrowerController {
    @Autowired
    BorrowerService borrowerService;

    @PostMapping("/add")
    public ResponseEntity<BorrowerEntity> addBorrower(@RequestBody Borrower borrower){
        BorrowerEntity borrowerEntity = borrowerService.addBorrower(borrower);
        return new ResponseEntity<>(borrowerEntity, HttpStatus.CREATED);
    }
@GetMapping("/all")
    public ResponseEntity<List<BorrowerEntity>> getBorrowers(){
        List<BorrowerEntity> allBorrowers = borrowerService.getAllBorrowers();
        return new ResponseEntity<>(allBorrowers,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBorrower(@PathVariable("id") Long id){
        if(borrowerService.deleteBorrower(id)){
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
    }

}
