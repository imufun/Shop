package shop.portonics.com.shop.firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import shop.portonics.com.shop.MainActivity;
import shop.portonics.com.shop.R;

/**
 * Created by Imran on 11/25/2016.
 */

public class MyFirebaseMessagingServices extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent = new Intent(new Intent(this, MainActivity.class));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationsBuilder = new NotificationCompat.Builder(this);
        notificationsBuilder.setContentTitle("Shop ctivity");
        notificationsBuilder.setContentText(remoteMessage.getNotification().getBody());
        notificationsBuilder.setAutoCancel(true);
        notificationsBuilder.setSmallIcon(R.drawable.ic_home);
        notificationsBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationsBuilder.build());
    }
}
