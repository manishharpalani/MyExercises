package HackerRank

import spock.lang.Specification

class PermutationTest extends Specification {
    def "test permute"() {
        expect:
        [] == Permutation.permute([] as Integer[])
        [[1]] == Permutation.permute([1] as Integer[])
        [[1, 2], [2, 1]] == Permutation.permute([1, 2] as Integer[])
        //Integer[] input = [1, 2, 3]
        [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] == Permutation.permute([1, 2, 3] as Integer[])
    }
}
