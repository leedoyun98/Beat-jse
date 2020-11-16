package day07;

import java.util.Scanner;

import util.ScannerUtil;

public class Bord11 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	menu(scanner);
	scanner.close();
	}
	private static void menu(Scanner scanner){
		Ard[] ardArray = new Ard[0];
		while (true) {
			System.out.println("         게시판                 ");
			System.out.println("1. 글쓰기 2. 목록보기 3. 종료");

			System.out.println("------------------------");
			int userChoice = ScannerUtil.nextInt(scanner, "> ", 1, 3);
			if (userChoice == 1) {
				ardArray = insert(scanner, ardArray);

			} else if (userChoice == 2) {
				ardArray = printAll(scanner, ardArray);

			} else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}
		
	}
	private static Ard[] insert(Scanner scanner, Ard[] ardArray) {

			Ard s = new Ard();

			System.out.print("게시판 번호: ");
			s.id = scanner.nextInt();

			System.out.print("작성자: ");
			s.name = ScannerUtil.nextLine(scanner);
			System.out.print("제목: ");
			s.read = ScannerUtil.nextLine(scanner);
			System.out.print("글 내용: ");
			s.write = ScannerUtil.nextLine(scanner);

		
			
			ardArray = Array.add(ardArray, s);

	

		return ardArray;
	}
	private static Ard[] printAll(Scanner scanner, Ard[] ardArray) {
		
		if (Array.size(ardArray) == 0) {
			System.out.println("아직 입력된 학생이 없습니다.");
		} else {
			System.out.println("-------------------------------");
			for (int i = 0; i < ardArray.length; i++) {
				System.out.printf("%d 게시판 번호: %d\n", i + 1, ardArray[i].id);
				
			}
			System.out.println("-------------------------------");
			
			int userChoice = ScannerUtil.nextInt(scanner,
					"출력할 번호의 학생을 선택해주세요(0은 뒤로가기):",0, ardArray.length) - 1;

			if (userChoice != -1) {
   			ardArray= selectOne(scanner, ardArray, userChoice);
			}

		}

		return ardArray;
	}

	private static Ard[] selectOne(Scanner scanner, 
			Ard[] ardArray, int index) {

		
		Ard s = ardArray[index];
		System.out.printf("게시판 번호: %d번 작성자: %s\n ", s.id, s.name);
		System.out.printf("제목: %s\n ",s.read);
		System.out.printf("글 내용: %s\n ",s.write);

		
		
		int userChoice = ScannerUtil.nextInt(scanner, "1. 수정하기"
				+ " 2. 삭제하기 3. 뒤로가기",1,3);
		if(userChoice ==  1) {

			updateArd(scanner, ardArray[index]);

			ardArray = selectOne(scanner, ardArray, index);
		
		}else if(userChoice ==2) {
	
			ardArray = deleteArd(scanner, ardArray, index);
			ardArray = printAll(scanner, ardArray);
		}
		

		return ardArray;
	}
	
	private static void updateArd(Scanner scanner, Ard s) {
		System.out.println("==========================");
		System.out.println("                  수정");
		System.out.println("==========================");
		System.out.println("현재 게시판 번호: "+s.id+"번");
		//System.out.println("수정 할 게시판 번호: ");
	    s.id = ScannerUtil.nextInt(scanner,"수정 할 게시판 번호: ", 1, 4);
		System.out.println("현재 작성자: "+s.name);
		System.out.print("수정할 작성자: ");
		s.name = ScannerUtil.nextLine(scanner);
		System.out.print("수정 할 제목: ");
		s.read = ScannerUtil.nextLine(scanner);
		System.out.print("수정할 글 내용: ");
		s.write = ScannerUtil.nextLine(scanner);
		
	}

	
	private static Ard[] deleteArd(Scanner scanner,Ard[] ArdArray, int index) {
		System.out.print("해당 학생을 정말 삭제하시겠습니다 y/n: ");
		String agree = ScannerUtil.nextLine(scanner);

		if(agree.equals("y")) {
			ArdArray = Array.removeByIndex(ArdArray, index);
		}
		return ArdArray;
	}

}


