package vet.ai.joiitechnical.ui.main

interface FragmentManager {
    fun showFragment(fragment: BaseFragment<*>)
    fun goBack()
}