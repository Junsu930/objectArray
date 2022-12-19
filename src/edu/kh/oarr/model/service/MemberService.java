package edu.kh.oarr.model.service;
import java.util.Scanner;
import edu.kh.oarr.model.vo.Member;

public class MemberService {
	
	private Scanner sc = new Scanner(System.in);
	
	// Member 5칸까지 객체 배열 선언 및 할당
	private Member[] memberArr = new Member[5];
	
	// 현재 로그인한 회원의 정보를 저장할 변수 선언
	private Member loginMemver = null;
	
	public MemberService() { //기본 생성자
		// memberArr 배열 0, 1, 2 인덱스 초기화
		memberArr[0] = new Member("user01", "user01", "김밥밥", 30, "인천");
		memberArr[1] = new Member("user02", "user02", "이짱짱", 32, "김포");
		memberArr[2] = new Member("user03", "user03", "강콩콩", 30, "의정부");
		
	}
	
	// 메뉴 출력용 메소드
	public void displayMenu() {
		
		
		int menuNum = 0;
		
		do {
			System.out.println("\n ====== 회원 정보 관리 프로그램 v2 ======");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색(지역)");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 > ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1 : signUp(); break;
			case 2 :
			case 3 :
			case 4 :
			case 5 :
			case 0 :
			default : System.out.println("\n 잘못 입력하셨습니다.");
			}
		
	
		}while(menuNum != 0);
	}
	// 회원 가입 메소드
	public String signUp() {
		System.out.println("===== 회원 가입 ======");
		
		// 객체 배열(memberArr)에 가입한 회원 정보를 저장할 예정 
		// -> 새로운 회원 정보를 입력할 장소가 있는지 확인 
		// 빈 공간의 인덱스 번호를 얻어오기 -> 새로운 메소드 작성
		
		int index = emptyIndex(); // memberArr 배열에서 비어있는 인덱스를 반환받음.
		System.out.println("현재 회원 수" + index);
		
		if(index == -1) { // 회원 가입 불가
			return "회원 가입이 불가능합니다. (인원 초과)";
		}else {
			
			System.out.print("아이디 : ");
			String memberId = sc.next();
			
			System.out.print("비밀번호 : ");
			String memberPw = sc.next();
			
			System.out.print("비밀번호 확인 : ");
			String memberPw2 = sc.next();
			
			System.out.print("이름 : ");
			String memberName = sc.next();
			
			System.out.print("나이 : ");
			int memberAge = sc.nextInt();
			
			System.out.print("지역 : ");
			String memberRegion = sc.next();
			
			// 비밀번호, 비밀번호 확인 일치시 회원가입
			if(memberPw.equals(memberPw2)) {
				// 멤버 객체를 생성하서 할당된 주소를 memverArr 비어있는 인덱스에 대입 
				memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, memberRegion);
				return "회원 가입 성공";
			}else {
				return "회원 가입 실패(비밀번호 불일치)"; 
			}
		}
		
	
	}
	// memberArr의 비어있는 인덱스 번호를 반환하는 메소드
	// 단 비어있는 인덱스가 없으면 -1 반환
	public int emptyIndex() {
		// memberArr 배열을 하나씩 접근 0번 인덱스부터 끝까지 접근
		// 참조하는 값이 null 인 경우 인덱스를 반환
		for(int i =0; i < memberArr.length; i++) {
			if(memberArr[i].equals(null)) {
				return i;
			}
		}
		return -1;
		// for문을 수행했지만 return이 되지 않은 경우 return 은 -1을 반환 
	}
	
	// 2. 로그인 
	
	public String login() {
		// 1) memberArr 배열 내 요소를 순서대로 접근하여 null이 아닌지 확인 
		//   2) 회원 정보(memberArr[i])의 아이디 비밀번호가 입력받은 
		//				아이디, 비밀번호가 같은지 확인
		//		3) 로그인 회원 정보 객체 (Member)를 참조하는 변수 loginMember 에
		//   		현재 접근중인 memberArr[i] 요소에 저장된 주소를 얕은 복사 
		// 4) 로그인 성공 / 실패 여부에 따라 결과값 반환
		return "";
		
		
	}
}
