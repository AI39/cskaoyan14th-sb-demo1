package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Issue;
import com.cskaoyan14th.mapper.IssueMapper;
import com.cskaoyan14th.service.IssueService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:29
 */
@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    IssueMapper issueMapper;
    @Override
    public Page<Issue> queryIssueList(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Issue> issueList1 = issueMapper.queryIssueList();
        PageInfo<Issue> pageInfo = new PageInfo<>(issueList1);
        Page<Issue> issueList = new Page<>(pageInfo.getList(), pageInfo.getTotal());

        return issueList;
    }
}
