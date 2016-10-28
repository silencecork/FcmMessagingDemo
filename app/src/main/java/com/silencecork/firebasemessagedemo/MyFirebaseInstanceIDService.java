package com.silencecork.firebasemessagedemo;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * 負責取得FCM Token的service
 * Android會自動啟動，只要你有正確在AndroidManifest.xml中寫好宣告
 *
 * 如何推播？推播的Firebase server以及訊息格式寫在FirebaseMessageDemo/push_msg_sample
 * 
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    /**
     * 沒有FCM Token時，或是FCM的Token更新時，onTokenRefresh()就會被Android系統自動呼叫
     * 接下來就可以使用FirebaseInstanceId.getInstance().getToken()取得token
     */
    @Override
    public void onTokenRefresh() {
        // 開始取得FCM Token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "FCM token: " + refreshedToken);

        // 可以將token上傳至server，以便server儲存，爾後發推播時使用
        sendRegistrationToServer(refreshedToken);
    }

    /**
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // TODO: 寫下上傳token到server的程式碼
    }
}
