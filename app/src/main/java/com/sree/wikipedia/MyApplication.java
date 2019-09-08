package com.sree.wikipedia;

import android.app.Application;
import android.content.Context;

import com.sree.wikipedia.models.WikiPage;

import java.util.ArrayList;

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
    public static ArrayList<WikiPage> usersFavouriteArticles =new ArrayList<WikiPage>();
}
