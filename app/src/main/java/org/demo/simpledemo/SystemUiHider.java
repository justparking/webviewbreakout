package org.demo.simpledemo;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

public class SystemUiHider implements Runnable, OnSystemUiVisibilityChangeListener, OnFocusChangeListener {

    private static final int VIEW_FLAGS =
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
            View.SYSTEM_UI_FLAG_FULLSCREEN |
            View.SYSTEM_UI_LAYOUT_FLAGS |
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_LOW_PROFILE;

    private static final int WINDOW_FLAGS =
            View.SOUND_EFFECTS_ENABLED |
            View.KEEP_SCREEN_ON |
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;

    final View _view;

    final Window _window;

    public SystemUiHider(Window w) {
        this._window = w;
        this._view = w.getDecorView();

        if (this._view != null) {
            this._view.setOnSystemUiVisibilityChangeListener(this);
            this._view.setOnFocusChangeListener(this);
        }

        run();
    }

    public void run() {
        if (this._window != null)
            this._window.addFlags(WINDOW_FLAGS);

        if (this._view != null) {
            this._view.setSystemUiVisibility(VIEW_FLAGS);
            this._view.clearFocus();
        }
    }

    public void onSystemUiVisibilityChange(int visibility) {
        run();
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            run();
        }
    }
}
