package com.woshuwu.test.robot;

/**
 * Created with IntelliJ IDEA.
 * User: jianjun_liang
 * Date: 13-2-25
 * Time: 下午4:49
 * To change this template use File | Settings | File Templates.
 */
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.win32.StdCallLibrary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TryWithHWND {

    public Map<String,HWND> HWNDMap = new HashMap<String,HWND>();

    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
        boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);
        int GetWindowTextA(HWND hWnd, byte[] lpString, int nMaxCount);
        HWND FindWindowW(String lpClassName, String lpWindowName);
        HWND SetFocus(HWND hWnd);
        boolean SetForegroundWindow(HWND hWnd);
        boolean CloseWindow(HWND hWnd);
        void PostMessageW(HWND hWnd, int msg, WinDef.WPARAM wParam, WinDef.LPARAM lParam);
    }

    private final User32 user32 = User32.INSTANCE;

    /**
     * return the HWND of the windowName, or null if it doesn't exist.
     * FindWindowW的中文窗体无法获取
     * @param windowName
     * @return
     */
    public HWND getHWND(String windowName){
        if(HWNDMap.containsKey(windowName)){
            return HWNDMap.get(windowName);
        }else{
            //refresh the cache
            user32.EnumWindows(new WNDENUMPROC() {
                int count = 0;
                @Override
                public boolean callback(HWND hWnd, Pointer arg1) {
                    byte[] windowText = new byte[512];
                    user32.GetWindowTextA(hWnd, windowText, 512);
                    String wText = Native.toString(windowText,"GBK");
                    if (wText.isEmpty()) {
                        return true;
                    }
                    if(!HWNDMap.containsKey(wText)){
                        System.out.println("Found window with text " + hWnd + " Text: " + wText);
                        HWNDMap.put(wText,hWnd);
                    }
                    return true;
                }
            }, null);

            return HWNDMap.get(windowName);
        }
    }

    public void RefreshCache(){
        HWNDMap.clear();
        user32.EnumWindows(new WNDENUMPROC() {
            int count = 0;
            @Override
            public boolean callback(HWND hWnd, Pointer arg1) {
                byte[] windowText = new byte[512];
                user32.GetWindowTextA(hWnd, windowText, 512);
                String wText = Native.toString(windowText,"GBK");
                if (wText.isEmpty()) {
                    return true;
                }
                if(!HWNDMap.containsKey(wText)){
                    System.out.println("Found window with text " + hWnd + " Text: " + wText);
                    HWNDMap.put(wText,hWnd);
                }
                return true;
            }
        }, null);
    }

    public boolean sendMessage(String message, HWND hwnd){
        if(hwnd == null){
            return false;
        }
        for (int i = 0; i < message.length(); i++){
            user32.PostMessageW(hwnd, WinUser.WM_CHAR, new WinDef.WPARAM(message.codePointAt(i)), null);
        }
        return true;
    }

    public static void main(String[] args) {
        TryWithHWND th = new TryWithHWND();
        th.RefreshCache();
        for(String windowName:th.HWNDMap.keySet()){
            th.sendMessage("test看看",th.getHWND(windowName));
        }
        /*String text = "上午好";
        final User32 user32 = User32.INSTANCE;
        HWND qqWin = user32.FindWindowW(null, Native.toString("工作任务 - Notepad".getBytes(),"GBK"));
        for (int i = 0; i < text.length(); i++){
            user32.PostMessageW(qqWin, WinUser.WM_CHAR, new WinDef.WPARAM(text.codePointAt(i)), null);
        }
        byte[] windowText = new byte[512];
        user32.GetWindowTextA(qqWin, windowText, 512);
        String wText = Native.toString(windowText,"GBK");
        System.out.println(user32.CloseWindow(qqWin));
        //user32.SetFocus(qqWin);
        //user32.SetForegroundWindow(qqWin);
        user32.EnumWindows(new WNDENUMPROC() {
            int count = 0;
            @Override
            public boolean callback(HWND hWnd, Pointer arg1) {
                byte[] windowText = new byte[512];
                user32.GetWindowTextA(hWnd, windowText, 512);
                String wText = Native.toString(windowText,"GBK");

                // get rid of this if block if you want all windows regardless of whether
                // or not they have text
                if (wText.isEmpty()) {
                    return true;
                }
                System.out.println("Found window with text " + hWnd + ", total " + ++count + " Text: " + wText);
                return true;
            }
        }, null);*/
    }
}
