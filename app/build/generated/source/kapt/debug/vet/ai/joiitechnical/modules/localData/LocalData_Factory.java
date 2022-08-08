package vet.ai.joiitechnical.modules.localData;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LocalData_Factory implements Factory<LocalData> {
  private final Provider<Context> contextProvider;

  public LocalData_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public LocalData get() {
    return newInstance(contextProvider.get());
  }

  public static LocalData_Factory create(Provider<Context> contextProvider) {
    return new LocalData_Factory(contextProvider);
  }

  public static LocalData newInstance(Context context) {
    return new LocalData(context);
  }
}
