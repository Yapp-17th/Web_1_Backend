package yapp.pastel.domain.user;

import lombok.Data;

@Data
public class Token {
  private String accessToken;
  private String refreshToken;
}
