package InterviewCake

import spock.lang.Specification
import InterviewCake.Q4_MergingRanges.Meeting

/**
 * Created by manishharpalani on 21/02/17.
 */
class Q4_MergingRangesTest extends Specification {
    def "basic mergeRanges"() {
        given:
        List<Meeting> schedule = Arrays.asList(
                new Meeting(0, 1),
                new Meeting(3, 5),
                new Meeting(4, 8),
                new Meeting(10, 12),
                new Meeting(9, 10));

        when:
        def merged = Q4_MergingRanges.mergeRanges(schedule.toArray(new Meeting[0]))
        then:
        merged.size() == 3

        merged[0].startTime == 0
        merged[0].endTime == 1

        merged[1].startTime == 3
        merged[1].endTime == 8

        merged[2].startTime == 9
        merged[2].endTime == 12
    }
    def "mergent adjacent"() {
        given:
        List<Meeting> schedule = Arrays.asList(
                new Meeting(1, 2),
                new Meeting(2, 3));

        when:
        def merged = Q4_MergingRanges.mergeRanges(schedule.toArray(new Meeting[0]))
        then:
        merged.size() == 1

        merged[0].startTime == 1
        merged[0].endTime == 3
    }

    def "merge subset"() {
        given:
        List<Meeting> schedule = Arrays.asList(
                new Meeting(1, 5),
                new Meeting(2, 3));

        when:
        def merged = Q4_MergingRanges.mergeRanges(schedule.toArray(new Meeting[0]))
        then:
        merged.size() == 1

        merged[0].startTime == 1
        merged[0].endTime == 5
    }

    def "reversed subset"() {
        given:
        List<Meeting> schedule = Arrays.asList(
                new Meeting(2, 3),
                new Meeting(1, 5));

        when:
        def merged = Q4_MergingRanges.mergeRanges(schedule.toArray(new Meeting[0]))
        then:
        merged.size() == 1

        merged[0].startTime == 1
        merged[0].endTime == 5
    }

    def "merge multi subsets"() {
        given:
        List<Meeting> schedule = Arrays.asList(
                new Meeting(1, 10),
                new Meeting(2, 6),
                new Meeting(3, 5),
                new Meeting(7, 9));

        when:
        def merged = Q4_MergingRanges.mergeRanges(schedule.toArray(new Meeting[0]))
        then:
        merged.size() == 1

        merged[0].startTime == 1
        merged[0].endTime == 10
    }
}
