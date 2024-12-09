package Utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class ScreenShot {
	public static void TakesScreenShot(String className) {
		try {
			Robot robot = new Robot();
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			BufferedImage screenCapture = robot.createScreenCapture(screenRect);
			String timestamp = sdf.format(d);
			File outputDir = new File("src/main/resources/screenshots");
			if (!outputDir.exists()) {
				outputDir.mkdirs();
			}
			File outputFile = new File(outputDir, className + "_" + timestamp + ".png");
			ImageIO.write(screenCapture, "png", outputFile);
			System.out.println("Screenshot saved to: " + outputFile.getAbsolutePath());
		} catch (AWTException | IOException ex) {
			System.err.println("Failed to capture screenshot: " + ex.getMessage());
		}
	}
}