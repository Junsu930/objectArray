package edu.kh.objarray.practice.model.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.objarray.practice.model.vo.Employee;


public class EmployeeService {
	
	private Employee[] employees = new Employee[3];
	
	private Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		try {
			int sel = 0;
			do {
				System.out.println("===직원 관리 프로그램===");
				System.out.println("1. 직원 정보 입력");
				System.out.println("2. 모든 직원 정보 출력");
				System.out.println("3. 특정 직원 정보 출력(이름 검색)");
				System.out.println("4. 특정 직원 급여 / 연봉 출력 (사번 검색)");
				System.out.println("5. 모든 직원 급여 합/ 연봉 합 출력");
				System.out.println("6. 모든 직원 중 급여가 가장 높은 직원의"
						+ " 이름, 부서, 급여 출력");
				System.out.println("0. 종료");
				System.out.print("메뉴 선택 : ");
				sel = sc.nextInt();
				sc.nextLine();
				
				switch(sel) {
				
				case 1: initEmployee() ; break;
				
				case 2: System.out.println(allEmployeesInformation()); break;
					
				
				case 3: System.out.println(searchEmployee()); break;
				
				
				case 4: System.out.println(salaryCheck()); break;
			
				case 5: System.out.println("모든 직원 급여의 합 : " + allSalaryCheck());
						System.out.println("모든 직원 연봉의 합 : " + allSalaryCheck()*12);
				break;
				case 6: topSalaryEmployee(); break;
				case 0: System.out.println("프로그램 종료"); break; 
				default : System.out.println("잘못 입력하셨습니다.");
				}
				
			}while(sel != 0);
		}catch(InputMismatchException e) {
			System.out.println("값을 잘못 입력하셨습니다.");
			sc.nextLine();
			displayMenu();
	
		}catch(NullPointerException e) {
			System.out.println("등록된 인원이 없습니다.");
			displayMenu();
		}

	}
	
	//3명의 직원 정보 입력받기
	public void initEmployee() throws NullPointerException, InputMismatchException {
		
		System.out.println("직원 등록");
		
		for(int i = 0; i<employees.length; i++) {
			System.out.println("==="+(i+1) + "번 째 사원 정보 입력===");
			System.out.print("사번 입력 : ");
			int no = sc.nextInt();
			System.out.print("이름 입력 : ");
			String name = sc.next();
			System.out.print("부서 입력 : ");
			String department = sc.next();
			System.out.print("직급 입력 : ");
			String rank = sc.next();
			System.out.print("급여 입력 : ");
			int salary = sc.nextInt();
			
			employees[i]=new Employee(no, name, department, rank, salary);
		}
		System.out.println("등록 완료");
		
	}
	
	public String allEmployeesInformation() throws NullPointerException, InputMismatchException {
		String mem = "";
		
		for(int i = 0; i<employees.length; i++) {
			mem += employees[i].info();
		}
	
		return mem;
		
	}
	
	public String searchEmployee() throws NullPointerException, InputMismatchException {
		
		String search = "";
		System.out.print("검색할 직원의 이름을 입력하세요 : ");
		String name = sc.next();
		//정보 받기
		for(int i=0; i<employees.length; i++) {
			if(name.equals(employees[i].getName())) {
				//같은 경우
				search += employees[i].info();
			}
		}
		
		if(search != "") {
			return search;			
		}else {
			return "일치하는 직원이 없습니다";
		}
		
	}

	public String salaryCheck() throws NullPointerException, InputMismatchException {
		String sal = "";
		System.out.print("검색할 사번을 입력하세요 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		for(int i =0; i<employees.length; i++) {
			if(no == employees[i].getNo()) {
				sal += ("급여 : " + employees[i].getSalary() + " 연봉 : " + employees[i].getSalary()*12 + " ");
			}
		}
		
		return sal;
	}

	public int allSalaryCheck() {
		
		int sum = 0;
		for(int i=0; i<employees.length; i++) {
			sum+=employees[i].getSalary();
		}
		
		return sum;
	}
	
	public void topSalaryEmployee() {
		Employee top = new Employee();
		
		for(int i=0; i<employees.length; i++) {
			if(employees[i].getSalary()>top.getSalary()) {
				top = employees[i];
			}else if(employees[i].getSalary()==top.getSalary()) {
					
				if(employees[i].getNo()<top.getNo()) {
						
					top = employees[i];
					
				}
			}
		}
		
		System.out.println("이름 : " + top.getName() + " 부서 : " + top.getDepartment() + " 급여 : " + top.getSalary()  );
		
	}
}
