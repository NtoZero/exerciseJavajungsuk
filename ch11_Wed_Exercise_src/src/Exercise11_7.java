// [11-7] 다음에 제시된
// BanNoAscending클래스를 완성하여, ArrayList에 담긴 Student인스턴스들이
// 반(ban)과 번호(no)로 오름차순 정렬되게 하시오.
// (반이 같은 경우 번호를 비교해서 정렬한다.)

import java.util.*;

class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
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
} // class Student

class BanNoAscending implements Comparator {
    public int compare(Object o1, Object o2) {
/*
(1)	알맞은 코드를 넣어 완성하시오.
*/
    }
}

class Exercise11_7 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student9("이자바", 2, 1, 70, 90, 70));
        list.add(new Student9("안자바", 2, 2, 60, 100, 80));
        list.add(new Student9("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student9("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student9("김자바", 1, 2, 80, 80, 90));
        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}

/*
<실행결과>
남궁성,1,1,90,70,80,240,80.0
김자바,1,2,80,80,90,250,83.3
홍길동,1,3,100,100,100,300,100.0
이자바,2,1,70,90,70,230,76.7
안자바,2,2,60,100,80,240,80.0
 */