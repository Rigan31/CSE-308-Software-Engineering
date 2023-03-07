import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {


    public List<Integer> generateList(int min, int max, int n){
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int random_number = (int) Math.floor(Math.random()*(max-min+1)+min);
            list.add(random_number);
        }

        return list;
    }

    HashMap<Integer, Integer> getHashMap(List<Integer> arr){
        HashMap<Integer, Integer> source = new HashMap<>();

        for(int i = 0; i < arr.size(); i++){
            if(source.get(arr.get(i)) == null){
                source.put(arr.get(i), 1);
            }
            else{
                source.put(arr.get(i), source.get(arr.get(i)) + 1);
            }
        }

        return source;
    }

    public int isValid( List<Integer> testArr, List<Integer> sortedArr){
        HashMap<Integer, Integer> map1 = getHashMap(testArr);
        HashMap<Integer, Integer> map2 = getHashMap(sortedArr);

            if(!map1.equals(map2)){
                return 0;
            }

            for(int i = 0; i < sortedArr.size()-1; i++){
                if(sortedArr.get(i) > sortedArr.get(i+1)){
                    return 0;
                }
            }
            return 1;
    }


    @Test
    void testBlankList(){
        List<Integer> list = new ArrayList<>();
        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        assertEquals(true, sortedList.isEmpty());

    }

    @Test
    void testOneNumberList(){
        List<Integer> list = generateList(-100000, 100000, 1);

        System.out.println("test one number------" + list);

        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);

    }

    @Test
    void testTwoNumberList(){
        List<Integer> list = generateList(-100000, 100000, 2);

        System.out.println("test two number--------" + list);


        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);
    }

    @Test
    void testRandomSizeList(){
        int listSize = (int) Math.floor(Math.random()*(100000+1));
        List<Integer> list = generateList(-100000, 100000, listSize);

        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);

    }

    @Test
    void testRandomNumberList(){
        int listSize = 100;
        List<Integer> list = generateList(-100000, 100000, listSize);

        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);

    }

    @Test
    void testAscendingList(){
        int listSize = 10;
        int miniNum = -100000;
        int max = 1000000;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < listSize; i++){
            int random_number = (int) Math.floor(Math.random()*(max-miniNum)+miniNum+1);
            list.add(random_number);
            miniNum = random_number;
        }

        System.out.println("test ascending-----" + list);
        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);

    }

    @Test
    void testDescendingList(){
        int listSize = 10;
        int maxiNum = 1000000;
        int min = -1000000;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < listSize; i++){
            int random_number = (int) Math.floor(Math.random()*(maxiNum-min+1)+min);
            list.add(random_number);
            maxiNum = random_number;
        }

        System.out.println("test descending-----" + list);
        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);

    }

    @Test
    void testEqualNumberList(){
        int listSize = 10;
        int randNumber = (int) Math.floor(Math.random()*(100000+1));

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < listSize; i ++){
            list.add(randNumber);
        }

        System.out.println("test equal number--------" + list);
        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);

    }

    // bonus part
    @Test
    void testNegativeNumberList(){
        int listSize = 10;
        List<Integer> list = generateList(-100000, -1, listSize);

        System.out.println("test all negative------" + list);
        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);
    }

    @Test
    void testMinimumValaue(){
        int listSize = 10;
        List<Integer> list = generateList(Integer.MIN_VALUE, Integer.MIN_VALUE-4, listSize);

        System.out.println("test lowest integer value-------" + list);
        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);
    }

    @Test
    void testMaximumValaue(){
        int listSize = 10;
        List<Integer> list = generateList(Integer.MAX_VALUE-4, Integer.MIN_VALUE, listSize);

        System.out.println("test greatest integer value------" + list);
        Sorting sorting = new Sorting(list);
        List<Integer> sortedList = sorting.sort();

        int mm = isValid(list, sortedList);
        assertEquals(1, mm);
    }
}