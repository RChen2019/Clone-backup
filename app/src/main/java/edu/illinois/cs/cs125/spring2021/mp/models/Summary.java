package edu.illinois.cs.cs125.spring2021.mp.models;

import androidx.annotation.NonNull;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Model holding the course summary information shown in the course list.
 *
 * <p>You will need to complete this model for MP0.
 */
public class Summary implements SortedListAdapter.ViewModel {
  private String year;

  /**
   * Get the year for this Summary.
   *
   * @return the year for this Summary
   */
  public final String getYear() {
    return year;
  }

  private String semester;

  /**
   * Get the semester for this Summary.
   *
   * @return the semester for this Summary
   */
  public final String getSemester() {
    return semester;
  }

  private String department;

  /**
   * Get the department for this Summary.
   *
   * @return the department for this Summary
   */
  public final String getDepartment() {
    return department;
  }

  private String number;

  /**
   * Get the number for this Summary.
   *
   * @return the number for this Summary
   */
  public final String getNumber() {
    return number;
  }

  private String title;

  /**
   * Get the title for this Summary.
   *
   * @return the title for this Summary
   */
  public final String getTitle() {
    return title;
  }

  /** Create an empty Summary. */
  @SuppressWarnings({"unused", "RedundantSuppression"})
  public Summary() {}

  /**
   * Create a Summary with the provided fields.
   *
   * @param setYear the year for this Summary
   * @param setSemester the semester for this Summary
   * @param setDepartment the department for this Summary
   * @param setNumber the number for this Summary
   * @param setTitle the title for this Summary
   */
  public Summary(
      final String setYear,
      final String setSemester,
      final String setDepartment,
      final String setNumber,
      final String setTitle) {
    year = setYear;
    semester = setSemester;
    department = setDepartment;
    number = setNumber;
    title = setTitle;
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof Summary)) {
      return false;
    }
    Summary course = (Summary) o;
    return Objects.equals(year, course.year)
        && Objects.equals(semester, course.semester)
        && Objects.equals(department, course.department)
        && Objects.equals(number, course.number);
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(year, semester, department, number);
  }

  /** {@inheritDoc} */
  @Override
  public <T> boolean isSameModelAs(@NonNull final T model) {
    return equals(model);
  }

  /** {@inheritDoc} */
  @Override
  public <T> boolean isContentTheSameAs(@NonNull final T model) {
    return equals(model);
  }

  /** Compares two things I presume. */
  public static final Comparator<Summary> COMPARATOR = (courseModel1, courseModel2) -> {
    String firstCompare = courseModel1.department + " " + courseModel1.number + " " + courseModel1.title;
    String secondCompare = courseModel2.department + " " + courseModel2.number + " " + courseModel2.title;
    return firstCompare.compareTo(secondCompare);
  };

  /**
   * Lists courses probably.
   *
   * @param courses be the courses.
   * @param text be the text.
   * @return the courses guy.
   */
  public static List<Summary> filter(
          @NonNull final List<Summary> courses, @NonNull final String text) {
    //List<Summary> clone = Collections.emptyList();
    List<Summary> clone = new ArrayList<Summary>();
    if (courses.size() == 0) {
      return courses;
    }
    for (int i = 0; i < courses.size(); i++) {
      Summary temp = courses.get(i);
      if ((temp.number).contains(text) || (temp.title).toLowerCase().contains(text.toLowerCase())) {
        clone.add(new Summary(temp.year, temp.semester, temp.department, temp.number, temp.title));
      }
    }
    return clone;
  }
}
