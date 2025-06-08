package com.spring.proxylab.lazy.controller;

import com.spring.proxylab.lazy.service.LazyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lazy")
public class LazyController {

    @Autowired
    private  LazyService lazyService;

    @GetMapping("/inside-session/{id}")
    public String loadWithTransaction(@PathVariable Long id) {
        lazyService.loadAuthorAndBooks(id);
        return " Loaded inside transaction";
    }

    @GetMapping("/outside-session/{id}")
    public String loadOutsideTransaction(@PathVariable Long id) {
        lazyService.loadOutsideTransaction(id);
        return " This may fail if books are lazy!";
    }
}
