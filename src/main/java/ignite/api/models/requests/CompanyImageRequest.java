package ignite.api.models.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanyImageRequest {
    private String imageUrl;
    private boolean isMain;
}
