package vet.ai.joiitechnical.ui.pokemons.one;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import vet.ai.joiitechnical.modules.usecases.GerNextPageOfPokemon;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PokemonViewModel_AssistedFactory_Factory implements Factory<PokemonViewModel_AssistedFactory> {
  private final Provider<GerNextPageOfPokemon> getNextPageOfPokemonProvider;

  public PokemonViewModel_AssistedFactory_Factory(
      Provider<GerNextPageOfPokemon> getNextPageOfPokemonProvider) {
    this.getNextPageOfPokemonProvider = getNextPageOfPokemonProvider;
  }

  @Override
  public PokemonViewModel_AssistedFactory get() {
    return newInstance(getNextPageOfPokemonProvider);
  }

  public static PokemonViewModel_AssistedFactory_Factory create(
      Provider<GerNextPageOfPokemon> getNextPageOfPokemonProvider) {
    return new PokemonViewModel_AssistedFactory_Factory(getNextPageOfPokemonProvider);
  }

  public static PokemonViewModel_AssistedFactory newInstance(
      Provider<GerNextPageOfPokemon> getNextPageOfPokemon) {
    return new PokemonViewModel_AssistedFactory(getNextPageOfPokemon);
  }
}
