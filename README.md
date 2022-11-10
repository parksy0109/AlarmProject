Simple Alarm Project
==================

🎉 간단하게 사용자에게 시간을 입력 받아 알람을 설정하는 어플리케이션 입니다.
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
            setSmallIcon(R.drawable.ic_img_noti_small_icon) // 안드로이드 상단 상태창에 뜨는 노티 이미지
            color = Color.RED // 노티 색상 (상단바 내려서 노티 확인할 때 적용 됨 )
            setContentTitle("Alarm") // 노티 제목
            setContentText("content Text") // 노티 내용
            setStyle(NotificationCompat.BigTextStyle().bigText("content Text\nGive me a Star")) // 노티 확장시 나오는 텍스트 설정
            setDefaults(NotificationCompat.DEFAULT_ALL)
            priority = NotificationCompat.PRIORITY_HIGH
            setContentIntent(pendingIntent)
        }
```

Reference
======================
[AlarmManager in Android Studio || Notification using AlarmManager is Android Studio](https://www.youtube.com/watch?v=xSrVWFCtgaE)

[Android Developers - 알림 만들기](https://developer.android.com/training/notify-user/build-notification?hl=ko)

Contact
======================
📧 kalnalvid@gmail.com
