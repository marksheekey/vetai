package vet.ai.joiitechnical;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import vet.ai.joiitechnical.databinding.PokemonListFragmentBindingImpl;
import vet.ai.joiitechnical.databinding.PokemonViewFragmentBindingImpl;
import vet.ai.joiitechnical.databinding.RowPokemonBindingImpl;

@Generated("Android Data Binding")
public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_POKEMONLISTFRAGMENT = 1;

  private static final int LAYOUT_POKEMONVIEWFRAGMENT = 2;

  private static final int LAYOUT_ROWPOKEMON = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(vet.ai.joiitechnical.R.layout.pokemon_list_fragment, LAYOUT_POKEMONLISTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(vet.ai.joiitechnical.R.layout.pokemon_view_fragment, LAYOUT_POKEMONVIEWFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(vet.ai.joiitechnical.R.layout.row_pokemon, LAYOUT_ROWPOKEMON);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_POKEMONLISTFRAGMENT: {
          if ("layout/pokemon_list_fragment_0".equals(tag)) {
            return new PokemonListFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for pokemon_list_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_POKEMONVIEWFRAGMENT: {
          if ("layout/pokemon_view_fragment_0".equals(tag)) {
            return new PokemonViewFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for pokemon_view_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_ROWPOKEMON: {
          if ("layout/row_pokemon_0".equals(tag)) {
            return new RowPokemonBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for row_pokemon is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "item");
      sKeys.put(2, "pokemon");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/pokemon_list_fragment_0", vet.ai.joiitechnical.R.layout.pokemon_list_fragment);
      sKeys.put("layout/pokemon_view_fragment_0", vet.ai.joiitechnical.R.layout.pokemon_view_fragment);
      sKeys.put("layout/row_pokemon_0", vet.ai.joiitechnical.R.layout.row_pokemon);
    }
  }
}
