package com.green.board.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardPutReq {
    private long boardId;
    private String title;
    private String contents;
    private long writerId;
}
