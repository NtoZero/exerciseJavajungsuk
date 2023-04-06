//[11-10] 다음 예제의 빙고판은 1~30사이의 숫자들로 만든 것인데,
//        숫자들의 위치가 잘 섞이지 않는다는 문제가 있다.
//        이러한 문제가 발생하는 이유와 이 문제를 개선하기 위한 방법을 설명하고,
//        이를 개선한 새로운 코드를 작성하시오.

import java.util.*;

class Sol_Exercise11_10 {
    public static void main(String[] args) {
        Set set = new HashSet();
        int[][] board = new int[5][5];

        //⭐ 1~30 사이의 임의의 수를 String 타입으로 25개 만들어서 HashSet 객체에 저장
        for (int i = 0; set.size() < 25; i++) {
            set.add((int) (Math.random() * 30) + 1 + "");
        }
        System.out.println(set);
        //⭐HashSet의 반복자 객체를 it에 저장
        Iterator it = set.iterator();
        //⭐5x5 이차원 배열인 board.length의 행(i)과 열(j)를 순회
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //⭐ set에 저장했던 String타입 요소들이 board[i][j]에 int타입으로 담김
                board[i][j] = Integer.parseInt((String) it.next());
                //⭐ 한자리 숫자는 공백 둘을 주고, 두자리 숫자는 공백 하나 띄고 출력
                System.out.print((board[i][j] < 10 ? "  " : " ")
                        + board[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        //🔥 set 요소의 내용 담기
        List list = new ArrayList(set);
        System.out.println(list);
        //🔥 Collections.sort(list, RandomComparator)로 순서 섞어주기
        Collections.sort(list, new RandomComparator());
        System.out.println(list);
        Iterator it2 = list.iterator();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.valueOf((String) it2.next());
                System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
            }
            System.out.println();


        }

    }// main
}


//🔥 RandomComparator 구현하기
class RandomComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int result = (int)(Math.random()*2); // 0이나 1 반환
        return (result==0)? -1 : 1; // 0이 나왔을 경우 -1 반환. 즉, -1이나 1을 반환한다.
    }
}


/*
<풀이 접근>
빙고판의 숫자의 위치가 잘 섞이지 않는 이유는
자료구조로 Set을 구현한 HashSet을 사용했기 때문이다.
Set은 저장순서를 유지하지않으며, 중복을 허용하지 않는다.
이 중, 저장순서를 유지하지 않는다는 점이 순서를 섞어도 저장되지 않는 문제를 발생시킨다.
정확히는 Set이 독자적인 규격으로 String 요소를 저장하고 있기 때문에
결과적으로 1~30의 난수를 발생시켰음에도 불구하고 비슷한 위치에 해당 숫자가 들어가게 된것이다.

따라서 랜덤 생성된 그대로 저장순서를 유지하기 위해서는 Set을 List 타입으로 변경할 수 있다.
방법으로는 ArrayList 객체를 구현해서 arrayList.addAll(Collection c)를 사용하던지,
List list = new ArrayList(Collection c) 생성자로 변환하면 저장 순서를 유지할 수 있을 것이다.

🔥🔥🔥 단, set이 이미 난수를 add하기 전에 List로 바뀌어 있어야 한다.
🔥🔥🔥 단, 빙고는 숫자의 중복을 허용하지 않아야 한다.
위의 두 가지 문제를 해결해야 하기 때문에 set으로 바꾸기 전 List로 바꾼다는 생각은 하지 않는다.
set을 List에 그대로 담고 랜덤 Comparator로 섞어주면 어떨까?
랜덤 Comparator는 1과 -1만을 5:5 비율로 리턴하는 int compare(Object o1, Object o2)를 가지고 있는거지...
➡️ 성공적이었다.

 */

/*
<모범풀이>
import java.util.*;

class Exercise11_10_2 {
    public static void main(String[] args) {
        Set set = new HashSet();
        int[][] board = new int[5][5];

        for (int i = 0; set.size() < 25; i++) {
            set.add((int) (Math.random() * 30) + 1 + "");
        }

        //⭐ HashSet에 저장된 요소들을 ArrayList에 옮긴다.
        ArrayList list = new ArrayList(set);
        //⭐⭐ Collections.shuffle을 이용해 섞어준다.
        Collections.shuffle(list);

        //⭐반복자를 이용해 출력한다.
        Iterator it = list.iterator();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt((String) it.next());
                System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
            }
            System.out.println();
        }
    } // main
}

<해설>
[해설] 중복된 값을 허용하지 않는 다는 특성을 이용해서 HashSet에 서로 다른 임의의 값 을 저장하는 것까지는 좋았는데,
⭐해싱알고리즘의 특성상 같은 값은 같은 자리에 저장되기 때문에 빙고판의 숫자들이 잘 섞이지 않는다는 문제가 발생하였다.
그래서 저장순서를 유지하는 ArrayList에 HashSet의 데이터를 옮겨 담은 다음,
Collections.shuffle()을 이용해서 저장된 데이터들의 순서를 뒤섞었다.

이처럼 대부분의 컬렉션 클래스들은 다른 컬렉션으로 데이터를 쉽게 옮길 수 있게 설계되어 있다.


💡매개변수의 타입이 Collection인터페이스이므로 Collection 인터페이스의 자손인 List인터페이스와
Set인터페이스를 구현한 모든 클래스의 인스턴스가 매개변수로 가능하다.
ArrayList(Collection<? extends E> c)
LinkedList(Collection<? extends E> c)
Vector(Collection<? extends E> c)
HashSet(Collection<? extends E> c)
TreeSet(Collection<? extends E> c)
LinkedHashSet(Collection<? extends E> c)


 */