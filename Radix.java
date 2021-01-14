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

/*
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
  */

  public static void radixSortSimple(SortableLinkedList data){
    int LeastSignficantDigitPass = 0;
    SortableLinkedList [] buckets = new SortableLinkedList [10];
    for (int i = 0; i < 10; i++){
      buckets[i] = new SortableLinkedList();
    }
    while (data.size() != 0){
      int NumberToBeSorted = data.remove(0);
      if (LeastSignficantDigitPass < length(NumberToBeSorted) ){
        LeastSignficantDigitPass = length (NumberToBeSorted);
      }
      int digit = nth (NumberToBeSorted,0);
      (buckets[digit]).add(NumberToBeSorted);
    }
    merge(data,buckets);
    for (int DigitPlace = 1; DigitPlace < LeastSignficantDigitPass; DigitPlace++){
      while (data.size() != 0){
        int NumberToBeSorted = data.remove(0);
        int digit = nth (NumberToBeSorted,DigitPlace);
        (buckets[digit]).add(NumberToBeSorted);
      }
      merge(data,buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList Negatives = new SortableLinkedList();
    SortableLinkedList NonNegatives = new SortableLinkedList();
    for (int i = 0; i < data.size(); i++){
      if (data.get(i) < 0){
        Negatives.add(data.get(i));
      }
      else{
        NonNegatives.add(data.get(i));
      }
    }
    for (int j = 0; j < Negatives.size(); j++){
      Negatives.set(j, Negatives.get(j) * -1);
    }
    radixSortSimple(Negatives);
    radixSortSimple(NonNegatives);
    SortableLinkedList NegativesInCorrectOrder = new SortableLinkedList();
    for (int k = Negatives.size() - 1; k > 0; k--) {
      NegativesInCorrectOrder.add(Negatives.get(k));
    }
    for (int j = 0; j < NegativesInCorrectOrder.size(); j++){
      NegativesInCorrectOrder.set(j, NegativesInCorrectOrder.get(j) * -1);
    }
    NegativesInCorrectOrder.extend(NonNegatives);
    while (data.size() != 0){
      data.remove(0);
    }
    data.extend(NegativesInCorrectOrder);
  }
}
