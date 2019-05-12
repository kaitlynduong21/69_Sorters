import java.util.ArrayList;

public class SubSortThenMerge_Sorter extends Sorter{

  private ArrayList<String> localCopy;

  public SubSortThenMerge_Sorter(  ArrayList< String> usersData) {
      super(usersData);
  }

  public void mySort() {
    subSort(0, elements.size());
  }

  private int subSort(
      int start
    , int end
    ) {
    if (end - start <= 1 ) {         //decision between the base case and recursive cases
      return start;                     //solution to the base case
    } else {                            //solution to the recusive cases
      int mid = (start + end) / 2;
      //System.out.println("Sub Sort invoked \n List 0 starts at: " + start + "\n List 1 starts at: " + mid);
      merge(                            //leftover processing
        subSort(start, mid),            //recusive abstraction
        subSort(mid, end), end);        //recursive abstraction
      //System.out.println(elements);
      return start;
    }
  }

  public void merge(
    // indexes of sub-list boundaries; see README
      int start0  // index of first item in list0
    , int start1  // index of first item in list1
                  // = just past end of list0
    , int end1    // index past end of list1
    ) {

      localCopy = new ArrayList<String> (end1 - start1);

      int positionOfList0 = start0;
      int positionOfList1 = start1;

      for (int i = 0; i < start0; i ++) {
          localCopy.add(elements.get(i));
      }
      while (positionOfList0 < start1 && positionOfList1 < end1) { //check to see if there are still elements to compare
        if (elements.get(positionOfList0).compareTo(elements.get(positionOfList1)) < 1) {
          localCopy.add(elements.get(positionOfList0));
          positionOfList0++;
        } else {
          localCopy.add(elements.get(positionOfList1));
          positionOfList1++;
        }
      }
      addLeftOvers(localCopy, positionOfList0, start1); //check if there are still elements in list0
      addLeftOvers(localCopy, positionOfList1, end1); //check if there are still elements in list1
      for (int i = end1 ; i < elements.size(); i ++) {
          localCopy.add(elements.get(i));
      }
      elements = localCopy;
  }

  private void addLeftOvers(ArrayList<String> list, int start, int end){
    while(start < end) {
      list.add(elements.get(start));
      start++;
    }
  }


  /**
    @return a string representation of the user's data
   */
  public String toString() {
      return "" + elements;
  }
}
