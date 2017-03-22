package edu.slu.cs.contactmanager;

import android.provider.BaseColumns;

/**
 * Created by dave on 2/22/17.
 */

public final class ContactDBContract {
    private ContactDBContract() {}

    public static class ContactDBEntry implements BaseColumns {
        public static final String TABLE_NAME = "contacts";
        public static final String COLUMN_NAME_FIRST = "first";
        public static final String COLUMN_NAME_LAST = "last";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_EMAIL = "email";
    }
}
