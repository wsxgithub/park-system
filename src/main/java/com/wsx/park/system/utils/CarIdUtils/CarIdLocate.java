package com.wsx.park.system.utils.CarIdUtils;

import org.opencv.core.Mat;
import org.opencv.core.Size;

import java.util.Vector;

import static org.opencv.core.Core.addWeighted;
import static org.opencv.core.Core.convertScaleAbs;
import static org.opencv.core.CvType.CV_16S;
import static org.opencv.highgui.Highgui.imwrite;
import static org.opencv.imgproc.Imgproc.*;

public class CarIdLocate {
    public void plateLocate(Mat src) {
        Vector<Mat> resultVec = new Vector<Mat>();

        Mat src_blur = new Mat();
        Mat src_gray = new Mat();
        Mat grad = new Mat();

        int scale = SOBEL_SCALE;
        int delta = SOBEL_DELTA;
        int ddepth = SOBEL_DDEPTH;

        // 高斯模糊。Size中的数字影响车牌定位的效果。
        GaussianBlur(src, src_blur, new Size(gaussianBlurSize, gaussianBlurSize), 0, 0, BORDER_DEFAULT);
        imwrite("tmp/debug_GaussianBlur.jpg", src_blur);

        // Convert it to gray 将图像进行灰度化
        cvtColor(src_blur, src_gray, COLOR_RGB2GRAY);
        imwrite("tmp/debug_gray.jpg", src_gray);

        // 对图像进行Sobel 运算，得到的是图像的一阶水平方向导数。

        // Generate grad_x and grad_y
        Mat grad_x = new Mat();
        Mat grad_y = new Mat();
        Mat abs_grad_x = new Mat();
        Mat abs_grad_y = new Mat();

        Sobel(src_gray, grad_x, ddepth, 1, 0, 3, scale, delta, BORDER_DEFAULT);
        convertScaleAbs(grad_x, abs_grad_x);

        Sobel(src_gray, grad_y, ddepth, 0, 1, 3, scale, delta, BORDER_DEFAULT);
        convertScaleAbs(grad_y, abs_grad_y);

        // Total Gradient (approximate)
        addWeighted(abs_grad_x, SOBEL_X_WEIGHT, abs_grad_y, SOBEL_Y_WEIGHT, 0, grad);
        imwrite("tmp/debug_Sobel.jpg", grad);
    }

    // PlateLocate所用常量
    public static final int DEFAULT_GAUSSIANBLUR_SIZE = 5;
    public static final int SOBEL_SCALE = 1;
    public static final int SOBEL_DELTA = 0;
    public static final int SOBEL_DDEPTH = CV_16S;
    public static final int SOBEL_X_WEIGHT = 1;
    public static final int SOBEL_Y_WEIGHT = 0;
    public static final int DEFAULT_MORPH_SIZE_WIDTH = 17;
    public static final int DEFAULT_MORPH_SIZE_HEIGHT = 3;

    // 高斯模糊所用变量
    protected int gaussianBlurSize = DEFAULT_GAUSSIANBLUR_SIZE;

}
