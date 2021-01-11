//package com.vikko.demo.copy;
//
//import org.springframework.util.CollectionUtils;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author vikko
// * @date 2020/6/10 10:52
// */
//public class NewArticle {
//}
//
//    /**
//     * 检查是否有新的讨论和帖子
//     *
//     * @param topics 需要检查的群列表
//     * @param userId 针对的用户
//     */
//    public void checkNewDiscussNewArticleState(List<KnowledgeTopicSimpleDTO> topics, String userId) {
//        if (CollectionUtils.isEmpty(topics)) {
//            return;
//        }
//        // 到缓存里取数据
//        String redisKey = RedisKeyConstants.TOPIC_DISCUSS_ARTICLE_COUNT + userId;
//        Map<String, TopicArticleCountDiscussCountInfo> cache = (Map<String, TopicArticleCountDiscussCountInfo>) redisService
//                .getObject(redisKey);
//        if (cache == null) {
//            cache = new HashMap<>();
//        }
//
//        for (KnowledgeTopicSimpleDTO topic : topics) {
//            TopicArticleCountDiscussCountInfo countInfo = cache.getOrDefault(topic.getTopicId(), null);
//            if (countInfo == null) {
//                countInfo = new TopicArticleCountDiscussCountInfo();
//                if (topic.getPostNum() != null) {
//                    countInfo.setArticleCount(topic.getPostNum());
//                }
//                if (topic.getCommentNum() != null) {
//                    countInfo.setDiscussCount(topic.getCommentNum());
//                }
//
//                countInfo.setStateExpire(false);
//            } else {
//                //缓存里有topic信息
//                if (!countInfo.isStateExpire()) {//没过期
//                    if (!countInfo.isHasNewGene()) {//不含有新帖
//                        if (topic.getPostNum() != null) {
//                            if (topic.getPostNum() > countInfo.getArticleCount()) {
//                                topic.setHasNewGene(true);
//                                countInfo.setHasNewGene(true);
//                            }
//
//                            countInfo.setArticleCount(topic.getPostNum());
//                        }
//                    } else {//含有新帖
//                        topic.setHasNewGene(true);
//                    }
//                } else {//countInfo过期了
//                    if (topic.getPostNum() != null) {
//                        topic.setHasNewGene(topic.getPostNum() > countInfo.getArticleCount());
//                        countInfo.setHasNewGene(topic.getPostNum() > countInfo.getArticleCount());
//
//                        countInfo.setArticleCount(topic.getPostNum());
//                    }
//                }
//
//                if (!countInfo.isStateExpire()) {
//                    if (!countInfo.isHasNewDiscuss()) {
//                        if (topic.getCommentNum() != null) {
//                            if (topic.getCommentNum() > countInfo.getDiscussCount()) {
//                                topic.setHasNewDiscuss(true);
//                                countInfo.setHasNewDiscuss(true);
//                            }
//                            countInfo.setDiscussCount(topic.getCommentNum());
//                        }
//                    } else {
//                        topic.setHasNewDiscuss(true);
//                    }
//                } else {
//                    if (topic.getCommentNum() != null) {
//                        topic.setHasNewDiscuss(topic.getCommentNum() > countInfo.getDiscussCount());
//                        countInfo.setHasNewDiscuss(topic.getCommentNum() > countInfo.getDiscussCount());
//
//                        countInfo.setDiscussCount(topic.getCommentNum());
//                    }
//                }
//
//                countInfo.setStateExpire(false);
//            }
//
//            cache.put(topic.getTopicId(), countInfo);
//        }
//
//        redisService.setObject(redisKey, cache);
//    }
//}
