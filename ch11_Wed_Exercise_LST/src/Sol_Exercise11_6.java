//[11-6] 다음의 코드는 성적평균의 범위별로 학생 수를 세기 위한 것이다.
// TreeSet이 학생들의 평균을 기준으로 정렬하도록 compare(Object o1, Object o2)와
// 평균점수의 범위를 주면 해당 범위에 속한 학생의 수를 반환하는 getGroupCount()를 완성하라.
// [Hint] TreeSet의 subSet(Object from, Object to)를 사용하라.

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Student6 implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student6(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    public String toString() {
        return name
                + "," + ban
                + "," + no
                + "," + kor
                + "," + eng
                + "," + math
                + "," + getTotal()
                + "," + getAverage()
                ;
    }

    public int compareTo(Object o) {
        if (o instanceof Student6) {
            Student6 tmp = (Student6) o;

            return name.compareTo(tmp.name);
        } else {
            return -1;
        }
    }
} // class Student

class Sol_Exercise11_6 {
    static int getGroupCount(TreeSet tset, float from, float to) {
    /*
    (1)	알맞은 코드를 넣어 완성하시오.
    */
        //🔥 tset에 담긴 Student 객체 값들의 평균을 꺼내와 집합에 저장한다.
        //🔥 Set을 참조변수의 타입으로 선언하면 안된다. subSet()으로 범위 탐색할 것이기 때문.
        TreeSet avgSet = new TreeSet();
        Iterator it = tset.iterator();
        while(it.hasNext()) {
            Object tmp = it.next();
            if(tmp instanceof Student6) {
                Student6 stud = (Student6) tmp;
                avgSet.add(stud.getAverage());
            } else return -1;   //형변환 자체가 안되면 -1 반환
        }

        //🔥 범위 검색이므로 tset.subSet(int from, int to)를 활용한다.
        //🔥 그것의 사이즈를 반환하면 되는 것이다.
        return avgSet.subSet(from, to).size();

        /*Student6 s1 = new Student6("",0,0,from,from,from);
        Student6 s2 = new Student6("",0,0,to,to,to);
        return tset.subSet(s1,s2).size();*/

    }

    public static void main(String[] args) {
        //🔥 익명클래스로 Comparator 인스턴스 구현!
        TreeSet set = new TreeSet(new Comparator() {
            public int compare(Object o1, Object o2) {
            /*
            (2)	알맞은 코드를 넣어 완성하시오.
            */
                if (o1 instanceof Student6 && o2 instanceof Student6) {
                    Student6 s1 = (Student6) o1;
                    Student6 s2 = (Student6) o2;
                    //🔥 3항 연산자 사용하여 평균값을 기준으로 정렬하기
                    return s1.getAverage() > s2.getAverage() ? 1 : (s1.getAverage() == s2.getAverage() ? 0 : -1);
                } else return -1;
            }
        });




        set.add(new Student6("홍길동", 1, 1, 100, 100, 100));
        set.add(new Student6("남궁성", 1, 2, 90, 70, 80));
        set.add(new Student6("김자바", 1, 3, 80, 80, 90));
        set.add(new Student6("이자바", 1, 4, 70, 90, 70));
        set.add(new Student6("안자바", 1, 5, 60, 100, 80));
        Iterator it = set.iterator();
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("[60~69] :" + getGroupCount(set, 60, 70));
        System.out.println("[70~79] :" + getGroupCount(set, 70, 80));
        System.out.println("[80~89] :" + getGroupCount(set, 80, 90));
        System.out.println("[90~100] :" + getGroupCount(set, 90, 101));
    }
}

/*
이자바,1,4,70,90,70,230,76.7
남궁성,1,2,90,70,80,240,80.0
김자바,1,3,80,80,90,250,83.3
홍길동,1,1,100,100,100,300,100.0
//근데 왜 안자바는 출력안됨?
    ➡️⭐ TreeSet set은 getAverage로 비교하여 정렬하도록 구현해 놓았다.
    안자바의 평균값이 남궁성과 같으므로, 0을 리턴한다.
    따라서 중복된 값을 허용하지 않는 TreeSet의 특성으로 False를 반환하며 add되지 않는 것이다.

[60~69] :0
[70~79] :1
[80~89] :2
[90~100] :1
 */

/*
<풀이 접근>
⭐ '범위에 속한 학생의 수 반환'이라는 측면은 결국 '범위 탐색'을 이용한다.
따라서 TreeMap이나 TreeSet을 이용해야 한다.
현 클래스에서는 ⭐TreeSet을 사용했고, 검색 방법으로 subSet(Object from, Object to)을 사용할 수 있다.

⭐ compare(Object o1, Object o2)는 Comparator를 구현했을 때 구현해야하는 추상메서드이다.
compare(Object o1, Object o2)는 학생의 평균을 기준으로 구현하는 메서드이므로,
Object o1과 Object o2를 각각 Student로 형변환 시킬 수 있는 지 형변환 검사이후,
각각의 o1.평균 - o2.평균 값을 리턴해주면 될 것이다.
o1.평균이 더 작다면 음수, 같다면 0, 크다면 양수를 반환하기 때문에 해당 값들의 비교로 정렬이 가능해진다. (두 개씩 비교하면됨)

⭐ getGroupCount는 평균점수의 범위를 주면 해당 범위에 속한 학생 수를 반환하는 메서드이다.

<이 문제의 풀이과정는 블로그에 기록해두었다. 꼭 다시 보자>
https://velog.io/@9to0/%EC%9E%90%EB%B0%94%EC%9D%98-%EC%A0%95%EC%84%9D-4%ED%8C%90-11-%EC%97%B0%EC%8A%B5%EB%AC%B8%EC%A0%9C-%EC%BB%AC%EB%A0%89%EC%85%98-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8D

 */