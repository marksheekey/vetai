package vet.ai.joiitechnical.databinding;
import vet.ai.joiitechnical.R;
import vet.ai.joiitechnical.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class PokemonViewFragmentBindingImpl extends PokemonViewFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.header, 3);
        sViewsWithIds.put(R.id.toolbar, 4);
        sViewsWithIds.put(R.id.back, 5);
        sViewsWithIds.put(R.id.pokemon_image, 6);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PokemonViewFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private PokemonViewFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[1]
            , (com.google.android.material.appbar.AppBarLayout) bindings[3]
            , (android.widget.ImageView) bindings[6]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.Toolbar) bindings[4]
            );
        this.favouriteIcon.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.pokemonName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.pokemon == variableId) {
            setPokemon((vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPokemon(@Nullable vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO Pokemon) {
        this.mPokemon = Pokemon;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.pokemon);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String PokemonName1 = null;
        boolean pokemonFavourited = false;
        vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO pokemon = mPokemon;

        if ((dirtyFlags & 0x3L) != 0) {



                if (pokemon != null) {
                    // read pokemon.name
                    PokemonName1 = pokemon.getName();
                    // read pokemon.favourited
                    pokemonFavourited = pokemon.getFavourited();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.favouriteIcon, pokemonFavourited);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.pokemonName, PokemonName1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): pokemon
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}