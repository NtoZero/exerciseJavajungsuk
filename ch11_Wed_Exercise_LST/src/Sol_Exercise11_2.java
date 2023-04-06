//[11-2] 다음 코드의 실행결과를 적으시오.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

class Sol_Exercise11_2 {
    public static void main(String[] args) {
        //⭐ArrayList는 저장순서 유지, 중복 허용 3,6,2,2,2,7
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(7);

        //⭐HashSet은 저장순서X, 중복X 3,6,2,7
        HashSet set = new HashSet(list);
        //⭐TreeSet은 저장할 때 정렬됨. 중복X 2,3,6,7
        TreeSet tset = new TreeSet(set);
        //⭐Stack은 LIFO, 후입선출
        Stack stack = new Stack();
        stack.addAll(tset);

        //⭐stack이 empty할 때까지 stack.pop()으로 후입선출 7, 6, 3, 2
        while(!stack.empty()) System.out.println(stack.pop());
    }
}

/*
<해설>
[해설] 각 컬렉션 클래스들의 특징을 이해하고 있는지 확인하는 문제이다. ArrayList는 중복을 허용하고 저장순서를 유지한다.
HashSet은 중복을 허용하지 않기 때문에 중복요소 들은 저장되지 않는다.
그래서 HashSet에는 2,6,3,7이 저장된다.(HashSet은 저장순서를 유지하지 않는 다는 사실을 잊지 말자)
⭐HashSet set = new HashSet(list); // 중복요소들이 제거되고 순서유지 안됨 2,6,3,7

TreeSet은 정렬해서 저장하기 때문에, 그리고 따로 정렬기준을 주지 않았기 때문에 숫자 의 기본정렬인 오름차순으로 정렬한다. 그래서 2,3,6,7이 된다.
⭐TreeSet tset = new TreeSet(set); // 오름차순으로 정렬된다. 2,3,6,7

Stack은 FILO구조(처음 넣은 것이 마지막에 나오는 구조)로 되어 있기 때문에 TreeSet의 모든 요소들을 저장한 다음 다시 꺼내면 저장한 순서와 반대가 된다.
⭐
Stack stack = new Stack(); // Stack에 넣었다 꺼내면 저장순서가 반대가 된다.
stack.addAll(tset);     // TreeSet의  저장된 모든 요소를  stack에 담는다.
while(!stack.empty())
    System.out.println(stack.pop()); // stack에 저장된 값을 하나씩 꺼낸다.

 */

