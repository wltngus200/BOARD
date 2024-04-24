package com.green.board;

import com.green.board.model.BoardGetDetailRes;
import com.green.board.model.BoardGetRes;
import com.green.board.model.BoardPostReq;
import com.green.board.model.BoardPutReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
    public interface BoardMapper {//인터페이스 구현부가 없는 메소드를 가짐
    //BoardMapper과 만나서 DAO를 생성한다
    //DAO란 데이터베이스와 활동하는 애들. 데이터베이스에 명령을 하는 존재
    //서비스와 상속의 관계가 아니라 has a의 관계

        int postBoard(BoardPostReq p);
        //작성용(boardId, 시간은 자동 부여)
        //타이틀, 콘텐츠, 작성자 멤버필드를 가짐+게터세터 자동

        List<BoardGetRes> getBoardList();
        //출력용 게시글 번호, 제목, 작성자, 작성시간

        BoardGetDetailRes getBoardOne(long boardId);
        //1개를 자세히 보기 (위의 것에 내용까지 포함)

        int deleteBoard(int p);
        //삭제할 게시글의 번호

        int putBoard(BoardPutReq p);

        // insert, update, delete는 영향받은 행의 값을 가져오는 int
        // 파라미터로는 쿼리문을 만들 값을 넣어준다
        // select는 실제로 데이터를 가져와야 하기 때문에 데이터를 가져올 수 있는 애로
}
