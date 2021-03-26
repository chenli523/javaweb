package com.atguigu.bean;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    public static final int PAGE_SIZE = 10;
    private static final long serialVersionUID = 3637096835003671877L;
    private int pageNo;
    private int totalPageNo;
    private int totalRecord;
//    private static final int PAGE_SIZE = 10;
    private List<T> list;

    public Page() {
    }

    public Page(int pageNo, int totalPageNo, int totalRecord, List<T> list) {
        this.pageNo = pageNo;
        this.totalPageNo = totalPageNo;
        this.totalRecord = totalRecord;
        this.list = list;
    }

    public int getPageNo() {
        if (pageNo <= 1) {
             return 1;
        } else if (pageNo > getTotalPageNo()) {
             return getTotalPageNo();
        }
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
//        if (pageNo <= 1) {
//            this.pageNo = 1;
//        } else if (pageNo > getTotalPageNo()) {
//            this.pageNo = getTotalPageNo();
//        } else {
            this.pageNo = pageNo;
//        }
    }

    public int getTotalPageNo() {
        return (int) Math.ceil(totalRecord/(double)PAGE_SIZE);
    }

    public void setTotalPageNo(int totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", totalPageNo=" + totalPageNo +
                ", totalRecord=" + totalRecord +
                ", list=" + list +
                '}';
    }
}
