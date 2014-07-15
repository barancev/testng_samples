package ru.stqa.trainings.testng.tricky4.sample34;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;

public class VideoCreator {

  private static final long FRAME_RATE = 25;
  private static final Dimension SCREEEN_BOUNDS = Toolkit.getDefaultToolkit()
      .getScreenSize();

  private File outputFile;
  private AtomicBoolean pleaseStop = new AtomicBoolean(false);
  private boolean stoppedCreation = true;

  public VideoCreator() {

  }

  public VideoCreator(File outputFile) {
    this.outputFile = outputFile;
  }

  public void createVideoFromScreens() {
    IMediaWriter writer = null;
    try {
      if (getOutputFile() == null) {
        throw new IllegalStateException(
            "Output video file cannot be null");
      }

      setStoppedCreation(false);

      writer = ToolFactory.makeWriter(getOutputFile()
          .getAbsolutePath());
      writer.addVideoStream(0, 0, SCREEEN_BOUNDS.width,
          SCREEEN_BOUNDS.height);

      long startTime = System.nanoTime();

      while (!getPleaseStop()) {
        BufferedImage screen = getDesktopScreenshot();
        BufferedImage bgrScreen = convertToType(screen, BufferedImage.TYPE_3BYTE_BGR);

        writer.encodeVideo(0, bgrScreen, System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

        try {
          Thread.currentThread().sleep(1000 / FRAME_RATE);
        } catch (InterruptedException e) {
          // Ignore
        }
      }
      setStoppedCreation(true);
    } finally {
      if(writer!=null){
        writer.flush();
        writer.close();
      }
      
    }
  }

  private BufferedImage getDesktopScreenshot() {
    try {
      Robot robot = new Robot();
      Rectangle captureSize = new Rectangle(SCREEEN_BOUNDS);
      return robot.createScreenCapture(captureSize);
    } catch (AWTException e) {
      throw new RuntimeException(
          "Error occurred while getting desktop screenshot", e);
    }
  }

  public File getOutputFile() {
    return outputFile;
  }

  public void setOutputFile(File outputFile) {
    this.outputFile = outputFile;
  }

  public boolean getPleaseStop() {
    return pleaseStop.get();
  }

  public void setPleaseStop(boolean pleaseStop) {
    this.pleaseStop.set(pleaseStop);
  }

  public boolean isStoppedCreation() {
    return stoppedCreation;
  }

  private void setStoppedCreation(boolean stoppedCreation) {
    this.stoppedCreation = stoppedCreation;
  }

  public static BufferedImage convertToType(BufferedImage sourceImage, int targetType) {
    BufferedImage image = null;
    
    if (sourceImage.getType() == targetType) {
      image = sourceImage;
    } else {
      image = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), targetType);
      image.getGraphics().drawImage(sourceImage, 0, 0, null);
    }
    
    return image;
  }
}