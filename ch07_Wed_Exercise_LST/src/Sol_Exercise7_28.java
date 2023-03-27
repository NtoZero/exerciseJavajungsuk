// [7-28] 아래의 EventHandler를 익명 클래스(anonymous class)로 변경하시오.

import java.awt.*;
import java.awt.event.*;

class Exercise7_28 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.addWindowListener(new WindowAdapter () {
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});
	}
}

class EventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}
}

/*
 * <내 풀이접근>
 * 9행의 f.addWindowListener()의 매개변수로 어떤 것을 요구하고 있는지가 중요하다.
 * 이는 추상 클래스 WindowAdapter를 요구하고 있는데 이 추상클래스를 구현한 클래스의 객체를 인수로 전달하고자
 * EventHandler라는 별도의 객체를 만든 것이다.
 * 그러나 EventHandler는 일회용 클래스이기 때문에 차라리 이를 만들지 않고 
 * WindowAdapter 클래스를 익명클래스화하여 인수로 전달하는 것이 더 나은 선택이다.
 * 익명 클래스는 new 조상클래스(){ }로 선언한다.
 * 해당 구현부 안에 원래 넣고자 했던 코드를 작성하면 끝.	//이 경우에는 public void windowClosing(WindowEvent e)의 정의부와 구현부 전체
 * 
 * 
 * 
 */
