package com.nepalicoders.exercisenotifyproject;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class SimplePictureActivity extends Activity {
  public static final String TITLE_EXTRA = "title extra";
  public static final String IMAGE_RESOURCE_ID_EXTRA = "image resource id extra";

  public static final int IMAGE_RESOURCE_ID_NOT_SET = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_picture);

    Intent createIntent = getIntent();
    String title = createIntent.getStringExtra(TITLE_EXTRA);
    int imageResourceId =
        createIntent.getIntExtra(IMAGE_RESOURCE_ID_EXTRA, IMAGE_RESOURCE_ID_NOT_SET);

    if(title != null)
      setTitle(title);
    if(imageResourceId != IMAGE_RESOURCE_ID_NOT_SET)
      ((ImageView)findViewById(R.id.imageView)).setImageResource(imageResourceId);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.simple_picture, menu);
    return true;
  }

}
