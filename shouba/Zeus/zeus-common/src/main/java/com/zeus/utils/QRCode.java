package com.zeus.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.zeus.common.QRCodeUrl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Description 二维码生成
 * @author:wangdi
 * @date:2019/1/7
 * @ver:1.0
 */
public class QRCode {

    public static QRCodeUrl orc(Long userId, String url, Long id) {


        int num = (int) ((Math.random() * 9 + 1) * 100000);

        String contents = id + "";
        String orcurl = url + userId + ".png";
        MultiFormatWriter writer = new MultiFormatWriter();
        QRCodeUrl qrCode = new QRCodeUrl();

        int w = 200;
        int h = 200;
        HashMap<EncodeHintType, Object> hints = new HashMap<>(16);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, w, h, hints);

            MatrixToImageWriter.writeToPath(bitMatrix, "png", new File(orcurl).toPath());
            qrCode.setIdWorker(Long.getLong(contents));
            qrCode.setQrCidenum(Integer.toUnsignedLong(num));
            qrCode.setQrCideUrl(orcurl);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return qrCode;


    }

    public static void main(String[] args) {
        QRCodeUrl qr = new QRCodeUrl();
        Long l1=new Long(101);
        Long l2=new Long(102);

        qr = orc(l1, "D:/img/", l2);
        System.out.println(qr.toString());
    }
}

