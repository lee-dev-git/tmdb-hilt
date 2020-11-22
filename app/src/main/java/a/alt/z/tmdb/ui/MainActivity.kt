package a.alt.z.tmdb.ui

import a.alt.z.tmdb.R
import a.alt.z.tmdb.databinding.ActivityMainBinding
import a.alt.z.tmdb.ui.popular.PopularMoviesFragment
import a.alt.z.tmdb.util.viewBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        supportFragmentManager.commit { replace(R.id.mainRootLayout, PopularMoviesFragment(), null) }
    }
}