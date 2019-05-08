/**
  Implement an insertion sort, in the Sorters structure


 */
import java.util.ArrayList;

public class InsertionSorter extends Sorter {


    /**
      Construct an instance to process the user's data
     */
    public InsertionSorter(  ArrayList< String> usersData) {
        super(usersData);
        // your code here, if necessary
    }


    /**
      traverse through the list
      invoke insert1 for position 1 to n - 1
      pre-condition: a list of n elements
      post-condition: a sorted list of the same n elements
     */
    public void mySort() {
      for (int goodNameNeeded = 1; goodNameNeeded < elements.size(); goodNameNeeded++) {
        insert1(goodNameNeeded);
        /*System.out.println( "    dbg: "
          + "after inserting element " + goodNameNeeded
          + " elements: " + elements
          );*/
      }
    }

    /** given a list of n elements, find the position of the first unsorted element in the current sorted region
        insert the first unsorted element into the position
        shift all larger values to the right one slot
        pre-condition: a list of n elements with an unsorted region and a sorted region
        post-condition: the list will have a sorted region that increases in size by 1 and a unsorted region
          that decreases in size by 1
    **/

    private void insert1(int alreadyInserted) {
      String valueToInsert = elements.get(alreadyInserted);
      for (int indexToCompare = alreadyInserted - 1; indexToCompare >= 0; indexToCompare -- ) {
        if (valueToInsert.compareTo(elements.get(indexToCompare)) < 0) {
          shift(indexToCompare);
          if (indexToCompare == 0) dropValue(0, valueToInsert);
        } else {
          dropValue(indexToCompare + 1, valueToInsert);
          indexToCompare = -1;
        }
      }
    }

    private void shift(int indexToMoveTo) {
      elements.set(indexToMoveTo + 1, elements.get(indexToMoveTo));
    }

    private void dropValue(int indexToMoveTo, String valueToInsert) {
      elements.set(indexToMoveTo, valueToInsert);
    }

}
