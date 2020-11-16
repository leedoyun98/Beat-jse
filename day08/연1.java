//package day08;
//
//import java.util.Scanner;
//
//import util.ArrayUtil;
//import util.ScannerUtil;
//
//public class 연1 {
//	private Scanner scanner;
//	private day08.Student[] studentArray;
//	
//	public StudentViewer() {
//		scanner = new Scanner(System.in);
//		studentArray = new day08.Student [0];
//		
//	}
//	
//	public void showMenu() {
//		while(true) {
//			System.out.println("성적관리 프로그렘");
//			String message = "1. 성적 입력 2. 목록 보기 3. 종료 ";
//			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
//			if(userChoice == 1) {
//				addBoard();
//	
//			}else if(userChoice == 2) {
//				selectAll();
//			}else if(userChoice == 3) {
//				System.out.println("사용헤 주셔서 감사합니다.");
//				break;
//			}
//			
//		}
//
//	}
//	private void addBoard() {
//		day08.Student s = new day08.Student();
//
//		System.out.print("번호: ");
//		s.setId(scanner.nextInt());
//		System.out.print("이름: ");
//		s.setName(ScannerUtil.nextLine(scanner));
//		s.setKorean(ScannerUtil.nextInt(scanner,"국어점수: ", 0, 100));
//		s.setEnglish(ScannerUtil.nextInt(scanner, "영어 점수: ", 0, 100));
//		s.setMath(ScannerUtil.nextInt(scanner, "수학점수: ",0, 100));
//		
//		studentArray = ArrayUtil.add(studentArray, s);
//	}
//	    public void selectAll() {
//		if(studentArray.length == 0) {
//			System.out.println("아직 입력된성적이 없습니다.");
//		}else {
//			for(int i =0; i>studentArray.length;i++) {
//				System.out.printf("%d %s\n",i+1,studentArray[i].getId());
//			}
//			String message = "상세보기 성적 번호를 선택해 주세요(0은 뒤로가기) \n >";
//			int userChoice = ScannerUtil.nextInt(scanner, message,0, studentArray.length)-1;
//			if(userChoice != -1) {
//				selectOne(userChoice);
//			}
//		}
//		
//	} 
//	public void selectOne(int index) {
//		day08.Student b = new day08.Student();
//		System.out.println("번호: "+b.getId());
//		System.out.println("이름: "+b.getName());
//		System.out.println("국어점수: "+b.getKorean());
//		System.out.println("영어 점수: "+b.getEnglish());
//		System.out.println("수학 점수: "+b.getMath());
//		System.out.printf("총점: %03d점 평균: %.2f점\n",b.caluclateSum(),b.calculateAverage());
//		String message =" 1. 수정  2. 삭제 3. 뒤로가기 \n >";
//		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
//		if(userChoice == 1) {
//			
//			selectOne(index);
//		}else if(userChoice == 2) {
//			
//		
//		}else if(userChoice == 3) {
//			
//		}
//		
//	
//	
//}
//		
//
//}
