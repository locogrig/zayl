package com.baizhi.test;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/12/4.
 */
public class TestLucene {
    //使用lucene创建索引
    @Test
    public void CrearLucene() throws IOException {
        //创建索引写出对象
        FSDirectory dir = FSDirectory.open(new File("F:/myLucene/index"));//索引存放位置
        //参数一：当前使用lucene版本，参数二：分词器
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_44,
                new StandardAnalyzer(Version.LUCENE_44));//索引写出配置对象
        IndexWriter indexWriter = new IndexWriter(dir, config);

        //文档对象
        Document document = new Document();
        document.add(new StringField("id","1001", Field.Store.YES));
        document.add(new StringField("title","战国策",Field.Store.YES));
        document.add(new TextField("content","那天晚上有美丽的月光，我和你走在小路上昂~昂",Field.Store.YES));
        indexWriter.addDocument(document);
        indexWriter.commit();
        indexWriter.close();
    }


    @Test
    public void indexSearch() throws IOException {
        FSDirectory dir = FSDirectory.open(new File("F:/myLucene/index"));//索引存放位置
        DirectoryReader reader = DirectoryReader.open(dir);
        //创建indexSearch对象   参数一：指定索引位置
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        //使用index搜索
        //参数一：查询的关键词    参数二：符合条件的多少条数据
        Query termQuery = new TermQuery(new Term("content", "上"));
        //返回topDoxs
        TopDocs topDocs = indexSearcher.search(termQuery, 100);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;//搜索结果做相关排序
        for(int i = 0;i < scoreDocs.length;i++){
            int doc = scoreDocs[i].doc;//文章具体位置，相当于字典页数
            Document document = indexSearcher.doc(doc);
            System.out.println(document.get("id"));
            System.out.println(document.get("title"));
            System.out.println(document.get("content"));

        }

    }
}
