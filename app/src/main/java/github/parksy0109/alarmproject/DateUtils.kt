package github.parksy0109.alarmproject

import java.util.*

//20221110
//오후 01:10
fun hourTimeStringToCalendar(locDate: String, time: String): Calendar {
    return Calendar.getInstance().apply {
        set(
            locDate.substring(0, 4).toInt(),
            locDate.substring(4, 6).toInt().minus(1),
            locDate.substring(6, 8).toInt(),
            if(time.substring(0,2) == "오후") time.substring(3, 5).toInt().plus(12) else time.substring(3, 5).toInt(),
            time.substring(6, 8).toInt(),
            0,
        )
    }
}