package org.example.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.seckill.pojo.Goods;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


/* 商品返回对象
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo extends Goods {
    private BigDecimal seckillPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}



