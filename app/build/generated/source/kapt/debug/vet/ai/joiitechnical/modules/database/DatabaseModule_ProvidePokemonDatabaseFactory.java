package vet.ai.joiitechnical.modules.database;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDatabase;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DatabaseModule_ProvidePokemonDatabaseFactory implements Factory<PokemonDatabase> {
  private final DatabaseModule module;

  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvidePokemonDatabaseFactory(DatabaseModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public PokemonDatabase get() {
    return providePokemonDatabase(module, contextProvider.get());
  }

  public static DatabaseModule_ProvidePokemonDatabaseFactory create(DatabaseModule module,
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvidePokemonDatabaseFactory(module, contextProvider);
  }

  public static PokemonDatabase providePokemonDatabase(DatabaseModule instance, Context context) {
    return Preconditions.checkNotNull(instance.providePokemonDatabase(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
