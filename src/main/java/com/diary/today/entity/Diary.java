package com.diary.today.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary {

    private String id;
    private String title;
    private String content;
    private int viewCount;
    private int likeCount;
    private String writerId;
    private String createDate;
    private String updateDate;

}
