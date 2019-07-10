package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Ad;
import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.service.AddressService;
import com.cskaoyan14th.util.UserTokenManager;
import com.cskaoyan14th.vo.ResponseVo;
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
@RequestMapping("wx/address")
public class AddressController {

    @Autowired
    AddressService addressService;
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<List<Address>> list(HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseVo(-1, new HashMap<String, Object>(), "错误");
        }

        ResponseVo<List<Address>> responseVo = new ResponseVo<>();
        List<Address> list = addressService.getAddressList(userId);
        responseVo.setErrmsg("OK");
        responseVo.setErrno(0);
        responseVo.setData(list);
        return responseVo;
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseVo delete(@RequestBody Map<String,Integer> map){
        ResponseVo responseVo = new ResponseVo<>();
        int delete = addressService.deleteAddressById(map.get("id"));
        if (delete == 1){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(-1);
        }
        return responseVo;
    }

    @RequestMapping("detail")
    @ResponseBody
    public ResponseVo<Map<String, Object>> detail(Integer id) {
        Address address = addressService.getAddressById(id);
        /*这里封装数据的方法很二。。。没办法，时间紧迫*/
        Map<String, Object> map = new HashMap<>();
        map.put("address", address.getAddress());
        map.put("areaId", address.getAreaId());
        map.put("areaName", address.getArea());
        map.put("cityId", address.getCityId());
        map.put("cityName", address.getCity());
        map.put("id", address.getId());
        map.put("isDefault", address.getIsDefault());
        map.put("mobile", address.getMobile());
        map.put("name", address.getName());
        map.put("provinceId", address.getProvinceId());
        map.put("provinceName", address.getProvince());
        return new ResponseVo(0, map, "成功");
    }

    @RequestMapping("save")
    @ResponseBody
    public ResponseVo<Object> detail(@RequestBody Address address) {
        int i = addressService.updateAddress(address);
        /*这里省略了一些字段的更改。。。没办法，时间紧迫*/
        if (i == 1){
            return new ResponseVo(0, 17, "成功");
        }else {
            return new ResponseVo(-1, null, "失败");
        }
    }
}
