package edu.kh.oarr.model.vo;

public class Member {

	// 필드 ( == 멤버 변수 ) 
	// 생성자
	// 메소드 
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region; //지역

	
	//생성자 규칙
	// 1. 생성자 이름은 클래스명과 같아야 한다.
	// 2. 반환형이 없다. 
	
	public Member() {} // 기본 생성자 

	// 매개변수 생성자 
	public Member(String memberId, String memberPw, String memberName, int memberAge, String region) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
	}

	public String getMemberId() { 
		/* 모두 접근 가능하도록 public
		 * String 자료형 반환하겠다.
		 * 매개변수가 없어서 중복된 이름의 memberId가 없기 때문에 memberId라고만 써도 OK
		 * */
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
		//return; ==> 컴파일러가 자동으로 return 
		// 모든 메소드는 종료 시 호출한 곳으로 돌아가는 
		// return 구문이 필요하지만, void의 경우 생략 가능하다. 
	}
	/* setter는 세팅하는 기능
	 * 무엇을 세팅할지 받아올 매개변수가 필요하다
	 * setter는 보통 반환값은 없음 
	 */

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
