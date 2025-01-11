package com.priyakdey.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class CalendarMatching {

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1, StringMeeting dailyBounds1,
            List<StringMeeting> calendar2, StringMeeting dailyBounds2,
            int meetingDuration) {

        List<int[]> cal1 = convert(calendar1);
        List<int[]> cal2 = convert(calendar2);
        List<int[]> cal = mergeCalendar(cal1, cal2);

        // TODO: meaningful naming
        int[] arr1 = parseStringMeeting(dailyBounds1);
        int[] arr2 = parseStringMeeting(dailyBounds2);

        int startBound = Math.max(arr1[0], arr2[0]);
        int endBound = Math.min(arr1[1], arr2[1]);


        List<StringMeeting> availableSlots = new ArrayList<>();

        int prevEnd = startBound;
        for (int[] arr : cal) {
            int currStart = arr[0];
            int currEnd = arr[1];

            if (timeDiffInMins(currStart, prevEnd) >= meetingDuration
                    && currStart <= endBound) {
                availableSlots.add(parseInt(prevEnd, currStart));
            }
            prevEnd = currEnd;
        }

        if (timeDiffInMins(endBound, prevEnd) >= meetingDuration) {
            availableSlots.add(parseInt(prevEnd, endBound));
        }

        return availableSlots;
    }

    private static List<int[]> mergeCalendar(List<int[]> cal1,
                                             List<int[]> cal2) {
        int m = cal1.size(), n = cal2.size();

        List<int[]> cal = new ArrayList<>();
        int i = 0, j = 0;

        while (i < m && j < n) {
            int[] currMeeting;
            if (cal1.get(i)[0] <= cal2.get(j)[0]) {
                currMeeting = cal1.get(i++);
            } else {
                currMeeting = cal2.get(j++);
            }

            if (cal.isEmpty()) {
                cal.add(currMeeting);
            } else {
                int[] prevMeeting = cal.getLast();
                if (currMeeting[0] <= prevMeeting[1]) {
                    cal.getLast()[1] = Math.max(currMeeting[1],
                            prevMeeting[1]);
                } else {
                    cal.add(currMeeting);
                }
            }
        }

        while (i < m) {
            int[] currMeeting = cal1.get(i++);
            if (cal.isEmpty()) {
                cal.add(currMeeting);
            } else {
                int[] prevMeeting = cal.getLast();
                if (currMeeting[0] <= prevMeeting[1]) {
                    cal.getLast()[1] = Math.max(currMeeting[1],
                            prevMeeting[1]);
                } else {
                    cal.add(currMeeting);
                }
            }
        }

        while (j < n) {
            int[] currMeeting = cal2.get(j++);
            if (cal.isEmpty()) {
                cal.add(currMeeting);
            } else {
                int[] prevMeeting = cal.getLast();
                if (currMeeting[0] <= prevMeeting[1]) {
                    cal.getLast()[1] = Math.max(currMeeting[1],
                            prevMeeting[1]);
                } else {
                    cal.add(currMeeting);
                }
            }
        }

        return cal;
    }

    private static List<int[]> convert(List<StringMeeting> calendar) {
        return calendar.stream()
                .map(CalendarMatching::parseStringMeeting).toList();
    }

    private static StringMeeting parseInt(int startTime, int endTime) {
        String start = String.format("%02d:%02d", startTime / 100,
                startTime % 100);
        String end = String.format("%02d:%02d", endTime / 100, endTime % 100);
        return new StringMeeting(start, end);
    }

    private static int[] parseStringMeeting(StringMeeting meeting) {
        int[] arr = Arrays.stream(meeting.start.split(":"))
                .mapToInt(Integer::parseInt).toArray();
        int startTime = arr[0] * 100 + arr[1];

        arr = Arrays.stream(meeting.end.split(":"))
                .mapToInt(Integer::parseInt).toArray();
        int end = arr[0] * 100 + arr[1];
        return new int[]{startTime, end};
    }

    private static int timeDiffInMins(int endTime, int startTime) {
        return (60 - (startTime % 100))
                + (endTime % 100)
                + (((endTime / 100) - (startTime / 100) - 1) * 60);
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<StringMeeting> calendar1 = new ArrayList<>();
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "13:00"));
        calendar1.add(new StringMeeting("16:00", "18:00"));

        List<StringMeeting> calendar2 = new ArrayList<>();
        calendar2.add(new StringMeeting("10:00", "11:30"));
        calendar2.add(new StringMeeting("12:30", "14:30"));
        calendar2.add(new StringMeeting("14:30", "15:00"));
        calendar2.add(new StringMeeting("16:00", "17:00"));

        StringMeeting dailyBounds1 = new StringMeeting("9:00", "20:00");
        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");
        int meetingDuration = 45;

        List<StringMeeting> stringMeetings = calendarMatching(calendar1,
                dailyBounds1, calendar2, dailyBounds2,
                meetingDuration);

        System.out.println(stringMeetings);
    }
}
