package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Storage;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    int insertStorageAll(MultipartFile myfile);

    ResponseVo queryStorageAll(MultipartFile myfile);

    ResponseVo<Page<Storage>> queryStorage(int page, int limit, String name, String key);

    ResponseVo<Storage> updateStorage(Storage storage);

    ResponseVo<Storage> deleteStorage(Storage storage);
}
