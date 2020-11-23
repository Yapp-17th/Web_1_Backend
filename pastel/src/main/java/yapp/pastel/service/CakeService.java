package yapp.pastel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yapp.pastel.domain.Cake;
import yapp.pastel.domain.Tag;
import yapp.pastel.repository.CakeRepository;
import yapp.pastel.repository.KindRepository;
import yapp.pastel.repository.TagRepository;

@Service
public class CakeService {
  @Autowired
  private CakeRepository cakeRepository;
  @Autowired
  private TagRepository tagRepository;
  @Autowired
  private KindRepository kindRepository;

  public List<Cake> recent() {
    return cakeRepository.findTop12ByOrderByCreatedAtDesc();
  }

  public Cake register(Cake cake) {
    cake.setLikes(0);
    cake.setViews(0);
    for (String tag : cake.getTags()) {
      System.out.println(tag);
      Optional<Tag> optionalTag = tagRepository.findByContent(tag);
      if (optionalTag.isPresent()) {
        Tag tempTag = optionalTag.get();
        System.out.println(tag + tempTag.toString());
        tempTag.setCount(tempTag.getCount() + 1);
        tagRepository.save(tempTag);
      } else {
        System.out.println(tag + "Nothing!!!");
        Tag tempTag = new Tag(tag);
        tagRepository.save(tempTag);
      }
    }
    return cakeRepository.save(cake);
  }

  public Cake findById(Long id) {
    return cakeRepository.findById(id).get();
  }
}
