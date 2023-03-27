

//[7-26] Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.

class Outer5 {
	static class Inner {
		int iv = 200;
	}
}

class Sol_Exercise7_26 {
	public static void main(String[] args) {
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		Outer5.Inner oi = new Outer5.Inner();
		System.out.println(oi.iv);
	}
}

// 실행결과
// 200
//

/*
 * <풀이 접근>
 * 외부 클래스 내부 스태틱 클래스에 접근하는 문제이다.
 * 내부 스태틱 클래스는 그 자체만으로 독립적인 스태틱 클래스이다.
 * 왜냐하면 JVM이 메소드 영역에 클래스정보를 로드할 때 스태틱 멤버들의 정보를 미리 로드하기 때문이다.
 * 따라서 객체를 생성하지 않고 해당 값에 접근할 수 있다.
 * 
 * 단, 잘못 생각한 부분이 Inner 클래스는 클래스 영역에 존재하지만 
 * Inner 클래스의 iv는 말 그대로 객체 변수이기 때문에 Inner의 인스턴스가 생성된 후에야 접근할 수 있다.
 * 단지 외부 클래스의 인스턴스를 만들지 않아도 된다는 점이 차이점이다.
 * 
 * [해설] 
 * 스태틱 클래스(static inner class)는 인스턴스 클래스와 달리 외부 클래스의 인 스턴스를 생성하지 않고도 사용할 수 있다. 
 * 마치 static멤버를 인스턴스 생성없이 사용할 수 있는 것처럼.
 *  Outer.Inner ii = new Outer.Inner(); 
 *  System.out.println(ii.iv);
 * 
 */