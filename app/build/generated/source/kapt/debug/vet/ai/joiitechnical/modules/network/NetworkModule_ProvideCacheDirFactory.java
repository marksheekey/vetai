package vet.ai.joiitechnical.modules.network;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideCacheDirFactory implements Factory<Cache> {
  private final Provider<Context> contextProvider;

  public NetworkModule_ProvideCacheDirFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Cache get() {
    return provideCacheDir(contextProvider.get());
  }

  public static NetworkModule_ProvideCacheDirFactory create(Provider<Context> contextProvider) {
    return new NetworkModule_ProvideCacheDirFactory(contextProvider);
  }

  public static Cache provideCacheDir(Context context) {
    return Preconditions.checkNotNull(NetworkModule.INSTANCE.provideCacheDir(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
