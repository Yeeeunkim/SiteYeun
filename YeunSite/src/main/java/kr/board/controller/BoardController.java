package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {
	@Autowired
	BoardMapper boardMapper;
	
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	@RequestMapping("/boardList.do")
	public @ResponseBody List<Board> boardList(){ //@ResponseBody -> jackson-databind(객체를 -> JSON 데이터포맷으로 변환 ) 
		List<Board> list = boardMapper.getLists();
		return list; //JSON데이터 형식으로 변환(API)해서 리턴 
	}
	@RequestMapping("/boardInsert.do")
	public @ResponseBody void boardInsert(Board vo) {
		boardMapper.boardInsert(vo);
	}
	@RequestMapping("/boardDelete.do")
	public @ResponseBody void boardDelete(int idx) {
		boardMapper.boardDelete(idx);
	}
}
