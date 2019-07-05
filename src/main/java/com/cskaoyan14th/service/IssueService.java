package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Issue;
import com.cskaoyan14th.vo.Page;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:28
 */
public interface IssueService {
    Page<Issue> queryIssueList(int page, int limit);                                                                //回显数据

    Page<Issue> queryIssueList(int page, int limit, String question, String sort, String order);

    Issue updateIssue(Issue issue);                                                                                 //编辑

    int deleteIssue(Issue issue);                                                                                   //删除

    Issue createIssue(Issue issue);                                                                                 //添加
}
