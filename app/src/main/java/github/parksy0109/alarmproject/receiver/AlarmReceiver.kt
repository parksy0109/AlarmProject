package github.parksy0109.alarmproject.receiver

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import github.parksy0109.alarmproject.MainActivity
import github.parksy0109.alarmproject.R

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val i = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        val pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_IMMUTABLE)

        // context 가 null value 일 경우 리턴
        if (context == null) return

        val builder = NotificationCompat.Builder(context, CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_img_noti_small_icon)
            color = Color.RED
            setContentTitle("Alarm")
            setContentText("content Text")
            setAutoCancel(true)
            setStyle(NotificationCompat.BigTextStyle().bigText("content Text\nGive me a Star"))
            setDefaults(NotificationCompat.DEFAULT_ALL)
            priority = NotificationCompat.PRIORITY_HIGH
            setContentIntent(pendingIntent)
        }

        val notificationManagerCompat = NotificationManagerCompat.from(context)
        notificationManagerCompat.notify(0, builder.build())


    }

    companion object {
        const val CHANNEL_ID = "parksy0109"
    }
}