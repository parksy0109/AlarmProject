Simple Alarm Project
==================

π κ°λ¨νκ² μ¬μ©μμκ² μκ°μ μλ ₯ λ°μ μλμ μ€μ νλ μ΄νλ¦¬μΌμ΄μ μλλ€.
- AlarmManager
- BroadcastReceiver

## Index
* [Application](#Application)
* [Code](#Code)
* [Reference](#Reference)
* [Contact](#Contact)

Application
======================
<img src="https://user-images.githubusercontent.com/85792293/201021313-071459cd-032a-486e-b47a-9fba1da0bd2a.png">

<img src="https://user-images.githubusercontent.com/85792293/201022112-a8782f4b-baa8-441f-9a35-09169f49097c.png">


Code
======================
```kotlin
NotificationCompat.Builder(context, CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_img_noti_small_icon) // μλλ‘μ΄λ μλ¨ μνμ°½μ λ¨λ λΈν° μ΄λ―Έμ§
            color = Color.RED // λΈν° μμ (μλ¨λ° λ΄λ €μ λΈν° νμΈν  λ μ μ© λ¨ )
            setContentTitle("Alarm") // λΈν° μ λͺ©
            setContentText("content Text") // λΈν° λ΄μ©
            setStyle(NotificationCompat.BigTextStyle().bigText("content Text\nGive me a Star")) // λΈν° νμ₯μ λμ€λ νμ€νΈ μ€μ 
            setDefaults(NotificationCompat.DEFAULT_ALL)
            priority = NotificationCompat.PRIORITY_HIGH
            setContentIntent(pendingIntent)
        }
```

Reference
======================
[AlarmManager in Android Studio || Notification using AlarmManager is Android Studio](https://www.youtube.com/watch?v=xSrVWFCtgaE)

[Android Developers - μλ¦Ό λ§λ€κΈ°](https://developer.android.com/training/notify-user/build-notification?hl=ko)

Contact
======================
π§ kalnalvid@gmail.com
