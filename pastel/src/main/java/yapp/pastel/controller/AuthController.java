package yapp.pastel.controller;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.oauth2.sdk.token.RefreshToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import yapp.pastel.config.token.TokenRegistry;
import yapp.pastel.config.token.TokenUtils;
import yapp.pastel.domain.user.TokenRequest;
import yapp.pastel.domain.user.User;
import yapp.pastel.repository.UserRepository;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
  
  @Autowired private TokenUtils tokenUtils;
  @Autowired private ObjectMapper objectMapper;
  @Autowired private TokenRegistry tokenRegistry;
  @Autowired private UserRepository userRepository;

  @PostMapping(path = "/token")
  public String token(@RequestBody TokenRequest tokenRequest) {
    String result;
    try {
      UsernamePasswordAuthenticationToken authToken = 
          new UsernamePasswordAuthenticationToken(tokenRequest.getUsername(), tokenRequest.getEmail());
      Map<String, String> tokens = new HashMap<>();
      User user = userRepository.findByEmail(tokenRequest.getEmail()).get();
      String refreshToken = tokenUtils.createRefreshToken(user);
      tokens.put("accessToken", tokenUtils.createAccessToken(user));
      tokens.put("refreshToken", refreshToken);

      String email = user.getEmail();
      if (tokenRegistry.exists(email)) 
        tokenRegistry.remove(email);
      tokenRegistry.add(user.getEmail(), refreshToken);
      
    } catch (Exception e) {
      e.printStackTrace();
      return "Bad Request";
    }

    return tokenRegistry.get(tokenRequest.getEmail());

  }
  
}
