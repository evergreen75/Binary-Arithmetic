// Author: Joshua Bowen
// Date:   09/05/2017
// Tabs:   2 spaces

// A test program for the functions in Arithmetic.java

public class ArithmeticTest
{
  // prints an array of bytes in reverse order
  
  private static void printBinary(byte[] myByte)
  {
    for (int i = myByte.length - 1; i >= 0; i--)
    {
      System.out.print(myByte[i]);
    }
  }

  // For keeping up with which test we are currently running.
  static int testNumber = 1;

  // printTests(A, B) prints a series of tests for
  // the functions inc, sum, and product in
  // Arithmetic.java

  private static void printTests(byte[] A, byte[] B)
  {
    System.out.print("TEST " + testNumber + ": ");
    printBinary(A);
    System.out.print(" & ");
    printBinary(B);
    testNumber++;
    System.out.println("\n=================================================================");
    byte[] myByte = Arithmetic.inc(A);
    System.out.print("The increment of (");
    printBinary(A);
    System.out.print(") is ");
    printBinary(myByte);
    System.out.println();

    myByte = Arithmetic.inc(B);
    System.out.print("The increment of (");
    printBinary(B);
    System.out.print(") is ");
    printBinary(myByte);
    System.out.println();

    myByte = Arithmetic.sum(A, B);
    System.out.print("The sum of (");
    printBinary(A);
    System.out.print(" + ");
    printBinary(B);
    System.out.print(") is ");
    printBinary(myByte);
    System.out.println();

    myByte = Arithmetic.product(A, B);
    System.out.print("The product of (");
    printBinary(A);
    System.out.print(" * ");
    printBinary(B);
    System.out.print(") is ");
    printBinary(myByte);
    System.out.println();
    System.out.println("=================================================================");
    System.out.println();
  }
  public static void main(String[] args){

    byte[] D = new byte[6];
    D[0] = 1;
    D[1] = 0;
    D[2] = 0;
    D[3] = 1;
    D[4] = 0;
    D[5] = 1;
    byte[] F = new byte[9];
    F[0] = 0;
    F[1] = 0;
    F[2] = 1;
    F[3] = 1;
    F[4] = 1;
    F[5] = 1;
    F[6] = 1;
    F[7] = 0;
    F[8] = 1;

    printTests(D, F);

    D = new byte[5];
    D[0] = 1;
    D[1] = 1;
    D[2] = 1;
    D[3] = 1;
    D[4] = 1;

    F = new byte[4];
    F[0] = 0;
    F[1] = 0;
    F[2] = 1;
    F[3] = 1;

    printTests(D, F);

    D = new byte[5];
    D[0] = 0;
    D[1] = 0;
    D[2] = 0;
    D[3] = 0;
    D[4] = 1;

    F = new byte[5];
    F[0] = 0;
    F[1] = 0;
    F[2] = 0;
    F[3] = 0;
    F[4] = 1;

    printTests(D, F);

    D = new byte[1];
    D[0] = 0;
    F = new byte[1];
    F[0] = 0;

    printTests(D, F);

    D = new byte[6];
    D[0] = 1;
    D[1] = 0;
    D[2] = 0;
    D[3] = 1;
    D[4] = 0;
    D[5] = 1;

    F = new byte[2];
    F[0] = 0;
    F[1] = 1;

    printTests(D, F);

    F = new byte[10];
    F[0] = 1;
    F[1] = 1;
    F[2] = 0;
    F[3] = 0;
    F[4] = 1;
    F[5] = 1;
    F[6] = 0;
    F[7] = 0;
    F[8] = 0;
    F[9] = 1;

    D = new byte[7];
    D[0] = 1;
    D[1] = 0;
    D[2] = 1;
    D[3] = 1;
    D[4] = 1;
    D[5] = 0;
    D[6] = 0;

    printTests(D, F);

    F = new byte[5];
    F[0] = 0;
    F[1] = 0;
    F[2] = 0;
    F[3] = 0;
    F[4] = 0;

    D = new byte[3];
    D[0] = 0;
    D[1] = 0;
    D[2] = 0;

    printTests(D, F);

    F = new byte[6];
    F[0] = 0;
    F[1] = 0;
    F[2] = 0;
    F[3] = 1;
    F[4] = 0;
    F[5] = 1;

    D = new byte[3];
    D[0] = 1;
    D[1] = 0;
    D[2] = 0;

    printTests(D, F);

    F = new byte[5];
    F[0] = 1;
    F[1] = 0;
    F[2] = 1;
    F[3] = 1;
    F[4] = 1;

    D = new byte[3];
    D[0] = 1;
    D[1] = 1;
    D[2] = 1;

    printTests(D, F);

    F = new byte[2];
    F[0] = 0;
    F[1] = 0;

    D = new byte[10];
    D[0] = 1;
    D[1] = 0;
    D[2] = 1;
    D[3] = 1;
    D[4] = 1;
    D[5] = 0;
    D[6] = 0;
    D[7] = 0;
    D[8] = 1;
    D[9] = 2;

    printTests(D, F);
  }
}
