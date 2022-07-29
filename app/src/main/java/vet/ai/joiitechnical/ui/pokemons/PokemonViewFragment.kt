package vet.ai.joiitechnical.ui.pokemons

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import vet.ai.joiitechnical.R
import vet.ai.joiitechnical.databinding.PokemonViewFragmentBinding
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO
import vet.ai.joiitechnical.modules.database.pokemon.PokemonRepo
import vet.ai.joiitechnical.ui.main.BaseFragment
import vet.ai.joiitechnical.ui.main.FragmentManager
import javax.inject.Inject

@AndroidEntryPoint
class PokemonViewFragment : BaseFragment<PokemonViewFragmentBinding>() {

    override val layoutId = R.layout.pokemon_view_fragment

    var pokemonDTO: PokemonDTO? = null

    companion object {
        fun newInstance(pokemonDTO: PokemonDTO) = PokemonViewFragment().apply {
            this.pokemonDTO = pokemonDTO
        }
    }

    @Inject
    lateinit var pokemonRepo: PokemonRepo

    private val vm: PokemonViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.listenToUpdate(pokemonDTO!!)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                binding.pokemon = it
                binding.executePendingBindings()
            }, {
                it.printStackTrace()
            })

        binding.back.setOnClickListener {
            (activity as? FragmentManager)?.goBack()
        }

        binding.favouriteIcon.setOnClickListener {
            val checked = (it as AppCompatCheckBox).isChecked
            vm.favourite(pokemonDTO!!,checked) {
                Snackbar.make(
                    binding.root,
                    getString(R.string.favourited, checked.toString()),
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}