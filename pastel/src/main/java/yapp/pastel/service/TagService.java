package yapp.pastel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yapp.pastel.domain.Tag;
import yapp.pastel.repository.TagRepository;

@Service
public class TagService {
  @Autowired
  private TagRepository tagRepository;

  public Tag save(Tag tag) {
    return tagRepository.save(tag);
  }

  public List<Tag> favorite() {
    return tagRepository.findTop3ByOrderByCountDesc();
  }

  public List<Tag> random() {
    return tagRepository.findByRandomOrder();
  }


}
