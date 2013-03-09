package com.thundashop.api.managers;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import com.thundashop.core.common.JsonObject2;
import com.thundashop.core.calendarmanager.data.Entry;
import java.util.List;
import com.thundashop.core.calendarmanager.data.Month;

public class APICalendarManager {

      private Transporter transport;

      public APICalendarManager(Transporter transport){
           this.transport = transport;
      }

     /**
     * Add a given user to a given event.
     * @param userId The user id to add to a the given event (see usermanager for more inforamtion about this id)
     * @param eventId The event id to attach to the user.
     * @param password A password you want to attach to the email that is being sent to the user.
     * @param username A username you want to attach to the email that is being sent to the user.
     * @return void
     * @throws ErrorException 
     */

     public void addUserToEvent(String userId, String eventId, String password, String username)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("userId",new Gson().toJson(userId));
          data.args.put("eventId",new Gson().toJson(eventId));
          data.args.put("password",new Gson().toJson(password));
          data.args.put("username",new Gson().toJson(username));
          data.method = "addUserToEvent";
          data.interfaceName = "core.calendar.ICalendarManager";
          String result = transport.send(data);
     }

     /**
     * Create a new entry to the calendar on a given date.
     * @param year The year to attach the entry to
     * @param month The month to attach the entry to
     * @param day The day to attach the entry to
     * @param entry The entry to attach
     * @return Entry
     * @throws ErrorException 
     */

     public Entry createEntry(int year, int month, int day)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("year",new Gson().toJson(year));
          data.args.put("month",new Gson().toJson(month));
          data.args.put("day",new Gson().toJson(day));
          data.method = "createEntry";
          data.interfaceName = "core.calendar.ICalendarManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<Entry>() {}.getType();
          Entry object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Delete an existing entry by a given id from the calendar.
     * @param id The id of the entry to delete.
     * @throws ErrorException 
     */

     public void deleteEntry(String id)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("id",new Gson().toJson(id));
          data.method = "deleteEntry";
          data.interfaceName = "core.calendar.ICalendarManager";
          String result = transport.send(data);
     }

     /**
     * Get all entries to a given day
     * @param year The year to fetch the entries on.
     * @param month The month to fetch the entries on.
     * @param day The day to fetch the entries on.
     * @return List<Entry>
     * @throws ErrorException 
     */

     public List<Entry> getEntries(int year, int month, int day)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("year",new Gson().toJson(year));
          data.args.put("month",new Gson().toJson(month));
          data.args.put("day",new Gson().toJson(day));
          data.method = "getEntries";
          data.interfaceName = "core.calendar.ICalendarManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<List<Entry>>() {}.getType();
          List<Entry> object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Gives you the specified entry by id
     * 
     * @param entryId
     * @return Entry
     */

     public Entry getEntry(String entryId)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("entryId",new Gson().toJson(entryId));
          data.method = "getEntry";
          data.interfaceName = "core.calendar.ICalendarManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<Entry>() {}.getType();
          Entry object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Get all data attached to a given month.
     * @param year The year to fetch
     * @param month The month to fetch
     * @param includeExtraEvents 
     * @return Month
     * @throws ErrorException 
     */

     public Month getMonth(int year, int month, boolean includeExtraEvents)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("year",new Gson().toJson(year));
          data.args.put("month",new Gson().toJson(month));
          data.args.put("includeExtraEvents",new Gson().toJson(includeExtraEvents));
          data.method = "getMonth";
          data.interfaceName = "core.calendar.ICalendarManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<Month>() {}.getType();
          Month object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Remove a given user from a given event.
     * @param userId The userid for the event to be removed. (see usermanager for more inforamtion about this id)
     * @param eventId The id of the event for the user to be removed from.
     * @return void
     * @throws ErrorException 
     */

     public void removeUserFromEvent(String userId, String eventId)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("userId",new Gson().toJson(userId));
          data.args.put("eventId",new Gson().toJson(eventId));
          data.method = "removeUserFromEvent";
          data.interfaceName = "core.calendar.ICalendarManager";
          String result = transport.send(data);
     }

     /**
     * Save an already existing entry.
     * @param entry
     * @throws ErrorException 
     */

     public void saveEntry(Entry entry)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("entry",new Gson().toJson(entry));
          data.method = "saveEntry";
          data.interfaceName = "core.calendar.ICalendarManager";
          String result = transport.send(data);
     }

     /**
     Remind a given list of users about a given entry.
     * @param entryId The id of the entry to remind about.
     * @param byEmail Remind users by email (true to send)
     * @param bySMS Remind users by sms (true to send)
     * @param users A list of user ids to remind.
     * @param text The text to send when reminding.
     * @param subject A subject to attach to the email.
     * @return void
     * @throws ErrorException 
     */

     public void sendReminderToUser(boolean byEmail, boolean bySMS, List<String> users, String text, String subject)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("byEmail",new Gson().toJson(byEmail));
          data.args.put("bySMS",new Gson().toJson(bySMS));
          data.args.put("users",new Gson().toJson(users));
          data.args.put("text",new Gson().toJson(text));
          data.args.put("subject",new Gson().toJson(subject));
          data.method = "sendReminderToUser";
          data.interfaceName = "core.calendar.ICalendarManager";
          String result = transport.send(data);
     }

}