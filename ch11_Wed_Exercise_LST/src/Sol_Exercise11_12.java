//[11-12] 다음은 섯다게임에서 카드의 순위를 결정하는 등급목록(족보)이다.
//        HashMap에 등급과 점수를 저장하는 registerJokbo()와
//        게임참가자의 점수를 계산해서 반환하는 getPoint()를 완성하시오.
//        [참고] 섯다게임은 두 장의 카드의 숫자를 더한 값을 10으로 나눈 나머지가 높은 쪽이 이기는 게임이다.
//        그 외에도 특정 숫자로 구성된 카드로 이루어진 등급(족보)이 있어서 높은 등급의 카드가 이긴다.

import java.util.HashMap;

class Exercise11_12 {
    public static void main(String args[]) throws Exception {
        SutdaDeck deck = new SutdaDeck();

        //⭐deck을 섞는다.
        deck.shuffle();
        //⭐p1과 p2가 섞인 덱에 있는 카드를 2개씩 뽑는다.
        Player p1 = new Player("타짜", deck.pick(), deck.pick());
        Player p2 = new Player("고수", deck.pick(), deck.pick());

        //⭐계산한 점수를 알려준다.
        System.out.println(p1 + " " + deck.getPoint(p1));
        System.out.println(p2 + " " + deck.getPoint(p2));
    }
}

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard12[] cards = new SutdaCard12[CARD_NUM];

    int pos = 0; // 다음에 가져올 카드의 위치
    HashMap jokbo = new HashMap(); // 족보를 저장할 HashMap

    SutdaDeck() {
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;
            boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);

            cards[i] = new SutdaCard12(num, isKwang);
        }
        registerJokbo(); // 족보를 등록한다.
    }

    void registerJokbo() {
    /*
    (1)	🔥🔥아래의 로직에 맞게 코드를 작성하시오.
    1. jokbo(HashMap)에 족보를 저장한다.
    두 카드의 값을 문자열로 붙여서 key로, 점수를 value로 저장한다.
    */
    jokbo.put("KK",4000);
    for(int i=10, j=10, n=0; i>0; i--, j--, n+=10) {
       jokbo.put(i+""+j, 3100-n);
    }
    jokbo.put("12",2060);
    jokbo.put("21",2060);
    jokbo.put("14",2050);
    jokbo.put("41",2050);
    jokbo.put("19",2040);
    jokbo.put("91",2040);
    jokbo.put("110",2030);
    jokbo.put("101",2030);
    jokbo.put("410",2020);
    jokbo.put("104",2020);
    jokbo.put("46",2010);
    jokbo.put("64",2010);

    }

    int getPoint(Player p) {
        if (p == null) return 0;

        SutdaCard12 c1 = p.c1;
        SutdaCard12 c2 = p.c2;

        Integer result = 0;

    /*
    (2)	🔥🔥아래의 로직에 맞게 코드를 작성하시오.
    1.	카드 두 장이 모두 광이면, jokbo에서 키를 "KK"로 해서 점수를 조회한다.
    2.	두 카드의 숫자(num)로 jokbo에서 등급을 조회한다.
    3.	해당하는 등급이 없으면, 아래의 공식으로 점수를 계산한다. (c1.num + c2.num) % 10 + 1000
    4.	Player의 점수(point)에 계산한 값을 저장한다.
    */
        if(c1.isKwang&&c2.isKwang) result = (Integer) jokbo.get("KK");
        result = (Integer) jokbo.get(c1.num+""+c2.num); //🔥처음엔 jokbo.get(c1.num+c2.num+"")로 했는데 잘못된 값이 나옴. 덧셈후 문자열로 바뀌기 때문
        if(result==null) result=(c1.num+c2.num)%10 +1000;

        return result.intValue();
    }

    //⭐ card를 0번부터 뽑는 메서드 뽑은 카드 인덱스는 null, pos는+1함.
    SutdaCard12 pick() throws Exception {
        SutdaCard12 c = null;

        if (0 <= pos && pos < CARD_NUM) {
            c = cards[pos];
            cards[pos++] = null;
        } else {
            throw new Exception("남아있는 카드가 없습니다.");
        }

        return c;
    }

    void shuffle() {
        for (int x = 0; x < CARD_NUM * 2; x++) {
            int i = (int) (Math.random() * CARD_NUM);
            int j = (int) (Math.random() * CARD_NUM);

            SutdaCard12 tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
    }
} // SutdaDeck

class Player {
    String name;
    SutdaCard12 c1;
    SutdaCard12 c2;

    int point; // 카드의 등급에 따른 점수 - 새로 추가

    Player(String name, SutdaCard12 c1, SutdaCard12 c2) {
        this.name = name;
        this.c1 = c1;
        this.c2 = c2;
    }

    public String toString() {
        return "[" + name + "]" + c1.toString() + "," + c2.toString();
    }
} // class Player

class SutdaCard12 {
    int num;
    boolean isKwang;

    SutdaCard12() {
        this(1, true);
    }

    SutdaCard12(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

/*
<실행결과>
[타짜]5,9 1004
[고수]1,1K 3010
 */

/*
int getPoint(Player p) {

    if(p==null) return 0;

        SutdaCard c1 = p.c1; SutdaCard c2 = p.c2;

        Integer result = 0; // Integer result = new Integer(0);

//	1. 카드 두 장이 모두 광이면, jokbo에서 키를 "KK"로 해서 점수를 조회한다.
        if(c1.isKwang && c2.isKwang) {
        result = (Integer)jokbo.get("KK");
        } else {
//	2. 두 카드의 숫자(num)로 jokbo에서 등급을 조회한다.
        result = (Integer)jokbo.get(""+c1.num+c2.num);

//	3. 해당하는 등급이 없으면, 아래의 공식으로 점수를 계산한다.
//	(c1.num + c2.num) % 10 + 1000
        if(result==null) {
        result = new Integer((c1.num + c2.num) % 10 + 1000);
        }
        }

//	4. Player의 점수(point)에 계산한 값을 저장한다.
        p.point = result.intValue();

        return result.intValue();
        }
 */

/*
[해설]

registerJokbo()는 단순히 put()을 호출해서 HashMap에 값을 저장하는 것이므로
설명하지 않아도 이해하는데 어려움이 없을 것 같다.
굳이 설명한다면, put(Object key, Object value)에 대한 것인데,
이 메서드의 매개변수 타입을 보면 Object라서 오른쪽의 코드와 같이 wrapper클래스를 써야하는 것이 원칙이다.
그러나 jdk1.5에서 부터 오토박싱기능이 추가되어 컴파일러가 기본형(primitive type)을 자동적으로 wrapper클래스로 변환해준다.
그래서 왼쪽과 같은 코드가 가능한 것이다. 왼쪽과 같이 코드를 작성해도 컴파일러가 오른쪽과 같은 코드로 자동 변환해주는 것이 다.
jokbo.put("KK", 4000); <--> jokbo.put("KK", new Integer(4000);
 */