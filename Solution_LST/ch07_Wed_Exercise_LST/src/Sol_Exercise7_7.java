/* [7-7] 다음 코드의 실행했을 때 호출되는 생성자의 순서와 실행결과를 적으시오. */
class Parent {
	int x = 100;	//조상의 멤버변수 x

	Parent() {
		this(200);
	}

	Parent(int x) {
		this.x = x;
	}

	int getX() {
		return x;
	}
}

class Child extends Parent {
	int x = 3000;	//동명 조상의 멤버변수 x와 구분된다. 그냥 x = this.x 이고, super.x가 붙어야 조상 멤버변수이다. 

	Child() {
		this(1000);
	}

	Child(int x) {
		this.x = x;
	}
}

class Sol_Exercise7_7 {
	public static void main(String[] args) {
		Child c = new Child();

		System.out.println("x=" + c.getX());
	}
}


//  <내 생각>
//  	32행에서 new Child();로 자손 클래스 객체를 생성할 때 
//  Child() 생성자 구현부 안에서 super();가 가장 먼저 실행된다.
//  조상멤버의 유효성을 위해, 가장 먼저 상속받은 조상 클래스의 멤버부터 초기화해야하기 때문이다.
//  super()가 발동하면 this(200)이 적용되어 super.x는 200이 된다.
//  그 다음 자손 Child 클래스에서 this(1000)이 발동한다.
//  이 때 this(1000)은 같은 자손클래스의 생성자이며 this.x = 1000;으로 만든다.
//  this는 Child 클래스 객체를 말하므로 x=1000;의 값이 출력된다.
//  
//  => 답이 틀렸다.
  
 

