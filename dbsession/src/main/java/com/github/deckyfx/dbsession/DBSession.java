package com.github.deckyfx.dbsession;

import android.content.Context;

import com.github.deckyfx.dbhelper.DBHelper;
import com.github.deckyfx.dbsession.dao.DaoMaster;
import com.github.deckyfx.dbsession.dao.DbSession;
import com.github.deckyfx.greendao.Property;
import com.github.deckyfx.simpleadapter.BaseItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by decky on 12/29/16.
 */
public class DBSession<T extends BaseItem> extends DBHelper {
    private final Class<T> mSessionClass;

    private static final class DB_SESSION {
        public static final String DAO_NAME             = "DbSession";
        public static final String PROPERTY_ID          = "Id";
    }

    private static final class TYPE {
        public static final String STRING               = "string";
        public static final String INT                  = "int";
        public static final String LONG                 = "long";
        public static final String DOUBLE               = "double";
        public static final String DATE                 = "date";
        public static final String OBJECT               = "object";
        public static final String ARRAY                = "array";
        public static final String OTHER                = "other";
        public static final String NULL                 = "null";
    }

    public Property DbSessionIdProperty;

    public static final String DB_SESSION_DB_NAME       = "dbsession.db";
    public static final String SESSION_DATA_PREFIX      = "SESSION_DATA_";
    public static final String SESSION_DATA_SEPARATOR   = ".";
    public static final String ACCESS_LOG_TIME_KEY      = "ACCESS_LOG_TIME";

    public DBSession(Context context, Class<T> sessionClass) {
        super(context, DaoMaster.class, DB_SESSION_DB_NAME);

        this.mSessionClass                  = sessionClass;

        this.DbSessionIdProperty            = this.getEntity(DB_SESSION.DAO_NAME).getProperty(DB_SESSION.PROPERTY_ID);
    }

    public String getRaw(){
        JSONObject session_json = null;
        List session_list = this.getEntity(DB_SESSION.DAO_NAME)
                .queryBuilder().limit(1)
                .orderAsc(this.DbSessionIdProperty).list();
        DbSession session;
        Date date           = new Date();
        if (session_list.size() > 0) {
            session         = (DbSession) session_list.get(0);
            return session.getSession();
        }
        return "{}";
    }

    public T get(){
        T session                           =  this.getOrNull();
        if (session == null) {
            try {
                session = this.mSessionClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return session;
    }

    public T getOrNull(){
        T session                           = null;
        try {
            session = T.fromJson(this.getRaw(), this.mSessionClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    public void set(String config) throws JSONException {
        this.set(new JSONObject(config));
    }

    public void set(JSONObject config) {
        List session_list = this.getEntity(DB_SESSION.DAO_NAME)
                .queryBuilder().limit(1)
                .orderAsc(this.DbSessionIdProperty).list();
        DbSession session;
        Date date = new Date();
        if (session_list.size() > 0) {
            session = (DbSession) session_list.get(0);
        } else {
            session = new DbSession();
            session.setCreatedAt(date);
        }
        session.setUpdatedAt(date);
        session.setSession(config.toString());
        this.getEntity(DB_SESSION.DAO_NAME).insertOrReplace(session);
    }

    public void set(T session) throws Exception {
        this.set(BaseItem.toJson(session));
    }

    public void clear(){
        this.getEntity(DB_SESSION.DAO_NAME).deleteAll();
    }

    public boolean valid(){
        JSONObject session_json         = null;
        try {
            session_json = new JSONObject(this.getRaw());
        } catch (JSONException e) {
            return false;
        }
        Iterator<String> keys = session_json.keys();
        int i = 0;
        while (keys.hasNext()) {
            String key = keys.next();
            i++;
        }
        if (i == 0) {
            return false;
        }
        return true;
    }
}
