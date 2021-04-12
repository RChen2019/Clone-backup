package edu.illinois.cs.cs125.spring2021.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.illinois.cs.cs125.spring2021.mp.R;
import edu.illinois.cs.cs125.spring2021.mp.application.CourseableApplication;
import edu.illinois.cs.cs125.spring2021.mp.databinding.ActivityCourseBinding;
import edu.illinois.cs.cs125.spring2021.mp.models.Course;
import edu.illinois.cs.cs125.spring2021.mp.models.Summary;
import edu.illinois.cs.cs125.spring2021.mp.network.Client;

/** CourseActivity does something. */
public class CourseActivity extends AppCompatActivity implements Client.CourseClientCallbacks {
  @SuppressWarnings({"unused", "RedundantSuppression"})
  private static final String TAG = CourseActivity.class.getSimpleName();
  // Binding to the layout in activity_main.xml
  private ActivityCourseBinding binding;

  /** @param savedInstanceState */
  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "CourseActivity launched");
    // Bind to the layout in activity_main.xml
    binding = DataBindingUtil.setContentView(this, R.layout.activity_course);

    ObjectMapper objectMapper = new ObjectMapper();
    Intent intent = getIntent();
    String course = intent.getStringExtra("COURSE");
    try {
      Summary summary = objectMapper.readValue(course, Summary.class);
      CourseableApplication application = (CourseableApplication) getApplication();
      binding.title.setText(
          summary.getDepartment() + " " + summary.getNumber() + " : " + summary.getTitle());
      Log.i("NetworkExample", "MainActivity getSummary");
      application.getCourseClient().getCourse(summary, this);

    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  /**
   * @param summary the year that was retrieved
   * @param course the semester that was retrieved
   */
  @Override
  public void courseResponse(final Summary summary, final Course course) {
    binding.description.setText(course.getDescription());
  }
}
