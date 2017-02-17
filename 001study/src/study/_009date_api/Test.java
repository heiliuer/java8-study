package study._009date_api;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/16 0016.
 */
public class Test {

    //    Java 8 contains a brand new date and time API under the package java.time.
// The new Date API is comparable with the Joda-Time library,
// however it's not the same. The following examples cover the most important parts of this new API.
    public static void main(String[] args) {
        clock();
        time_zone();
        localtime();
    }

    private static void time_zone() {

        System.out.println(ZoneId.getAvailableZoneIds());
        // prints all available timezone ids

        ZoneId zone1 = ZoneId.of("Asia/Chongqing");

        System.out.println(zone1.getRules());

        // ZoneRules[currentStandardOffset=+08:00]

    }

    private static void localtime() {

        ZoneId zone1 = ZoneId.of("Asia/Chongqing");
        ZoneId zone2 = ZoneId.of("Asia/Tokyo");

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));  // true

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // 1
        System.out.println(minutesBetween);     // 60

    }

    private static void clock() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date

    }

    private static void timezones() {


    }


}
