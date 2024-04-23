package com.green.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//리스트를 불러오기 위해 그걸 담아줄 애를 만듦
@Setter
@Getter
public class BoardGetDetailRes {
    private long boardId;
    private String title;
    private String contents;
    private String writer;
    private String createdAt;
}
