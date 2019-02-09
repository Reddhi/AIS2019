package org.gtre.itg.ais2019;

import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDatabaseUtility {

    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }
}