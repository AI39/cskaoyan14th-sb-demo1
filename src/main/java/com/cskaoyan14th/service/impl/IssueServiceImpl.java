package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Issue;
import com.cskaoyan14th.mapper.IssueMapper;
import com.cskaoyan14th.service.IssueService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        return null;
    }

    @Override
    public Page<Issue> queryIssueList(int page, int limit, String question, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Issue> issueList1 = issueMapper.queryIssueList(question, sort, order);
        PageInfo<Issue> pageInfo = new PageInfo<>(issueList1);
        Page<Issue> issueList = new Page<>(pageInfo.getList(), pageInfo.getTotal());

        return issueList;
    }

    @Override
    public Issue updateIssue(Issue issue) {
        issueMapper.updateByPrimaryKey(issue);                                                                      //先进行修改
        Issue issue1 = issueMapper.selectById(issue.getId());                                                       //再获取修改以后的issue
        return issue1;
    }

    @Override
    public int deleteIssue(Issue issue) {
        int delete = issueMapper.deleteById(issue.getId());
        return delete;
    }

    @Override
    public Issue createIssue(Issue issue) {
        long l = System.currentTimeMillis();
        Date date = new Date(l);

        issue.setAddTime(date);
        issue.setUpdateTime(date);
        issueMapper.inserts(issue);
        Issue issue1 = issueMapper.selectByPrimaryKey(issue.getId());
        return issue1;
    }
}
