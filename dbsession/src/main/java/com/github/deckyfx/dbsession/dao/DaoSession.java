package com.github.deckyfx.dbsession.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.github.deckyfx.dbsession.dao.DbSession;

import com.github.deckyfx.dbsession.dao.DbSessionDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dbSessionDaoConfig;

    private final DbSessionDao dbSessionDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dbSessionDaoConfig = daoConfigMap.get(DbSessionDao.class).clone();
        dbSessionDaoConfig.initIdentityScope(type);

        dbSessionDao = new DbSessionDao(dbSessionDaoConfig, this);

        registerDao(DbSession.class, dbSessionDao);
    }
    
    public void clear() {
        dbSessionDaoConfig.clearIdentityScope();
    }

    public DbSessionDao getDbSessionDao() {
        return dbSessionDao;
    }

}
