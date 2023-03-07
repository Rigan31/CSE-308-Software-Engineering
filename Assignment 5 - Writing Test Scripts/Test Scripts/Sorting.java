import java.util.List;

public class Sorting{

    private List<Integer> arr;

    Sorting(List<Integer> arr){
        this.arr =  arr;
    }


    public List<Integer> sort() {
        for (int i = 1; i < arr.size(); ++i) {
            int key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key) {
                arr.set(j+1, arr.get(j));
                j = j - 1;
            }
            arr.set(j+1, key);
        }

        return arr;

    }

}
