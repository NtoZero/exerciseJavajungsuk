//[7-16] 다음 중 연산결과가 true가 아닌 것은? (모두 고르시오)


//class Car {}
//class FireEngine extends Car implements Movable {} 
//class Ambulance extends Car {}
//
//FireEngine fe = new FireEngine();

//a.	fe instanceof FireEngine
//b.	fe instanceof Movable
//c.	fe instanceof Object
//d.	fe instanceof Car
//e.	fe instanceof Ambulance


/*
 *<내 풀이>
 * instanceof는 형변환 가능한 타입을 찾아주는 메서드이다.
 * 형변환이 가능하다는 것은 어떤 클래스타입 참조변수가 있을 때 동타입이거나 그 조상타입이라는 것이다.
 * 형변환이 가능하면 true를 반환한다.
 * fe는 FireEngine의 객체이다. FireEngine은 Car, Movable을 상속하므로 우측에 오는 타입이 FireEngine, Car, Movable일 때 true를 반환한다.
 * (한 가지 빼먹었는데 모든 클래스는 Object를 상속받으므로 Object가 와도 true를 반환한다.)
 * 단, e와는 상속 관계가 아니므로 false를 반환한다.
 * 답. e
 * 
 * <정답>
 * e
 * 
 * <💡생각해볼점>
 * 어떤 참조변수를 형변환하기 전에 instanceof가 true를 반환하는지 살펴보는 것이 좋다.
 */