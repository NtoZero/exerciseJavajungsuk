//[12-4] 아래의 메서드는 두 개의 ArrayList를 매개변수로 받아서,
//        하나의 새로운 ArrayList로 병합하는 메서드이다.
//        이를 지네릭 메서드로 변경하시오.

public static ArrayList<?extends Product> merge( ArrayList<?extends Product> list, ArrayList<?extends Product> list2)
        {
            ArrayList<?extends Product> newList = new ArrayList<>(list);
            newList.addAll(list2);
            return newList;
        }

