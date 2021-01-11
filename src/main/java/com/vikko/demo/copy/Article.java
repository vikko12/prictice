package com.vikko.demo.copy;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author vikko
 * @date 2020/5/20 14:41
 */
public class Article {
//    @PostMapping("/modify")
//    public BaseResponse modifyArticle(@RequestBody SampleArticle sampleArticle) {
//        // 10分钟校验
//        String articleId = sampleArticle.getArticleId();
//        Article article = articleService.selectContentTitleTypeCoverByObjectId(articleId);
//        if (article == null) {
//            return BaseResponse.error(CodeEnum.CODE_300048);
//        }
//
//        if (!article.getType().equals(sampleArticle.getType())) {
//            // 修改了帖子类型，禁止修改
//            return BaseResponse.error(CodeEnum.CODE_300067);
//        }
//
//        if (System.currentTimeMillis() - article.getCreatedTime().getTime() > 10 * 60 * 1000) {
//            // 超过10分钟禁止修改
//            return BaseResponse.error(CodeEnum.CODE_300068);
//        }
//
//        if (article.getType() == ArticleTypeEnum.URL.getType()) {
//            // 链接贴禁止修改
//            return BaseResponse.error(CodeEnum.CODE_300069);
//        }
//
//        try {
//
//            // 参数类型验证
////        if (!StringUtil.isEmpty(params, "images") && !JSONObject
////                .isValidArray(JSONObject.toJSONString(params.get("images")))) {
////            return BaseResponse.error(CodeEnum.CODE_100002);
////        }
//
//            // 获取当前登录用户
////        String userId = getCurrentUserId();
////        if (StringUtils.isEmpty(userId)) {
////            userId = (String) params.getOrDefault("mpUserId", "");
////        }
////        if(StringUtils.isEmpty(userId)){
////            userId = (String) params.getOrDefault("userId", "");
////        }
////
////        if (StringUtil.isTrimEmpty(userId)) {
////            return BaseResponse.error(CodeEnum.CODE_100003);
////        }
////
////        // 每天发帖不能超过20条
////        Object count = redisService.getHashObject(RedisKeyConstants.H_USER_PUBLISH_COUNT, userId);
////        Integer oldCount = 0;
////        if (count != null) {
////            oldCount = (Integer) count;
////            if (oldCount >= 20) {
////                return BaseResponse.error(CodeEnum.CODE_300061);
////            }
////        }
////
////        // 待检测敏感词的内容
////        String checkSensitiveWord = "";
////
////        // 图文类型验证
////        if (type == ArticleTypeEnum.IMAGE_TEXT.getType()) {
////            if (StringUtil.isEmpty(params, "content") && StringUtil.isEmpty(params, "images")) {
////                return BaseResponse.error(CodeEnum.CODE_100001);
////            }
////
////            if (!StringUtil.isEmpty(params, "content")
////                    && ((String) params.get("content")).length() > 10000) {
////                return BaseResponse.error(CodeEnum.CODE_200002);
////            }
////
////            if (!StringUtil.isEmpty(params, "images")
////                    && JSONObject.parseArray(JSONObject.toJSONString(params.get("images"))).size() > 9) {
////                return BaseResponse.error(CodeEnum.CODE_200003);
////            }
////
////            if (!StringUtil.isEmpty(params, "content")) {
////                checkSensitiveWord = (String) params.get("content");
////            }
////
////        }
////
////        // 链接类型验证
////        if (type == ArticleTypeEnum.URL.getType()) {
////            if (StringUtil.isEmpty(params, "urlInfo")) {
////                return BaseResponse.error(CodeEnum.CODE_100001);
////            }
////
////            if (!JSONObject.isValidObject(JSONObject.toJSONString(params.get("urlInfo")))) {
////                return BaseResponse.error(CodeEnum.CODE_100002);
////            }
////
////            if (!StringUtil.isEmpty(params, "content")
////                    && ((String) params.get("content")).length() > 10000) {
////                return BaseResponse.error(CodeEnum.CODE_200002);
////            }
////
////            if (!StringUtil.isEmpty(params, "content")) {
////                checkSensitiveWord = (String) params.get("content");
////            }
////        }
////
////        // 提问类型验证
////        if (type == ArticleTypeEnum.QUESTION.getType()) {
////            if (StringUtil.isEmpty(params, "title")) {
////                return BaseResponse.error(CodeEnum.CODE_100001);
////            }
////
////            if (((String) params.get("title")).length() > 10000) {
////                return BaseResponse.error(CodeEnum.CODE_200001);
////            }
////
////            if (!StringUtil.isEmpty(params, "content")
////                    && ((String) params.get("content")).length() > 10000) {
////                return BaseResponse.error(CodeEnum.CODE_200002);
////            }
////
////            if (!StringUtil.isEmpty(params, "images")
////                    && JSONObject.parseArray(JSONObject.toJSONString(params.get("images"))).size() > 9) {
////                return BaseResponse.error(CodeEnum.CODE_200003);
////            }
////
////            if (!StringUtil.isEmpty(params, "content")) {
////                checkSensitiveWord = params.get("title") + "," + params.get("content");
////            } else {
////                checkSensitiveWord = (String) params.get("title");
////            }
////        }
////
////        // 文章类型验证
////        if (type == ArticleTypeEnum.ARTICLE.getType()) {
////            if (StringUtil.isEmpty(params, "title") || StringUtil.isEmpty(params, "contentText")) {
////                return BaseResponse.error(CodeEnum.CODE_100001);
////            }
////
////            if (((String) params.get("title")).length() > 100) {
////                return BaseResponse.error(CodeEnum.CODE_200001);
////            }
////
////            if (((String) params.get("contentText")).length() > 100000) {
////                return BaseResponse.error(CodeEnum.CODE_200002);
////            }
////
////            if (!StringUtil.isEmpty(params, "contentImages")
////                    && JSONObject.parseArray(JSONObject.toJSONString(params.get("contentImages"))).size()
////                    > 30) {
////                return BaseResponse.error(CodeEnum.CODE_200003);
////            }
////
////            checkSensitiveWord = params.get("title") + "," + params.get("contentText");
////        }
////
////        try {
////            String systemId =
////                    StringUtil.isEmpty(params, "mpUserId") ? SystemEnum.MICRO_SERVICE_BUSINESS.getTerminalId()
////                            : SystemEnum.MICRO_SERVICE_MP.getTerminalId();
////            String proId = "/article/post";
////
////            // 检测发帖用户是否冻结
////            boolean isFrozen = userService.getUserFrozenState(userId);
////            if (isFrozen) {
////                return BaseResponse.error(CodeEnum.CODE_200024);
////            }
////
////            // 检测敏感词
////            Integer sensitiveLevel = sensitiveService.checkSingleContentSensitive(checkSensitiveWord,
////                    SensitiveStorageEnum.CONTENT.getStorage());
////            if (null != sensitiveLevel && sensitiveLevel == 1) { // 存在1级敏感词不能发布
////                return BaseResponse.error(CodeEnum.CODE_200022);
////            }
////
////            // 如果参数中包含userId,则使用该userId
////            if (!StringUtil.isEmpty(params, "userId")) {
////                userId = (String) params.get("userId");
////            }
////
////            // 在没有图片的情况下重复性检查
////            if (StringUtil.isEmpty(params, "contentImages") && StringUtil.isEmpty(params, "images")
////                    && type != ArticleTypeEnum.URL.getType()) {
////                String title = (String) params.get("title");
////                String content = (String) params.get("content");
////                String contentText = (String) params.get("contentText");
////
////                if (!StringUtil.isTrimEmpty(title) || !StringUtil.isTrimEmpty(content) || !StringUtil
////                        .isTrimEmpty(contentText)) {
////                    Date createdTimeLowerLimit = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000L);
////                    boolean hasSameArticle = articleService
////                            .hasSameArticle(userId, title, content, contentText, createdTimeLowerLimit);
////                    if (hasSameArticle) {
////                        return BaseResponse.error(CodeEnum.CODE_300053);
////                    }
////                }
////            }
////
////            if (type == ArticleTypeEnum.URL.getType()) {
////                Map urlInfo =
////                        StringUtil.isEmpty(params, "urlInfo") ? new HashMap() : (Map) params.get("urlInfo");
////                if (urlInfo.containsKey("requestUrl")) {// 兼容老数据
////                    if (!urlInfo.containsKey("url")) {
////                        String requestUrl = (String) urlInfo.get("requestUrl");
////                        urlInfo.put("url", requestUrl);
////                    }
////                }
////                if (urlInfo.containsKey("url")) {
////                    String url = (String) urlInfo.get("url");
////                    Date createdTimeLowerLimit = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000L);
////                    boolean hasSameArticle = articleService
////                            .hasSameArticleForUrl(userId, url, createdTimeLowerLimit);
////                    if (hasSameArticle) {
////                        return BaseResponse.error(CodeEnum.CODE_300053);
////                    }
////                }
////            }
////
////            params.put("userId", userId);
////            params.put("ip", ClientUtil.getClientIp(request));
////            ArticleOperation article = articleService.addArticle(params, sensitiveLevel, systemId, proId);
////            String topicId = null;
////            String addArticleToTopicResult = null;
////            if (!StringUtil.isEmpty(params, "topicId")) {
////                topicId = params.get("topicId").toString();
////                // 尝试把帖子加入到圈子内
////                addArticleToTopicResult = knowledgeTopicService
////                        .addArticleToTopic(userId, topicId, article.getObjectId());
////            }
////
////            CompletableFuture.runAsync(() -> {
////                try {
////                    // 申请计算帖子群相似度
////                    nlpClient.applySimilar(article.getCoreId());
////                } catch (Exception e) {
////                    logger.error("申请nlp计算失败", e);
////                }
////            });
////
////            // 更新发帖数量
////            oldCount++;
////            if (!redisService.hasKey(RedisKeyConstants.H_USER_PUBLISH_COUNT)) {
////                redisService.setHashObject(RedisKeyConstants.H_USER_PUBLISH_COUNT, userId, oldCount);
////                redisService.expire(RedisKeyConstants.H_USER_PUBLISH_COUNT,// 设值过期时间到明天零点
////                        (DateUtil.getTomorrowZeroPoint() - System.currentTimeMillis()) / 1000);
////            } else {
////                redisService.setHashObject(RedisKeyConstants.H_USER_PUBLISH_COUNT, userId, oldCount);
////            }
////
////
////            // 添加文章完毕，再次获取文章相关信息（文章、作者等）返回请求方
////            boolean lessThen163 = currentAppVersionLessThanGiven("1.6.3");
////            if (lessThen163) {
////                LinkedHashMap articleInfoMap = articleService
////                        .getArticleByObjectIdWithAttribute(article.getObjectId(), userId,
////                                currentAppVersionLessThanGiven("1.6.0"));
////                JSONObject result = articleInfoMap != null ? (JSONObject) JSONObject.toJSON(articleInfoMap)
////                        : new JSONObject();
////                if (topicId != null) {
////                    result.put("addToTopicResult", addArticleToTopicResult.equals("success"));
////                    result.put("addToTopicHint", addArticleToTopicResult);
////                }
////
////                return BaseResponse.ok(result);
////            } else {
////                article.setCreatedTime(new Date());
////                List<AlgorithmArticle> algorithmArticles = articleService.convertArticle(Arrays.asList(article), userId, false, false,
////                        false, false, true, false);
////                if (algorithmArticles.size() == 0) {
////                    logger.error("后端系统异常：", "刚发布的帖子找不到");
////                    return BaseResponse.error();
////                }
////                AlgorithmArticle algorithmArticle = algorithmArticles.get(0);
////                if (topicId != null) {
////                    algorithmArticle.setAddToTopicResult(addArticleToTopicResult.equals("success"));
////                    algorithmArticle.setAddToTopicHint(addArticleToTopicResult);
////                }
////
////                return BaseResponse.ok(algorithmArticle);
////            }
//
//            return BaseResponse.ok();
//        } catch (Exception e) {
//            logger.error("后端系统异常：", e);
//            return BaseResponse.error();
//        }
//    }
}
