package com.vikko.demo.copy.aiui;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Security;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

/**
 * @author vikko
 * @date 2020/6/18 19:16
 */
public class impl {


//    private static final String token = "e1ea7c2e388a9983";
//    private static final String aeskey = "0e1ea7c2e388a998";

//
//    @Override
//    public HttpServletResponse aiuiGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//        log.info("======================== aiui后处理开始 get=======================");
//        //get请求，用于服务校验认证阶段
//
//        String signature = request.getParameter("signature");
//        String timestamp = request.getParameter("timestamp");
//        String rand = request.getParameter("rand");
//        log.info("参数为【{}，{}，{}】", signature, timestamp,rand);
//        if (signature == null || timestamp == null || rand == null) {
//            return null;
//        }
//        if (signature.isEmpty() || rand.isEmpty() || timestamp.isEmpty()) {
//            return null;
//        }
//
//        //对三个参数进行字典排序
//        List<String> list = new ArrayList<String>();
//
//        list.add(token);
//        list.add(timestamp);
//        list.add(rand);
//        Collections.sort(list);
//
//        String localSig = "";
//        for (int i = 0; i < list.size(); i++) {
//            localSig += list.get(i);
//        }
//        //sha1加密
//        String sigtureSha1 = DigestUtils.sha1Hex(localSig);
//
//        //参数校验通过，返回token给AIUI，否则自行处理
//        if (sigtureSha1.equals(signature)) {
//            log.info("======================== 签名校验成功 =======================");
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().append(DigestUtils.sha1Hex(token));
//        } else {
//            //这里可以不用发送，写入日志系统或告警组件即可，AIUI不会接收处理。
//            response.getWriter().append("check token failed" + sigtureSha1);
//        }
//
//
//        return response;
//    }
//
//    @Override
//    public HttpServletResponse aiuiPost(HttpServletRequest request,HttpServletResponse response) throws Exception {
//        log.info("======================== aiui后处理开始 post =======================");
//        String encrypttype = request.getParameter("encrypttype");
//
//        log.info("encrypttype参数为【{}】", encrypttype);
//        // 消息加密，解密
//        if (encrypttype.equals("aes")) {
//
//            log.info( "================aes编码格式");
//
//            int len = request.getContentLength();
//            ServletInputStream inputStream = request.getInputStream();
//            byte[] buffer = new byte[len];
//            inputStream.read(buffer, 0, len);
//
//            //FileUtils.saveBytesToFile(buffer);
//            try {
//                String content = decrypt(aeskey, aeskey, buffer);
//                JSONObject fullResult = JSONObject.parseObject(content);
//                JSONObject msg = fullResult.getJSONObject("Msg");
//                String text = msg.getString("Content");
//                log.info("========================解码后base64: " + text);
//                Base64.Decoder decoder = Base64.getDecoder();
//                byte[] decode = decoder.decode(text);
//                log.info("========================解码后Stirng: " + new String(decode));
//            } catch (Exception e) {
//                e.printStackTrace();
//                log.info("========================编码错误" + e.getMessage());
//            }
//            //构建自定义格式数据给AIUI服务器，AIUI服务器全量下发给客户端。
//            JSONObject customData = new JSONObject();
//            customData.put("key", "custome");
//            customData.put("content", "这是一条来自后处理的测试结果");
//
//            response.setContentType("application/json;charset=utf-8");
//            log.info("======================== 返回值未编码: " + customData.toString());
//
//            log.info("======================== 返回值编码: " + encrypt(aeskey, aeskey, customData.toString()));
//
//            Base64.Encoder encoder = Base64.getEncoder();
//            byte[] returnMsg64 = encoder.encode(customData.toString().getBytes());
//            response.getWriter().append(encrypt(aeskey, aeskey, new String(returnMsg64,"utf-8")));
//
//            log.info("======================== 返回值base64编码: " + new String(returnMsg64));
//
//            log.info("======================== 返回值aes编码: " + encrypt(aeskey, aeskey, new String(returnMsg64)));
//
//
//        } else {
//            log.info( "Normal Mode.");
//            // get request body.
//            ServletInputStream inputStream = request.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String line = "";
//            StringBuilder aiuiPostData = new StringBuilder();
//            while ((line = bufferedReader.readLine()) != null) {
//                aiuiPostData.append(line);
//            }
//
//            log.info("aiui data post " + aiuiPostData.toString());
//
//            JSONObject aiuiPostJson = (JSONObject) JSONObject.parse(aiuiPostData.toString());
//            String sub = aiuiPostJson.getString("FromSub");
//
//            log.info( "aiui data sub  = " + sub);
//
//            JSONObject msgJson = aiuiPostJson.getJSONObject("Msg");
//            String content = msgJson.getString("Content");
//            log.info("========================decrypt data: " + content);
//            JSONObject customData = new JSONObject();
//            customData.put("key", "custom");
//            customData.put("content", "这是一条来自后处理的测试结果");
//
//            log.info( "resonse: customData  = " + customData.toJSONString());
//
//            //repsonse to AIUI server
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().append(customData.toJSONString());
//        }
//        log.info("======================== aiui后处理结束 post =======================");
//        return response;
//    }
//
//    //加密
//    public static String encrypt(String secretKey, String ivKey, String content){
//        String encryptMode = "AES/CBC/PKCS7Padding";
//        String decryptContent = null;
//        try {
//            byte[] secrecKeyByte = secretKey.getBytes("utf-8");
//
//            Security.addProvider(new BouncyCastleProvider());
//            SecretKeySpec keyspec = new SecretKeySpec(secrecKeyByte, "AES");
//            Cipher cipher = Cipher.getInstance(encryptMode, "BC");
//
//            IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes("utf-8"));
//            cipher.init(Cipher.ENCRYPT_MODE, keyspec, iv);
//            byte[] byte_content = cipher.doFinal(content.getBytes());
//
//            decryptContent = org.apache.commons.net.util.Base64.encodeBase64String(byte_content);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return decryptContent;
//    }
//
//    //解密
//    public static String decrypt(String secretKey, String ivKey, byte[] content){
//        String encryptMode = "AES/CBC/PKCS7Padding";
//        String decryptContent = null;
//        try {
//            byte[] secrecKeyByte = secretKey.getBytes("utf-8");
//
//            Security.addProvider(new BouncyCastleProvider());
//            SecretKeySpec keyspec = new SecretKeySpec(secrecKeyByte, "AES");
//            Cipher cipher = Cipher.getInstance(encryptMode, "BC");
//
//            IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes("utf-8"));
//            cipher.init(Cipher.DECRYPT_MODE, keyspec, iv);
//            byte[] byte_content = cipher.doFinal(content);
//
//            decryptContent = new String(byte_content, "utf-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return decryptContent;
//    }
}
