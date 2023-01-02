package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@RequestMapping("/board")
@RestController // @ResponseBody(JSON)응답 
//Controller가 REST방식을 처리하기 위한 것임을 명시합니다.
public class BoardRestController {
	
	    @Autowired
	    BoardMapper boardMapper;
	
	    // @ResponseBody->jackson-databind(객체를->JSON 데이터포멧으로 변환)
		@GetMapping("/all")
		public List<Board> boardList(){
			List<Board> list=boardMapper.getLists();
			return list; // JSON 데이터 형식으로 변환(API)해서 리턴(응답)하겠다.
		}	
		//@RequestMapping("/boardInsert.do")
		@PostMapping("/new")
		public void boardInsert(Board vo) {
			boardMapper.boardInsert(vo); // 등록성공
		}
		@DeleteMapping("/{idx}")
		public void boardDelete(@PathVariable("idx") int idx) {
			boardMapper.boardDelete(idx);
		}	
		@PutMapping("/update")
		public void boardUpdate(@RequestBody Board vo) { //@RequestBody :: JSON 데이터를 원하는 타입으로 바인딩 처리
			boardMapper.boardUpdate(vo);
		}
		@GetMapping("/{idx}")
		public Board boardContent(@PathVariable("idx") int idx) { //@PathVariable :: URL 경로에 있는 값을 파라메터로 추출하려고 할때 사용
			Board vo=boardMapper.boardContent(idx);
			return vo; // vo->JSON
		}
		@PutMapping("/count/{idx}")
		public Board boardCount(@PathVariable("idx") int idx) {
			boardMapper.boardCount(idx);
			Board vo=boardMapper.boardContent(idx);
			return vo;
		}
}