/*
 * [7-11] 문제7-10에서 작성한 MyTv2클래스에 이전 채널(previous channel)로 이동하는 기능의 메서드를 추가해서
 * 실행결과와 같은 결과를 얻도록 하시오. [Hint] 이전 채널의 값을 저장할 멤버변수를 정의하라.
 * 
 * 
 * 메서드명 : gotoPrevChannel 
 * 기 능 : 현재 채널을 이전 채널로 변경한다. 
 * 반환타입 : 없음 매개변수 : 없음
 */

class MyTv2 {
	/*
	 * (1) 문제7-10의 MyTv2클래스에 gotoPrevChannel메서드를 추가하여 완성하시오.
	 */
}

class Exercise7_11 {
	public static void main(String args[]) {
		MyTv2 t = new MyTv2();

		t.setChannel(10);
		System.out.println("CH:" + t.getChannel());
		t.setChannel(20);
		System.out.println("CH:" + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());
	}
}

//<실행결과>
//CH:10 
//CH:20 
//CH:10 
//CH:20