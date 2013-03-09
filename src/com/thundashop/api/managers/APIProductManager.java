package com.thundashop.api.managers;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import com.thundashop.core.common.JsonObject2;
import java.util.ArrayList;
import com.thundashop.core.productmanager.data.ProductCriteria;
import com.thundashop.core.productmanager.data.Product;
import java.util.List;
import java.util.HashMap;

public class APIProductManager {

      private Transporter transport;

      public APIProductManager(Transporter transport){
           this.transport = transport;
      }

     /**
     * add image to specified product
     * 
     * @param productId
     * @param productImageId
     * @param description
     * @throws ErrorException 
     */

     public void addImage(String productId, String productImageId, String description)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("productId",new Gson().toJson(productId));
          data.args.put("productImageId",new Gson().toJson(productImageId));
          data.args.put("description",new Gson().toJson(description));
          data.method = "addImage";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
     }

     /**
     * You can use this function to change the stock quantity for a given product
     * 
     * @param productId The id for the product to change.
     * @param count Number of entries to substract from the product stock quantity, an be negative number to decrease the stock quantity.
     * @return void
     * @throws ErrorException 
     */

     public void changeStockQuantity(String productId, int count)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("productId",new Gson().toJson(productId));
          data.args.put("count",new Gson().toJson(count));
          data.method = "changeStockQuantity";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
     }

     /**
     * Create a new product instance.
     * @return Product
     * @throws ErrorException 
     */

     public Product createProduct()  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.method = "createProduct";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<Product>() {}.getType();
          Product object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Fetch one single product by id
     * 
     * @param id
     * @return Product
     * @throws ErrorException 
     */

     public Product getProduct(String id)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("id",new Gson().toJson(id));
          data.method = "getProduct";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<Product>() {}.getType();
          Product object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Fetch products 
     * 
     * @param productCriteria
     * @return List<Product>
     * @throws ErrorException 
     */

     public List<Product> getProducts(ProductCriteria productCriteria)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("productCriteria",new Gson().toJson(productCriteria));
          data.method = "getProducts";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<List<Product>>() {}.getType();
          List<Product> object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Returns a random set of products
     * If the store does not have enough products it will return as close as possible to 
     * the fetchsize specified.
     * 
     * @param fetchSize Amount of products that you wish to fetch.
     * @param ignoreProductId Will skip this id, can be the productId or the productPageId.
     * @return ArrayList<Product>
     */

     public ArrayList<Product> getRandomProducts(Integer fetchSize, String ignoreProductId)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("fetchSize",new Gson().toJson(fetchSize));
          data.args.put("ignoreProductId",new Gson().toJson(ignoreProductId));
          data.method = "getRandomProducts";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<ArrayList<Product>>() {}.getType();
          ArrayList<Product> object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Remove an existing product.
     * 
     * @param productId The id of the product to remove.
     * @return void
     * @throws ErrorException 
     */

     public void removeProduct(String productId)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("productId",new Gson().toJson(productId));
          data.method = "removeProduct";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
     }

     /**
     * Save a product.
     * 
     * @param product The product to save, if the id for the product is not set.
     * @param parentPageId Attach this product to a given page, leave this empty to avoid attaching it.
     * @return Product
     * @throws ErrorException 
     */

     public Product saveProduct(Product product)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("product",new Gson().toJson(product));
          data.method = "saveProduct";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<Product>() {}.getType();
          Product object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

     /**
     * Method for setting a known product image as main image.
     * 
     * @param productId
     * @param imageId
     * @throws ErrorException 
     */

     public void setMainImage(String productId, String imageId)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("productId",new Gson().toJson(productId));
          data.args.put("imageId",new Gson().toJson(imageId));
          data.method = "setMainImage";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
     }

     /**
     * Translate all antries found in a given list of entry ids.
     * @param entryIds A list of entries id to translate.
     * @return HashMap<String,String>
     * @throws ErrorException 
     */

     public HashMap<String,String> translateEntries(List<String> entryIds)  throws Exception  {
          JsonObject2 data = new JsonObject2();
          data.args = new HashMap();
          data.args.put("entryIds",new Gson().toJson(entryIds));
          data.method = "translateEntries";
          data.interfaceName = "core.productmanager.IProductManager";
          String result = transport.send(data);
          Gson gson = new GsonBuilder().serializeNulls().create();
          Type typeJson_3323322222_autogenerated = new TypeToken<HashMap<String,String>>() {}.getType();
          HashMap<String,String> object = gson.fromJson(result, typeJson_3323322222_autogenerated);
          return object;
     }

}