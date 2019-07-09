package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.User;
import com.cskaoyan14th.service.UserService;
import com.cskaoyan14th.util.UserTokenManager;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.wrapper.UserInfo;
import com.cskaoyan14th.wrapper.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxUserController {
    @Autowired
    UserService userService;

    /*账号登录*/
    @RequestMapping("/auth/login")
    @ResponseBody
    public ResponseVo<Map<String, Object>> login(@RequestBody User user) {
        //*******************************
        //根据username和password查询user信息
        User activeUser = userService.getUser(user.getUsername(), user.getPassword());
        //*******************************

        if (activeUser == null) {
            return new ResponseVo(-1, null, "用户名或密码错误");
        }

        // userInfo
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(activeUser.getNickname());
        userInfo.setAvatarUrl(activeUser.getAvatar());

        //********************************
        //根据获得userid
        int userId = activeUser.getId();
        //********************************
        // token
        UserToken userToken = UserTokenManager.generateToken(userId);

        Map<String, Object> result = new HashMap<>();
        result.put("token", userToken.getToken());
        result.put("tokenExpire", userToken.getExpireTime().toString());
        result.put("userInfo", userInfo);

        return new ResponseVo(0, result, "成功");
    }

    /*账号退出*/
    @RequestMapping("auth/logout")
    @ResponseBody
    public ResponseVo<Object> logout(HttpServletRequest request) {
        //前端写了一个token放在请求头中
        //*************************
        //获得请求头
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseVo(-1, null, "错误");
        }
        //删除与本地维护用户token相关的数据
        UserTokenManager.removeToken(userId);
        return new ResponseVo(0, null, "成功");
    }

    /*微信登录，这里好像直接屏蔽了*/
    @RequestMapping("auth/login_by_weixin")
    @ResponseBody
    public ResponseVo<Object> logout() {
        return new ResponseVo(-1, null, "错误");
    }

    /*显示个人页面相关信息*/
    @RequestMapping("user/index")
    public ResponseVo<Map<String, Map<String, Object>>> index(HttpServletRequest request) {
        //前端写了一个token放在请求头中
        //*************************
        //获得请求头
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseVo(-1, null, "错误");
        }

        Map<String, Map<String, Object>> data = new HashMap<>();
        Map<String, Object> orderData = new HashMap<>();
        //***********************************
        //根据userId查询订单信息
        orderData.put("unpaid", userService.countByOrderStatus((short)101));
        orderData.put("unship", userService.countByOrderStatus((short)201));
        orderData.put("unrecv", userService.countByOrderStatus((short)301));
        orderData.put("uncomment", 0);                                         //uncomment先空一下

        data.put("order", orderData);
        //***********************************

        return new ResponseVo(0, data, "成功");
    }
}
