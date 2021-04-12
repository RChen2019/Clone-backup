package edu.illinois.cs.cs125.spring2021.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.illinois.cs.cs125.spring2021.mp.application.CourseableApplication;
import edu.illinois.cs.cs125.spring2021.mp.models.Course;
import edu.illinois.cs.cs125.spring2021.mp.models.Summary;
import edu.illinois.cs.cs125.spring2021.mp.network.Client;

public class CourseActivity extends AppCompatActivity implements Client.CourseClientCallbacks {
  @SuppressWarnings({"unused", "RedundantSuppression"})
  private static final String TAG = CourseActivity.class.getSimpleName();

  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "CourseActivity launched");

    Intent intent = getIntent();
    String course = intent.getStringExtra("COURSE");
    CourseableApplication application = (CourseableApplication) getApplication();
    Log.i("NetworkExample", "MainActivity getSummary");
    //application.getCourseClient().getCourse(summary, this);
  }
    //Course courses = objectMapper.readValue(response, Course.class);
  @Override
  public void courseResponse(final Summary summary, final Course course) {}
}
