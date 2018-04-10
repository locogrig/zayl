package com.baizhi.common.dao;

import com.baizhi.common.entity.Article;
import com.baizhi.common.util.LuceneUtil;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;

/**
 * Created by Administrator on 2017/12/5.
 */
public class LuceneDao {
    /*
    * 创建索引
    * */
    public void addIndex(Article article){
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();

        Document document = new Document();
        document.add(new StringField("id",article.getId(), Field.Store.YES));
        document.add(new StringField("userid",article.getUserid(), Field.Store.YES));
        document.add(new StringField("date",article.getDate().toString(), Field.Store.YES));
        document.add(new IntField("clickcount",article.getClickcount(), Field.Store.YES));
        document.add(new TextField("content",article.getContent(), Field.Store.YES));
        document.add(new StringField("status",article.getId(), Field.Store.YES));
    }
}
