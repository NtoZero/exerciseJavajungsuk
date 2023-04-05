//[11-9] 문제11-8의 Student클래스에 반등수(classRank)를 저장하기 위한 인스턴스변수
//        를 추가하였다. 반등수를 계산하고 반과 반등수로 오름차순 정렬하여 결과를 출력하시오.
//        (1)~(2)에 알맞은 코드를 넣어 완성하시오.

import java.util.*;

class Student implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;


    int total;
    int schoolRank;


// 전교등수

    int classRank; // 반등수

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        total = kor + eng + math;
    }

    int getTotal() {
        return total;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student tmp = (Student) o;

            return tmp.total - this.total;
        } else {
            return -1;
        }
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
                + "," + schoolRank

                + "," + classRank
                ;
    }

// 새로추가

} // class Student

class ClassTotalComparator implements Comparator {
    public int compare(Object o1, Object o2) {
/*
(1)	알맞은 코드를 넣어 완성하시오.
*/
    }
}

class Exercise11_9 {
    public static void calculateClassRank(List list) {
// 먼저 반별 총점기준 내림차순으로 정렬한다. Collections.sort(list, new ClassTotalComparator());

        int prevBan = -1;
        int prevRank = -1;
        int prevTotal = -1;
        int length = list.size();

        /*
        (2)	아래의 로직에 맞게 코드를 작성하시오.
        1.	반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
        1.1	반이 달라지면,(ban과 prevBan이 다르면)
        이전 등수(prevRank)와 이전 총점(prevTotal)을 초기화한다.
        1.2	총점(total)이 이전총점(prevTotal)과 같으면
        이전 등수(prevRank)를 등수(classRank)로 한다.
        1.3	총점이 서로 다르면,
        등수(classRank)의 값을 알맞게 계산해서 저장한다.
        이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야 한다. (실행결과 참고)
        1.4	현재 반과 총점과 등수를 이전 반(prevBan),
        이전 총점(prevTotal), 이전 등수(prevRank)에 저장한다.
        */
            } //public static void calculateClassRank(List list) {
        public static void calculateSchoolRank(List list) {
            /* 내용 생략 */
        }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student("이자바", 2, 1, 70, 90, 70));
        list.add(new Student("안자바", 2, 2, 60, 100, 80));
        list.add(new Student("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student("김자바", 1, 2, 80, 80, 90));
        calculateSchoolRank(list);
        calculateClassRank(list);
        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}

/*
<실행결과>
홍길동,1,3,100,100,100,300,100.0,1,1
김자바,1,2,80,80,90,250,83.3,2,2
남궁성,1,1,90,70,80,240,80.0,3,3
안자바,2,2,60,100,80,240,80.0,3,1
이자바,2,1,70,90,70,230,76.7,5,2
 */