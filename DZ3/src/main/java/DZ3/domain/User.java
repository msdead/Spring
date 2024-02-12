package DZ3.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private String email;

}
