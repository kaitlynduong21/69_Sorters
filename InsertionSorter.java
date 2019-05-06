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
      sort the user's data, implementing insertion sort
     */
    public void mySort() {
      for (int goodNameNeeded = 1; goodNameNeeded < elements.size() - 1; goodNameNeeded++) {
        insert1(goodNameNeeded);
        /*System.out.println( "    dbg: "
          + "after inserting element " + goodNameNeeded
          + " elements: " + elements
          );*/
      }
    }

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
