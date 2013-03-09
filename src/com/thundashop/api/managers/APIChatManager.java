package com.thundashop.api.managers;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import com.thundashop.core.common.JsonObject2;
import java.util.List;
import com.thundashop.core.chatmanager.ChatMessage;
import com.thundashop.core.chatmanager.Chatter;

public class APIChatManager {

      private Transporter transport;

      public APIChatManager(Transporter transport){
           this.transport = transport;
      }

     /**
     * Reply to a chat message.
     * 
     * @param id - Chatters id
     * @param message
     */

     public void closeChat(String id)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("id",new Gson().toJson(id));
          data.method = "closeChat";
          data.interfaceName = "core.chat.IChatManager";
          String result = transport.send(data);
     }

     /**
     * Returns a list of available poeple to chat with.
     * @return List<Chatter>
     */

     public List<Chatter> getChatters()  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.method = "getChatters";
          data.interfaceName = "core.chat.IChatManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<List<Chatter>>() {}.getType();
          List<Chatter> object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Get all your chat messages
     * 
     * @return List<ChatMessage>
     */

     public List<ChatMessage> getMessages()  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.method = "getMessages";
          data.interfaceName = "core.chat.IChatManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<List<ChatMessage>>() {}.getType();
          List<ChatMessage> object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Reply to a chat message.
     * 
     * @param id - Chatters id
     * @param message
     */

     public void replyToChat(String id, String message)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("id",new Gson().toJson(id));
          data.args.put("message",new Gson().toJson(message));
          data.method = "replyToChat";
          data.interfaceName = "core.chat.IChatManager";
          String result = transport.send(data);
     }

     /**
     * Send a message to administrator
     * 
     * @param message
     * @throws ErrorException 
     */

     public void sendMessage(String message)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("message",new Gson().toJson(message));
          data.method = "sendMessage";
          data.interfaceName = "core.chat.IChatManager";
          String result = transport.send(data);
     }

}