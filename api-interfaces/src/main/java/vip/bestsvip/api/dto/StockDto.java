package vip.bestsvip.api.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockDto implements Serializable {
    private Long id;
    private String name;
    private Long amount;
}
