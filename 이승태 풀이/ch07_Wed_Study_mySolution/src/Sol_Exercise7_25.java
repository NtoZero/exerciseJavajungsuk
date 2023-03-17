

//[7-25] Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.

class Outer {
	class Inner {
		int iv = 100;
	}
}

class Sol_Exercise7_25 {
	public static void main(String[] args) {
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		System.out.println(i.iv);
	}
}

// <실행결과> 
// 100

/*
 * <풀이 접근>
 * 특정 클래스의 내부 클래스에 접근할 수 있는지를 묻는 문제이다.
 * 특정 클래스의 인스턴스가 생성되어야 내부 클래스에 접근할 수 있으므로
 * 특정 클래스 인스턴스 생성 -> 내부 클래스 인스턴스 생성 -> 내부 클래스 인스턴스값 접근의 순서를 지킨다.
 * 주의할점은 문법이다. 내부 클래스 인스턴스를 생성할때 외부클래스객체.new 내부클래스생성자 가 와야한다. 
 */