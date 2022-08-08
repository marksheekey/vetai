package vet.ai.joiitechnical;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vet.ai.joiitechnical.modules.database.DatabaseModule;
import vet.ai.joiitechnical.modules.database.DatabaseModule_ProvidePokemonDaoFactory;
import vet.ai.joiitechnical.modules.database.DatabaseModule_ProvidePokemonDatabaseFactory;
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDao;
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDatabase;
import vet.ai.joiitechnical.modules.localData.LocalData;
import vet.ai.joiitechnical.modules.network.NetworkModule;
import vet.ai.joiitechnical.modules.network.NetworkModule_ProvideCacheDirFactory;
import vet.ai.joiitechnical.modules.network.NetworkModule_ProvideGsonConverterFactoryFactory;
import vet.ai.joiitechnical.modules.network.NetworkModule_ProvideGsonFactory;
import vet.ai.joiitechnical.modules.network.NetworkModule_ProvideHttpClientFactory;
import vet.ai.joiitechnical.modules.network.NetworkModule_ProvidePokemonAPIFactory;
import vet.ai.joiitechnical.modules.network.NetworkModule_ProvideRetrofitFactory;
import vet.ai.joiitechnical.modules.network.PokemonAPI;
import vet.ai.joiitechnical.modules.repos.PokemonRepo;
import vet.ai.joiitechnical.modules.usecases.FetchPokemonFromDb;
import vet.ai.joiitechnical.modules.usecases.GerNextPageOfPokemon;
import vet.ai.joiitechnical.ui.main.MainActivity;
import vet.ai.joiitechnical.ui.pokemons.list.PokemonListFragment;
import vet.ai.joiitechnical.ui.pokemons.list.PokemonListViewModel_AssistedFactory;
import vet.ai.joiitechnical.ui.pokemons.list.PokemonListViewModel_AssistedFactory_Factory;
import vet.ai.joiitechnical.ui.pokemons.one.PokemonViewFragment;
import vet.ai.joiitechnical.ui.pokemons.one.PokemonViewFragment_MembersInjector;
import vet.ai.joiitechnical.ui.pokemons.one.PokemonViewModel_AssistedFactory;
import vet.ai.joiitechnical.ui.pokemons.one.PokemonViewModel_AssistedFactory_Factory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerApp_HiltComponents_ApplicationC extends App_HiltComponents.ApplicationC {
  private final ApplicationContextModule applicationContextModule;

  private final DatabaseModule databaseModule;

  private volatile Object cache = new MemoizedSentinel();

  private volatile Object okHttpClient = new MemoizedSentinel();

  private volatile Object gson = new MemoizedSentinel();

  private volatile Object gsonConverterFactory = new MemoizedSentinel();

  private volatile Object retrofit = new MemoizedSentinel();

  private volatile Object pokemonAPI = new MemoizedSentinel();

  private volatile Object localData = new MemoizedSentinel();

  private volatile Object gerNextPageOfPokemon = new MemoizedSentinel();

  private volatile Provider<GerNextPageOfPokemon> gerNextPageOfPokemonProvider;

  private DaggerApp_HiltComponents_ApplicationC(
      ApplicationContextModule applicationContextModuleParam, DatabaseModule databaseModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
    this.databaseModule = databaseModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private PokemonDatabase getPokemonDatabase() {
    return DatabaseModule_ProvidePokemonDatabaseFactory.providePokemonDatabase(databaseModule, ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
  }

  private PokemonDao getPokemonDao() {
    return DatabaseModule_ProvidePokemonDaoFactory.providePokemonDao(databaseModule, getPokemonDatabase());
  }

  private Cache getCache() {
    Object local = cache;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = cache;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvideCacheDirFactory.provideCacheDir(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          cache = DoubleCheck.reentrantCheck(cache, local);
        }
      }
    }
    return (Cache) local;
  }

  private OkHttpClient getOkHttpClient() {
    Object local = okHttpClient;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = okHttpClient;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvideHttpClientFactory.provideHttpClient(getCache());
          okHttpClient = DoubleCheck.reentrantCheck(okHttpClient, local);
        }
      }
    }
    return (OkHttpClient) local;
  }

  private Gson getGson() {
    Object local = gson;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = gson;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvideGsonFactory.provideGson();
          gson = DoubleCheck.reentrantCheck(gson, local);
        }
      }
    }
    return (Gson) local;
  }

  private GsonConverterFactory getGsonConverterFactory() {
    Object local = gsonConverterFactory;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = gsonConverterFactory;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvideGsonConverterFactoryFactory.provideGsonConverterFactory(getGson());
          gsonConverterFactory = DoubleCheck.reentrantCheck(gsonConverterFactory, local);
        }
      }
    }
    return (GsonConverterFactory) local;
  }

  private Retrofit getRetrofit() {
    Object local = retrofit;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = retrofit;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvideRetrofitFactory.provideRetrofit(getOkHttpClient(), getGsonConverterFactory());
          retrofit = DoubleCheck.reentrantCheck(retrofit, local);
        }
      }
    }
    return (Retrofit) local;
  }

  private PokemonAPI getPokemonAPI() {
    Object local = pokemonAPI;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = pokemonAPI;
        if (local instanceof MemoizedSentinel) {
          local = NetworkModule_ProvidePokemonAPIFactory.providePokemonAPI(getRetrofit());
          pokemonAPI = DoubleCheck.reentrantCheck(pokemonAPI, local);
        }
      }
    }
    return (PokemonAPI) local;
  }

  private LocalData getLocalData() {
    Object local = localData;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = localData;
        if (local instanceof MemoizedSentinel) {
          local = new LocalData(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          localData = DoubleCheck.reentrantCheck(localData, local);
        }
      }
    }
    return (LocalData) local;
  }

  private PokemonRepo getPokemonRepo() {
    return new PokemonRepo(getPokemonDao(), getPokemonAPI(), getLocalData());
  }

  private GerNextPageOfPokemon getGerNextPageOfPokemon() {
    Object local = gerNextPageOfPokemon;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = gerNextPageOfPokemon;
        if (local instanceof MemoizedSentinel) {
          local = new GerNextPageOfPokemon(getPokemonRepo());
          gerNextPageOfPokemon = DoubleCheck.reentrantCheck(gerNextPageOfPokemon, local);
        }
      }
    }
    return (GerNextPageOfPokemon) local;
  }

  private Provider<GerNextPageOfPokemon> getGerNextPageOfPokemonProvider() {
    Object local = gerNextPageOfPokemonProvider;
    if (local == null) {
      local = new SwitchingProvider<>(0);
      gerNextPageOfPokemonProvider = (Provider<GerNextPageOfPokemon>) local;
    }
    return (Provider<GerNextPageOfPokemon>) local;
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  @Override
  public void injectApp(App app) {
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private DatabaseModule databaseModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public Builder databaseModule(DatabaseModule databaseModule) {
      this.databaseModule = Preconditions.checkNotNull(databaseModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder networkModule(NetworkModule networkModule) {
      Preconditions.checkNotNull(networkModule);
      return this;
    }

    public App_HiltComponents.ApplicationC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      if (databaseModule == null) {
        this.databaseModule = new DatabaseModule();
      }
      return new DaggerApp_HiltComponents_ApplicationC(applicationContextModule, databaseModule);
    }
  }

  private final class ActivityRetainedCBuilder implements App_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public App_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends App_HiltComponents.ActivityRetainedC {
    private ActivityRetainedCImpl() {

    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    private final class ActivityCBuilder implements App_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public App_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends App_HiltComponents.ActivityC {
      private final Activity activity;

      private volatile Provider<FetchPokemonFromDb> fetchPokemonFromDbProvider;

      private volatile Provider<PokemonListViewModel_AssistedFactory> pokemonListViewModel_AssistedFactoryProvider;

      private volatile Provider<PokemonViewModel_AssistedFactory> pokemonViewModel_AssistedFactoryProvider;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private FetchPokemonFromDb getFetchPokemonFromDb() {
        return new FetchPokemonFromDb(DaggerApp_HiltComponents_ApplicationC.this.getPokemonRepo());
      }

      private Provider<FetchPokemonFromDb> getFetchPokemonFromDbProvider() {
        Object local = fetchPokemonFromDbProvider;
        if (local == null) {
          local = new SwitchingProvider<>(1);
          fetchPokemonFromDbProvider = (Provider<FetchPokemonFromDb>) local;
        }
        return (Provider<FetchPokemonFromDb>) local;
      }

      private PokemonListViewModel_AssistedFactory getPokemonListViewModel_AssistedFactory() {
        return PokemonListViewModel_AssistedFactory_Factory.newInstance(DaggerApp_HiltComponents_ApplicationC.this.getGerNextPageOfPokemonProvider(), getFetchPokemonFromDbProvider());
      }

      private Provider<PokemonListViewModel_AssistedFactory> getPokemonListViewModel_AssistedFactoryProvider(
          ) {
        Object local = pokemonListViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          pokemonListViewModel_AssistedFactoryProvider = (Provider<PokemonListViewModel_AssistedFactory>) local;
        }
        return (Provider<PokemonListViewModel_AssistedFactory>) local;
      }

      private PokemonViewModel_AssistedFactory getPokemonViewModel_AssistedFactory() {
        return PokemonViewModel_AssistedFactory_Factory.newInstance(DaggerApp_HiltComponents_ApplicationC.this.getGerNextPageOfPokemonProvider());
      }

      private Provider<PokemonViewModel_AssistedFactory> getPokemonViewModel_AssistedFactoryProvider(
          ) {
        Object local = pokemonViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(2);
          pokemonViewModel_AssistedFactoryProvider = (Provider<PokemonViewModel_AssistedFactory>) local;
        }
        return (Provider<PokemonViewModel_AssistedFactory>) local;
      }

      private Map<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>> getMapOfStringAndProviderOfViewModelAssistedFactoryOf(
          ) {
        return MapBuilder.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>newMapBuilder(2).put("vet.ai.joiitechnical.ui.pokemons.list.PokemonListViewModel", (Provider) getPokemonListViewModel_AssistedFactoryProvider()).put("vet.ai.joiitechnical.ui.pokemons.one.PokemonViewModel", (Provider) getPokemonViewModel_AssistedFactoryProvider()).build();
      }

      private ViewModelProvider.Factory getProvideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerApp_HiltComponents_ApplicationC.this.applicationContextModule), getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
      }

      @Override
      public Set<ViewModelProvider.Factory> getActivityViewModelFactory() {
        return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      @Override
      public void injectMainActivity(MainActivity mainActivity) {
      }

      private final class FragmentCBuilder implements App_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public App_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends App_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory getProvideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerApp_HiltComponents_ApplicationC.this.applicationContextModule), ActivityCImpl.this.getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
        }

        @Override
        public Set<ViewModelProvider.Factory> getFragmentViewModelFactory() {
          return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        @Override
        public void injectPokemonListFragment(PokemonListFragment pokemonListFragment) {
        }

        @Override
        public void injectPokemonViewFragment(PokemonViewFragment pokemonViewFragment) {
          injectPokemonViewFragment2(pokemonViewFragment);
        }

        private PokemonViewFragment injectPokemonViewFragment2(PokemonViewFragment instance) {
          PokemonViewFragment_MembersInjector.injectPokemonRepo(instance, DaggerApp_HiltComponents_ApplicationC.this.getPokemonRepo());
          return instance;
        }

        private final class ViewWithFragmentCBuilder implements App_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public App_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends App_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements App_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public App_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends App_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // vet.ai.joiitechnical.ui.pokemons.list.PokemonListViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getPokemonListViewModel_AssistedFactory();

            case 1: // vet.ai.joiitechnical.modules.usecases.FetchPokemonFromDb 
            return (T) ActivityCImpl.this.getFetchPokemonFromDb();

            case 2: // vet.ai.joiitechnical.ui.pokemons.one.PokemonViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getPokemonViewModel_AssistedFactory();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements App_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public App_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends App_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }

  private final class SwitchingProvider<T> implements Provider<T> {
    private final int id;

    SwitchingProvider(int id) {
      this.id = id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
      switch (id) {
        case 0: // vet.ai.joiitechnical.modules.usecases.GerNextPageOfPokemon 
        return (T) DaggerApp_HiltComponents_ApplicationC.this.getGerNextPageOfPokemon();

        default: throw new AssertionError(id);
      }
    }
  }
}
