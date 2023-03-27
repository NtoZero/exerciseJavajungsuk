//[9-2] 다음과 같은 실행결과를 얻도록 Point3D클래스의 equals()를 멤버변수인 x, y, z 의 값을 비교하도록 오버라이딩하고,
//        toString()은 실행결과를 참고해서 적절히 오버라이딩하시오.
class Sol_Exercise9_2 {
    public static void main(String[] args) {
        Point3D p1 = new Point3D(1,2,3);
        Point3D p2 = new Point3D(1,2,3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("p1==p2?"+(p1==p2)); //⭐ '=='은 주소값끼리 비교한다.
        System.out.println("p1.equals(p2)?"+(p1.equals(p2))); //⭐ 오버라이딩된 equals는 iv비교!
    }
}

class Point3D { int x,y,z;

    Point3D(int x, int y, int z) { this.x=x;
        this.y=y; this.z=z;
    }

    Point3D() {
        this(0,0,0);
    }

    public boolean equals(Object obj) {
        /*
        (1)	인스턴스변수 x, y, z를 비교하도록 오버라이딩하시오.
        */
        if(!(obj instanceof Point3D)) return false;
        Point3D p3D = (Point3D) obj;
        return (this.x==p3D.x)&&(this.y== p3D.y)&&(this.z==p3D.z);
    }

    public String toString() {
        /*
        (2)	인스턴스변수 x, y, z의 내용을 출력하도록 오버라이딩하시오.
        */
//      💡찾아보니 printf와 비슷한 기능을하는 String.format메소드가 있었다. 이 메서드는 printf처럼 콘솔에 출력되는 것이 아니라, String을 반환한다.
        return  String.format("[%d, %d, %d]", x, y, z);
    }
}
/*
[1,2,3]
[1,2,3]
p1==p2?false
p1.equals(p2)?true
 */

/*
<문제접근>
⭐equals, toString()를 적절히 오버라이딩 할 수 있는지 묻는 문제이다.
toString()을 오버라이딩 할 때는 해당 객체의 인스턴스 변수 값을 return하도록 오버라이딩 한다.
 */

// <❓궁금증> printf를 사용하면 결과물 출력이 편할 것 같은데 String이 아닌 void로 반환하네. 비슷하게 String을 반환하는 메서드는 없나?
// 💡찾아보니 printf와 비슷한 기능을하는 String.format메소드가 있었다. 이 메서드는 printf처럼 콘솔에 출력되는 것이 아니라, String을 반환한다.

/*
<정답>
public boolean equals(Object obj) {
    if(obj instanceof Point3D) { Point3D p =(Point3D)obj;
        return x==p.x && y==p.y && z==p.z;
    }

    return false;
}

    public String toString() {
        return "["+x+","+y+","+z+"]";
    }
}
 */
