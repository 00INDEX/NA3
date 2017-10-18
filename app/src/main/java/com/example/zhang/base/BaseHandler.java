package com.example.zhang.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.zhang.util.AppUtil;

/**
 * Created by zhang on 2017/10/17.
 */

public class BaseHandler extends Handler{
    protected BaseUI ui;

    public BaseHandler (BaseUI ui) {
        this.ui = ui;
    }

    public BaseHandler (Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        try {
            int taskId;
            String result;
            switch (msg.what) {
                case BaseTask.TASK_COMPLETE:
                    ui.hideLoadBar();
                    taskId = msg.getData().getInt("task");
                    result = msg.getData().getString("data");
                    if (result != null) {
                        ui.onTaskComplete(taskId, AppUtil.getMessage(result));
                    } else if (!AppUtil.isEmptyInt(taskId)) {
                        ui.onTaskComplete(taskId);
                    } else {
                        ui.toast(Primer.err.message);
                    }
                    break;
                case BaseTask.NETWORK_ERROR:
                    ui.hideLoadBar();
                    taskId = msg.getData().getInt("task");
                    ui.onNetworkError(taskId);
                    break;
                case BaseTask.SHOW_LOADBAR:
                    ui.showLoadBar();
                    break;
                case BaseTask.HIDE_LOADBAR:
                    ui.hideLoadBar();
                    break;
                case BaseTask.SHOW_TOAST:
                    ui.hideLoadBar();
                    result = msg.getData().getString("data");
                    ui.toast(result);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ui.toast(e.getMessage());
        }
    }
}
