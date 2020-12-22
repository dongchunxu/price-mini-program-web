package com.dianwoyin.price.utils;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public class EncryptUtils {
    private static final String KEY_MD5 = "MD5";

    public static String md5(String inputStr) {
        return inputStr;
//        BigInteger bigInteger = null;
//        try {
//            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
//            byte[] inputData = (inputStr + System.currentTimeMillis()).getBytes();
//            md.update(inputData);
//            bigInteger = new BigInteger(md.digest());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bigInteger.toString(16);
    }

}
