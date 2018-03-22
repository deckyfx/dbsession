package com.github.deckyfx.dbsession.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import com.github.deckyfx.greendao.AbstractDao;
import com.github.deckyfx.greendao.Property;
import com.github.deckyfx.greendao.internal.DaoConfig;
import com.github.deckyfx.greendao.database.Database;
import com.github.deckyfx.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DB_SESSION".
*/
public class DbSessionDao extends AbstractDao<DbSession, Long> {

    public static final String TABLENAME = "DB_SESSION";

    /**
     * Properties of entity DbSession.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Session = new Property(1, String.class, "session", false, "SESSION");
        public final static Property CreatedAt = new Property(2, java.util.Date.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(3, java.util.Date.class, "updatedAt", false, "UPDATED_AT");
    }

    private DaoSession daoSession;


    public DbSessionDao(DaoConfig config) {
        super(config);
    }
    
    public DbSessionDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DB_SESSION\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"SESSION\" TEXT," + // 1: session
                "\"CREATED_AT\" INTEGER," + // 2: createdAt
                "\"UPDATED_AT\" INTEGER);"); // 3: updatedAt
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DB_SESSION\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DbSession entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String session = entity.getSession();
        if (session != null) {
            stmt.bindString(2, session);
        }
 
        java.util.Date createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindLong(3, createdAt.getTime());
        }
 
        java.util.Date updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindLong(4, updatedAt.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DbSession entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String session = entity.getSession();
        if (session != null) {
            stmt.bindString(2, session);
        }
 
        java.util.Date createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindLong(3, createdAt.getTime());
        }
 
        java.util.Date updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindLong(4, updatedAt.getTime());
        }
    }

    @Override
    protected final void attachEntity(DbSession entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public DbSession readEntity(Cursor cursor, int offset) {
        DbSession entity = new DbSession( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // session
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // createdAt
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)) // updatedAt
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DbSession entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setSession(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCreatedAt(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setUpdatedAt(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DbSession entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DbSession entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DbSession entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
