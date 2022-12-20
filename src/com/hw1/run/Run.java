package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		
		Employee[] ep = new Employee[3]; 
		
		ep[0] = new Employee();
		ep[1] = new Employee(1, "홍길동", 19, 'M', "01022223333", "서울 잠실");
		ep[2] = new Employee(1, "김말순", "교육부", 
				"강사", 20 , 'F', 1000000, 0.01, "01011112222", "서울 마곡");
		
		System.out.println("ep[0] : " + ep[0].information());
		System.out.println("ep[1] : " + ep[1].information());
		System.out.println("ep[2] : " + ep[2].information());

		System.out.println("================================");
		
		ep[0]=  new Employee(0, "김말똥", "영업부", "팀장", 30, 'M', 3000000
				, 0.2, "01055559999", "전라도 광주");
		
		ep[1].setDept("기획부");
		ep[1].setJob("부장");
		ep[1].setSalary(4000000);
		ep[1].setBonusPoint(0.3);

		System.out.println(ep[0].information());
		System.out.println(ep[1].information());
		
		System.out.println("================================");
		
		int ysal[] = new int [ep.length];
	
		int sum = 0;
		
		for(int i = 0; i< ep.length; i++) {
			
			ysal[i] = (int)(ep[i].getSalary()+ ep[i].getSalary()*ep[i].getBonusPoint())*12;
			System.out.printf("%s의 연봉 : %d원\n", ep[i].getEmpName(), ysal[i]);
			sum += ysal[i];
		}
		
		System.out.println("================================");
		
		System.out.println("직원들의 연봉의 평균 : "  + sum/3 );
		
		
	}

}
