package vet.ai.joiitechnical.ui.pokemons.list;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;
import vet.ai.joiitechnical.modules.usecases.FetchPokemonFromDb;
import vet.ai.joiitechnical.modules.usecases.GerNextPageOfPokemon;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class PokemonListViewModel_AssistedFactory implements ViewModelAssistedFactory<PokemonListViewModel> {
  private final Provider<GerNextPageOfPokemon> getNextPageOfPokemon;

  private final Provider<FetchPokemonFromDb> fetchPokemonFromDb;

  @Inject
  PokemonListViewModel_AssistedFactory(Provider<GerNextPageOfPokemon> getNextPageOfPokemon,
      Provider<FetchPokemonFromDb> fetchPokemonFromDb) {
    this.getNextPageOfPokemon = getNextPageOfPokemon;
    this.fetchPokemonFromDb = fetchPokemonFromDb;
  }

  @Override
  @NonNull
  public PokemonListViewModel create(SavedStateHandle arg0) {
    return new PokemonListViewModel(getNextPageOfPokemon.get(), fetchPokemonFromDb.get());
  }
}
