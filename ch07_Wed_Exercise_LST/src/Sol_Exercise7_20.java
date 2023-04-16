// [7-20] 다음의 코드를 실행한 결과를 적으시오.

class Sol_Exercise7_20 {
	public static void main(String[] args) {
		Parent2 p = new Child2();	//조상참조변수 p는 자손인스턴스 참조
		Child2 c = new Child2();	//자손참조변수 c는 동타입 인스턴스 참조

		System.out.println("p.x = " + p.x);	//200
		p.method();

		System.out.println("c.x = " + c.x);	//200
		c.method();
	}
}

class Parent2 {
	int x = 100;

	void method() {
		System.out.println("Parent Method");
	}
}

class Child2 extends Parent2 {
	int x = 200;

	void method() {
		System.out.println("Child Method");
	}
}


/*
 * <내 풀이>
 * 상속과 객체의 다형성을 이해하고 있는지에 관한 문제이다.
 * 자손 인스턴스 변수와 조상 인스턴스 변수의 이름이 겹친다면(예를 들어 x), 
 * x= this.x이다. 조상 인스턴스 변수를 호출하려면 super.x를 호출해야한다.
 * 
 * p.x와 c.x는 모두 동일한 자손 인스턴스를 가리키고 있으므로 해당 멤버를 호출하는 것은 자손 클래스의 x를 호출하는 것이다.
 * 결과값은 둘 모두 200이 나온다.
 * 
 * <오답>
 * 나는 바보다... 조상 참조변수는 조상 멤버만 사용할 수 있다. (리모컨의 버튼에 비유)
 * 조상 참조변수는 자손 인스턴스에서 확장된 멤버에 접근할 수 없기 때문에 p.x = 100이다.
 * <정정>
 * 조상 참조변수는 조상 멤버변수 + 오버라이딩된 자손의 메서드까지 접근할 수 있어
 * 
 * 
[해설] 조상 클래스에 선언된 멤버변수와 같은 이름의 인스턴스변수를 자손 클래스에 중
복으로 정의했을 때, 조상타입의 참조변수로 자손 인스턴스를 참조하는 경우와 자손타입
의 참조변수로 자손 인스턴스를 참조하는 경우는 서로 다른 결과를 얻는다.

메서드의 경우 조상 클래스의 메서드를 자손의 클래스에서 오버라이딩한 경우에도 참조변 수의 타입에 관계없이 항상 실제 인스턴스의 메서드(오버라이딩된 메서드)가 호출되지만, 멤버변수의 경우 참조변수의 타입에 따라 달라진다.

타입은 다르지만, 참조변수 p, c모두 Child인스턴스를 참조하고 있다.
그리고, Parent클래스와 Child클래스는 서로 같은 멤버들을 정의하고 있다.
이 때 조상타입의 참조변수 p로 Child인스턴스의 멤버들을 사용하는 것과 자손타입의 참조변수 c로 Child인스턴스의 멤버들을 사용하는 것의 차이를 알 수 있다.
메서드인 method()의 경우 참조변수의 타입에 관계없이 항상 실제 인스턴스의 타입인
Child클래스에 정의된 메서드가 호출되지만, 인스턴스변수인 x는 참조변수의 타입에 따라서 달라진다.

 */