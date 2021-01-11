package com.vikko.demo.copy;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author vikko
 * @date 2020/5/25 15:25
 */
public class TopicState {
//    public Map<String, NodeStateResp> checkNodeStateRebuild(String userId, List<String> topicIds) {
//
//        if (CollectionUtils.isEmpty(topicIds)) {
//            return new HashMap<>();
//        }
//        Map<String, NodeStateResp> result = new HashMap<>(topicIds.size());
//
//        // 获取id映射关系，topicId和coreId
//        Map<String, Long> idMap = CollectionUtilx
//                .list2map(knowledgeTopicMapper.fetchIdMaps(topicIds), IdMap::getAppId, IdMap::getCoreId);
//        // 取帖子数量
//        // 批量获取群详情
//        List<CoreTopicInfo> topicEntities = coreService
//                .getTopicDetailMulti(new ArrayList<>(idMap.values()));
//
//        Map<Long, List<Long>> topicIdAndPostIds = topicEntities.stream().collect(Collectors.toMap(data ->data.topicId, data ->data.postIds));
//        topicIdAndPostIds.forEach((k,v)->{
//            String topicId = getTopicIdByCoreId(k, idMap);
//
//            NodeStateResp nodeStateResp = new NodeStateResp();
//            String key = USER_TOPIC_READ  + topicId;
//            //redis中的最大id；
//            Map<String, TopicMaxIdInfo> cache = (Map<String, TopicMaxIdInfo>) redisService.getObject(key);
//            redisService.getObject(key);
//            if(Objects.isNull(cache) || Objects.isNull(cache.get(userId))){
//                nodeStateResp.setHasNewGene(true);
//                nodeStateResp.setHasNewDiscuss(true);
////                cache.put(userId,new TopicMaxIdInfo());
//                result.put(topicId,nodeStateResp);
//            }else {
//                TopicMaxIdInfo topicMaxIdInfo = cache.get(userId);
//                Long maxArticleId = topicMaxIdInfo.getMaxArticleId();
//                Long maxDiscussId = topicMaxIdInfo.getMaxDiscussId();
//
//                List<String> articleIds = visvaCoreService.getPostIdStrings(v);
//
//                Long dbMaxArticleId = articleService.selectMaxIdByObjectIds(articleIds, userId);
////                Article maxIdArticle = articleWithFullMsg.stream().collect(Collectors.maxBy(Comparator.comparing(Article::getId))).get();
////                Long dbMaxArticleId = maxIdArticle.getId();
//
//                //discuss
//                Long dbMaxDiscussId = topicDiscussMapper.selectMaxDiscussId(topicId, userId);
//                nodeStateResp.setHasNewGene(dbMaxArticleId > maxArticleId);
//                nodeStateResp.setHasNewDiscuss(dbMaxDiscussId > maxDiscussId);
//
//                result.put(topicId, nodeStateResp);
//            }
//        });
//
//        return result;
//    }
}
