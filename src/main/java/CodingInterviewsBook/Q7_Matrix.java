package CodingInterviewsBook;

/**
 * Created by manishharpalani on 07/02/17.
 * Question 7 In a 2-D matrix, every row is increasingly sorted from left to right,
 * and the last number in each row is not greater than the first number of the next
 * row. A sample matrix follows. Please implement a function to check whether a number
 * is in such a matrix or not. It returns true if it tries to find the number 7 in the
 * sample matrix, but it returns false if it tries to find the number 12.
 * 1 3 5
 * 7 9 11
 * 13 15 17
 */
public class Q7_Matrix {

    private final int[][] matrix;

    public Q7_Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean contains(int value) {
        System.out.println();

        if (matrix.length == 0)
            return false;

        int lowIndex = 0;
        int highIndex = matrix.length * matrix[0].length - 1;

        System.out.format("contains(%d) in %d-%d : \t", value, lowIndex, highIndex);
        while (lowIndex <= highIndex) {
            int curIndex = getMid(lowIndex, highIndex);
            int curValue = getValue(curIndex);
            System.out.format("mid(%d, %d): [%d] = %d\t", lowIndex, highIndex, curIndex, curValue);

            if (curValue == value)
                return true;
            if (curValue > value)
                highIndex = curIndex - 1;
            else
                lowIndex = curIndex + 1;
        }
        return false;
    }

    private int getMid(int lowIndex, int highIndex) {
        return (lowIndex + highIndex) / 2;
    }

    private int getValue(int index) {
        int rowLength = matrix[0].length;
        int index0 = index / rowLength;
        return matrix[index0][index % rowLength];
    }

    public boolean bruteContains(int value) {

        System.out.println();
        for (int[] array: matrix) {
            for (int arrayVal : array) {
                System.out.print(arrayVal + " ");
                if (arrayVal == value)
                    return true;
            }
        }
        return false;
    }

}
