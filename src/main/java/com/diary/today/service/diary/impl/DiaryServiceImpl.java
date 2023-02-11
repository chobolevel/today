package com.diary.today.service.diary.impl;

import com.diary.today.entity.Diary;
import com.diary.today.enums.common.ApiExceptionType;
import com.diary.today.exception.ApiException;
import com.diary.today.mapper.diary.DiaryMapper;
import com.diary.today.service.diary.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

    private final DiaryMapper diaryMapper;

    @Override
    public List<Diary> findAll(Diary diary) throws ApiException {
        return diaryMapper.search(diary);
    }

    @Override
    public Diary findOne(Diary diary) throws ApiException {
        checkId(diary);
        return diaryMapper.fetch(diary);
    }

    @Override
    public void create(Diary diary) throws ApiException {
        if(diary.getTitle() == null || diary.getTitle().trim().equals("")) {
            throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "title", "String");
        }
        else if(diary.getContent() == null || diary.getContent().trim().equals("")) {
            throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "content", "String");
        }
        diary.setId(UUID.randomUUID().toString());
        diaryMapper.insert(diary);
    }

    @Override
    public void modify(Diary diary) throws ApiException {
        checkId(diary);
        diaryMapper.update(diary);
    }

    @Override
    public void remove(Diary diary) throws ApiException {
        checkId(diary);
        diaryMapper.delete(diary);
    }

    private void checkId(Diary diary) throws ApiException {
        if(diary.getId() == null || diary.getId().trim().equals("")) {
            throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "id", "String");
        }
    }

}
