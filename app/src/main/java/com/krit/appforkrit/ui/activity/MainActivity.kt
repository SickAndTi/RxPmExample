package com.krit.appforkrit.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.krit.appforkrit.App
import com.krit.appforkrit.R
import com.krit.appforkrit.Screens
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    var navigator: Navigator = object :SupportAppNavigator(this, R.id.mainContainer) {
        override fun applyCommand(command: Command) {
            super.applyCommand(command)
            Timber.d("Command:$command")
        }
    }

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.COMPONENT.inject(this)

        if (savedInstanceState == null) {
            router.newRootScreen(Screens.CityListScreen)
        }

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }

}
