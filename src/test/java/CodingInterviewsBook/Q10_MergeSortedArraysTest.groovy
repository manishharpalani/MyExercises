package CodingInterviewsBook

import spock.lang.Specification

/**
 * Created by manishharpalani on 08/02/17.
 */
class Q10_MergeSortedArraysTest extends Specification {
    def "basic merge"() {
        given:
        ///int[] array0 = new int[] ([4, 7, 10, 13, 50]);
        int[] array0 = new int[9];
        array0[0] = 1;
        array0[1] = 4;
        array0[2] = 8;
        array0[3] = 50;
        int[] array1 = [4, 7, 8, 13, 50];
        int mergedSize = array0.length + array1.length

        when:
        Q10_MergeSortedArrays.merge(array0, 4, array1)
        then:
        array0 == [1, 4, 4, 7, 8, 8, 13, 50, 50]


    }

    def "array0 empty"() {
        given:
        int[] array0 = new int[5];
        int[] array1 = [4, 7, 10, 13, 50];
        int mergedSize = array0.length + array1.length

        when:
        Q10_MergeSortedArrays.merge(array0, 0, array1)
        then:
        array0 == [4, 7, 10, 13, 50]
    }

    def "array1 empty"() {
        given:
        int[] array0 = new int[4];
        array0[0] = 1;
        array0[1] = 4;
        array0[2] = 8;
        array0[3] = 33;
        int[] array1 = [];
        int mergedSize = array0.length + array1.length

        when:
        Q10_MergeSortedArrays.merge(array0, 0, array1)
        then:
        array0 == [1, 4, 8, 33]
    }

    def "both array empty"() {
        given:
        int[] array0 = [];
        int[] array1 = [];

        when:
        Q10_MergeSortedArrays.merge(array0, 0, array1)
        then:
        array0 == []


    }

    def "null arrays"() {
        given:
        int[] array0 = null;
        int[] array1 = null;

        when:
        Q10_MergeSortedArrays.merge(array0, 0, array1)
        then:
        thrown RuntimeException;


    }

}
