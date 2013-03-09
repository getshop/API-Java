package com.thundashop.api.managers;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import com.thundashop.core.common.JsonObject2;
import java.util.HashMap;

public class APIContentManager {

      private Transporter transport;

      public APIContentManager(Transporter transport){
           this.transport = transport;
      }

     /**
     * Create a new instance for the content manager.<br>
     * An id will automatically be generated and returned on creation.<br>
     * 
     * @param content The content to build upon.
     * @return String
     * @throws ErrorException
     */

     public String createContent(String content)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("content",new Gson().toJson(content));
          data.method = "createContent";
          data.interfaceName = "app.content.IContentManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<String>() {}.getType();
          String object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Remove the content for a given id.
     * @param id The id to remove the content for.
     * @throws ErrorException
     */

     public void deleteContent(String id)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("id",new Gson().toJson(id));
          data.method = "deleteContent";
          data.interfaceName = "app.content.IContentManager";
          String result = transport.send(data);
     }

     /**
     * Fetch all content saved until now.
     * @return HashMap<String,String>
     * @throws ErrorException 
     */

     public HashMap<String,String> getAllContent()  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.method = "getAllContent";
          data.interfaceName = "app.content.IContentManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<HashMap<String,String>>() {}.getType();
          HashMap<String,String> object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Fetch the content for a given id.
     * @param id The id which is identifying the content.
     * @return String
     * @throws ErrorException
     */

     public String getContent(String id)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("id",new Gson().toJson(id));
          data.method = "getContent";
          data.interfaceName = "app.content.IContentManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<String>() {}.getType();
          String object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Update / replace the content for a given id.
     * @param id The id to update the content for.
     * @param content The content to update. This could be html / text.
     * @throws ErrorException
     */

     public void saveContent(String id, String content)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("id",new Gson().toJson(id));
          data.args.put("content",new Gson().toJson(content));
          data.method = "saveContent";
          data.interfaceName = "app.content.IContentManager";
          String result = transport.send(data);
     }

}