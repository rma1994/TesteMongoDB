/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testemongodb;

import com.mongodb.DB;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;

/**
 *
 * @author rma19_000
 */
public class Database {
    MongoClientURI uri  = new MongoClientURI("mongodb://rma1994:123456@ds055689.mongolab.com:55689/mytestdb"); 
    DB db;
    
    public DB getConnection() throws Exception{
        if (db == null){
            MongoClient client = new MongoClient(uri);
            db = client.getDB(uri.getDatabase());
        }
        return db;
    }
}
