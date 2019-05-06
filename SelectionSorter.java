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

    public void mySort() {
      for (int i = 0; i < elements.size() - 1; i ++) {
                int index = champIndex(elements, i);
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

    private int champIndex(ArrayList<String> elements, int start) {
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
