package javaWeb.shop.entity;

import java.util.List;

/**
 * 分页javaBean对象
 */
public class PageBean<T> {
    private Integer pageNo;     //当前页
    private Integer pageSize;   //每页显示的记录数
    private Integer totalRecord;//总记录数
    private Integer totalPageNo;//总页数
    private Integer begin;      //开始位置
    private List<T> list;       //每页数据集合

    public PageBean() {
    }

    public PageBean(Integer pageNo, Integer pageSize, Integer totalRecord, Integer totalPageNo, Integer begin, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPageNo = totalPageNo;
        this.begin = begin;
        this.list = list;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPageNo() {
        return totalPageNo;
    }

    public void setTotalPageNo(Integer totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
