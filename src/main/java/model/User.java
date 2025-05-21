package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString(exclude = "password")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    int id;
    String username;
    String password;
    Role role;
}
