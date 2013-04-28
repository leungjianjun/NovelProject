package com.woshuwu.test.robot;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.win32.StdCallLibrary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jianjun_liang
 * Date: 13-3-18
 * Time: 下午3:43
 * To change this template use File | Settings | File Templates.
 */
public class WindowsOnTop {
    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
        boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);
        int GetWindowTextA(WinDef.HWND hWnd, byte[] lpString, int nMaxCount);
        WinDef.HWND FindWindowW(String lpClassName, String lpWindowName);
        WinDef.HWND SetFocus(WinDef.HWND hWnd);
        boolean SetForegroundWindow(WinDef.HWND hWnd);
        boolean CloseWindow(WinDef.HWND hWnd);
        void PostMessageW(WinDef.HWND hWnd, int msg, WinDef.WPARAM wParam, WinDef.LPARAM lParam);
        boolean SetWindowPos(WinDef.HWND hWnd,WinDef.HWND hWndInsertAfter,int X,int Y,int cx,int cy,int uFlags);
    }

    private final User32 user32 = User32.INSTANCE;

    public Map<String,WinDef.HWND> HWNDMap = new HashMap<String,WinDef.HWND>();

    public void refreshCache(){
        HWNDMap.clear();
        user32.EnumWindows(new WinUser.WNDENUMPROC() {
            int count = 0;
            @Override
            public boolean callback(WinDef.HWND hWnd, Pointer arg1) {
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

    public WinDef.HWND getHWND(String windowName){
        if(HWNDMap.containsKey(windowName)){
            return HWNDMap.get(windowName);
        }else{
            //refresh the cache
            user32.EnumWindows(new WinUser.WNDENUMPROC() {
                int count = 0;
                @Override
                public boolean callback(WinDef.HWND hWnd, Pointer arg1) {
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

    public void setOnTop(WinDef.HWND hwnd){
        Pointer PHWND_BOTTOM = Pointer.createConstant(-1);
        WinDef.HWND HWND_BOTTOM = new WinDef.HWND(PHWND_BOTTOM);
        System.out.println("test "+user32.SetWindowPos(hwnd,HWND_BOTTOM, -1, -1, -1, -1, 3));
    }

    public static void main(String[] args){
        WindowsOnTop windowsOnTop = new WindowsOnTop();
        windowsOnTop.refreshCache();
        WinDef.HWND hwnd = windowsOnTop.getHWND("NPAPI Plugins - Google Chrome - Google Chrome");
        windowsOnTop.setOnTop(hwnd);
    }
}
