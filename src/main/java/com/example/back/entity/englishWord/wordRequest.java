package com.example.back.entity.englishWord;

//对应前端请求英语单词的请求体
public class wordRequest {
    private String name;
    private int lowBorder;
    private int upBorder;
    private int page;
    private String translation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLowBorder() {
        return lowBorder;
    }

    public void setLowBorder(int lowBorder) {
        this.lowBorder = lowBorder;
    }

    public int getUpBorder() {
        return upBorder;
    }

    public void setUpBorder(int upBorder) {
        this.upBorder = upBorder;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
