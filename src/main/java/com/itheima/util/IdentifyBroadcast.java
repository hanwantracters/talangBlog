package com.itheima.util;

public class IdentifyBroadcast
{
    public static String username;
    public  static void SetIdentifyBroadcast(String username)
    {
        IdentifyBroadcast.username = username;
    }
    public static String GetIdentifyBroadcast()
    {
        return IdentifyBroadcast.username;
    }
}
