package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Ad;
import com.cskaoyan14th.bean.AdExample;
import com.cskaoyan14th.mapper.AdMapper;
import com.cskaoyan14th.service.AdService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdMapper adMapper;

    @Override
    public ResponseVo<Page> getAdList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        AdExample adExample = new AdExample();
        AdExample.Criteria criteria = adExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Ad> ads = adMapper.selectByExample(adExample);
        PageInfo<Ad> pageInfo=new PageInfo<>(ads);
        Page<Ad> adPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,adPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Ad> editAd(Ad ad) {
        ResponseVo<Ad> adResponseVo = new ResponseVo<>();
        int i = adMapper.updateByPrimaryKey(ad);
        if(i==1){
            adResponseVo.setErrno(0);
            adResponseVo.setErrmsg("成功");
            adResponseVo.setData(ad);
        }
        return adResponseVo;
    }

    @Override
    public ResponseVo<String> deleteAd(Ad ad) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        int i = adMapper.deleteByPrimaryKey(ad.getId());
        if(i==1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

    @Override
    public ResponseVo<Ad> insertAd(Ad ad) {
        ResponseVo<Ad> responseVo = new ResponseVo<>();
        int insert = adMapper.insert(ad);
        if(insert==1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(ad);
        }
        return responseVo;
    }
}
