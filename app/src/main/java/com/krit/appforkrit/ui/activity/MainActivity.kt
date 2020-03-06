package com.krit.appforkrit.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krit.App
import com.krit.appforkrit.R
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    var navigator: Navigator = object : SupportAppNavigator(this, R.id.mainContainer){}

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.COMPONENT.inject(this)
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
