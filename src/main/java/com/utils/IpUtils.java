package com.utils;

import java.net.InetAddress;

/**
 * @author YangQing
 * @version 1.0.0
 */

public class IpUtils {
    public static String getIp() {
        // TODO Auto-generated method stub
        InetAddress ia = null;
        try {
            ia = ia.getLocalHost();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ia.getHostAddress();
    }
}
