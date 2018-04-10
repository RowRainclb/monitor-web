package com.zhizus.forest.metrics.dao;

import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import com.zhizus.forest.metrics.bean.App;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Dempe on 2017/1/5.
 */
@Repository
public class AppDao {

    @Value("${mongo.database}")
    private String dbName;

    @Autowired
    private MongoClient mongoClient;

    MongoCollection<Document> collection;

    @PostConstruct
    public void init() {
        this.collection = mongoClient.getDatabase(dbName).getCollection("metric_app");
    }

    private Document getDocument(App app) {
        return new Document().append("_id", app.getServiceName())
                .append("appKey", app.getAppKey())
                .append("createAt", app.getCreateAt())
                .append("createBy", app.getCreateBy());
    }

    public App getApp(Document document) {
        App app = new App();
        app.setAppKey(document.getString("appKey"));
        app.setCreateBy(document.getString("createBy"));
        app.setCreateAt(document.getLong("createAt"));
        app.setServiceName(document.getString("_id"));
        return app;
    }

    public void save(App app) {
        collection.insertOne(getDocument(app));
    }

    public List<App> find() {
        List<App> list = Lists.newArrayList();
        App app1 = new App();
        app1.setCreateBy("clb");
        app1.setAppKey("333");
        app1.setCreateAt(300L);
        app1.setServiceName("监听客户接入");
        app1.setTopic("defaultUser-defaultSpace-raw");
        app1.setZookeeperUrl("192.168.130.62:2181");
        app1.setStatus("正常");
        list.add(app1);
        App app2 = new App();
        app2.setCreateBy("clb");
        app2.setAppKey("333");
        app2.setCreateAt(300L);
        app2.setServiceName("监听异常数据");
        app2.setTopic("defaultUser-defaultSpace-exception");
        app2.setZookeeperUrl("192.168.130.62:2181");
        app1.setStatus("异常");
        list.add(app2);
        return list;
    }

    public DeleteResult deleteByServiceName(String serviceName) {
        return collection.deleteOne(new BasicDBObject("_id", serviceName));
    }

}
