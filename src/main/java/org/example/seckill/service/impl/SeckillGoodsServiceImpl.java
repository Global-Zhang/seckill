package org.example.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.seckill.mapper.SeckillGoodsMapper;
import org.example.seckill.pojo.SeckillGoods;
import org.example.seckill.service.ISeckillGoodsService;
import org.springframework.stereotype.Service;

@Service
public class SeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsMapper, SeckillGoods> implements ISeckillGoodsService  {
}
