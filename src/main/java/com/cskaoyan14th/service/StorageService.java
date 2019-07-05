package com.cskaoyan14th.service;

import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    int insertStorageAll(MultipartFile myfile);

    ResponseVo queryStorageAll(MultipartFile myfile);

}
