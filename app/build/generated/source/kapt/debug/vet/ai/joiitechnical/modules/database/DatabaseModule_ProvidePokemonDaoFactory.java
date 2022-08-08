package vet.ai.joiitechnical.modules.database;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDao;
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDatabase;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DatabaseModule_ProvidePokemonDaoFactory implements Factory<PokemonDao> {
  private final DatabaseModule module;

  private final Provider<PokemonDatabase> dbProvider;

  public DatabaseModule_ProvidePokemonDaoFactory(DatabaseModule module,
      Provider<PokemonDatabase> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public PokemonDao get() {
    return providePokemonDao(module, dbProvider.get());
  }

  public static DatabaseModule_ProvidePokemonDaoFactory create(DatabaseModule module,
      Provider<PokemonDatabase> dbProvider) {
    return new DatabaseModule_ProvidePokemonDaoFactory(module, dbProvider);
  }

  public static PokemonDao providePokemonDao(DatabaseModule instance, PokemonDatabase db) {
    return Preconditions.checkNotNull(instance.providePokemonDao(db), "Cannot return null from a non-@Nullable @Provides method");
  }
}
