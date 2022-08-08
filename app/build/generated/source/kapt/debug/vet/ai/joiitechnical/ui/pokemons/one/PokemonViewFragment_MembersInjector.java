package vet.ai.joiitechnical.ui.pokemons.one;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class PokemonViewFragment_MembersInjector implements MembersInjector<PokemonViewFragment> {
  private final Provider<PokemonRepo> pokemonRepoProvider;

  public PokemonViewFragment_MembersInjector(Provider<PokemonRepo> pokemonRepoProvider) {
    this.pokemonRepoProvider = pokemonRepoProvider;
  }

  public static MembersInjector<PokemonViewFragment> create(
      Provider<PokemonRepo> pokemonRepoProvider) {
    return new PokemonViewFragment_MembersInjector(pokemonRepoProvider);
  }

  @Override
  public void injectMembers(PokemonViewFragment instance) {
    injectPokemonRepo(instance, pokemonRepoProvider.get());
  }

  @InjectedFieldSignature("vet.ai.joiitechnical.ui.pokemons.one.PokemonViewFragment.pokemonRepo")
  public static void injectPokemonRepo(PokemonViewFragment instance, PokemonRepo pokemonRepo) {
    instance.pokemonRepo = pokemonRepo;
  }
}
