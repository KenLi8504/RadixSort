public class Radix{

  public static int nth (int n, int col){
    if (col > length(n) - 1){
      return 0;
    }
    int place = (int)Math.pow (10,col);
    int newnumber = n / place;
    return Math.abs(newnumber % 10);
  }

  public static int length(int n){
    if (n == 0){
      return 1;
    }
    return (int)Math.log10(Math.abs(n)) + 1;
  }

  public static void merge (SortableLinkedList original, SortableLinkedList [] buckets){
    for (SortableLinkedList test : buckets){
      original.extend(test);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int LeastSignficantDigitPass = 0;
    for (int i = 0; i < data.size(); i++){
      if (LeastSignficantDigitPass < length(data.get(i)) ){
        LeastSignficantDigitPass = length(data.get(i));
      }
    }
    for (int j = 0; j < LeastSignficantDigitPass; j++){
      SortableLinkedList NewVersion = new SortableLinkedList();
      SortableLinkedList [] buckets = new SortableLinkedList [10];
      for (int i = 0; i < 10; i++){
        buckets[i] = new SortableLinkedList();
      }
      for (int k = 0; k < data.size(); k++){
        int digit = nth ( data.get(k),j);
        (buckets[digit]).add(data.get(k));
      }
      merge(NewVersion,buckets);
      while (data.size() != 0){
        data.remove(0);
      }
      data.extend(NewVersion);
    }
  }

  public static void main (String [] args){
    SortableLinkedList test = new SortableLinkedList();
    test.add(3469);
    test.add(323);
    test.add(6742);
    test.add(3437);
    test.add(8541);
    radixSortSimple(test);
    System.out.println(test);
  }
}
