package org.liujiazhen.mongo.test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongodbTest {
    public static void main(String[] args) {
        // 连接mongo服务器
        MongoClient mongoClient = new MongoClient("127.0.0.1");
        // 得到要操作的数据库
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");
        // 得到要操作的集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        // 封装查询条件
        BasicDBObject bson = new BasicDBObject("content", "lost me a lost");
        // 进行查询
        FindIterable<Document> documents = spit.find(bson);
        // 遍历数据
        for (Document document: documents) {
            System.out.println(document.getObjectId("_id"));
            System.out.println(document.getString("content"));
        }
        mongoClient.close();
    }
}
