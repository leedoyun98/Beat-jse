package day08;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
// 글을 수정할때는
import day07.Board;
import util.ArrayUtil;
import util.ScannerUtil;

public class BoardViewer03 {
	private Scanner scanner;
	private Board[] boardArry;
    // 글 번호를 보관할 전역변수 id
	private int id = 1;
	public BoardViewer03() {
		scanner = new Scanner(System.in);
		boardArry = new Board[0];
		
	}


	public void showMenu() {
		while (true) {
			System.out.println("게시판 관리 프로그램");
			String message = "1. 새글 쓰기 2. 목록 보기 3. 종료 ";
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
			if (userChoice == 1) {

				addBoard();
			} else if (userChoice == 2) {
	
				selectAll();
			} else if (userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}

		}
	}


	private void addBoard() {

		Board b = new Board();

		System.out.print("제목: ");
		b.setTitle(ScannerUtil.nextLine(scanner));
//		System.out.print("번호: ");
		b.setId(id++);
		System.out.print("작성자: ");
		b.setWriter(ScannerUtil.nextLine(scanner));
		System.out.print("내용: ");
		b.setContent(ScannerUtil.nextLine(scanner));
		
		b.setWrittenDate(Calendar.getInstance());
		b.setUpdateDate(Calendar.getInstance());

		boardArry = ArrayUtil.add(boardArry, b);

	}

	private void selectAll() {

		if(boardArry.length == 0) {
			System.out.println("아직 작성된 게시글이 없습니다.");
		}else {
			for(int i = boardArry.length-1; i>=0;i--) {
				System.out.printf("%d %s\n",i+1,boardArry[i].getTitle());
			}

			String message = "상세보기 할 글 번호를 선택해 주세요(0은 뒤로가기) \n >";
			int userChoice = ScannerUtil.nextInt(scanner, message,0, boardArry.length)-1;
			if(userChoice != -1) {

				selectOne(userChoice);
			}
		}
	}

		private void selectOne(int index) {
			
			
			Board b = boardArry[index];
			SimpleDateFormat sdf = new SimpleDateFormat("yy년 M월 d일 H시 m분 s초");
			System.out.println("제목: "+b.getTitle());
				System.out.println("번호: "+b.getId());
				System.out.println("작성자: "+b.getWriter());
				System.out.println("작성일: "+sdf.format(b.getWrittenDate().getTime()));
				System.out.println("수정일: "+sdf.format(b.getUpdateDate().getTime()));
				System.out.println("---------------------");
				System.out.println(b.getContent());

				String message =" 1. 수정  2. 삭제 3. 뒤로가기 \n >";
				int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
				if(userChoice == 1) {
					updateBoard(index);
					selectOne(index);
				}else if(userChoice == 2) {
					deleteBoard(index);
					selectAll();
				}else if(userChoice == 3) {
					selectAll();
				}
				
			
			
		}

		private void updateBoard(int index) {
			System.out.print("제목: ");
			boardArry[index].setTitle(ScannerUtil.nextLine(scanner));
			
			System.out.print("내용: ");
			boardArry[index].setContent(ScannerUtil.nextLine(scanner));
			
			boardArry[index].setUpdateDate(Calendar.getInstance());
		}
	
		private void deleteBoard(int index) {
			System.out.print("정말로 삭제 하시겟습니다? y/n");
			String agree = ScannerUtil.nextLine(scanner);
			if(agree.equals("y")) {
				boardArry = ArrayUtil.removeByIndex(boardArry, index);
			}
		}

}
