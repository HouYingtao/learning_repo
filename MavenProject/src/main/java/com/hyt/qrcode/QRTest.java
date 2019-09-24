package com.hyt.qrcode;

import org.junit.Test;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2019-09-24 22:32
 * @since 1.8
 **/
public class QRTest {
    @Test
    public void qrcode(){
        QRCodeUtil.encodeQRCode("www.baidu.com", "C:\\test\\first2.png");
    }

}
