package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Feedback;
import com.cskaoyan14th.service.FeedbackService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/feedback")
public class WxFeedbackController {

    @Autowired
    FeedbackService feedbackService;


    @RequestMapping("/submit")

    public ResponseVo add(@RequestBody Feedback feedback){

        ResponseVo<Object> objectResponseVo = new ResponseVo<>();

        int i = feedbackService.insertSelective(feedback);

        if(i==1){

            objectResponseVo.setErrmsg("成功");
            objectResponseVo.setErrno(0);

            //"errno":0,"errmsg":"成功"
        }

        return objectResponseVo;

    }

}
