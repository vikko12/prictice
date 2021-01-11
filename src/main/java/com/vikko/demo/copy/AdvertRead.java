package com.vikko.demo.copy;

import java.util.Date;
import java.util.Objects;

/**
 * @author vikko
 * @date 2020/6/4 18:59
 */
public class AdvertRead {
//    boolean isIdEquals = Objects.equals(advertId,AdvertConstants.ADVERT_ID_FOR_AFTER_182);
//            if(isIdEquals){
//        String key = ADVERT_KEY_ + advertId + userId;
//        String advertCache = redisService.getString(key);
//        if(StringUtil.isTrimEmpty(advertCache)){
//            Date date = new Date(AdvertConstants.VERSION_182_DATE_LONG);
//            int createAfterDate = userMapper.isCreateAfterDate(date, userId);
//            boolean isNewUser  = 1 == createAfterDate ;
//            if(isNewUser){
//                boolean beyondRate = Math.random() >= adRate;
//                //新用户且未被选中
//                if(beyondRate){
//                    advertisementActivateService.readAd(userId, advertId);
//                    return screenAdvertResp;
//                }else {
//                    //被概率选中,设置redis
//                    redisService.setString(key,"1");
//
//                }
//            }else {
//                //老用户直接设置已读
//                advertisementActivateService.readAd(userId, advertId);
//                return screenAdvertResp;
//            }
//        }else {
//            //redis中含有该用户信息，则设置弹窗次数 + 1
//            AdvertState advertState = advertMapper.selectAdvertStateEntity(advertId, userId);
//            if(Objects.isNull(advertState)){
//                AdvertState originAdvertState = AdvertState.builder().userId(userId).advertId(advertId).adComeOutTime(1).objectId(IdUtil.getId()).build();
//                advertMapper.insertAdvertState(originAdvertState);
//            }else {
//                advertMapper.updateReadCount(advertId, userId);
//            }
//        }
//
//
//    }
}
