package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Issue;
import com.cskaoyan14th.vo.Page;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:28
 */
public interface IssueService {
    Page<Issue> queryIssueList(int page, int limit);
}
