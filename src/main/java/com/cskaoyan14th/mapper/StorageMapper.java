package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Storage;
import com.cskaoyan14th.bean.StorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {

    int insertStorageAll(@Param("sto") Storage storage);

    Storage queryStorageAll(@Param("ori") String originalFilename);
}