//[7-23] 문제7-22에서 정의한 클래스들의 면적을 구하는 메서드를 작성하고 테스트 하시오.

//1.	메서드명 : sumArea
//기	능 : 주어진 배열에 담긴 도형들의 넓이를 모두 더해서 반환한다. 
//반환타입 : double
//매개변수 : Shape[] arr

//class Exercise7_23
//{
///*
//(1) sumArea메서드를 작성하시오.
//*/
//
//public static void main(String[] args)
//{
//Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)}; 
//System.out.println("면적의 합:"+sumArea(arr));
//}
//}

//면적의 합:93.68140899333463

class Sol_Exercise7_23 {
	/*(1) sumArea메서드를 작성하시오.*/
	static double sumArea(Shape1[] arr) {
		double result = 0;
		for(int i=0; i<arr.length; i++) {
			 result += arr[i].calcArea();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Shape1[] arr = {new Circle1(5.0), new Rect(3,4), new Circle1(1)}; 
		System.out.println("면적의 합:"+sumArea(arr));
	}
}

class Rect extends Shape1 {
	double width;
	double height;

	Rect(double width, double height) {
		this(new Point(0, 0), width, height);
	}

	Rect(Point p, double width, double height) {
		super(p); // 조상의 멤버는 조상의 생성자가 초기화하도록 한다. 
		this.width = width;
		this.height = height;
	}

	boolean isSquare() {
		// width나 height가 0이 아니고 width와 height가 같으면 true를 반환한다. 
		return width*height!=0 && width==height;
	}

	double calcArea() {
		return width * height;
	}
}

class Circle1 extends Shape1 {
	double r; // 반지름

	Circle1(double r) {
		this(new Point(0, 0), r); // Circle(Point p, double r)를 호출
	}

	Circle1(Point p, double r) {
		super(p); // 조상의 멤버는 조상의 생성자가 초기화하도록 한다. 
		this.r = r;
	}

	double calcArea() {
		return Math.PI * r * r;
	}
}

abstract class Shape1 {
	Point p;

	Shape1() {
		this(new Point(0, 0));
	}

	Shape1(Point p) {
		this.p = p;
	}

	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드

	Point getPosition() {
		return p;
	}

	void setPosition(Point p) {
		this.p = p;
	}
}

class Point1 {
	int x;
	int y;

	Point1() {
		this(0, 0);
	}

	Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
