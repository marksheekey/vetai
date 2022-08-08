package vet.ai.joiitechnical.modules.usecases;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import vet.ai.joiitechnical.modules.repos.PokemonRepo;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GerNextPageOfPokemon_Factory implements Factory<GerNextPageOfPokemon> {
  private final Provider<PokemonRepo> repoProvider;

  public GerNextPageOfPokemon_Factory(Provider<PokemonRepo> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GerNextPageOfPokemon get() {
    return newInstance(repoProvider.get());
  }

  public static GerNextPageOfPokemon_Factory create(Provider<PokemonRepo> repoProvider) {
    return new GerNextPageOfPokemon_Factory(repoProvider);
  }

  public static GerNextPageOfPokemon newInstance(PokemonRepo repo) {
    return new GerNextPageOfPokemon(repo);
  }
}
