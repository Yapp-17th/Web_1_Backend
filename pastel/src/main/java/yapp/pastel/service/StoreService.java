package yapp.pastel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yapp.pastel.repository.StoreRepository;

@Service
public class StoreService {
  @Autowired
  private StoreRepository storeRepository;
}
