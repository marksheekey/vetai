package vet.ai.joiitechnical.modules.network;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideGsonConverterFactoryFactory implements Factory<GsonConverterFactory> {
  private final Provider<Gson> gsonProvider;

  public NetworkModule_ProvideGsonConverterFactoryFactory(Provider<Gson> gsonProvider) {
    this.gsonProvider = gsonProvider;
  }

  @Override
  public GsonConverterFactory get() {
    return provideGsonConverterFactory(gsonProvider.get());
  }

  public static NetworkModule_ProvideGsonConverterFactoryFactory create(
      Provider<Gson> gsonProvider) {
    return new NetworkModule_ProvideGsonConverterFactoryFactory(gsonProvider);
  }

  public static GsonConverterFactory provideGsonConverterFactory(Gson gson) {
    return Preconditions.checkNotNull(NetworkModule.INSTANCE.provideGsonConverterFactory(gson), "Cannot return null from a non-@Nullable @Provides method");
  }
}
