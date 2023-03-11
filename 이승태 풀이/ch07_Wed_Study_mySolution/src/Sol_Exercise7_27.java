// [7-27] 다음과 같은 실행결과를 얻도록 (1)~(4)의 코드를 완성하시오.

class Outer8 {
	int value = 10;

	class Inner {
		int value = 20;

		void method1() {
			int value = 30;

			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer8.this.value);
		}
	} // Inner클래스의 끝
} // Outer클래스의 끝

class Sol_Exercise7_27 {
	public static void main(String args[]) {
		Outer8 o = new Outer8();
		Outer8.Inner inner = o.new Inner();

		inner.method1();
	}
}

/*
 * <실행결과>
 * 30
 * 20
 * 10
 */

/*
 * <풀이 접근>
 * Outer8 클래스의 내부 클래스 Inner 클래스의 인스턴스 메서드에 접근까지 해야하는 문제이다.
 * 순서는 
 * 1. 외부클래스 인스턴스 생성
 * 2. 내부클래스 인스턴스 생성
 * 3. 내부클래스 인스턴스 메서드 void method1() 호출. 
 * 
 * +. void method1()의 구현부 에 적힌 (1), (2), (3)은 각각
 * (1)에는 value
 * (2)에는 this.value
 * (3)에는 Outer.this.value가 되어야 한다. 
 * 		->(3)의 의미는 Outer8클래스의 객체의 value값을 의미하는 것이다.
 * 
 * [해설] 외부 클래스와 내부 클래스에 같은 이름의 인스턴스 변수(value)가 선언되었을 때
어떻게 구별하는가에 대한 문제이다. 외부 클래스의 인스턴스 변수는 내부 클래스에서
‘외부클래스이름.this.변수이름’로 접근할 수 있다.
내부 클래스의 종류가 인스턴스 클래스이기 때문에 외부 클래스의 인스턴스를 생성한 다 음에야 내부 클래스의 인스턴스를 생성할 수 있다.

 */