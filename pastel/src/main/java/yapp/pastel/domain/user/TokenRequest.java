package yapp.pastel.domain.user;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TokenRequest {
  private String username;
  private String email;

}
