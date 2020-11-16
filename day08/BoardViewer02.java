package day08;
// 우리가 게시판에 글을 쓸때는
// 글 번호가 자동을 부여된다.
// 또한 우리가 글을 10개를 쓰고
// 도중에 하나를 지우더라도
// 새글을 쓰면 글 번호는 11부터 다시 부여된다!

import java.util.Scanner;

import day07.Board;
import util.ArrayUtil;
import util.ScannerUtil;



public class BoardViewer02 {
	private Scanner scanner;
	private Board[] boardArry;
    // 글 번호를 보관할 전역변수 id
	private int id = 1;
	public BoardViewer02() {
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
				System.out.println("제목: "+b.getTitle());
				System.out.println("번호: "+b.getId());
				System.out.println("작성자: "+b.getWriter());
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
		}
	
		private void deleteBoard(int index) {
			System.out.print("정말로 삭제 하시겟습니다? y/n");
			String agree = ScannerUtil.nextLine(scanner);
			if(agree.equals("y")) {
				boardArry = ArrayUtil.removeByIndex(boardArry, index);
			}
		}

}
