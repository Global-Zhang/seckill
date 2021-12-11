package org.example.seckill.controller;

import org.example.seckill.pojo.User;
import org.example.seckill.service.IGoodsService;
import org.example.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

/**
 * 商品
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model,User user,@PathVariable("goodsId") Long goodsId){
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods",goods);
        Date endDate = goods.getEndDate();
        Date startDate = goods.getStartDate();
        Date nowDate = new Date();
        //秒杀状态
        int seckillStatus = 0;
        //剩余开始时间
        int remainSeconds = 0;
        //秒杀未开始
        if (nowDate.before(startDate)){
            remainSeconds = (int)((startDate.getTime() - nowDate.getTime())/1000);
        }
        //秒杀已结束
        else if (nowDate.after(endDate)){
            seckillStatus = 2;
            remainSeconds = -1;
        }
        //秒杀中
        else {
            seckillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("secKillStatus",seckillStatus);
        model.addAttribute("remainSeconds",remainSeconds);
        return "goodsDetail";
    }

    @RequestMapping("toList")
    public String toLogin(Model model,User user){
       model.addAttribute("user",user);
       model.addAttribute("goodsList",goodsService.findGoodsVo());
       return "goodsList";
    }

    /**
    @Autowired
    private IUserService userService;

    @RequestMapping("/toList")
    //public String toLogin(HttpSession session, Model model, @CookieValue("userTicket") String ticket) {
    public String toLogin(HttpServletRequest request, HttpServletResponse response,Model model,@CookieValue("userTicket")String ticket){
        if (StringUtils.isEmpty(ticket)) {
            return "login";
        }
        //User user = (User) session.getAttribute(ticket);
        User user = userService.getByUserTicket(ticket,request,response);
        if (null == user) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }
    */
}
