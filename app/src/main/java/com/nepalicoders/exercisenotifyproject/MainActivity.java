package com.nepalicoders.exercisenotifyproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private final static int NOTIFY_ID = 1;

    private int mNotifyCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtons();
    }

    private void setupButtons() {
        findViewById(R.id.btnNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNotifyOnClick((Button) v);
            }
        });

        findViewById(R.id.btnNotifyPersonal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNotifyPersonalOnClick((Button) v);
            }
        });

        findViewById(R.id.btnNotifyMulti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNotifyMultiOnClick((Button) v);
            }
        });

        findViewById(R.id.btnNotifyBigText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNotifyBigTextOnClick((Button) v);
            }
        });

        findViewById(R.id.btnNotifyBigPicture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNotifyBigPictureOnClick((Button) v);
            }
        });

        findViewById(R.id.btnRemoveNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRemoveNotifyOnClick((Button) v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void btnNotifyOnClick(Button v) {
        String title = "Meow";
        String text = "Never mind .. just being a cat";

        Intent intent = new Intent(this, SimpleTextActivity.class);
        intent.setAction("Notify");
        intent.putExtra(SimpleTextActivity.TITLE_EXTRA, title);
        intent.putExtra(SimpleTextActivity.BODY_TEXT_EXTRA, text);
        NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);

    }


    private void btnNotifyPersonalOnClick(Button v) {
        String title = "Meow";
        String text = "Never mind .. just being a cat";

        // Create the Intent to display the text in an Activity
        Intent intent = new Intent(this, SimpleTextActivity.class);
        intent.setAction("NotifyPersonal");
        intent.putExtra(SimpleTextActivity.TITLE_EXTRA, title);
        intent.putExtra(SimpleTextActivity.BODY_TEXT_EXTRA, text);

        // Create Builder with basic notification info
        NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

        // Make things personal
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_fwankwin))
                .setAutoCancel(true);

        // Construct the Notification
        Notification notification = builder.build();

        // Display the Notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);
    }

    private void btnNotifyMultiOnClick(Button v) {
        String title = "Notify";
        String text = "You have multiple entries";

        String detailText1 = "Never mind .. just being a cat";
        String detailText2 = "Just making sure you're paying attention";
        ++mNotifyCount;

        ArrayList<String> textValues = new ArrayList<>();
        textValues.add(detailText1);
        textValues.add(detailText2);

        // Create the Intent to display the info in an Activity
        Intent intent = new Intent(this, SimpleListActivity.class);
        intent.setAction("NotifyMulti");
        intent.putExtra(SimpleListActivity.TITLE_EXTRA, title);
        intent.putExtra(SimpleListActivity.TEXT_VALUES_EXTRA, textValues);

        // Create Builder with basic notification info
        NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

        // Make multi
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_stat_notify_kitty_multi))
                .setNumber(mNotifyCount)
                .setTicker("You received another value");

        // Construct the Notification
        Notification notification = builder.build();

        // Display the Notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);
    }

    private void btnNotifyBigTextOnClick(Button v) {
        String title = "Meow";
        String text = "Never mind .. just being a cat";
        String bigTitle = "This is the big title";
        String bigSummary = "This is the big summary";
        String notificationText = getString(R.string.big_text_for_notification);

        // Create the Intent to display the text in an Activity
        Intent intent = new Intent(this, SimpleTextActivity.class);
        intent.setAction("NotifyBigText");
        intent.putExtra(SimpleTextActivity.TITLE_EXTRA, bigTitle);
        intent.putExtra(SimpleTextActivity.BODY_TEXT_EXTRA, notificationText);

        // Create Builder with basic notification info
        NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

        // Add the Big Text Style
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle(bigTitle)
                .setSummaryText(bigSummary)
                .bigText(notificationText);
        builder.setStyle(bigTextStyle);

        // Construct the Notification
        Notification notification = builder.build();

        // Display the Notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);
    }

    private void btnNotifyBigPictureOnClick(Button v) {
        String title = "Meow";
        String text = "Never mind .. just being a cat";
        String bigTitle = "Growing Up";
        String bigSummary = "This is me in my box now";

        // Create the Intent to display the picture in an Activity
        Intent intent = new Intent(this, SimplePictureActivity.class);
        intent.setAction("NotifyBigPicture");
        intent.putExtra(SimplePictureActivity.TITLE_EXTRA, bigTitle);
        intent.putExtra(SimplePictureActivity.IMAGE_RESOURCE_ID_EXTRA, R.drawable.fwankwin_grows_into_his_box);

        // Create Builder with basic notification info
        NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

        // Add the Big Picture Style
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.setBigContentTitle(bigTitle)
                .setSummaryText(bigSummary)
                .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.fwankwin_grows_into_his_box));
        builder.setStyle(bigPictureStyle);

        // Construct the Notification
        Notification notification = builder.build();

        // Display the Notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);
    }


    private NotificationCompat.Builder initBasicBuilder(String title, String text, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_stat_notify_kitty_round)
                .setContentTitle(title)
                .setContentText(text);

        if (intent != null) {
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            builder.setContentIntent(pendingIntent);
        }

        return builder;
    }

    private void btnRemoveNotifyOnClick(Button v) {
    }

}
