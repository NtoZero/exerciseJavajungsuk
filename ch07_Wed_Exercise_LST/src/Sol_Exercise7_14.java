//[7-14] 문제7-1에 나오는 섯다카드의 숫자와 종류(isKwang)는 사실 한번 값이 지정되면
//변경되어서는 안 되는 값이다. 카드의 숫자가 한번 잘못 바뀌면 똑같은 카드가 두 장이
//될 수 도 있기 때문이다. 이러한 문제점이 발생하지 않도록 아래의 SutdaCard를 수정하시 오.

class SutdaCard3 {
	private final int NUM;	//🔥해당 객체값을 변경하지 못하도록 iv의 접근제어자를 private와 final로 선언
	private final boolean isKwang; //🔥 private로 선언하면 외부클래스에서는 접근이 불가능, final로 선언하면 메서드를 통해서도 값 변경 불가능. 

	SutdaCard3() {		//🔥생성자를 통해서는 기존 인스턴스 멤버에 접근 가능하다.
		this(1, true);
	}

	SutdaCard3(int num, boolean isKwang) {
		this.NUM = num;
		this.isKwang = isKwang;
	}

	public String toString() {
		return NUM + (isKwang ? "K" : "");
	}
}

class Sol_Exercise7_14 {
	public static void main(String args[]) {
		SutdaCard3 card = new SutdaCard3(3, true);
		System.out.println(card.toString());
		//card.num = 1; // 🔥private로 선언했으므로 애초에 접근 불가능. 접근한다고 하더라도 final이므로 수정 불가능.
	}
}

/* 
 * 단, 궁금증이 생긴다.
 * SutdaCard3에서 final로 num와 isKwang을 선언했을 때 자동초기화로 0이나 false가 되지 않는가?
 * 그 상태에서 생성자로 num, isKwang을 수정하는 원리가 어떤 것일까?
 * 생각해보니, 인스턴스 변수가 생성되는 시점은 인스턴스가 생성된 그 시점이다. 
 * 따라서 두 변수는 final로 선언만 되었을 뿐 초기화된 시점이 아니기 때문에 
 * 두 변수가 메인단에서 이상 없이 final 상수로써 초기화 될 수 있는 것이다.
 */
