package ru.stqa.trainings.testng.tricky2.sample31;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreInBrowser {
  
  public static enum Browser {
    ALL,
    ANDROID,
    CHROME,
    HTMLUNIT,
    FIREFOX,
    IE,
    IPHONE,
    MARIONETTE,
    OPERA,
    OPERA_MOBILE,
    PHANTOMJS,
    REMOTE,
    SAFARI,
  }

  Browser[] value();

}
