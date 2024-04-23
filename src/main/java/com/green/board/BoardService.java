package com.green.board;

import com.green.board.model.BoardGetDetailRes;
import com.green.board.model.BoardGetRes;
import com.green.board.model.BoardPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//빈등록을 담당하는 역할(빈등록:스프링 컨테이너에게 객체화 요청)
@RequiredArgsConstructor

public class BoardService {
    private final BoardMapper mapper;

    public int postBoard(BoardPostReq p){
        System.out.println("BoardService - postBoard");
        return mapper.postBoard(p);
    }
    public int deleteBoard(int boardId){
        return mapper.deleteBoard(boardId);
    }
    public List<BoardGetRes> getBoardList(){
        return mapper.getBoardList();
    }

    public BoardGetDetailRes getBoardOne(long boardId){
        return mapper.getBoardOne(boardId);
    }
}
