package yapp.pastel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yapp.pastel.domain.Cake;
import yapp.pastel.service.CakeService;

@RestController
public class CakeController {
  
  @Autowired
  private CakeService cakeService;
  
  @PostMapping("/cake")
  public Cake register(@RequestBody Cake cake) {
    return cakeService.register(cake);
  }

  @GetMapping("/cake/{id}")
  public Cake get(@PathVariable("id") Long id) {
    return cakeService.findById(id);
  }
}
