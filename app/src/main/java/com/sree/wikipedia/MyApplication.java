package com.sree.wikipedia;

import android.app.Application;

import com.sree.wikipedia.models.WikiPage;

import java.util.ArrayList;

public class MyApplication extends Application {
    public static Boolean FROM_SEARCH = false;
    public static Boolean FROM_RANDOM = false;
   // val userVisitedArticles: ArrayList<WikiPage> = ArrayList<WikiPage>()

    public static ArrayList<WikiPage> userVisitedArticles =new ArrayList<WikiPage>();
}
