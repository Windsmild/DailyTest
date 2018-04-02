package entity;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author Stephen Cai
 * @date 2018-01-31 17:39
 */
@Data
public class JosSKU {
    private Long wareId;
    private BigDecimal jdPrice;
    private Integer outerId;
    //private Integer status;
}
