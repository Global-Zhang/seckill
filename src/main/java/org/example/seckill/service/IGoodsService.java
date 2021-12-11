package org.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.seckill.pojo.Goods;
import org.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhoubin
 * @since 1.0.0
 */
public interface IGoodsService extends IService<Goods> {
    /**
     * 获取商品列表
     * @return
     */
    List<GoodsVo> findGoodsVo();
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
