package compareimages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Compare {
	static Logger log = LogManager.getLogger(Compare.class);
	
	@Test
	public void testng() throws IOException {
		try {
			
		
		BufferedImage expectedImage = ImageIO.read(new File("E:\\Chickmagalur\\1.JPG"));
		BufferedImage actualImage = ImageIO.read(new File("E:\\Chickmagalur\\2.JPG"));
		
		//create an object of image differ class to compare images
		ImageDiffer differ = new ImageDiffer();
		ImageDiff diff = differ.makeDiff(expectedImage, actualImage);
		
		//Asserting for comparing images
		//1st checking if the images are same or not
		if (diff.hasDiff())
		{
			log.info("Images are not similar");
		}
		else
			log.info("Images are similar");
		
	
		//2nd way of Asserting using Assert class
		Assert.assertFalse(diff.hasDiff(), "images are not matching");
		}
		
		catch(AssertionError e)
		{
			e.printStackTrace();
		}
		}

	}


