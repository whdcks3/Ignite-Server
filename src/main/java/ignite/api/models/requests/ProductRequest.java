package ignite.api.models.requests;

import java.util.ArrayList;
import java.util.List;

import ignite.api.models.ProductSchedule;
import ignite.api.models.Dto.ProductScheduleDto;
import ignite.api.models.enums.Category;
import ignite.api.models.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private ProductType productType;
    private List<Category> categories = new ArrayList<>();
    private String name;
    private List<ProductScheduleDto> schedules = new ArrayList<>();
    private int regularPrice;
    private int discountPrice;
    private String content;

}
