package io.nekohasekai.sagernet.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import io.nekohasekai.sagernet.R
import io.nekohasekai.sagernet.database.DataStore
import io.nekohasekai.sagernet.databinding.LayoutMainTvBinding
import io.nekohasekai.sagernet.ktx.launchCustomTab

class MainActivityTv : ThemedActivity() {

    lateinit var binding: LayoutMainTvBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = LayoutMainTvBinding.inflate(layoutInflater)


        setContentView(R.layout.layout_main_tv)
    }

    @SuppressLint("CommitTransaction")
    fun displayFragment(fragment: ToolbarFragment) {
        if (fragment is ConfigurationFragment) {

        } else if (!DataStore.showBottomBar) {

        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.config_fragment, fragment)
            .commitAllowingStateLoss()
    }

    fun displayFragmentWithId(@IdRes id: Int): Boolean {
        when (id) {
            R.id.nav_configuration -> {
                displayFragment(ConfigurationFragment())
            }

            R.id.nav_group -> displayFragment(GroupFragment())
            R.id.nav_route -> displayFragment(RouteFragment())
            R.id.nav_settings -> displayFragment(SettingsFragment())
            R.id.nav_traffic -> displayFragment(WebviewFragment())
            R.id.nav_tools -> displayFragment(ToolsFragment())
            R.id.nav_logcat -> displayFragment(LogcatFragment())
            R.id.nav_faq -> {
                launchCustomTab("https://matsuridayo.github.io/")
                return false
            }

            R.id.nav_about -> displayFragment(AboutFragment())
            R.id.nav_tuiguang -> {
                launchCustomTab("https://matsuricom.pages.dev/")
                return false
            }

            else -> return false
        }
//        navigation.menu.findItem(id).isChecked = true
        return true
    }
}