package edu.kh.oarr.model.service;
import java.util.Scanner;
import edu.kh.oarr.model.vo.Member;

public class MemberService {
	
	private Scanner sc = new Scanner(System.in);
	
	// Member 5칸까지 객체 배열 선언 및 할당
	private Member[] memberArr = new Member[5];
	
	// 현재 로그인한 회원의 정보를 저장할 변수 선언
	private Member loginMember = null;
	
	public MemberService() { //기본 생성자
		// memberArr 배열 0, 1, 2 인덱스 초기화

		memberArr[0] = new Member("a1", "a1", "김방방", 20, "인천");
		memberArr[1] = new Member("a2", "a2", "김뿡뿡", 22, "인천");
		memberArr[2] = new Member("a3", "a3", "김차차", 10, "의정부");
		
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
			case 1 : System.out.println(signUp()); break;
			case 2 : System.out.println(login());; break;
			case 3 : System.out.println(selecMember()); break;
			case 4 : int result = updateMember();
					if(result == -1) {
						System.out.println("로그인 먼저 진행하세요");
					}else if (result == 1) {
						System.out.println("수정 완료");
					}else {
						System.out.println("수정 실패(비밀번호가 다릅니다)");
					}
					break;
			case 5 : searchRegion();
			case 0 : System.out.println("프로그램을 종료합니다."); break;
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
		if(index != -1) {
		System.out.print("현재 회원 수 : " + index );
		}
		
		if(index == -1) { // 회원 가입 불가
			return "회원 가입이 불가능합니다. (인원 초과)";
		}else {
			
			System.out.print("\n아이디 : ");
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
			if(memberArr[i] == null) {
				return i;
			}
		}
		return -1;
		// for문을 수행했지만 return이 되지 않은 경우 return 은 -1을 반환 
	}
	// 2. 로그인 
	
	public String login() {
		
		System.out.println("======= 로그인 =======");
		
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		
		System.out.print("패스워드 입력 : ");
		String memberPw = sc.next();
		
		
		for (int i = 0; i < memberArr.length; i++) {
			//회원 정보가 있을 경우
			// 1) memberArr 배열 내 요소를 순서대로 접근하여 null이 아닌지 확인 
			if(memberArr[i]!=null) {
				//2) 회원 정보의 아이디 비밀번호가 입력받은 아이디 비밀번호가 같은지 확인 
				if(memberId.equals(memberArr[i].getMemberId()) 
						&& memberPw.equals( memberArr[i].getMemberPw())) {
					//		3) 로그인 회원 정보 객체 (Member)를 참조하는 변수 loginMember 에
					//   		현재 접근중인 memberArr[i] 요소에 저장된 주소를 얕은 복사 
					
					loginMember = memberArr[i];
					break; // 더 이상 같은 아이디, 비밀번호 없으므로 for문 종료
				}
			}
			//for문 끝
		}
		// 4) 로그인 성공 / 실패 여부에 따라 결과값 반환
		if(loginMember == null) {//로그인 실패
			return "아이디 또는 비밀번호가 일치하지 않습니다.";
		}else {//로그인 성공
			return loginMember.getMemberName() + "님 환영합니다. ";
		}
			
	}
		
		/*int index = emptyIndex();
		
		if (index ==0) {
			return "\n가입자가 없습니다. ";
		} else {
			System.out.println("======= 로그인 =======");
			System.out.print("아이디 : ");
			String idCheck = sc.next();
			System.out.print("비밀번호 : ");
			String pwCheck = sc.next();
			
			for(int i =0; i<index; i++) {
				if(idCheck.equals(memberArr[i].getMemberId())&& pwCheck.equals(memberArr[i].getMemberPw())){
					loginMember = memberArr[i];
					return "\n로그인 성공";	
				}
			}
		}
		return "\n로그인 실패(회원 정보 오류)";
	}
		*/

	
	//3. 회원 정보 조회
	public String selecMember() {
		System.out.println("\n*******회원 정보*******");
		
		// 1) 로그인 여부 확인 -> 필드 loginMember가 참조하는 객체가 있는지 확인
		// 2) 로그인이 되어있는 경우 
		//	 회원 정보를 출력할 문자열 만들어서 반환 
		if(loginMember == null) {
			return "\n로그인먼저 진행해주세요";
		}else {
			String member = "\nID: " + loginMember.getMemberId();
			member += "\n이름 : " + loginMember.getMemberName();
			member += "\n나이 : " + loginMember.getMemberAge();
			member += "\n거주지 : " + loginMember.getRegion();
			
			return member;
		}
	}

	//4. 회원 정보 수정
	public int updateMember() {
		System.out.println("======= 회원 정보 수정 ========");
		
				
		//1)로그인 여부 판별
		//  로그인이 되어있지 않으면 -1 반환
		if(loginMember == null) {
			return -1;
		}
		
		//2)수정할 회원 정보 입력 받기(이름,나이, 지역)
		System.out.print("수정할 이름 입력 :");
		String inputName = sc.next();
		
		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt();
		sc.nextLine();
		
		System.out.print("수정할 지역 입력 : ");
		String inputRegion = sc.next();
	
		sc.nextLine();
		
		//3)비밀번호 입력 받아서 
		//	로그인한 회원의 비밀번호와 일치한지 확인 
		
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		if( inputPw.equals( loginMember.getMemberPw())) {
			//4)비밀번호 같은 경우
			//	로그인한 회원의 이름, 나이, 지역 정보를 입력받은 값으로 변경 후 1 반환
			loginMember.setMemberName( inputName) ;
			//입력받은 inputName을 loginMeber가 참조하는 Member객체의 필드 memberName에 대입 
			loginMember.setMemberAge( inputAge) ;
			loginMember.setRegion (inputRegion);
			return 1;
		} else {
			return 0;
			// 비밀번호가 다르면 0
		}
	}

	//5. 회원 검색(지역)
	public void searchRegion() {
		System.out.println("\n======= 회원 검색 =======");
		System.out.print("검색할 지역을 입력하세요 : ");
		String inputRegion = sc.next();
		
		boolean flag = false; // 검색 결과 신호용 변수
		
		
		
		//1) meberArr 배열의 모든 요소 순차 접근!
		for(int i = 0 ; i<memberArr.length; i++) {
			//2) memberArr[i] 요소가 null인 경우 반복 종료
			if(memberArr[i] == null) break;		
			//3) memberArr[i] 요소에 저장된 지역(getRegion())이
			//	입력받은 지역과(inputRegion) 같을 경우, 회원 아이디, 이름 출력
			if(memberArr[i].getRegion().equals(inputRegion)) {
				System.out.printf("아이디 : %s, 이름 : %s \n", memberArr[i].getMemberId(), memberArr[i].getMemberName());
				flag = true;
			}	
		}
		if(!flag)
		System.out.println("검색 결과가 없습니다.");
	}
	
	
	
	//5. 회원 검색(지역)
	/*public String findMember() {
		
		System.out.println("======= 회원 검색 =======");
		System.out.print("검색할 지역을 입력하세요 : ");
		String findRegion = sc.next();
		int index = emptyIndex();
		String str = "";
		int count = 0;

		for(int i =0; i<index; i++) {
			if(memberArr[i].getRegion().equals(findRegion)) {
	
				str += "아이디: " + memberArr[i].getMemberId() + " ";	
				str += "\n이름: " + memberArr[i].getMemberName() + " ";	
				count ++;
			}
		}
			if(count == 0) {
				return "해당 지역에 거주하는 회원이 없습니다.";
		}else {
			return findRegion + " 거주 회원 : " + str;
		}
	}*/
}
