//[7-17] 아래 세 개의 클래스로부터 공통부분을 뽑아서 Unit이라는 클래스를 만들고, 
//이 클래스를 상속받도록 코드를 변경하시오.


//class Marine extends Unit { // 보병
//	int x, y; // 현재 위치
//
//	void move(int x, int y) {
//		/* 지정된 위치로 이동 */ }
//
//	void stop() {
//		/* 현재 위치에 정지 */ }
//
//	void stimPack() {
//		/* 스팀팩을 사용한다. */}
//}
//
//class Tank { // 탱크
//	int x, y; // 현재 위치
//
//	void move(int x, int y) {
//		/* 지정된 위치로 이동 */ }
//
//	void stop() {
//		/* 현재 위치에 정지 */ }
//
//	void changeMode() {
//		/* 공격모드를 변환한다. */}
//}
//
//class Dropship { // 수송선
//	int x, y; // 현재 위치
//
//	void move(int x, int y) {
//		/* 지정된 위치로 이동 */ }
//
//	void stop() {
//		/* 현재 위치에 정지 */ }
//
//	void load() {
//		/* 선택된 대상을 태운다. */ }
//
//	void unload() {
//		/* 선택된 대상을 내린다. */ }
//}

class Marine extends Unit { // 보병
	void stimPack() {
		/* 스팀팩을 사용한다. */}
}

class Tank { // 탱크
	void changeMode() {
		/* 공격모드를 변환한다. */}
}

class Dropship { // 수송선
	void load() {
		/* 선택된 대상을 태운다. */ }

	void unload() {
		/* 선택된 대상을 내린다. */ }
}

class Unit {
	int x, y;
	void move(int x, int y) {
		//움직이는 기능
	}
	void stop() {
		//멈추는 기능
	}
}

// <내 풀이접근>
/* 추상화에 관한 내용이다. 기존에 존재하는 클래스 여럿의 공통적인 성질을 추상화하여 코드의 중복을 제거할 수 있다.
 * 추상 클래스 Unit에 포함시킬 공통 속성을 추려본다.
 * 인스턴스 멤버 int x, y를 포함한다. 인스턴스 메서드 void move(int x, int y), void stop()도 포함할 수 있다.
 * 이 때 move()와 stop()은 자손클래스별로 다르게 구현되어야 하므로 abstract 메서드로 선언하며,
 * 추상 메서드를 포함하는 추상 클래스의 선언 역시 abstract 제어자를 붙여주어야 한다.
 * 
 * <❗잘못된 생각>
 * 넓게 보면 추상화에 대한 개념은 맞지만 현 예제에서 추상 클래스를 사용하겠다는 생각은 잘못되었다.
 * void move(int x, int y)와 void stop() 모두 공통 메서드이기 때문에 
 * 별개의 추상 메서드를 추가해야하는 abstract 클래스를 선언하면 결국에 이를 상속받는 모든 자손클래스에서 각각 추상메서드를 구현해주어야 하므로
 * 현재 예제에는 적합하지 않다. 그냥 조상 클래스를 만드는 문제였다.
 * 
 * <정답>
 * 각 클래스의 공통부분을 뽑아서 Unit클래스를 생성하면 된다. 클래스마다 이동하는 방법이 다르므로 
 * move메서드는 추상메서드로 정의하였다. 책에도 같은 내용이 있기 때 문에 자세한 설명은 생략하겠다.
	
	<모범답안과 차이점>
	move 방식이 다르므로 move()는 추상 메서드로 선언해야하는 문제였다...
 */
