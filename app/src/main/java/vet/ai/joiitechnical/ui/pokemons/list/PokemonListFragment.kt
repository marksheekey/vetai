package vet.ai.joiitechnical.ui.pokemons.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.row_pokemon.view.*
import vet.ai.joiitechnical.R
import vet.ai.joiitechnical.databinding.PokemonListFragmentBinding
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDB
import vet.ai.joiitechnical.modules.database.pokemon.PokemonDTO
import vet.ai.joiitechnical.ui.main.BaseFragment
import vet.ai.joiitechnical.ui.main.FragmentManager
import vet.ai.joiitechnical.ui.pokemons.one.PokemonViewFragment


@AndroidEntryPoint
@SuppressLint("FragmentLiveDataObserve")
class PokemonListFragment : BaseFragment<PokemonListFragmentBinding>() {

    override val layoutId: Int = R.layout.pokemon_list_fragment

    companion object {
        fun newInstance() = PokemonListFragment()
    }

    private val viewModel: PokemonListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.pokemonList.observe(this) {
            displayPokemons(it)
        }

        binding.favouritesOnly.setOnCheckedChangeListener { _, isChecked ->
            //viewModel.filterPokemons(isChecked)
        }
    }

    private fun displayPokemons(list: List<PokemonListUIItem>) {
        val container = binding.pokemonList
        for (pokemon in list) {
            val child: View = layoutInflater.inflate(R.layout.row_pokemon, null)
            child.pokemon_name.text = pokemon.name
            child.favourite_icon.isChecked = pokemon.favourited
            child.pokemon_container.setOnClickListener {
                (activity as? FragmentManager)?.showFragment(PokemonViewFragment.newInstance(pokemon.id))
            }
            child.favourite_icon.setOnCheckedChangeListener { buttonView, isChecked ->
               // viewModel.favourite(pokemon, isChecked) {
               //     Snackbar.make(
               ////         binding.root,
               //         getString(R.string.favourited, isChecked.toString()),
                //        Snackbar.LENGTH_SHORT
                //    ).show()
               // }
            }
            container.addView(child)
        }
    }
}