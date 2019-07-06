package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Storage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StorageMapper {

    int insertStorageAll(@Param("sto") Storage storage);

    Storage queryStorageAll(@Param("ori") String originalFilename);

    List<Storage> queryStorage(@Param("name")String name, @Param("key") String key);

    int updateStorageByKey(@Param("sto")Storage storage);

    int deleteStorageByKey(@Param("sto")Storage storage);
}