package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Storage;
import com.cskaoyan14th.oss.MyOssClient;
import com.cskaoyan14th.service.StorageService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("storage")
public class StorageController {
    @Autowired
    MyOssClient myOssClient;
    @Autowired
    StorageService storageService;
    @RequestMapping("create")
    @ResponseBody
    public ResponseVo<Storage> create(MultipartFile file) throws IOException {
        storageService.insertStorageAll(file);
        ResponseVo<Storage> responseVo = storageService.queryStorageAll(file);
        return responseVo;
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Page<Storage>> list(int page, int limit, String name, String key){
        ResponseVo<Page<Storage>> listResponseVo = storageService.queryStorage(page,limit,name,key);

        return listResponseVo;
    }

    @RequestMapping("update")
    @ResponseBody
    public ResponseVo<Storage> update(@RequestBody Storage storage){
        ResponseVo<Storage> storageResponseVo = storageService.updateStorage(storage);
        return storageResponseVo;
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseVo<Storage> delete(@RequestBody Storage storage){
        ResponseVo<Storage> storageResponseVo = storageService.deleteStorage(storage);
        return storageResponseVo;
    }
}
