package com.vikko.demo.copy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vikko
 * @date 2020/6/1 16:56
 */
public class DelGene {
//    public void deleteGeneArticle(GeneDelReq geneDelReq){
//        String topicId = geneDelReq.getTopicId();
//        if(StringUtils.isEmpty(topicId)){
//            throw new BaseException(CodeEnum.CODE_100001);
//        }
//        List<String> articleIds = geneDelReq.getArticleList();
//        if(CollectionUtils.isEmpty(articleIds)){
//            throw new BaseException(CodeEnum.CODE_100001);
//        }
//        KnowledgeTopic topic = knowledgeTopicMapper.selectByObjectId(topicId);
//
//        //去重
//        articleIds = articleIds.stream().distinct().collect(Collectors.toList());
//
//        ModifyTopicReq req = new ModifyTopicReq();
//        req.setName(topic.getName());
//        req.setCover(topic.getCover());
//        req.setTopicId(topic.getObjectId());
//        req.setOwnerId(topic.getTopicOwner());
//        req.setDeletedArticles(articleIds);
//        topicFeign.editTopicArticle(req);
//
//    }
}
