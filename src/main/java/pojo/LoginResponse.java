package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    String token;
    String userId;
    String message;
}
