package InterviewCake;

/*
Your company built an in-house calendar tool called HiCal.
You want to add a feature to see the times in a day when everyone is available.
        To do this, you’ll need to know when any team is having a meeting.
        In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime.
        These integers represent the number of 30-minute blocks past 9:00am.
*/

import java.util.*;

/**
 * Created by manishharpalani on 21/02/17.
 */
public class Q4_MergingRanges {
    public static class Meeting {

        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }
    }

    public static Meeting[] mergeRanges(Meeting[] meetings) {
        // sort by start times
        List<Meeting> sortedMeetings = Arrays.asList(meetings);
        Collections.sort(sortedMeetings, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2) {
                return m1.startTime - m2.startTime;
            }
        });

        List<Meeting> merged = new ArrayList<>();
        for (Meeting m: sortedMeetings) {

            if (merged.isEmpty()) {
                merged.add(new Meeting(m.startTime, m.endTime));
            }
            else {
                Meeting lastMerged = merged.get(merged.size() - 1);
                if (m.startTime <= lastMerged.endTime)
                    lastMerged.endTime = Math.max(lastMerged.endTime, m.endTime);
                else
                    merged.add(new Meeting(m.startTime, m.endTime));
            }

        }

        return merged.toArray(new Meeting[0]);

    }
}
