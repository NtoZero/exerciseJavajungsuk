//[12-5] 아래는 예제7-3에 열거형 Kind와 Number를 새로 정의하여 적용한 것이다. (1)에 알맞은 코드를 넣어 예제를 완성하시오.
// (Math.random()을 사용했으므로 실행결과가 달라 질 수 있다.)

class DeckTest {
    public static void main(String args[]) {

        Deck d = new Deck();
        Card c = d.pick(0);

// 카드 한 벌(Deck)을 만든다.
// 섞기 전에 제일 위의 카드를 뽑는다.

        System.out.println(c);    // System.out.println(c.toString());과 같다.


        d.shuffle();
        c = d.pick(0);
        System.out.println(c);
    }
}

// 카드를 섞는다.
// 섞은 후에 제일 위의 카드를 뽑는다.


class Deck {
    final int CARD_NUM = Card.Kind.values().length
            * Card.Number.values().length; // 카드의 개수
    Card cardArr[] = new Card[CARD_NUM]; // Card객체 배열을 포함

    Deck() {
    /*
        ⭐⭐(1) 알맞은 코드를 넣어서 완성하시오. Deck의 카드를 초기화한다.
    */
        int i=0;
        //⭐Card 클래스 내부에 선언된 열거형 Kind 타입 kind를 Card.Kind.values()로 배열을 받아와 꺼내기
        for(Card.Kind kind : Card.Kind.values()) {
            //⭐ Card 내부 열거형 Number타입 num에 Card.Number.values()를 순회해서 받아오기
            for(Card.Number num : Card.Number.values()) {
                cardArr[i++] = new Card(kind, num);
            }
        }
    }

    Card pick(int index) {    // 지정된 위치(index)에 있는 카드 하나를 꺼내서 반환
        return cardArr[index];
    }

    Card pick() {    // Deck에서 카드 하나를 선택한다.
        int index = (int) (Math.random() * CARD_NUM);
        return pick(index);
    }

    void shuffle() { // 카드의 순서를 섞는다.
        for (int i = 0; i < cardArr.length; i++) {
            int r = (int) (Math.random() * CARD_NUM);
            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
} // Deck클래스의 끝

// ⭐ Card클래스
class Card {

//⭐ 열거형 Kind 선언
enum Kind {CLOVER, HEART, DIAMOND, SPADE}

//⭐ 열거형 Number 선언
enum Number {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

    Kind kind;
    Number num;

    Card() {
        this(Kind.SPADE, Number.ACE);
    }

    Card(Kind kind, Number num) {
        this.kind = kind;
        this.num = num;
    }

    public String toString() {
        return "[" + kind.name() + "," + num.name() + "]";
    } // toString()의 끝
} // Card클래스의 끝

/*
<실행결과>
[CLOVER,ACE] [HEART,TEN]
 */

/*
<정답>
int i=0;

        for(Card.Kind kind : Card.Kind.values()) {
            for(Card.Number num : Card.Number.values()) {
            cardArr[i++] = new Card(kind, num);
            }
        }
 */


