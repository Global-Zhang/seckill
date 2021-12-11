package org.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.seckill.pojo.User;
import org.example.seckill.vo.LoginVo;
import org.example.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUserService extends IService<User> {
    /**
     * 登录
     * @param loginVo
     * @return
     */
    RespBean login(HttpServletRequest request, HttpServletResponse response, LoginVo loginVo);

    User getByUserTicket(String userTicket, HttpServletRequest request, HttpServletResponse response);
}
