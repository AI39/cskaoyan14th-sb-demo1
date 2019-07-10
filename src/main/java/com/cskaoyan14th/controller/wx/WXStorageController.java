package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Storage;
import com.cskaoyan14th.oss.MyOssClient;
import com.cskaoyan14th.service.StorageService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("wx/storage")
public class WXStorageController {

    @Autowired
    MyOssClient myOssClient;

    @Autowired
    StorageService storageService;

    @RequestMapping("upload")
    @ResponseBody
    public ResponseVo<Storage> create(MultipartFile file) throws IOException {

        storageService.insertStorageAll(file);
        ResponseVo<Storage> responseVo = storageService.queryStorageAll(file);

        return responseVo;
    }
}
