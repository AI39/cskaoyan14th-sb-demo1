package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Grouponx;

import java.util.List;

public interface GrouponxMapper {
    List<Grouponx> selectGrouponxAll();

    List<Grouponx> selectGrouponxAllNotLimit();
}
