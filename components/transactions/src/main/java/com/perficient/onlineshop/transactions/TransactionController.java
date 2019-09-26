package com.perficient.onlineshop.transactions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransRepo transactionRepo;

    public TransactionController(TransRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction) {
        transactionRepo.save(transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> delete(@PathVariable Long id) {
        Optional<Transaction> doomed = transactionRepo.findById(id);
        if (doomed.isPresent()) transactionRepo.delete(doomed.get());
        HttpStatus status = (doomed.isPresent()) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @GetMapping("/count")
    public long count()
    {
        return transactionRepo.count();
    }

    @GetMapping()
    public Iterable<Transaction> read(){
        return transactionRepo.findAll();
    }
//
//    @GetMapping()
//    public Iterable<Transaction> read(
//            @RequestParam(value = "field", required = false) String field,
//            @RequestParam(value = "key", required = false) String key
//    ){
//        if (field != null && key != null) {
//            switch (field){
//                case "name":
//                    return transactionRepo.findAllByName(key);
//                case "email":
//                    return transactionRepo.findAllByEmail(key);
//                default:
//                    return new Iterable<AppUser>() {
//                        @Override
//                        public Iterator<AppUser> iterator() {
//                            return null;
//                        }
//                    };
//            }
//        } else {
//            return transactionRepo.findAll();
//        }
//    }

}