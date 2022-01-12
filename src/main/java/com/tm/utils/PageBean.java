package com.tm.utils;

import java.util.List;

/**
 * @author lichuan
 * @version 1.0
 * @description: TODO
 * @date 2021/7/7 13:41
 */
public class PageBean {

    //每页条数
    private Integer pageSize = 3;

    //当前页数
    private Integer pageNum = 1;

    //总页数
    private Integer pageTotal;

    //总条数
    private Integer total;

    //分页查询起始下标
    private Integer startIndex;

    //当前页数据
    private List list;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageIndex) {
        this.pageNum = pageIndex;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
        //计算总页数：总条数 % 每页条数 == 0 ? 总条数 / 每页条数 :  总条数 / 每页条数 + 1
        this.pageTotal = this.total % this.pageSize == 0 ? this.total / this.pageSize : this.total / this.pageSize + 1;
    }

    public Integer getStartIndex() {
        //计算起始下标：(页数-1)*条数
        return (pageNum-1) * pageSize;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }
}
