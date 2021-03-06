package org.example.seckill.controller;

import org.example.seckill.pojo.Order;
import org.example.seckill.pojo.User;
import org.example.seckill.service.IGoodsService;
import org.example.seckill.service.IOrderService;
import org.example.seckill.service.ISeckillOrderService;
import org.example.seckill.vo.GoodsVo;
import org.example.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seckill")
public class SeckillController{
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, User user, Long goodsId){
        if (user == null){
            return "login";
        }
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);

        //判断库存
        if (goods.getStockCount() < 1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMsg());
            return "seckillFail";
        }
        Order order = orderService.seckill(user,goods);

        model.addAttribute("order",order);
        model.addAttribute("goods",goods);
        return "orderDetail";
    }
}
