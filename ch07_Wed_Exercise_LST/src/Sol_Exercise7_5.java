/* 다음의 코드는 컴파일하면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기 위해서는 코드를 어떻게 바꾸어야 하는가? */

//class Product {
//	int price;
//
//	int bonusPoint; // 제품구매 시 제공하는 보너스점수
//
//	Product(int price) {
//		this.price = price;
//		bonusPoint = (int) (price / 10.0);
//	}
//}
//
//class Tv extends Product {
//	Tv() {
//	}
//
//	public String toString() {
//		return "Tv";
//	}
//}
//
//class Exercise7_5 {
//	public static void main(String[] args) {
//		Tv t = new Tv();
//	}
//}
