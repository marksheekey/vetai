package vet.ai.joiitechnical.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import vet.ai.joiitechnical.R
import vet.ai.joiitechnical.ui.pokemons.PokemonListFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), FragmentManager {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            showFragment(PokemonListFragment.newInstance())
        }
    }

    override fun showFragment(fragment: BaseFragment<*>) {
        supportFragmentManager.commit(true) {
            addToBackStack(null)
            replace(R.id.container, fragment, fragment::class.java.canonicalName)
        }
    }

    override fun goBack() {
        onBackPressed()
    }
}