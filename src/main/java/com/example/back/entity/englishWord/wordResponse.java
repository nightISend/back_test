package com.example.back.entity.englishWord;

import java.util.List;

public class wordResponse {
    private boolean success;
    private String condition;
    private int totalPage;
    private List<word> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<word> getData() {
        return data;
    }

    public void setData(List<word> data) {
        this.data = data;
    }
}
