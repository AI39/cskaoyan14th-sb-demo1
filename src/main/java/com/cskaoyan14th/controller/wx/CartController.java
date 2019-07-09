package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.bean.CartTotal;
import com.cskaoyan14th.service.CartService;
import com.cskaoyan14th.vo.ResponseVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wx/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("index")
    @ResponseBody
    public ResponseVo<Map<String,Object>> index(HttpServletRequest request){
        String token = request.getHeader("X-Litemall-Token");
        //Integer uid = UserTokenManager.getUserId(token);
        ResponseVo<Map<String,Object>> responseVo = new ResponseVo<>();
        List<Cart> cartList = cartService.getCartList(1);
        CartTotal cartTotal = CartTotal.calculate(cartList);
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("cartList",cartList);
        objectMap.put("cartTotal",cartTotal);

        responseVo.setData(objectMap);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }
}
