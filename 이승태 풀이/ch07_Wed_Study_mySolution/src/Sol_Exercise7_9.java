//[7-9] 다음 중 제어자 final을 붙일 수 있는 대상과 붙였을 때 그 의미를 적은 것이다. 옳지 않은 것은? (모두 고르시오)
//a.	지역변수 - 값을 변경할 수 없다.
//b.	클래스 - 상속을 통해 클래스에 새로운 멤버를 추가할 수 없다.
//c.	메서드 - 오버로딩을 할 수 없다.
//d.	멤버변수 - 값을 변경할 수 없다.

/*
 *
 *<내 풀이>
 * final이 지역변수에 붙으면 상수이다.(값 변경이 불가능하다.)
 * final 클래스는 상속이 불가능한 클래스이다.
 * >>final 메서드는 오버로딩이 아니라 오버라이딩이 불가능하다.
 * final 멤버변수(클래스 변수, 인스턴스변수)는 상수이다. (값 변경이 불가능하다.)
 * 
 * <정답> c
 * 
 * <정리할 것>
 * final 클래스와 메서드는 상속과 관계가 깊다. 
 * final 변수는 상수를 선언하는 것이다.
 * 
 * <추가 내용>
 * 오버로딩과 오버라이딩은 이름이 같을 뿐 완전히 다른 내용이다.
 * 오버로딩은 메서드의 이름만 같은 다른 내용의 메서드를 추가하는 것이다. 리턴타입은 관계 없지만 매개변수의 타입, 개수, 순서 등의 차이를 보인다.
 * 오버라이딩은 상속관계에서 자손 클래스가 조상 클래스에게 상속받은 메서드를 자손의 요구사항에 부합하게 적절하게 수정하는 것을 말한다. 메서드의 선언부가 완전히 동일해야한다.
 */