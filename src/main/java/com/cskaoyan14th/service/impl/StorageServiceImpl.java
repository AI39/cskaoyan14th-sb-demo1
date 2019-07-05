package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Storage;
import com.cskaoyan14th.mapper.StorageMapper;
import com.cskaoyan14th.oss.MyOssClient;
import com.cskaoyan14th.service.StorageService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageMapper storageMapper;
    @Autowired
    MyOssClient myOssClient;
    @Override
    public int insertStorageAll(MultipartFile myfile) {
        int i = 0;
        try {
            Storage storage = myOssClient.ossFileUpload(myfile);
            i = storageMapper.insertStorageAll(storage);
            return i;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public ResponseVo queryStorageAll(MultipartFile myfile) {
        ResponseVo<Storage> storageResponseVo = new ResponseVo<>();
        String originalFilename = myfile.getOriginalFilename();
        Storage storage = storageMapper.queryStorageAll(originalFilename);
        if (storage != null){
            storageResponseVo.setData(storage);
            storageResponseVo.setErrmsg("ok");
            storageResponseVo.setErrno(0);
            return storageResponseVo;
        }
        return null;
    }
}
