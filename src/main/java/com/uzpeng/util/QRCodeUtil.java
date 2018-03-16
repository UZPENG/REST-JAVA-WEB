package com.uzpeng.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @author serverliu on 2018/3/11.
 */
public class QRCodeUtil {
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 800;
    private static final String DEFAULT_CHARSET = "utf-8";
    private static final String DEFAULT_FORMAT = "png";
    private static final String DEFAULT_PATH = "/";

    public static Path encode(String url, int width, int height){
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        HashMap<EncodeHintType, String> map = new HashMap<>();
        map.put(EncodeHintType.CHARACTER_SET, DEFAULT_CHARSET);
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, width, height, map);

            Path path = Paths.get(DEFAULT_PATH);
            MatrixToImageWriter.writeToPath(bitMatrix, DEFAULT_FORMAT, path);

            return path;
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
