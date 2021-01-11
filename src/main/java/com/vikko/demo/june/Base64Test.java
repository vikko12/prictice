package com.vikko.demo.june;

import java.util.Base64;

/**
 * @author vikko
 * @date 2020/6/18 17:01
 */
public class Base64Test {

    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode("String".getBytes());
        System.out.println("=======s" + new String(encode));
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(encode);

        System.out.println("decode ==========" + new String(decode));


    }
}
