package com.diary.today.mapper.diary;

import com.diary.today.entity.Diary;
import com.diary.today.exception.ApiException;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {

    List<Diary> search(Diary diary) throws ApiException;

    Diary fetch(Diary diary) throws ApiException;

    void insert(Diary diary) throws ApiException;

    void update(Diary diary) throws ApiException;

    void delete(Diary diary) throws ApiException;

}
