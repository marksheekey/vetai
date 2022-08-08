package vet.ai.joiitechnical.modules.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvidePokemonAPIFactory implements Factory<PokemonAPI> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvidePokemonAPIFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public PokemonAPI get() {
    return providePokemonAPI(retrofitProvider.get());
  }

  public static NetworkModule_ProvidePokemonAPIFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvidePokemonAPIFactory(retrofitProvider);
  }

  public static PokemonAPI providePokemonAPI(Retrofit retrofit) {
    return Preconditions.checkNotNull(NetworkModule.INSTANCE.providePokemonAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
  }
}
