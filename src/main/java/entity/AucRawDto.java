package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AucRawDto {
    private String account_id;
    private int pcvr;
    private int conv_num;
    private int rank;

}
