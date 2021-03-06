package com.whut.basiccentre.frame.utils.qr;
//需要core-3.0.0.jar包

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * 二维码工具类
 */
public class QrCodeKit {

    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸
    private static final int QRCODE_SIZE = 170;
    // LOGO宽度
    private static final int WIDTH = 60;
    // LOGO高度
    private static final int HEIGHT = 60;

    private static BufferedImage createImage(String content, String imgPath,
                                             boolean needCompress) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                        : 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入图片
        QrCodeKit.insertImage(image, imgPath, needCompress);
        return image;
    }

    /**
     * 插入LOGO
     *
     * @param source       二维码图片
     * @param imgPath      LOGO图片地址
     * @param needCompress 是否压缩
     * @throws Exception
     */
    private static void insertImage(BufferedImage source, String imgPath,
                                    boolean needCompress) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            System.err.println("" + imgPath + "   该文件不存在！");
            return;
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) {
            // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            // 绘制缩小后的图
            g.drawImage(image, 0, 0, null);
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content      内容
     * @param imgPath      LOGO地址
     * @param destPath     存放目录
     * @param needCompress 是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath,
                              boolean needCompress) throws Exception {
        BufferedImage image = QrCodeKit.createImage(content, imgPath,
                needCompress);
        mkdirs(destPath);
        String file = new Random().nextInt(99999999) + ".jpg";
        ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
    }

    /**
     * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
     *
     * @param destPath 存放目录
     * @author lanyuan
     * Email: mmm333zzz520@163.com
     * @date 2013-12-11 上午10:16:36
     */
    public static void mkdirs(String destPath) {
        File file = new File(destPath);
        //当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content  内容
     * @param imgPath  LOGO地址
     * @param destPath 存储地址
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath)
            throws Exception {
        QrCodeKit.encode(content, imgPath, destPath, false);
    }

    /**
     * 生成二维码
     *
     * @param content      内容
     * @param destPath     存储地址
     * @param needCompress 是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String destPath,
                              boolean needCompress) throws Exception {
        QrCodeKit.encode(content, null, destPath, needCompress);
    }

    /**
     * 生成二维码
     *
     * @param content  内容
     * @param destPath 存储地址
     * @throws Exception
     */
    public static void encode(String content, String destPath) throws Exception {
        QrCodeKit.encode(content, null, destPath, false);
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content      内容
     * @param imgPath      LOGO地址
     * @param output       输出流
     * @param needCompress 是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String imgPath,
                              OutputStream output, boolean needCompress) throws Exception {
        BufferedImage image = QrCodeKit.createImage(content, imgPath,
                needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }

    /**
     * 生成二维码
     *
     * @param content 内容
     * @param output  输出流
     * @throws Exception
     */
    public static void encode(String content, OutputStream output)
            throws Exception {
        QrCodeKit.encode(content, null, output, false);
    }

    /**
     * 解析二维码
     *
     * @param file 二维码图片
     * @return
     * @throws Exception
     */
    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSourceKit source = new BufferedImageLuminanceSourceKit(
                image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    /**
     * 解析二维码
     *
     * @param path 二维码图片地址
     * @return
     * @throws Exception
     */
    public static String decode(String path) throws Exception {
        return QrCodeKit.decode(new File(path));
    }

    private static List<File> getFilename(String filepath) {
        File file = new File(filepath);
        //File类型可以是文件也可以是文件夹
        File[] fileList = file.listFiles();
        //将该目录下的所有文件放置在一个File类型的数组中
        List<File> wjList = new ArrayList<File>();
        //新建一个文件集合
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                //判断是否为文件
                wjList.add(fileList[i]);
            }
        }
        return wjList;
        //返回目录下的所有文件
    }

    /**
     * 生成有中心图标的二维码并与海报合成
     *
     * @param sourceFilePath 图标所在地址
     * @param waterFilePath  生成的个人二维码所在地址
     * @param saveFilePath   海报和二维码合成图片的保存位置
     * @param text           二维码所代表的网址，即报名网址加个人id
     * @param posterPath     海报所在地址
     */
    public static void createQRcode(String sourceFilePath, String waterFilePath, String saveFilePath, String text, String posterPath) {
        //------生成二维码
        try {
            QrCodeKit.encode(text, sourceFilePath, waterFilePath, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将二维码和海报合成一体
        List<File> wjList = getFilename(waterFilePath);
        waterFilePath += wjList.get(0).getName();
        PictureKit newImageUtils = new PictureKit();
        // 构建叠加层
        BufferedImage buffImg = null;
        try {
            buffImg = PictureKit.watermark(new File(posterPath), new File(waterFilePath), 81, 1004, 1.0f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 输出水印图片
        newImageUtils.generateWaterFile(buffImg, saveFilePath);
        wjList.get(0).delete();
    }/**
     * 生成有中心图标的二维码并与海报合成
     *
     * @param waterFilePath  生成的个人二维码所在地址
     * @param saveFilePath   海报和二维码合成图片的保存位置
     * @param text           二维码所代表的网址，即报名网址加个人id
     * @param posterPath     海报所在地址
     */
    public static BufferedImage createQRcode(String waterFilePath, String saveFilePath, String text, String posterPath) {
        //------生成二维码
        try {
            QrCodeKit.encode(text, "", waterFilePath, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将二维码和海报合成一体
        List<File> wjList = getFilename(waterFilePath);
        waterFilePath += wjList.get(0).getName();
        // 构建叠加层
        BufferedImage buffImg = null;
        try {
            buffImg = PictureKit.watermark(new File(posterPath), new File(waterFilePath), 81, 1004, 1.0f);
            wjList.get(0).delete();
            return buffImg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        wjList.get(0).delete();
        return null;
    }

}