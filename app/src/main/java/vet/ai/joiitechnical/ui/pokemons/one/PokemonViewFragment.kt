package vet.ai.joiitechnical.ui.pokemons.one

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import vet.ai.joiitechnical.R
import vet.ai.joiitechnical.databinding.PokemonViewFragmentBinding
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO
import vet.ai.joiitechnical.modules.repos.PokemonRepo
import vet.ai.joiitechnical.ui.main.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class PokemonViewFragment : BaseFragment<PokemonViewFragmentBinding>() {

    override val layoutId = R.layout.pokemon_view_fragment

    var pokemonId: Int? = null

    companion object {
        fun newInstance(pokemonId: Int) = PokemonViewFragment().apply {
            this.pokemonId = pokemonId
        }
    }


    private val vm: PokemonViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonId?.let{
            vm.fetchPokemon(it)
        }

        vm.pokemon.observe(viewLifecycleOwner) { pokemon ->
            //todo
        }
    }
}