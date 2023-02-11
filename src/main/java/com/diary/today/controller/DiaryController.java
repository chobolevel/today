package com.diary.today.controller;

import com.diary.today.entity.Diary;
import com.diary.today.exception.ApiException;
import com.diary.today.service.diary.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("diary")
public class DiaryController {

    private final DiaryService diaryService;

    @GetMapping("list")
    public ResponseEntity<?> search() throws ApiException {
        List<Diary> list = diaryService.findAll(Diary.builder().build());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> fetchDiary(@PathVariable("id") String id) throws ApiException {
        Diary fetch = diaryService.findOne(Diary.builder().id(id).build());
        return new ResponseEntity<>(fetch, HttpStatus.OK);
    }

    @PostMapping("write")
    public ResponseEntity<?> writeDiary(@RequestBody Diary diary) throws ApiException {
        diaryService.create(diary);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("modify")
    public ResponseEntity<?> modifyDiary(@RequestBody Diary diary) throws ApiException {
        diaryService.modify(diary);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> removeDiary(@PathVariable("id") String id) throws ApiException {
        diaryService.remove(Diary.builder().id(id).build());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
