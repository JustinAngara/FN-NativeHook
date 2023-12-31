package com.fortnitemaincheats;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.*;

import static com.sun.jna.platform.win32.WinUser.*;

public class HandleMouseOutput{

    public static final int MOUSEEVENTF_MOVE = 1;
    public static final int MOUSEEVENTF_LEFTDOWN = 2;
    public static final int MOUSEEVENTF_LEFTUP = 4;

    private static WinUser.HHOOK hHook;
    static final User32 user32Library = User32.INSTANCE;
    static WinDef.HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);



    public static void keyReMapOn() {
        WinUser.LowLevelKeyboardProc keyboardHook = new WinUser.LowLevelKeyboardProc() {
            @Override
            public WinDef.LRESULT callback(int nCode, WinDef.WPARAM wParam, WinUser.KBDLLHOOKSTRUCT kbDllHookStruct) {
                if (nCode >= 0) {
                    if (wParam.intValue() == WM_KEYDOWN) {
                        if (kbDllHookStruct.vkCode == 81) {  // Q button
                            clickByCord(40, 40);            
                            return new WinDef.LRESULT(1);
                        }
                    }
                }
                Pointer ptr = kbDllHookStruct.getPointer();
                long peer = Pointer.nativeValue(ptr);
                return user32Library.CallNextHookEx(hHook, nCode, wParam, new WinDef.LPARAM(peer));
            }
        };

        hHook = user32Library.SetWindowsHookEx(WH_KEYBOARD_LL, keyboardHook, hMod, 0);

        int result;
        WinUser.MSG msg = new WinUser.MSG();
        while ((result = user32Library.GetMessage(msg, null, 0, 0)) != 0) {
            if (result == -1) {
                break;
            } else {
                user32Library.TranslateMessage(msg);
                user32Library.DispatchMessage(msg);
            }
        }
    }

    public static void clickByCord(int x, int y) {
        mouseMove(x, y);
        mouseLeftClick(x, y);
    }

    static void mouseMove(int x, int y) {
        mouseAction(x, y, MOUSEEVENTF_MOVE);
    }

    public static void mouseLeftClick(int x, int y) {
        mouseAction(x, y, MOUSEEVENTF_LEFTDOWN);
        mouseAction(x, y, MOUSEEVENTF_LEFTUP);
    }

    public static void mouseAction(int x, int y, int flags) {
        INPUT input = new INPUT();

        input.type = new DWORD(INPUT.INPUT_MOUSE);
        input.input.setType("mi");
        if (x != -1) {
            input.input.mi.dx = new LONG(x);
        }
        if (y != -1) {
            input.input.mi.dy = new LONG(y);
        }
        input.input.mi.time = new DWORD(0);
        input.input.mi.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        input.input.mi.dwFlags = new DWORD(flags);
        User32.INSTANCE.SendInput(new DWORD(1), new INPUT[]{input}, input.size());
    }
    


}
