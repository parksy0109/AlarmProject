package github.parksy0109.alarmproject

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import github.parksy0109.alarmproject.databinding.ActivityMainBinding
import github.parksy0109.alarmproject.receiver.AlarmReceiver
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val picker: MaterialTimePicker = MaterialTimePicker.Builder().apply {
        setInputMode(MaterialTimePicker.INPUT_MODE_KEYBOARD)
        setTimeFormat(TimeFormat.CLOCK_12H)
        setHour(12)
        setMinute(0)
        setTitleText("Select Alarm Time")
    }.build()

    private var calendar: Calendar = Calendar.getInstance()
    private var alArmManager: AlarmManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotificationChannel()

        binding.btnSelectTime.setOnClickListener {
            showTimePicker()
        }

        binding.btnSetAlarm.setOnClickListener {
            setAlarm()

        }
        binding.btnCancelAlarm.setOnClickListener {
            cancelAlarm()
        }
    }

    private fun cancelAlarm() {
        val intent = Intent(this, AlarmReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        if(alArmManager == null) {
            alArmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        }

        alArmManager?.cancel(pendingIntent)

        Toast.makeText(this, "Alarm Cancelled",Toast.LENGTH_SHORT).show()
    }

    private fun setAlarm() {

        alArmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, AlarmReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        alArmManager?.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

        val formatToast = formatToast(this, calendar.timeInMillis)
        Snackbar.make(binding.mainRelativeLayout, formatToast, Snackbar.LENGTH_LONG).apply {
            val text = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            text.gravity = Gravity.CENTER_HORIZONTAL
            text.textAlignment = View.TEXT_ALIGNMENT_CENTER
            text.typeface = ResourcesCompat.getFont(this@MainActivity, R.font.cookierun_bold)
            text.setTextAppearance(applicationContext, R.style.BoldTextFont_14sp_white_shadow)
        }
            .setBackgroundTint(ContextCompat.getColor(this@MainActivity, R.color.orange))
            .show()
    }

    private fun showTimePicker() {
        picker.show(supportFragmentManager, "parksy0109")
        picker.addOnPositiveButtonClickListener {
            if (picker.hour > 12) {
                binding.tvTime.text = getString(R.string.time_format, String.format("%02d", picker.hour.minus(12)),String.format("%02d", picker.minute), "PM")
            } else {
                binding.tvTime.text = getString(R.string.time_format, String.format("%02d", picker.hour),String.format("%02d", picker.minute), "AM")
            }

            calendar = Calendar.getInstance().apply {
                set(Calendar.DAY_OF_MONTH, 10)
                set(Calendar.HOUR_OF_DAY,picker.hour)
                set(Calendar.MINUTE, picker.minute)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }
        }
    }

    private fun createNotificationChannel() {
        val name: CharSequence = "parksy0109ReminderChannel"
        val description = "Channel For Alarm Manager"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val notificationChannel = NotificationChannel("parksy0109", name, importance).apply {
            setDescription(description)
            enableLights(true)
            lightColor = Color.RED
            enableVibration(true)
        }

        getSystemService(NotificationManager::class.java).apply {
            createNotificationChannel(notificationChannel)
        }
    }
}