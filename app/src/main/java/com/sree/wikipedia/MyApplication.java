package com.sree.wikipedia;

import android.app.Application;
import android.content.Context;

import com.sree.wikipedia.models.WikiPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyApplication extends Application {

   

    /*private Context ctx;

    public Context getAppCtx(){
        if (ctx!=null){
            return ctx;
        }
    }*/
    public static Boolean FROM_SEARCH = false;
    public static Boolean FROM_RANDOM = false;
   // val userVisitedArticles: ArrayList<WikiPage> = ArrayList<WikiPage>()

    public static ArrayList<WikiPage> userVisitedArticles =new ArrayList<WikiPage>();
    public static Map<String, WikiPage> usersFavouriteArticles =new HashMap<String, WikiPage>();
}
