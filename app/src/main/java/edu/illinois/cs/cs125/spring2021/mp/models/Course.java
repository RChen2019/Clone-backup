package edu.illinois.cs.cs125.spring2021.mp.models;

/** Specific information of course. */
public class Course extends Summary {

  /** Create an empty Summary. */
  @SuppressWarnings({"unused", "RedundantSuppression"})
  public Course() {}
  private String description;
  /**
   * Create a Summary with the provided fields.
   *
   * @param setDescription the desc for Summary
   */
  public Course(
      final String setDescription) {
    description = setDescription;
  }
  /**
   * Get description.
   *
   * @return the description k
   */
  public final String getDescription() {
    return description;
  }
}
