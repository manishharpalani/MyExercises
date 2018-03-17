package CodingInterviewsBook

import spock.lang.Specification

/**
 * Created by manishharpalani on 07/02/17.
 */
class Q8_MatrixTest extends Specification {

    def "basic contains 1d"() {
        given:
        int[] array1d = [4, 7, 10, 13];

        expect:
        Q8_Matrix.contains(array1d, 0, 4);
        Q8_Matrix.contains(array1d, 1, 7);
        Q8_Matrix.contains(array1d, 2, 13);

        !Q8_Matrix.contains(array1d, 1, 4);
        !Q8_Matrix.contains(array1d, 2, 7);

        !Q8_Matrix.contains(array1d, 0, 0);
        !Q8_Matrix.contains(array1d, 0, 8);
        !Q8_Matrix.contains(array1d, 0, 103);
    }

    def "basic contains"() {
        given:

        int[][] array2d = [ [1, 2, 8, 0], [2, 4, 9, 12], [4, 7, 10, 13], [6, 8, 11, 15] ];

        when:
        Q8_Matrix matrix = new Q8_Matrix(array2d);

        then:
        matrix.contains(1)
        matrix.contains(8)
        matrix.contains(4)
        matrix.contains(7)
        matrix.contains(15)
    }

    def "basic not contains"() {
        given:

        int[][] array2d = [ [1, 2, 8, 0], [2, 4, 9, 12], [4, 7, 10, 13], [6, 8, 11, 15] ];

        when:
        Q8_Matrix matrix = new Q8_Matrix(array2d);

        then:
        !matrix.contains(-10)
        !matrix.contains(16)
        !matrix.contains(3)
        !matrix.contains(14)
        !matrix.contains(140)
    }

    def "empty matrix"() {
        given:

        int[][] array2d = [ [] ];

        when:
        Q8_Matrix matrix = new Q8_Matrix(array2d);

        then:
        !matrix.contains(1)
        !matrix.contains(5)
        !matrix.contains(9)
        !matrix.contains(17)
    }

    def "single elem matrix"() {
        given:

        int[][] array2d = [ [5] ];

        when:
        Q8_Matrix matrix = new Q8_Matrix(array2d);

        then:
        matrix.contains(5)
        !matrix.contains(-9)
        !matrix.contains(17)
    }

    def "1D matrix"() {
        given:

        int[][] array2d = [ ];

        when:
        Q8_Matrix matrix = new Q8_Matrix(array2d);

        then:
        !matrix.contains(1)
        !matrix.contains(5)
        !matrix.contains(9)
        !matrix.contains(17)
    }

    def "null matrix"() {
        given:

        int[][] array2d = null;
        Q8_Matrix matrix = new Q8_Matrix(array2d);

    }
}
