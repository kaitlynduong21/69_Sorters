/**
  Implement an insertion sort, in the Sorters structure

 */
import java.util.ArrayList;

public class SelectionSorter extends Sorter {


    /**
      Construct an instance to process the user's data
     */
    public SelectionSorter(  ArrayList< String> usersData) {
        super(usersData);
    }

    /**
      traverse through the list
      invoke champIndex for position 0 to n - 2
      swap the element at the index returned after champIndex is invoked
        with the element in the first region of the sorted region
      pre-condition: a list of n elements
      post-condition: a sorted list of the same n elements
    **/

    public void mySort() {
      for (int i = 0; i < elements.size() - 1; i ++) {
                int index = champIndex(i);
                String min = elements.get(index);
                elements.set(index, elements.get(i));
                elements.set(i, min);
                /*System.out.println(
                  elements
                  + System.lineSeparator()
                  + "You were going to do that even without prompting, right?"
                  );*/
              }
    }

    /** given a list of n elements, find the smallest element in the unsorted region
    @return the index of the given element
    pre-condition: a list of n elements with an unsorted region and a sorted region
    post-condition: the list will have a sorted region that increases in size by 1 and a unsorted region
      that decreases in size by 1
    **/

    private int champIndex(int start) {
        String champ = "";
        int index = start;
        for (int i = start; i < elements.size(); i ++) {
          if (elements.get(i).compareTo(champ) < 1) {
            champ = elements.get(i);
            index = i;
          }
        }
        return index;
     }

}
