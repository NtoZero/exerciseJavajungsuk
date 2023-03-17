//[7-18] 다음과 같은 실행결과를 얻도록 코드를 완성하시오.
//[Hint] instanceof연산자를 사용해서 형변환한다.
//
//메서드명 : action
//기	능 : 주어진 객체의 메서드를 호출한다.
//DanceRobot인 경우, dance()를 호출하고, SingRobot인 경우, sing()을 호출하고, DrawRobot인 경우, draw()를 호출한다.
//반환타입 : 없음
//매개변수 : Robot r - Robot인스턴스 또는 Robot의 자손 인스턴스

class Sol_Exercise7_18 {
	/*
	 * (1) action메서드를 작성하시오.
	 */
	static void action(Robot r) {
		if(r instanceof DanceRobot) {
			//여기에 형변환 과정을 추가해줘야 함. (나는 컴파일러가 붙여줌)
			((DanceRobot) r).dance();
		}
		else if(r instanceof SingRobot) {
			((SingRobot) r).sing();
		}
		else if(r instanceof DrawRobot) {
			((DrawRobot) r).draw();
		}
	}

	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };

		for (int i = 0; i < arr.length; i++)
			action(arr[i]);
	} // main
}

class Robot {
}

class DanceRobot extends Robot {
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("그림을 그립니다.");
	}
}

/*
 * <실행결과>
 * 춤을 춥니다. 
 * 노래를 합니다. 
 * 그림을 그립니다.
 */

/*
 * <정답>
 * public static void action(Robot r) 
 * 	{ if(r instanceof DanceRobot) {
DanceRobot dr = (DanceRobot)r;
 dr.dance();
} 
else if(r instanceof SingRobot) 
	{ SingRobot sr = (SingRobot)r; 
					sr.sing();
} else if(r instanceof DrawRobot) 
	{ DrawRobot dr = (DrawRobot)r; 
				dr.draw();
}
}
 <내 풀이와 다른점>
 참조변수의 형변환 과정이 추가되었다.
 해당 클래스로 바꾸지 않으면 확장된 메서드를 활용할 수 없으므로 당연히 바꿔야한다.
*/