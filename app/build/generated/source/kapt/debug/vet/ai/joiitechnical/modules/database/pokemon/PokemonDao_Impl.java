package vet.ai.joiitechnical.modules.database.pokemon;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PokemonDao_Impl implements PokemonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PokemonDB> __insertionAdapterOfPokemonDB;

  private final EntityInsertionAdapter<PokemonDB> __insertionAdapterOfPokemonDB_1;

  private final EntityDeletionOrUpdateAdapter<PokemonDB> __deletionAdapterOfPokemonDB;

  private final EntityDeletionOrUpdateAdapter<PokemonDB> __updateAdapterOfPokemonDB;

  public PokemonDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPokemonDB = new EntityInsertionAdapter<PokemonDB>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `pokemon` (`id`,`name`,`url`,`favourited`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PokemonDB value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUrl());
        }
        final int _tmp = value.getFavourited() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__insertionAdapterOfPokemonDB_1 = new EntityInsertionAdapter<PokemonDB>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `pokemon` (`id`,`name`,`url`,`favourited`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PokemonDB value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUrl());
        }
        final int _tmp = value.getFavourited() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__deletionAdapterOfPokemonDB = new EntityDeletionOrUpdateAdapter<PokemonDB>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `pokemon` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PokemonDB value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPokemonDB = new EntityDeletionOrUpdateAdapter<PokemonDB>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `pokemon` SET `id` = ?,`name` = ?,`url` = ?,`favourited` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PokemonDB value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUrl());
        }
        final int _tmp = value.getFavourited() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insert(final PokemonDB... entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPokemonDB.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object insertAll(final List<PokemonDB> pokemon,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPokemonDB_1.insert(pokemon);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public void delete(final PokemonDB... entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPokemonDB.handleMultiple(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PokemonDB... entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPokemonDB.handleMultiple(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public PokemonDB getPokemon(final int id) {
    final String _sql = "SELECT * FROM pokemon WHERE id = ? LIMIT 1 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfFavourited = CursorUtil.getColumnIndexOrThrow(_cursor, "favourited");
      final PokemonDB _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpUrl;
        if (_cursor.isNull(_cursorIndexOfUrl)) {
          _tmpUrl = null;
        } else {
          _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        }
        final boolean _tmpFavourited;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfFavourited);
        _tmpFavourited = _tmp != 0;
        _result = new PokemonDB(_tmpId,_tmpName,_tmpUrl,_tmpFavourited);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<List<PokemonDB>> getAllPokemon() {
    final String _sql = "SELECT * FROM pokemon";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"pokemon"}, new Callable<List<PokemonDB>>() {
      @Override
      public List<PokemonDB> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfFavourited = CursorUtil.getColumnIndexOrThrow(_cursor, "favourited");
          final List<PokemonDB> _result = new ArrayList<PokemonDB>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PokemonDB _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final boolean _tmpFavourited;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavourited);
            _tmpFavourited = _tmp != 0;
            _item = new PokemonDB(_tmpId,_tmpName,_tmpUrl,_tmpFavourited);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<PokemonDB>> getFavouritePokemon() {
    final String _sql = "SELECT * FROM pokemon WHERE favourited = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"pokemon"}, new Callable<List<PokemonDB>>() {
      @Override
      public List<PokemonDB> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfFavourited = CursorUtil.getColumnIndexOrThrow(_cursor, "favourited");
          final List<PokemonDB> _result = new ArrayList<PokemonDB>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PokemonDB _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final boolean _tmpFavourited;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavourited);
            _tmpFavourited = _tmp != 0;
            _item = new PokemonDB(_tmpId,_tmpName,_tmpUrl,_tmpFavourited);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
