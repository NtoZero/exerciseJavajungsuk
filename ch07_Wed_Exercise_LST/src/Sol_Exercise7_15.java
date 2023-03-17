//[7-15] 클래스가 다음과 같이 정의되어 있을 때, 형변환을 올바르게 하지 않은 것은?
//(모두고르시오.)

//class Unit {}
//class AirUnit extends Unit {} 
//class GroundUnit extends Unit {} 
//class Tank extends GroundUnit {} 
//class AirCraft extends AirUnit {}
//
//Unit u = new GroundUnit(); 
//Tank t = new Tank(); 
//AirCraft ac = new AirCraft();


//a.	u = (Unit)ac;
//b.	u = ac;
//c.	GroundUnit gu = (GroundUnit)u;
//d.	AirUnit au = ac;
//e.	t = (Tank)u;
//f.	GroundUnit gu = t;


/*
 * <내 풀이>
 * 현재 문제는 객체의 다형성을 물어보는 문제다.
 * 객체의 다형성이란 부모 클래스의 참조변수로 자손 클래스의 인스턴스를 다루는 것을 말한다.
 * 참조변수의 형변환이란 자손 클래스의 인스턴스를 가지고 있을 때 해당 자손 클래스타입 또는 동 클래스의 조상 타입 참조변수 간에 자유로운 형변환이 가능한 것을 말한다.
 * 단, 자손타입 참조변수가 조상의 인스턴스를 참조하는 것은 불가능하다. (리모컨 버튼 개수가 많음)
 * 
 * a의 경우 가능하다. ac는 Aircraft 인스턴스이므로 Unit의 자손클래스타입이다. 참조변수 u에 저장되어 있던 GroundUnit 객체도 Unit의 자손 객체였다. 
 * 조상타입 참조변수가 자손 인스턴스를 참조하는 것은 항상 가능하다. (Unit)도 생략이 가능하다.  
 * b의 경우가 (Unit)을 생략한 케이스이다. ❓형변환이 생략 불가능할 때는 조상 참조변수가 자손 참조변수로 갈아 끼워질 때이다. (물론 항상 내용물은 자손인스턴스다.)❓ //순간 헷가릶
 * c의 경우 가능하다. 원래 Unit u에 저장되어 있는 객체는 GroundUnit이었으므로 참조타입을 동타입으로 교환하는 것은 당연히 가능하다.
 * d의 경우 가능하다. AirUnit은 Aircraft 객체 ac의 조상타입이므로 객체의 다형성이 적용가능하다. 조상 타입 참조변수는 언제나 자손 인스턴스를 참조할 수 있다.
 * e의 경우 불가능하다. 참조변수 u에 저장된 객체는 GroundUnit 인스턴스로 그 자손타입 참조변수인 Tank에 저장될 수 없다.
 * f의 경우 가능하다. t는 자손타입 인스턴스를 저장하고 있으므로 조상타입 참조변수 GroundUnit이 얼마든지 참조할 수 있다.
 * 
 * <정답>
 * e.
 */