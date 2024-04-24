package com.green.board;

import com.green.board.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController //데이터를 주는 것이 목적 <-> controller는 화면을 출력
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController{
    private final BoardService service;

    @PostMapping
    //postman에서 send했을 때 값을 받아 데이터베이스에 넣음
    public int postBoard(@RequestBody BoardPostReq p){
        //데이터가 실려올 때 받는 법 json이면 @requestBody를 필수적으로
        System.out.println(p);
        service.postBoard(p);
        return 1;
    }
    @DeleteMapping
    public int deleteBoard(@RequestParam(name="board_id") int boardId){
        return service.deleteBoard(boardId);
    }//rest controller 데이터응답
    //쿼리스트링으로 데이터를 받겠다.
    //url대문자 안 쓰지만 자바는 써야하기 때문에 name기능을 사용

    @GetMapping
    public List<BoardGetRes> getBoardList(){
        return service.getBoardList();
    }

    @GetMapping("/{boardId}")
    // /가 생략되지만 있는 상태
    //오버라이딩과는 다르지만 담당자가 역할을 나누기 위한 차별점을 적어줌 /숫자로 URL에 표현
    public BoardGetDetailRes getBoardOne(@PathVariable long boardId){
        return service.getBoardOne(boardId);
    }

    @PutMapping
    //JSON으로 넘어오는 경우 @RequestBody
    public int putBoard(@RequestBody BoardPutReq p){
        //나중엔 리턴타입이 인트가 아님!
        return service.putBoard(p);
    }
}
/*
build.gradle: 외부에서 라이브러리 가져올 때, 가져오고 값까지 넣어줌
git이그노얼? 깃에 넣고싶지 않은 것
리소스는 자바파일 제외 모든 파일

[application.properties]
어플리케이션-드라이버: 데이터 접속정보
마이바티스 속성 =라이브러리에게 여기 저장되어있다고 알려줌
폴더가 몇개든 어떤이름이든 xml을 니가 관리해

보드 매퍼= 네임스페이스에서 저장되어있는 루트

보드 매퍼 이름의 자바파일과 xml 두개가 매칭이 되어 DAO생성
-connection 고속도로를 만들었다 안 쓴다고 부수고 하는느낌 유지도 닫는것도 리소스 많이 먹음
-3개정도 만들어놓고 고객이 찾으면 하나씩 주다가 없으면 대기시키고 반납과 동시에 전달 이런 역할을 하는것 커넥션풀
쿼리문과 ??? 만 적어도 생성 포스트보드가 임플리먼츠
#{}에 들어갈 값은 보드 포스트 리퀘스트의 멤버필드 값
@세터 게터를 자동 생성

executeUpdate를 호출함으로인해 정수값 리턴

매퍼 에노테이션이 DAO를 만들고 빈등록 까지 해준다.
-빈등록이란?? 스프링 컨테이너에게 객체화를 요청하는 것
-restcontroller 빈등록하고 넌 컨트롤러라는 역할지정까지 싱글톤으로 객체생성 이 명령어가 있으면 객체생성하고 스프링이 주소값을 가짐
url매핑을 할 수 있는게 컨트롤러의 역할 (즉 빈등록이란 스프링 컨테이너에게 객체화를 위임) 객체화는 스프링이 함+그 주소값 DI

@서비스도 빈등록을 함 서비스는 로직담당
postmapping 부장= 일을 시키기만 함(컨트롤 역할)
@requiredArgsconstructor과 BoardMapper만 적으면 DAO생성
    ㄴ롬복에서 제공하는 에노테이션: 파이널만 넣어줌
    ㄴ얘를 적으면 파이널 붙은 애들 생성자로 만들어!라는 의미
    ㄴ빈등록을 한 애의 주소값을 받고싶으면 사용

restcontroller 와 controller의 차이
웹서버는 크게 2가지 할수 있다 1. 화면을 보여주기 2. 요청에 따라 데이터를 주는 것이 목적
rest : 데이터를 주는 것이 목적->우리의 목적(프론트에게 주는 것)
그냥 : 화면을 주는 것이 목적
 컨트롤러가 가져오는 건 스트링=파일명
 */