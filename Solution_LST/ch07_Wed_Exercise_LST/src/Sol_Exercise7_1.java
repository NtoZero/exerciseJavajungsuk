//[7-1] 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)을 정의한 것이다.
//		섯다카드 20장을 담는 SutdaCard배열을 초기화하시오. 
// 		단, 섯다카드는 1부터 10까지의 숫자 가 적힌 카드가 한 쌍씩 있고,
//		숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광(Kwang)이 어야 한다.
//		즉, SutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다.
class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		/*
		 * (1) 배열 SutdaCard를 적절히 초기화 하시오.
		 */
		for(int i=0; i<cards.length; i++) {
			int num = (i+1)%10; // num은 1~9까지 수
				if(num==0) num=10;	//num이 0일 경우 10으로 변환. num은 1~10까지의 수
			cards[i] = new SutdaCard(num, (i<10)&&((num==1)||(num==3)||(num==8))); //🔥🔥🔥 조건식 자체를 boolean으로 반환
		}
	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) 
		{ this.num = num;
		this.isKwang = isKwang;
	}

	// info()대신 Object클래스의 toString()을 오버라이딩했다. 
	public String toString() {
	return num+(isKwang?"K":"");	//🔥isKwang이 true이면 num 옆에 K를 덧붙임.
	}
}

class Sol_Exercise7_1 {
	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();

		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
	}
}

//결과 : 1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10,ㄴ