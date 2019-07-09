package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.service.AddressService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wx/address")
public class AddressController {

    @Autowired
    AddressService addressService;
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<List<Address>> list(){
        ResponseVo<List<Address>> responseVo = new ResponseVo<>();
        List<Address> list = addressService.getAddressList(1);
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
}
