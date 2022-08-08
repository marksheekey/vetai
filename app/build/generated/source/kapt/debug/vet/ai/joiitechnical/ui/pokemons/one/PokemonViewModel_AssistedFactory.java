package vet.ai.joiitechnical.ui.pokemons.one;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;
import vet.ai.joiitechnical.modules.usecases.GerNextPageOfPokemon;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class PokemonViewModel_AssistedFactory implements ViewModelAssistedFactory<PokemonViewModel> {
  private final Provider<GerNextPageOfPokemon> getNextPageOfPokemon;

  @Inject
  PokemonViewModel_AssistedFactory(Provider<GerNextPageOfPokemon> getNextPageOfPokemon) {
    this.getNextPageOfPokemon = getNextPageOfPokemon;
  }

  @Override
  @NonNull
  public PokemonViewModel create(SavedStateHandle arg0) {
    return new PokemonViewModel(getNextPageOfPokemon.get());
  }
}
