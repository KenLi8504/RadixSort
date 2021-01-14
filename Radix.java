public class Radix{

  public static int nth (int n, int col){
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

  public static void merge (MyLinkedList original, MyLinkedList [] buckets){
    for (MyLinkedList test : buckets){
      original.extend(test);
    }
  }

  public static void main (String [] args){
    /*
    System.out.println(nth(123,1));
    System.out.println(nth(-123,1));
    System.out.println(nth(123,2));
    System.out.println(nth(-123,2));
    System.out.println(length(0));
    System.out.println(length(15));
    System.out.println(length(-10));
    System.out.println(length(-100));
    System.out.println(length(-1000));
    System.out.println(length(-1));
    System.out.println(length(5112));
    */
    MyLinkedList P1 = new MyLinkedList();
    P1.add("1");
    P1.add("2");
    P1.add("3");
    MyLinkedList Buckets0 = new MyLinkedList();
    Buckets0.add("4");
    Buckets0.add("5");
    MyLinkedList Buckets1 = new MyLinkedList();
    Buckets1.add("6");
    Buckets1.add("7");
    MyLinkedList Buckets2 = new MyLinkedList();
    Buckets2.add("8");
    Buckets2.add("9");

    MyLinkedList [] BucketTest = new MyLinkedList [3];
    BucketTest[0] = Buckets0;
    BucketTest[1] = Buckets1;
    BucketTest[2] = Buckets2;
    merge(P1,BucketTest);
    System.out.println(P1);
  }
}
