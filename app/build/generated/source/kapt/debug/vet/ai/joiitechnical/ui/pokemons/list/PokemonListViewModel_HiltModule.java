package vet.ai.joiitechnical.ui.pokemons.list;

import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(ActivityRetainedComponent.class)
@OriginatingElement(
    topLevelClass = PokemonListViewModel.class
)
public interface PokemonListViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("vet.ai.joiitechnical.ui.pokemons.list.PokemonListViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(PokemonListViewModel_AssistedFactory factory);
}
