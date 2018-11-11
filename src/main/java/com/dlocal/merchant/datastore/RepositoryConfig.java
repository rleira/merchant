package com.dlocal.merchant.datastore;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
class RepositoryConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "merchantDB";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.dlocal.merchant.datastore";
    }
}
