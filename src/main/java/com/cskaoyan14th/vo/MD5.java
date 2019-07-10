package com.cskaoyan14th.vo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String getMd5(String username,String password ){
        //1.获取Java语言中提供的Md5算法

        String result = null;
        //将密码个用户名拼接
        String s = username + password ;

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //2.传入密码，返回一个表示MD5的字节数组（16字节）
            byte[] digest = md5.digest(s.getBytes());
            //3.对结果进行处理：将MD5值（十六个字节的字节数组还原成字符串）
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                //3.1 将byte变为int （一个字节对应一个两位的16进制数）
                int i  = b&0x000000FF;
                //3.2 int转为16进制的字符串（将一个两位数的16进制数 转为 一个字节）
                String st = Integer.toHexString(i);
                //3.3 将每个字节对应的字符串一次放入StringBuffer 中
                if (st.length() == 1){
                    stringBuffer.append(0);
                }
                stringBuffer.append(st);
            }
            result = stringBuffer.toString();

            return result;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

}
