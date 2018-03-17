package HackerRank

import spock.lang.Specification

class QueensAttackTest extends Specification {

    def "test centeredQueen"() {
        given:
        QueensAttack queensAttack = new QueensAttack()

        expect:
        assert queensAttack.getNumMoves(5, 0, 3, 3, [] as int[][]) == 16

        // obstacle on E, W, N , S
        assert queensAttack.getNumMoves(5, 4, 3, 3, [[3,1],[3,5],[1,3],[5,3]] as int[][]) == 12

        // obstacle on corners
        assert queensAttack.getNumMoves(5, 4, 3, 3, [[1,1],[1,5],[5,1],[5,5]] as int[][]) == 12

        // obstacle on corners & E, W, N , S
        assert queensAttack.getNumMoves(5, 8, 3, 3, [[1,1],[1,5],[5,1],[5,5],[3,1],[3,5],[1,3],[5,3]] as int[][]) == 8


        // queen off-center
        assert queensAttack.getNumMoves(5, 0, 4, 3, [] as int[][]) == 14

        // obstacle on corners & E, W, N , S
        assert queensAttack.getNumMoves(5, 2, 4, 3, [[2,1],[2,5]] as int[][]) == 12
        assert queensAttack.getNumMoves(5, 2, 4, 3, [[5,2],[5,4]] as int[][]) == 12
    }


    def "test queensAttack"() {
        given:
        QueensAttack queensAttack = new QueensAttack()
        expect:
        assert queensAttack.getNumMoves(n, obstacles.size(), queen_row, queen_col, obstacles as int[][]) == num_moves
        where: "dates should be inserted in date order rather than alphabetic order"
        n | queen_row | queen_col | obstacles || num_moves
        1 | 1         | 1         | []          || 0

        2 | 1         | 1         | []          || 3
        2 | 1         | 2         | []          || 3
        2 | 2         | 1         | []          || 3
        2 | 2         | 2         | []          || 3

        2 | 2         | 2         | [[1,1]]             || 2
        2 | 2         | 2         | [[1,1],[1,2]]       || 1
        2 | 2         | 2         | [[1,1],[1,2],[2,1]] || 0

        3 | 1         | 1         | [][]      || 6
        3 | 2         | 2         | [][]      || 8

        3 | 2         | 2         | [[1, 1]]  || 7

        8 | 4         | 4         | []          || 27
    }
}
