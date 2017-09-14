package com.nepalicoders.exercisenotifyproject;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class SimpleTextActivity extends Activity {
  public static final String TITLE_EXTRA = "title extra";
  public static final String BODY_TEXT_EXTRA = "body text extra";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_text);

    Intent createIntent = getIntent();
    String title = createIntent.getStringExtra(TITLE_EXTRA);
    String bodyText = createIntent.getStringExtra(BODY_TEXT_EXTRA);

    if(title != null)
      setTitle(title);
    if(bodyText != null)
      ((TextView)findViewById(R.id.bodyText)).setText(bodyText);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.simple_text, menu);
    return true;
  }

}
