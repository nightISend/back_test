package com.example.back.entity.englishWord;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//数据库单词表实体
@Entity
@Table(name = "english_words")
public class word {

    @Id
    private String name;
    private int count;
    private String translation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "word{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", translation='" + translation + '\'' +
                '}';
    }
}
