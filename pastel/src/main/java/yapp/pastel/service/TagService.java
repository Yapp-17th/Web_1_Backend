package yapp.pastel.service;

import org.springframework.beans.factory.annotation.Autowired;

import yapp.pastel.repository.TagRepository;

public class TagService {
  @Autowired
  private TagRepository tagRepository;
}
