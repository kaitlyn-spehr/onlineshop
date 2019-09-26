package com.perficient.onlineshop.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        productRepo.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Optional<Product> doomed = productRepo.findById(id);
        if (doomed.isPresent()) productRepo.delete(doomed.get());
        HttpStatus status = (doomed.isPresent()) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @GetMapping("/count")
    public long count()
    {
        return productRepo.count();
    }

    @GetMapping()
    public Iterable<Product> read(){
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product view(@PathVariable Long id) {
        return productRepo.findById(id).get();
    }
//
//    @GetMapping()
//    public Iterable<Product> read(
//            @RequestParam(value = "field", required = false) String field,
//            @RequestParam(value = "key", required = false) String key
//    ){
//        if (field != null && key != null) {
//            switch (field){
//                case "name":
//                    return productRepo.findAllByName(key);
//                case "email":
//                    return productRepo.findAllByEmail(key);
//                default:
//                    return new Iterable<Product>() {
//                        @Override
//                        public Iterator<Product> iterator() {
//                            return null;
//                        }
//                    };
//            }
//        } else {
//            return productRepo.findAll();
//        }
//    }

}