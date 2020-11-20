package yapp.pastel.service;

import org.springframework.beans.factory.annotation.Autowired;

import yapp.pastel.repository.StoreRepository;

public class StoreService {
  @Autowired
  private StoreRepository storeRepository;
}
