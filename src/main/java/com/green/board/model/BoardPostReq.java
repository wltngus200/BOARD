package com.green.board.model;

import lombok.*;

@Setter
@Getter
@ToString //에노테이션 자동적으로 게터와 세터를 넣어줌
public class BoardPostReq {
    private String title;
    private String contents;
    private String writer;
}
