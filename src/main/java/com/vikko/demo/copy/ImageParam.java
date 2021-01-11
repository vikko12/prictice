package com.vikko.demo.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vikko
 * @date 2020/5/21 16:59
 */
public class ImageParam {
//    public static SampleArticle composeSampleArticle(Article from) {
//        String preParam = "?x-oss-process=image/resize,m_mfit,w_";
//        SampleArticle info = new SampleArticle();
//        if (from != null) {
//            info.setObjectId(from.getObjectId());
//            info.setArticleId(from.getObjectId());
//            info.setActivityId(from.getActivityId());
//            info.setContent(from.getContent());
//            info.setContentText(from.getContentText());
//            info.setActivityId(from.getActivityId());
//            if (!StringUtil.isTrimEmpty(from.getLocationLat()) && !StringUtil.isTrimEmpty(from.getLocationLng())) {
//                if (!(from.getLocationLat().equals("0") || from.getLocationLng().equals("0"))) {
//                    info.setLocationLat(from.getLocationLat());
//                    info.setLocationLng(from.getLocationLng());
//                    info.setLocationName(from.getLocationName());
//                }
//            }
//            info.setState(from.getState());
//            info.setTitle(from.getTitle());
//            info.setPartnerType(from.getPartnerType());
//            info.setType(from.getType());
//            info.setUserId(from.getUserId());
//            info.setCreatedTime(from.getCreatedTime() != null ? from.getCreatedTime().getTime() : 0L);
//            info.setUpdatedTime(from.getUpdatedTime() != null ? from.getUpdatedTime().getTime() : 0L);
////            info.setImages(StringUtils.isEmpty(from.getImages()) ? null : JSON.parseArray(from.getImages(), Cover.class));
//
//            ArrayList<Cover> coverList = new ArrayList<>();
//            if(from.getImages() != null){
//                List<JSONObject> jsonObjects = JSON.parseArray(from.getImages(), JSONObject.class);
//                for (JSONObject jsonObject : jsonObjects) {
//                    String rawQualityParam = defaultRawQuality;
//                    String middleQualityParam = defaultMiddleQuality;
//                    String lowQualityParam = defaultLowQuality;
//                    JSONObject imageOssParam = jsonObject.getJSONObject("imageOssParam");
//                    Integer width = jsonObject.getInteger("width");
//                    Integer height = jsonObject.getInteger("height");
//                    String url = jsonObject.getString("url");
//                    //拼接format参数
//                    String format = jsonObject.getString("format");
//                    //参数判断，为空则拿默认值
//                    if(null != imageOssParam){
//                        ImageOssParam param = imageOssParam.toJavaObject(ImageOssParam.class);
//                        Integer widthTem = param.getRawWidth() == null ? 1440 : param.getRawWidth();
//                        Integer heightTem = param.getRawHeight() == null ? 2560 : param.getRawHeight();
//                        rawQualityParam = preParam + widthTem + ",h_" + heightTem + "/quality,q_100";
//                        middleQualityParam = preParam + param.getMiddleWidth() + ",h_" + param.getMiddleHeight() +
//                                "/quality,q_" + param.getMiddleQuality() + webpString;
//                        lowQualityParam = preParam + param.getLowWidth() + ",h_" + param.getLowHeight() +
//                                "/quality,q_" + param.getLowQuality() + webpString;
//                    }
//
//                    if(height * maxWidth < width * maxHeight){
//                        rawQualityParam = replaceFit(rawQualityParam);
//                        middleQualityParam = replaceFit(middleQualityParam);
//                        lowQualityParam = replaceFit(lowQualityParam);
//                    }
//
//                    //单图特殊处理
//                    if(jsonObjects.size() == 1){
//                        lowQualityParam = "?x-oss-process=image/resize,m_mfit,w_800,h_800/quality,q_50/format,webp";
//                    }
//
//                    //处理格式
//                    if("gif".equalsIgnoreCase(format)){
//                        lowQualityParam = lowQualityParam.replace(webpString,jpgString);
//                        middleQualityParam = middleQualityParam.replace(webpString, gifString);
//                    }
//                    jsonObject.put("rawQualityParam", url + rawQualityParam);
//                    jsonObject.put("middleQualityParam", url + middleQualityParam);
//                    jsonObject.put("lowQualityParam", url + lowQualityParam);
//                    coverList.add(jsonObject.toJavaObject(Cover.class));
//                }
//            }
//            info.setImages(coverList);
//
//            info.setContentImages(StringUtils.isEmpty(from.getContentImages()) ? null : JSON.parseArray(from.getContentImages(), Cover.class));
//            if (!StringUtil.isTrimEmpty(from.getCover())) {
//                List<Cover> covers = Cover.multiConvert(from.getCover());
//                if (covers != null && covers.size() > 0) {
//                    info.setCover(covers.get(0));
//                }
//            }
//            info.setGenerateTemplate(from.getGenerateTemplate());
//        }
//        return info;
//    }
}
