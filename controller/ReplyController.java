package controller;

import java.util.ArrayList;

import dto.ReplyDTO;

public class ReplyController {
	private ArrayList<ReplyDTO> list;
	public ReplyController() {
		list = new ArrayList<>();
		}
	
	// 해당글의 댓글을 불러오는 selectByBoardId()
	public ArrayList<ReplyDTO> selectByBoardId(int BoardId) {
		ArrayList<ReplyDTO> temp = new ArrayList<>();
		for(ReplyDTO r: list ) {
			if(r.getBoardId() == BoardId) {
				temp.add(r);
			}			
		}		
		return temp;		
	}
	
	// 댓글을 list insert
	public void insert(ReplyDTO r) {
		list.add(r);
		
	}
	
	
	
}


















