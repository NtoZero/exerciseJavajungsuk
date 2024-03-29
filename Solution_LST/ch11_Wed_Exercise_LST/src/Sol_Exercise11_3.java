//[11-3] 다음 중
//        ArrayList에서 제일 비용이 많이 드는 작업은? 단,
//        작업도중에 ArrayList의 크기 변경이 발생하지 않는다고 가정한다.
//        a.	첫 번째 요소 삭제
//        b.	마지막 요소 삭제
//        c.	마지막에 새로운 요소 추가
//        d.	중간에 새로운 요소 추가

/*
<풀이>
ArrayList는 리스트를 배열 형태로 구현하였다.
순차적인 추가/삭제와 접근성에 뛰어난 속도를 보이며,
비순차적인 추가/삭제에 비효율성을 보인다.

따라서 b,c는 제외하고 a,d를 생각해봐야한다.
답은 a이다.
왜냐하면, 첫 번째 요소를 삭제하면 그 뒤의 모든 요소들이 한 칸씩 앞으로 당겨지기 때문이다.
이 상황이 가장 비용이 많이 든다.
 */

/*[정답] a
        [해설] ArrayList는 배열을 기반으로 하고, 배열은 크기를 변경할 수 없기 때문에 저장할 공간이 부족하면 새로운 배열을 만들고 내용을 복사해야하므로 많은 비용이 든다.
        그리고 배열의 중간에 새로운 요소를 추가 또는 삭제하는 것은 다른 요소들을 이동시켜 야하기 때문에 배열을 새로 생성하는 것보다는 적지만 역시 비용이 많이 드는 작업이다.
        특히 배열의 첫 번째 요소를 삭제하면, 빈자리를 채우기 위해 나머지 모든 요소들을 이 동시켜야 하기 때문에 많은 비용이 든다.
        반면에 ArrayList의 마지막에 요소를 추가 또는 삭제하는 것은 다른 요소들을 이동시킬 필요가 없기 때문에 아주 적은 비용만으로 처리가 가능하다.*/
