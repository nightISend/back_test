package com.example.back.mapper;

import com.example.back.entity.Record12345Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Record12345Mapper {
    @Select("select * from sum_12345_wash limit 2")
    public List<Record12345Entity> getAll();

    public List<Record12345Entity> selectByConditions(@Param("condition") Record12345Entity condition);
}
