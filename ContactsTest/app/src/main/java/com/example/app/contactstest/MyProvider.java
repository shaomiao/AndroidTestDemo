package com.example.app.contactstest;import android.content.ContentProvider;import android.content.ContentValues;import android.content.UriMatcher;import android.database.Cursor;import android.net.Uri;import android.support.annotation.Nullable;/** * Created by shaomiao on 2016-12-8. */public class MyProvider extends ContentProvider {    // content://com.example.app.provider/table1    // content://com.example.app.provider/table1/1 // id为1的数据    /**     *   1. *：表示匹配任意长度的任意字符         2. #：表示匹配任意长度的数字         所以，一个能够匹配任意表的内容 URI 格式就可以写成：         content://com.example.app.provider/*         而一个能够匹配 table1 表中任意一行数据的内容 URI 格式就可以写成：         content://com.example.app.provider/table1/#     */    public static final int TABLE1_DIR = 0;    public static final int TABLE1_ITEM = 1;    public static final int TABLE2_DIR = 2;    public static final int TABLE2_ITEM = 3;    private static UriMatcher uriMatcher;    static {        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);        uriMatcher.addURI("com.example.app.provider", "table1", TABLE1_DIR);        uriMatcher.addURI("com.example.app.provider", "table1/#", TABLE1_ITEM);        uriMatcher.addURI("com.example.app.provider", "table2", TABLE2_DIR);        uriMatcher.addURI("com.example.app.provider", "table2/#", TABLE2_ITEM);    }    /**     * 初始化内容提供器的时候调用     * 通常会创建和升级等操作     * 返回true表示初始化成功，返回false则表示失败     * 只有当存在ContentResolver尝试访问我们程序中的数据     * @return     */    @Override    public boolean onCreate() {        return false;    }    /**     * 从内容提供器中查询数据 使用     * uri参数来确定查询那张表     * projection参数用于确定查询那些列s     * election和selectionArgs参数用于约束查询那些列     * sortOrder参数用于对结果进行排序查询的结果     * 查询结果存放在Cursor对象中返回     * @param uri     * @param strings     * @param s     * @param strings1     * @param s1     * @return     */    @Nullable    @Override    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {        switch (uriMatcher.match(uri)) {            case TABLE1_DIR:                // 查询table1表中的所有数据                break;            case TABLE1_ITEM:                // 查询table1表中的单条数据                break;            case TABLE2_DIR:                // 查询table2表中的所有数据                break;            case TABLE2_ITEM:                // 查询table2表中的单条数据                break;            default:                break;        }        return null;    }    /**     * 根据传入的内容URI来返回相应的MIME类型     * @param uri     * @return     */    @Nullable    @Override    public String getType(Uri uri) {        switch (uriMatcher.match(uri)) {            case TABLE1_DIR:                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table1";            case TABLE1_ITEM:                return "vnd.android.cursor.item/vnd.com.example.app.provider.table1";            case TABLE2_DIR:                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table2";            case TABLE2_ITEM:                return "vnd.android.cursor.item/vnd.com.example.app.provider.table2";            default:                break;        }        return null;    }    /**     * 向内容提供器中添加一条数据     * 使用uri参数来确定要添加到的表     * 待添加的数据保存在values参数中     * 返回一个用于表示这条新纪录的URI     * @param uri     * @param contentValues     * @return     */    @Nullable    @Override    public Uri insert(Uri uri, ContentValues contentValues) {        return null;    }    /**     * 从内容提供器中删除数据     * uri参数来确定删除哪一张表中的数据     * selection和selectionArgs约束删除那些行     * 被删除的行数将作为返回值返回     * @param uri     * @param s     * @param strings     * @return     */    @Override    public int delete(Uri uri, String s, String[] strings) {        return 0;    }    /**     * 更新内容提供器中已有的数据     * uri参数来确定删除哪一张表中的数据     * selection和selectionArgs约束删更新些行     * 受影响的行数将作为返回值返回     * @param uri     * @param contentValues     * @param s     * @param strings     * @return     */    @Override    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {        return 0;    }}