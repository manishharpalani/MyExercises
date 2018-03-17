package CodingInterviewsBook;

/**
 * Created by manishharpalani on 07/02/17.
 * Question 8 In a 2-D matrix, every row is increasingly sorted from left to right,
 * and every column is increasingly sorted from top to bottom. Please implement a
 * function to check whether a number is in such a matrix or not. For example,
 * all rows and columns are increasingly sorted in the following matrix.
 * It returns true if it tries to find number 7, but it returns false if it
 * tries to find number 5.
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 */
public class Q8_Matrix {

    private final int[][] matrix;

    public Q8_Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean contains(int value) {
        System.out.println();

        int start = 0;
        int end = matrix.length - 1;
        for (int curIndex = 0; curIndex < matrix.length ;++curIndex) {
            if (matrix[curIndex].length == 0)
                continue;

            int curValue = matrix[curIndex][0];

            if (curValue == value)
                return true;
            else if (curValue > value)
                return false;

            else if (contains(matrix[curIndex], 1, value))
                return true;
        }
        return false;
    }

    private static boolean contains(int[] row, int start, int value) {
        int end = row.length - 1;

        while (start <= end) {
            int curIndex = getMid(start, end);
            int curValue = row[curIndex];
            System.out.format("%d-%d [%d] %d\n", start, end, curIndex, curValue);

            if (curValue == value)
                return true;
            else if (curValue > value)
                end = curIndex - 1;
            else
                start = curIndex + 1;
        }
        return false;

    }

    private static int getMid(int lowIndex, int highIndex) {
        return (lowIndex + highIndex) / 2;
    }

/*        int lowIndex = 0;
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
    }*/

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
