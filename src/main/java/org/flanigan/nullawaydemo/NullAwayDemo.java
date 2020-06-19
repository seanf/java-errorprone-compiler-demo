package org.flanigan.nullawaydemo;

import org.jetbrains.annotations.Nullable;

// This class should fail to compile when using errorprone + nullaway
public class NullAwayDemo
{
  private String message = "hello";
  public void reset() {
    // [NullAway] assigning @Nullable expression to @NonNull field
    message = null;
  }

  // NullAway: This should be @Nullable because it return null
  private String shouldBeNullableString() {
    return null;
  }

  // [NullAway] returning @Nullable expression from method with @NonNull return type
  private @Nullable String nullableString() {
    return null;
  }

  public static void main(String[] args) {
    NullAwayDemo demo = new NullAwayDemo();
    // [NullAway] dereferenced expression demo.nullableString() is @Nullable
    System.out.println(demo.nullableString().toLowerCase());
    System.out.println(demo.message);
  }
}
