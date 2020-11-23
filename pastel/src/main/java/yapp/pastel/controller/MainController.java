package yapp.pastel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import yapp.pastel.domain.Cake;
import yapp.pastel.domain.Tag;
import yapp.pastel.service.CakeService;
import yapp.pastel.service.TagService;

@RestController
public class MainController {
  
  @Autowired
  private CakeService cakeService;

  @Autowired
  private TagService tagService;

  @GetMapping("/main/keyword/favorite")
  public List<Tag> favorite() {
    return tagService.favorite();
  }

  @GetMapping("/main/keyword/random")
  public List<Tag> random() {
    return tagService.random();
  }

  @GetMapping("/main/cake/recent")
  public List<Cake> recent() {
    return cakeService.recent();
  }

}
