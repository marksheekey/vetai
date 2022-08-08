package vet.ai.joiitechnical.ui.pokemons.list;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import vet.ai.joiitechnical.modules.usecases.FetchPokemonFromDb;
import vet.ai.joiitechnical.modules.usecases.GerNextPageOfPokemon;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PokemonListViewModel_AssistedFactory_Factory implements Factory<PokemonListViewModel_AssistedFactory> {
  private final Provider<GerNextPageOfPokemon> getNextPageOfPokemonProvider;

  private final Provider<FetchPokemonFromDb> fetchPokemonFromDbProvider;

  public PokemonListViewModel_AssistedFactory_Factory(
      Provider<GerNextPageOfPokemon> getNextPageOfPokemonProvider,
      Provider<FetchPokemonFromDb> fetchPokemonFromDbProvider) {
    this.getNextPageOfPokemonProvider = getNextPageOfPokemonProvider;
    this.fetchPokemonFromDbProvider = fetchPokemonFromDbProvider;
  }

  @Override
  public PokemonListViewModel_AssistedFactory get() {
    return newInstance(getNextPageOfPokemonProvider, fetchPokemonFromDbProvider);
  }

  public static PokemonListViewModel_AssistedFactory_Factory create(
      Provider<GerNextPageOfPokemon> getNextPageOfPokemonProvider,
      Provider<FetchPokemonFromDb> fetchPokemonFromDbProvider) {
    return new PokemonListViewModel_AssistedFactory_Factory(getNextPageOfPokemonProvider, fetchPokemonFromDbProvider);
  }

  public static PokemonListViewModel_AssistedFactory newInstance(
      Provider<GerNextPageOfPokemon> getNextPageOfPokemon,
      Provider<FetchPokemonFromDb> fetchPokemonFromDb) {
    return new PokemonListViewModel_AssistedFactory(getNextPageOfPokemon, fetchPokemonFromDb);
  }
}
