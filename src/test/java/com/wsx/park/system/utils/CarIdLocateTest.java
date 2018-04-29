package com.wsx.park.system.utils;

import com.wsx.park.system.utils.CarIdUtils.CarIdLocate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opencv.core.Mat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.opencv.highgui.Highgui.imread;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarIdLocateTest {
    @Test
    public void testCarIdLocate() {
        String imgPath = "a.png";
        Mat img = imread(imgPath);
        CarIdLocate carIdLocate = new CarIdLocate();
        carIdLocate.plateLocate(img);
    }
}
