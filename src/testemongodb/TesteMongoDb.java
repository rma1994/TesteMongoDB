/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testemongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 *
 * @author rma19_000
 */
public class TesteMongoDb {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database database = new Database();
        
        try{
            DB db = database.getConnection();
            DBCollection collection = db.getCollection("collection");
            
            
            //insert
            BasicDBObject ale = new BasicDBObject();
            //ale.put("_id",2);
            ale.put("Nome","Paulo");
            ale.put("Sexo","Masculino");
            collection.insert(ale);
            
            //update
            BasicDBObject updateQuery = new BasicDBObject("Nome","Andrews");
            collection.update(updateQuery, new BasicDBObject("$set", new BasicDBObject("Nome","gonçalo")));
            
            //select
            DBCursor docs = collection.find();
            while(docs.hasNext()){
                DBObject doc = docs.next();
                System.out.println(doc.get("Nome"));
            }
            
            //delete
            collection.remove(new BasicDBObject("Nome","Paulo"));
            
        }catch (Exception e){
            System.out.println(e);
        }
        
    }
    
}
