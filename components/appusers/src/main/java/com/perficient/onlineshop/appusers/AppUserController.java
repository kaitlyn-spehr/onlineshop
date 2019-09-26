package com.perficient.onlineshop.appusers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appusers")
public class AppUserController {

    private AppUserRepo appUserRepo;

    public AppUserController(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @PostMapping
    public ResponseEntity<AppUser> create(@RequestBody AppUser appUser) {
        appUserRepo.save(appUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping
    public List<AppUser> read(){
        List<AppUser> ret = new ArrayList<>();
        appUserRepo.findAll().forEach(ret::add);
        return ret;
    }

    @GetMapping("/{id}")
    public AppUser view(@PathVariable Long id) {
        return appUserRepo.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AppUser> delete(@PathVariable Long id) {
        Optional<AppUser> doomed = appUserRepo.findById(id);
        if (doomed.isPresent()) appUserRepo.delete(doomed.get());
        HttpStatus status = (doomed.isPresent()) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

//    @PostMapping
//    public ResponseEntity<AppUser> create(@RequestBody AppUser appUser) {
//        appUserRepo.save(appUser);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//

//
//    @GetMapping("/count")
//    public long count()
//    {
//        return appUserRepo.count();
//    }
//
//    @GetMapping()
//    public Iterable<AppUser> read(
//            @RequestParam(value = "field", required = false) String field,
//            @RequestParam(value = "key", required = false) String key
//    ){
//        if (field != null && key != null) {
//            switch (field){
//                case "name":
//                    return appUserRepo.findAllByName(key);
//                case "email":
//                    return appUserRepo.findAllByEmail(key);
//                default:
//                    return new Iterable<AppUser>() {
//                        @Override
//                        public Iterator<AppUser> iterator() {
//                            return null;
//                        }
//                    };
//            }
//        } else {
//            return appUserRepo.findAll();
//        }
//    }

}