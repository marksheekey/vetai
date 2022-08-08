package vet.ai.joiitechnical.modules.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<Cache> cacheProvider;

  public NetworkModule_ProvideHttpClientFactory(Provider<Cache> cacheProvider) {
    this.cacheProvider = cacheProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideHttpClient(cacheProvider.get());
  }

  public static NetworkModule_ProvideHttpClientFactory create(Provider<Cache> cacheProvider) {
    return new NetworkModule_ProvideHttpClientFactory(cacheProvider);
  }

  public static OkHttpClient provideHttpClient(Cache cache) {
    return Preconditions.checkNotNull(NetworkModule.INSTANCE.provideHttpClient(cache), "Cannot return null from a non-@Nullable @Provides method");
  }
}
