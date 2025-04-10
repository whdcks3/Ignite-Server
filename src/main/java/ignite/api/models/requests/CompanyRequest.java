package ignite.api.models.requests;

import java.util.ArrayList;
import java.util.List;

import ignite.api.models.CompanyImage;
import ignite.api.models.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {

    private List<Category> categories = new ArrayList<>();
    private String name;
    private String phone;
    private String bankName;
    private String bankAccount;
    private String content;
    private List<CompanyImaageRequest> images = new ArrayList<>();
}
