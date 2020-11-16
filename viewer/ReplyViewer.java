package viewer;

import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import controller.ReplyController;
import day07.Board;
import dto.BoardDTO;
import dto.ReplyDTO;
import util.ScannerUtil;

public class ReplyViewer {
	private ReplyController controller;
	private Scanner scanner;
	private int id =1;
	
	public ReplyViewer() {
		controller = new ReplyController();
		scanner = new Scanner(System.in);
		
	}
	
	// 해당 글의 댓글을 출력하는 메소드
	public void printAll(int boardId, UserViewer userViewer) {
		ArrayList<ReplyDTO> list = controller.selectByBoardId(boardId);
		for(ReplyDTO r : list ) {
			SimpleDateFormat sdf =new SimpleDateFormat("y-M-d H:d:s");
			
			
			System.out.printf("%s\t%s\n",userViewer.selectNickname(r.getWriterdId())
					,sdf.format(r.getWrittenDate().getTime()));
			System.out.println("댓글내용: "+r.getContent());
			System.out.println("---------------------------");
			
			
		}
	}
	
	// 해당 글의 댓글을 작성하는 메소드
	public void writeReply(int boardId, int writerdId) {
		ReplyDTO r = new ReplyDTO();
		r.setId(id++);
		r.setWrittenDate(Calendar.getInstance());
		r.setBoardId(boardId);
		r.setWriterdId(writerdId);
		System.out.print("댓글내용: ");
		r.setContent(ScannerUtil.nextLine(scanner));
		
	    controller.insert(r);
		
		
	}
	
	
}
















