import Netskope.PathFinder
import spock.lang.Specification

/**
 * Created by manishharpalani on 31/01/17.
 */
class PathFinderTest extends Specification {
    def "one line"() {
            given:
            List<String> lines = Arrays.asList("A E")

            when:
            List<String> paths = PathFinder.parseLines(lines);

            then:
            paths.size() == 0
        }

    def "simple 1 line"() {
        given:
        List<String> lines = Arrays.asList("A E", "A : E")

        when:
        List<String> paths = PathFinder.parseLines(lines);

        then:
        paths.size() == 1
        paths.contains("AE")
    }

    def "basic test w/o cycles"() {
        given:
        List<String> lines = Arrays.asList("A E",
                "A : B C D",
                "B : C",
                "C : E",
                "D : B");

        when:
        List<String> paths = PathFinder.parseLines(lines);

        then:
        paths.size() == 3
        paths.contains("ACE")
        paths.contains("ABCE")
        paths.contains("ADBCE")
    }

    def "cyclical test"() {
        given:
        List<String> lines = Arrays.asList("A E",
                "A : B C D",
                "B : C",
                "C : E",
                "D : A");

        when:
        List<String> paths = PathFinder.parseLines(lines);

        then:
        paths.size() == 2
        paths.contains("ACE")
        paths.contains("ABCE")
    }
}
