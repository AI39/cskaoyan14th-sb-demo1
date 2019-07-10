package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Order;
import com.cskaoyan14th.service.OrderService;
import com.cskaoyan14th.util.UserTokenManager;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuechao Yang
 * @version 2019-07-09-14:36
 */
@RestController
@RequestMapping("/wx/order")
public class WxOrderController {
    @Autowired
    OrderService orderService;
//    @RequestMapping("list")
//    public ResponseMapVo orderList(int showType, int page, int size){
//        ResponseMapVo responseMapVo = new ResponseMapVo();
//        Map<String, Object> data = orderService.queryWxOrderList(showType, page, size);
//        if (data != null){
//            responseMapVo.setData(data);
//            responseMapVo.setErrno(0);
//            responseMapVo.setErrmsg("成功");
//        }else {
//            responseMapVo.setErrno(404);
//            responseMapVo.setErrmsg("失败");
//        }
//        return responseMapVo;
//    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Map<String, Object>> list(Integer showType, Integer page, Integer size, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseVo(-1, new HashMap<String, Object>(), "错误");
        }

        if (showType == null) {                                                //对showType输入为null做特殊处理，有时间建议优化这个处理
            showType = 0;
        }

        Map<String, Object> map = orderService.wxQueryOrderListByUserId(userId, showType, page, size);

        return new ResponseVo<>(0,  map, "成功");
    }

    @RequestMapping("detail")
    @ResponseBody
    public ResponseVo<Map<String, Object>> detail(Integer orderId) {
        Map<String, Object> map = new HashMap<>();

        map.put("orderInfo", orderService.queryWxOrderById(orderId));
        map.put("orderGoods", orderService.queryOrderGoodsById(orderId));
        System.out.println(map);
        return new ResponseVo<>(0,  map, "成功");
    }

    @RequestMapping("prepay")
    @ResponseBody
    public ResponseVo<Order> prepay(int OrderId){
        ResponseVo<Order> responseVo = new ResponseVo<>();
        responseVo.setErrno(724);
        responseVo.setErrmsg("订单不能支付");
        return responseVo;
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseVo<Order> delete(int orderId, HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseVo(-1, null, "错误");
        }
        ResponseVo<Order> responseVo = new ResponseVo<>();
        int delete = orderService.deleteList(orderId);
        if (delete != 0){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }else{
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }


}
