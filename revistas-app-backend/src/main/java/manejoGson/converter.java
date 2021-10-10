/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manejoGson;

import com.google.gson.Gson;

/**
 * 
 * @author AndaryuS
 */
public class converter<T> {

    private Gson gson;
    private Class<T> typeConverter;
    
    public converter(Class<T> typeConverter){
        this.gson=new Gson();
        this.typeConverter=typeConverter;
    }
    
    public T fromJson(String json){
        return gson.fromJson(json, typeConverter);
    }
    
    public String toJson(T object){
        return gson.toJson(object,typeConverter);
    }
    
    
    
}
