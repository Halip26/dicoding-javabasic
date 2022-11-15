public class StringDicoding {
  public static void main(String[] args) {
    char[] halipChart = {'h','a','l','i','p','u','d','d','i','n'};

    String namaSaya = "Halipuddin";
    
    String halipString = new String(halipChart);

    int panjangChar = halipString.length();

    char charPada = namaSaya.charAt(4);

    System.out.println(halipString);

    System.out.println(panjangChar);

    System.out.println(charPada);

  }
}
