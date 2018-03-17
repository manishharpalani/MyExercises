package CodingInterviewsBook

import spock.lang.Specification

/**
 * Created by manishharpalani on 07/02/17.
 */
class Q7_MatrixTest extends Specification {
    def "basic contains"() {
        given:

        int[][] array2d = [ [1, 3, 5], [7, 9, 11], [13, 15, 17] ];

        when:
        Q7_Matrix matrix = new Q7_Matrix(array2d);

        then:
        matrix.contains(1)
        matrix.contains(5)
        matrix.contains(9)
        matrix.contains(17)
    }

    def "basic not contains"() {
        given:

        int[][] array2d = [ [1, 3, 5], [7, 9, 11], [13, 15, 17] ];

        when:
        Q7_Matrix matrix = new Q7_Matrix(array2d);

        then:
        !matrix.contains(-10)
        !matrix.contains(10)
        !matrix.contains(16)
        !matrix.contains(160)
    }

    def "empty matrix"() {
        given:

        int[][] array2d = [ [] ];

        when:
        Q7_Matrix matrix = new Q7_Matrix(array2d);

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
        Q7_Matrix matrix = new Q7_Matrix(array2d);

        then:
        matrix.contains(5)
        !matrix.contains(-9)
        !matrix.contains(17)
    }

    def "1D matrix"() {
        given:

        int[][] array2d = [ ];

        when:
        Q7_Matrix matrix = new Q7_Matrix(array2d);

        then:
        !matrix.contains(1)
        !matrix.contains(5)
        !matrix.contains(9)
        !matrix.contains(17)
    }

    def "null matrix"() {
        given:

        int[][] array2d = null;
        Q7_Matrix matrix = new Q7_Matrix(array2d);

    }
}
