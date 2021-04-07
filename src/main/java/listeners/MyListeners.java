package listeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;
import utilities.Constants;

public class MyListeners implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			// String fileName = "screenshot_" +System.currentTimeMillis() + ".jpg";
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AShot ashot = new AShot();
			ShootingStrategy strategy = ShootingStrategies.viewportPasting(3000);
			ashot = ashot.shootingStrategy(strategy);
			BufferedImage image = ashot.takeScreenshot(Constants.driver).getImage();

			ImageIO.write(image, "jpg", new File("Screenshots/screenshot_" + System.currentTimeMillis() + ".jpg"));
		} catch (IOException e) {
			System.err.println("unable to find image");
			e.printStackTrace();
		} finally {
			Constants.driver.quit();
		}
		// System.out.println(driver.getTitle());.NoSuchSessionException:
	}

}
