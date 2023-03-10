/* 다음의 코드는 컴파일하면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기 위해서는 코드를 어떻게 바꾸어야 하는가? */

class Product10 {
	int price;

	int bonusPoint; // 제품구매 시 제공하는 보너스점수

	public Product10() {
		// TODO Auto-generated constructor stub
	}
	
	Product10(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}

class Tv10 extends Product10 {
	Tv10() {
		//super()가 호출된다.
	}

	public String toString() {
		return "Tv";
	}
}

class Exercise7_5 {
	public static void main(String[] args) {
		Tv t = new Tv();
	}
}


/*
 * <내 풀이> 자손 클래스의 생성자는 첫 줄에 반드시 조상 클래스의 생성자를 호출한다. Tv() { }에서 컴파일러가 구현부 안에서
 * super()를 호출하였는데 super()는 존재하지 않고 super(int price)만이 존재하기 때문에 오류가 발생한다.
 * 
 * 따라서 Product 클래스에 Product()를 추가해주거나, Tv 클래스에서 기본생성자 Tv(){}를 Tv(int price){}로
 * 바꿔주면 해결된다.
 * 
 * <모범 답안>
 */
  
 
