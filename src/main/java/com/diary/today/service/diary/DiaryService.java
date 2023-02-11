package com.diary.today.service.diary;

import com.diary.today.entity.Diary;
import com.diary.today.exception.ApiException;

import java.util.List;

public interface DiaryService {

    List<Diary> findAll(Diary diary) throws ApiException;

    Diary findOne(Diary diary) throws ApiException;

    void create(Diary diary) throws ApiException;

    void modify(Diary diary) throws ApiException;

    void remove(Diary diary) throws ApiException;

}
