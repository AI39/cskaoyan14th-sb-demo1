package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Storage;
import com.cskaoyan14th.mapper.StorageMapper;
import com.cskaoyan14th.oss.MyOssClient;
import com.cskaoyan14th.service.StorageService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @Override
    public ResponseVo<Page<Storage>> queryStorage(int page, int limit, String name, String key) {
        ResponseVo<Page<Storage>> storageResponseVo = new ResponseVo<>();

        PageHelper.startPage(page,limit);
        //查询
        List<Storage> storageList = storageMapper.queryStorage(name,key);

        PageInfo pageInfo = new PageInfo(storageList);

        Page<Storage> storagePage = new Page<Storage>(pageInfo.getList(), pageInfo.getTotal());
        //判断 是否为空
        if(storageList != null){
            storageResponseVo.setErrno(0);
            storageResponseVo.setErrmsg("成功");
            storageResponseVo.setData(storagePage);
        }
        return storageResponseVo;
    }

    @Override
    public ResponseVo<Storage> updateStorage(Storage storage) {
        ResponseVo<Storage> storageResponseVo = new ResponseVo<>();
        int i = storageMapper.updateStorageByKey(storage);
        if (storage != null){
            storageResponseVo.setErrmsg("ok");
            storageResponseVo.setErrno(0);
            return storageResponseVo;
        }
        return storageResponseVo;
    }

    @Override
    public ResponseVo<Storage> deleteStorage(Storage storage) {
        ResponseVo<Storage> storageResponseVo = new ResponseVo<>();
        int i = storageMapper.deleteStorageByKey(storage);
        if (storage != null){
            storageResponseVo.setErrmsg("ok");
            storageResponseVo.setErrno(0);
            return storageResponseVo;
        }
        return storageResponseVo;

    }
}
