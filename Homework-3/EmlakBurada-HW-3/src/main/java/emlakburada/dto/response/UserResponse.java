package main.java.emlakburada.dto.response;

import emlakburada.model.Advert;
import emlakburada.model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private int id;
    private String kullaniciTipi; // bireysel & kurumsal & yeniTip
    private String name;
    private String email;
    private String photo;
    private String bio;
    private Set<Advert> favoriIlanlar = new HashSet<>();
    private List<Advert> yayinladigiIlanlar = new ArrayList<>();
    private List<Message> mesajKutusu;
}
