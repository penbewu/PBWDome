package com.example.myapplication.Util;


import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.util.List;


/**
 * sky
 * 2021/3/18 18:14
 */

public class GsonUtil {
    private static Gson gson = new Gson();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> cls) {
        try {
            T obj = gson.fromJson(json, cls);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
//            L.e(e.getMessage() + "\n" + json);
            return null;
        }
    }

    public static <T> T fromJson(JsonElement json, Class<T> cls) {
        try {
            T obj = gson.fromJson(json, cls);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
//            L.e(e.getMessage() + "\n" + json);
            return null;
        }
    }

    public static <T> List<T> fromJsonList(String json, Type type) {
        try {
            List<T> lst = gson.fromJson(json, type);
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public static <T> T parseJSON(String json, Class<T> clazz) {

        Gson gson = new Gson();

        T info = gson.fromJson(json, clazz);

        return info;

    }


    public static <T> T parseJSON(String json, Type type) {

        Gson gson = new Gson();

        T info = gson.fromJson(json, type);

        return info;

    }

    /**
     * 對指定的List數據進行深度複製，並產生一個新的List。
     *
     * @param list: 指定的List數據
     * @return: 返回新的List
     */
    public static <T> List<T> deepCopy(List<T> list) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(list);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            List<T> newList = (List<T>) objectInputStream.readObject();
            return newList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
