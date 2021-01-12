public class Radix{
  public static int nth (int n, int col){
    int place = (int)Math.pow (10,col);
    int newnumber = n / place;
    return Math.abs(newnumber % 10);
  }
  public static void main (String [] args){
    System.out.println(nth(123,1));
    System.out.println(nth(-123,1));
    System.out.println(nth(123,2));
    System.out.println(nth(-123,2));
  }
}
