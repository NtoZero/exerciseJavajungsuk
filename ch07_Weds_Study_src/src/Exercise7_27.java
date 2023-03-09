// [7-27] 다음과 같은 실행결과를 얻도록 (1)~(4)의 코드를 완성하시오.

class Outer8 {
	int value = 10;

	class Inner {
		int value = 20;

		void method1() {
			int value = 30;

			System.out.println(/* (1) */);
			System.out.println(/* (2) */);
			System.out.println(/* (3) */);
		}
	} // Inner클래스의 끝
} // Outer클래스의 끝

class Exercise7_27 {
	public static void main(String args[]) {
		/*
		 * (4) 알맞은 코드를 넣어 완성하시오.
		 */

		inner.method1();
	}
}

/*
 * <실행결과>
 * 30
 * 20
 * 10
 */
