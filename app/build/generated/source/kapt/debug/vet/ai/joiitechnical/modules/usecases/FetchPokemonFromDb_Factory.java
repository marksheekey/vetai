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
public final class FetchPokemonFromDb_Factory implements Factory<FetchPokemonFromDb> {
  private final Provider<PokemonRepo> repoProvider;

  public FetchPokemonFromDb_Factory(Provider<PokemonRepo> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public FetchPokemonFromDb get() {
    return newInstance(repoProvider.get());
  }

  public static FetchPokemonFromDb_Factory create(Provider<PokemonRepo> repoProvider) {
    return new FetchPokemonFromDb_Factory(repoProvider);
  }

  public static FetchPokemonFromDb newInstance(PokemonRepo repo) {
    return new FetchPokemonFromDb(repo);
  }
}
