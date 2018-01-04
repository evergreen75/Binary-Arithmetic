// Author: Joshua Bowen
// Date:   09/05/2017
// Tabs:   2 spaces

//==============================================================
// These functions work on arrays that represent binary numbers.
// Each value in the arrays is either 0 or 1, and the low order
// bit is at index 0.  For example, if array A contains binary
// number 14 (1110 in standard binary notation), then it might be
// that
//    A[0] = 0
//    A[1] = 1
//    A[2] = 1
//    A[3] = 1
//
// Say that a binary number is *normalized* if its highest order
// bit is 1.  (As a special case, 0 is normalized if it is
// represented by an array of length 0.)
//
// All results of these functions are normalized.  But the
// parameters are not required to be normalized.  For example,
// if array A holds
//    A[0] = 0
//    A[1] = 1
//    A[2] = 1
//    A[3] = 1
//    A[4] = 0
//    A[5] = 0
// then A is a non-normalized representation of 14.
//==============================================================

public class Arithmetic
{

  private static void checkForInvalidValues(byte[] A)
  {
    for (int i = 0; i < A.length; i++)
    {
      if (A[i] != 0 && A[i] != 1)
      {

        System.out.print("ERROR. ");
        for (int j = A.length - 1; j >= 0; j--)
        {
          System.out.print(A[j]);
        }
        System.out.print(" is not a binary value! Exiting program.\n");
        System.exit(0);
      }
    }
  }
  //=================================================================
  // inc(A) returns an array of bits representing A+1.
  //=================================================================

  public static byte[] inc(byte[] A)
  {
    checkForInvalidValues(A);
    if (A == null)
    {
      System.out.println("ERROR. Null value given for parameter.");
      return null;
    }
    byte[] B = new byte[A.length];
    for (int i = 0; i < A.length; i++)
    {
      B[i] = A[i];
    }
    int i = 0;
    // Loop through till end of array or until value at index is not 1
    while (i < A.length && A[i] == 1)
    {
      B[i] = 0;
      i++;
    }
    // Reached end of array so we append a 1 at end of array and return
    if (i == A.length)
    {
      byte[] C = B;
      B = new byte[A.length + 1];
      for (int p = 0; i < C.length; p++)
      {
        B[p] = C[p];
      }
      B[B.length - 1] = 1;
      return trimBytes(B);

    }
    // Reached a 0 byte in array so we change this byte to a 1 and return
    else
    {
      B[i] = 1;
      return trimBytes(B);
    }
  }

  //=================================================================
  // padBytes(L, size) returns an array of bytes padded with 0's
  // at the beginning of the binary value L until the length of
  // the array is of the specified size.
  // e.g. if byte[] myByte contains binary value '101'
  // then padBytes(myByte, 5) = an array of bytes containing 00101.
  //=================================================================

  private static byte[] padBytes(byte[] L, int size)
  {
    if (L == null || size < L.length)
    {
      return L;
    }
    byte[] P = new byte[size];
    for (int i = 0; i < P.length; i++)
    {
      if (i < L.length)
      {
        P[i] = L[i];
      }
      else
      {
        P[i] = 0;
      }
    }
    return P;
  }

  //=================================================================
  // dupBytes(A) returns a duplicate array of bytes from A's contents.
  //=================================================================

  private static byte[] dupBytes(byte[] A)
  {
    byte[] B = new byte[A.length];
    for (int i = 0; i < A.length; i++)
    {
      B[i] = A[i];
    }
    return B;
  }

  //=================================================================
  // trimBytes(A) trims an array of bytes A from any useless leading
  // zero bytes. e.g. If A held the binary value 0001, then
  // trimBytes(A) = an array of bytes containing 1.
  //=================================================================

  private static byte[] trimBytes(byte[] A)
  {
    int q;
    // q is set to the index of the first 1 byte seen starting from
    // the beginning of the binary value in the array
    for (q = A.length - 1; (A[q] == 0 && q != 0); q--)
    {

    }
    byte[] trimmedArray = new byte[q + 1];
    for (int g = q; g >= 0; g--)
    {
      trimmedArray[g] = A[g];
    }
    return trimmedArray;
  }

  //=================================================================
  // sum(A,B) returns an array of bits representing A+B.
  //=================================================================

  public static byte[] sum(byte[] A, byte[] B)
  {
    checkForInvalidValues(A);
    checkForInvalidValues(B);
    if (A == null || B == null)
    {
      return null;
    }
    byte[] C = dupBytes(A);
    byte[] D = dupBytes(B);
    int maxLength = Math.max(C.length, D.length);
    // For making each bytes array the same length for
    // each individual intermediate step of addition.
    if (C.length < D.length)
    {
      C = padBytes(C, D.length);
    }
    else
    {
      D = padBytes(D, C.length);
    }
    byte[] sumArray = new byte[maxLength + 1];
    int i = 0;
    int carry = 0;
    for (int j = 0; j < maxLength; j++)
    {
      int currentSum = C[j] + D[j] + carry;
      switch (currentSum)
      {
        case 0:
                sumArray[i] = 0;
                carry = 0;
                break;
        case 1:
                sumArray[i] = 1;
                carry = 0;
                break;
        case 2:
                sumArray[i] = 0;
                carry = 1;
                break;
        case 3:
                sumArray[i] = 1;
                carry = 1;
                break;
      }
      i++;
    }
    // Check to see if a carry is still remaining after loop finishes
    if (carry == 1)
    {
      sumArray[i] = 1;
    }
    byte[] trimmedArray = trimBytes(sumArray);
    return trimmedArray;
  }



  //=================================================================
  // addZeros(L, numZerosToAdd) adds a number of zeros onto the end of
  // a binary value L specified by numZerosToAdd. e.g. If L contains
  // binary value 011 then addZeros(L, 3) = an array of bytes containing 011000.
  //=================================================================

  private static byte[] addZeros(byte[] L, int numZerosToAdd)
  {
    if (L == null)
    {
      return null;
    }
    byte[] P = new byte[L.length + numZerosToAdd];
    int j = P.length - 1;
    for (int i = L.length - 1; i >= 0; i--)
    {
      P[j] = L[i];
      j--;
    }
    while (j >= 0)
    {
      P[j] = 0;
      j--;
    }
    return P;
  }


  //=================================================================
  // product(A,B) returns an array of bits representing A*B.
  //=================================================================

  public static byte[] product(byte[] A, byte[] B)
  {
    checkForInvalidValues(A);
    checkForInvalidValues(B);
    int productSize = A.length + B.length;
    byte[] productArray = new byte[productSize];
    byte[] tempArray = new byte[productSize];
    int distanceFromEnd = 0;
    for (int i = 0; true; i++)
    {
      // Searched through whole bytes array A, productArray
      // now contains the answer
      if (i == A.length)
      {
        return trimBytes(productArray);
      }
      // Sum the intermediate value
      else if (A[i] == 1)
      {
        byte[] intermediateValue = B;
        intermediateValue = addZeros(intermediateValue, distanceFromEnd);
        productArray = sum(productArray, intermediateValue);
      }
      distanceFromEnd++;
    }
  }

}
