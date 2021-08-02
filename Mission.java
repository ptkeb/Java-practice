package step02.mission;


public class Mission {
	
	static void mm1() {
		char [] c = new char[] {1,2,3,64,69,83};
		try {
			System.out.println(c[5]);
			System.out.println(c[6]); //입력받았다고 가정
		} catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("존재하지 않는 인덱스 번호입니다");
			System.out.println("다시 입력해주세요");
		}
	}
	
	static void mm2() {
		int i = 65;
		while(i <= 70) {
			System.out.println((char) i);
			i++;
			try {
				Thread.sleep(100); //사용자가 지정할수있다고 가정
			} catch(InterruptedException e) {
				e.printStackTrace(); 
				System.out.println("명령간의 시간 간격을 입력해주세요");
			} finally {
				System.out.println("휴식코드  확인1");
			}
		}
	}
	
	static void mm3() {
		int i = 65;
		try {
			while(i <= 70) {
			System.out.println((char) i);
			i++;
			Thread.sleep(100); //사용자가 지정할수있다고 가정
			}
		} catch(InterruptedException e) {
			e.printStackTrace(); 
			System.out.println("명령간의 시간 간격을 입력해주세요");
		} finally {
			System.out.println("휴식코드  확인2");
		}
	}
	
	static void mm4() {
		int i = -3;
		while (i <= 0) {
			try {
				System.out.println(100/i);
				i++;
			} catch (ArithmeticException a) {
				System.out.println("연산에러! 값을 확인해주세요");
				break;
			} finally {
				System.out.println("계산 완료");
			}
		}
	}
	
	static void mm5() {
		int i = -3;
		try {
			while (i <= 0) {
				System.out.println(100/i);
				i++;
			}
		} catch (ArithmeticException a) {
			System.out.println("연산에러! 값을 확인해주세요");
		} finally {
			System.out.println("계산 완료");
		}
	}
	static void mm6() throws ArithmeticException{
		System.out.println(10/0);
	}
		
	public static void main(String[] args) { // 예외를 메인에서 다시 throw하여 없애버릴수있지만 문제가 생길 여지가 많으므로 권장하지않음
		try {
			mm1();
			Thread.sleep(1000);
			System.out.println("==================================");
			mm2();
			Thread.sleep(1000);
			System.out.println("==================================");
			mm3();
			Thread.sleep(1000);
			System.out.println("==================================");
			mm4();
			Thread.sleep(1000);
			System.out.println("==================================");
			mm5();
			Thread.sleep(2000);
			System.out.println("==================================");
		} catch(InterruptedException e) {
			System.out.println("알수없는 시간단위!");
		} finally {
			System.out.println("메인 종료");
		}
		try { 
			mm6();
		} catch(ArithmeticException e) {
			e.printStackTrace();
		} finally	{
			System.out.println("throws 테스트 1");
		}
	}
}
