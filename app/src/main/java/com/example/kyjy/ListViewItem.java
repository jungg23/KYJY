package com.example.kyjy;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable ;
    private String str1 ;
    private String str2 ;

    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setStr1(String str) {
        str1 = str ;
    }
    public void setStr2(String str) {
        str2 = str ;
    }

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getStr1() {
        return this.str1 ;
    }
    public String getStr2() {
        return this.str2;
    }
}
