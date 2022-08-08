package vet.ai.joiitechnical.modules.repos;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDao;
import vet.ai.joiitechnical.modules.localData.LocalData;
import vet.ai.joiitechnical.modules.network.PokemonAPI;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PokemonRepo_Factory implements Factory<PokemonRepo> {
  private final Provider<PokemonDao> pokemonDaoProvider;

  private final Provider<PokemonAPI> pokemonAPIProvider;

  private final Provider<LocalData> localDataProvider;

  public PokemonRepo_Factory(Provider<PokemonDao> pokemonDaoProvider,
      Provider<PokemonAPI> pokemonAPIProvider, Provider<LocalData> localDataProvider) {
    this.pokemonDaoProvider = pokemonDaoProvider;
    this.pokemonAPIProvider = pokemonAPIProvider;
    this.localDataProvider = localDataProvider;
  }

  @Override
  public PokemonRepo get() {
    return newInstance(pokemonDaoProvider.get(), pokemonAPIProvider.get(), localDataProvider.get());
  }

  public static PokemonRepo_Factory create(Provider<PokemonDao> pokemonDaoProvider,
      Provider<PokemonAPI> pokemonAPIProvider, Provider<LocalData> localDataProvider) {
    return new PokemonRepo_Factory(pokemonDaoProvider, pokemonAPIProvider, localDataProvider);
  }

  public static PokemonRepo newInstance(PokemonDao pokemonDao, PokemonAPI pokemonAPI,
      LocalData localData) {
    return new PokemonRepo(pokemonDao, pokemonAPI, localData);
  }
}
