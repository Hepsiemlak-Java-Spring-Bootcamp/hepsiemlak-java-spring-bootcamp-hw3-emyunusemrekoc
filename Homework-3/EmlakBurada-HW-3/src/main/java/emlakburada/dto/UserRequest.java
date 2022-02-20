package main.java.emlakburada.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String kullaniciTipi; // bireysel & kurumsal & yeniTip
    private String name;
    private String email;
}
