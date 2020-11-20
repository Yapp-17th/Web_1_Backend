package yapp.pastel.service;

import org.springframework.beans.factory.annotation.Autowired;

import yapp.pastel.domain.Tag;
import yapp.pastel.repository.TagRepository;

public class TagService {
  @Autowired
  private TagRepository tagRepository;

  public Tag save(Tag tag) {
    return tagRepository.save(tag);
  }


}
