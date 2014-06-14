package ru.stqa.trainings.testng.simple4.sample18;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class SoftHamcrestAssert extends SoftAssert {

  public <T> void assertThat(final T actual, final Matcher<? super T> matcher) {
    doAssert(new IAssert() {
      @Override
      public void doAssert() {
        MatcherAssert.assertThat(actual, matcher);
      }

      @Override
      public Object getActual() {
        return actual;
      }

      @Override
      public Object getExpected() {
        return null;
      }

      @Override
      public String getMessage() {
        return null;
      }
    });
  }

  public <T> void assertThat(final String reason, final T actual, final Matcher<? super T> matcher) {
    doAssert(new IAssert() {
      @Override
      public void doAssert() {
        MatcherAssert.assertThat(reason, actual, matcher);
      }

      @Override
      public Object getActual() {
        return actual;
      }

      @Override
      public Object getExpected() {
        return null;
      }

      @Override
      public String getMessage() {
        return reason;
      }
    });
  }

}
