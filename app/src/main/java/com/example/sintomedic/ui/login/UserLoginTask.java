package com.example.sintomedic.ui.login;

import android.os.AsyncTask;

class UserLoginTask extends AsyncTask<Void, Void, Integer> {

    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    public UserLoginTask(AsyncResponse delegate){
        this.delegate = delegate;
    }




    private static final String DUMMY_USER_ID ="aa" ;
    private static final String DUMMY_PASSWORD ="1234" ;
    private final String mUserId;
    private final String mPassword;

    UserLoginTask(String userId, String password) {
        mUserId = userId;
        mPassword = password;
    }



    @Override
    protected Integer doInBackground(Void... voids) {
        try {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return 4;
        }

        if (!mUserId.equals(DUMMY_USER_ID)) {
            return 2;
        }

        if (!mPassword.equals(DUMMY_PASSWORD)) {
            return 3;
        }

        return 1;
    }






}