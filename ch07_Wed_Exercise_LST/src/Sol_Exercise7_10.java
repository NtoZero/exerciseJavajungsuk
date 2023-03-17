/*
 * [7-10] MyTv2클래스의 멤버변수 isPowerOn, channel, volume을 클래스 외부에서 접근할 수 없도록 
 * 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록 getter와 setter메서드를 추가하라.
 */

class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	/*
	 * (1) 알맞은 코드를 넣어 완성하시오.
	 */
	public boolean getIsPowerOn() {
		return this.isPowerOn;
	}
	public int getChannel() {
		return this.channel;
	}
	public int getVolume() {
		return this.volume;
	}
	
	public void setIsPowerOn(boolean isPowerOn) {
		this.isPowerOn=!isPowerOn;
	}
	
	public void setChannel(int channel) {
		if(channel<0||channel>100) return;
		this.channel = channel;
	}
	
	public void setVolume(int volume) {
		if(volume<1||volume>100) return;
		this.volume = volume;
	}
}

class Sol_Exercise7_10 {
	public static void main(String args[]) {
		MyTv3 t = new MyTv3();

		t.setChannel(10);
		System.out.println("CH:" + t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:" + t.getVolume());
	}
}

//<실행결과>
//CH:10 
//VOL:20

/*
 * <내 풀이>
 * 캡슐화에 관한 문제이다. 내부의 중요한 데이터는 private로 선언하여 직접적으로 접근하지 못하게하고,
 * 게터를 통해 읽을 수 있게한다.
 * 세터를 통해 외부의 매개변수를 받아 내부의 private 변수들을 수정한다. 이 때, 매개변수의 값이 유효한지는 반드시 체크해야한다. 
 * 
 * <내가 잘못 구현한 부분>
 * 기존에 존재하는 static 상수를 활용하지 못하고 그냥 상수값을 유효성검사에 사용했다. 이렇게 하면 최대/최소 상수값들을 바꿔야할 때 작업이 누락된다.
 * if(channel<0||channel>100) return;
 * if(volume<1||volume>100) return; 가 아니라
 * if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) return;
 * if(volume > MAX_VOLUME || volume < MIN_VOLUME) return; 가 되어야 한다.
 */
