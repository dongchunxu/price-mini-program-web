package com.dianwoyin.price.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel(
    description = "分页结果"
)
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("当前页")
    @JsonIgnore
    private int pageNum;
    @ApiModelProperty("每页的数量")
    @JsonIgnore
    private int pageSize;
    @ApiModelProperty("业务数据")
    private List<T> results;
    @ApiModelProperty("总条数")
    private long total;
    @ApiModelProperty("总页数")
    private int pageCount;
    @ApiModelProperty("当前数据index")
    private int currentIndex;
    @ApiModelProperty("是否还有数据")
    private boolean hasNext;

    public PageResult() {
        this.results = new ArrayList();
        this.hasNext = false;
    }

    public PageResult(List<T> list, int pageNum, int pageSize, long total) {
        this(list, pageNum, pageSize, total, 0);
    }

    public PageResult(List<T> list, int pageNum, int pageSize, long total, int currentIndex) {
        this.results = new ArrayList();
        this.hasNext = false;
        this.results = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.currentIndex = currentIndex;
        this.total = total;
        this.calculatePageCount(pageSize, total);
        this.judgePageBoundary();
    }

    public static <T> PageResult<T> of(List<T> list, int pageNum, int pageSize, long total) {
        return new PageResult(list, pageNum, pageSize, total);
    }

    public static <T> PageResult<T> of(List<T> list, int pageNum, int pageSize, long total, int currentIndex) {
        return new PageResult(list, pageNum, pageSize, total, currentIndex);
    }

    private void calculatePageCount(int pageSize, long total) {
        if (total == -1L) {
            this.pageCount = 1;
        } else {
            if (pageSize > 0) {
                this.pageCount = (int)(total / (long)pageSize + (long)(total % (long)pageSize == 0L ? 0 : 1));
            } else {
                this.pageCount = 0;
            }

        }
    }

    private void judgePageBoundary() {
        this.hasNext = this.pageNum < this.pageCount;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public List<T> getResults() {
        return this.results;
    }

    public long getTotal() {
        return this.total;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public boolean isHasNext() {
        return this.hasNext;
    }

    public void setPageNum(final int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setResults(final List<T> results) {
        this.results = results;
    }

    public void setTotal(final long total) {
        this.total = total;
    }

    public void setPageCount(final int pageCount) {
        this.pageCount = pageCount;
    }

    public void setCurrentIndex(final int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void setHasNext(final boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String toString() {
        return "PageResult(pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ", results=" + this.getResults() + ", total=" + this.getTotal() + ", pageCount=" + this.getPageCount() + ", currentIndex=" + this.getCurrentIndex() + ", hasNext=" + this.isHasNext() + ")";
    }
}
