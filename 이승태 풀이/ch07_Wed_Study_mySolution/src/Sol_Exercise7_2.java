
//  [7-2] 문제7-1의 SutdaDeck클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트 하 시오. [주의]
//  Math.random()을 사용하는 경우 실행결과와 다를 수 있음.
//  
//  1. 메서드명 : shuffle 기 능 : 배열 cards에 담긴 카드의 위치를 뒤섞는다.(Math.random()사용) 반환타입 : 없음
//  매개변수 : 없음
//  
//  2. 메서드명 : pick 기 능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다. 반환타입 : SutdaCard
//  매개변수 : int index - 위치
//  
//  3. 메서드명 : pick 기 능 : 배열 cards에서 임의의 위치의 SutdaCard를 반환한다.(Math.random()사용)
//  반환타입 : SutdaCard 매개변수 : 없음
//  
//  <실행결과>
//  1K
//	7
//	2,6,10,1K,7,3,10,5,7,8,5,1,2,9,6,9,4,8K,4,3K,
//	2
//
// 

class SutdaDeck2 {
	final int CARD_NUM = 20;
	SutdaCard2[] cards = new SutdaCard2[CARD_NUM];

	SutdaDeck2() {
		/*
		 * (1) 배열 SutdaCard를 적절히 초기화 하시오.
		 */
		for(int i=0; i<cards.length; i++) {
			int num = (i+1)%10; // num은 1~9까지 수
				if(num==0) num=10;	//num이 0일 경우 10으로 변환. num은 1~10까지의 수
			cards[i] = new SutdaCard2(num, (i<10)&&((num==1)||(num==3)||(num==8))); //🔥🔥🔥 조건식 자체를 boolean으로 반환
		}
	}

	/*
	 * (1) 위에 정의된 세 개의 메서드를 작성하시오.
	 */
	void shuffle() {
		int randomIdx = (int)(Math.random()*cards.length); //random은 0부터 카드개수-1까지 임의 정수 반환
		for(int i=0; i<cards.length; i++) {
			SutdaCard2 tmp = cards[i];	//임시 참조변수 tmp에 cards 배열의 i번째 요소 담기
			cards[i] = cards[randomIdx]; //cards[i]의 공간에 cards[랜덤인덱스] 담기
			cards[randomIdx] = tmp;
		}
	}
	
	SutdaCard2 pick(int index) {
		return cards[index];
	}
	
	SutdaCard2 pick() {
		int randomIdx = (int)(Math.random()*cards.length); // 사실 랜덤인덱스 지역변수는 인스턴스 변수로 빼면 중복을 줄일 수 있다.
		return cards[randomIdx];
	}
	
} // SutdaDeck

class SutdaCard2 {
	int num;
	boolean isKwang;

	SutdaCard2() {
		this(1, true);
	}

	SutdaCard2(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

class Sol_Exercise7_2 {
	public static void main(String args[]) {
		SutdaDeck2 deck = new SutdaDeck2();

		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();

		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");

		System.out.println();
		System.out.println(deck.pick(0));
	}
}
