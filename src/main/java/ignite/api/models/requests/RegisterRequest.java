package ignite.api.models.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import ignite.api.models.enums.SocialType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String image;
    private String name;
    private String phone;
    private List<Category> categories = new ArrayList<>();

    private String email;
    private SocialType socialType;

}
