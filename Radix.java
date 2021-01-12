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

  public static void main (String [] args){
    /*
    System.out.println(nth(123,1));
    System.out.println(nth(-123,1));
    System.out.println(nth(123,2));
    System.out.println(nth(-123,2));
    */
    System.out.println(length(0));
    System.out.println(length(15));
    System.out.println(length(-10));
    System.out.println(length(-100));
    System.out.println(length(-1000));
    System.out.println(length(-1));
    System.out.println(length(5112));
  }

}
