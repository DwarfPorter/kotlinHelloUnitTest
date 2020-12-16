package ru.geekbrains.simplemvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IViewMainActivity {
    override val name: String
        get() = editName.text.toString()

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(StringResources(baseContext))
        presenter.attachView(this)
        button.setOnClickListener {
            presenter.sayHello()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun sayHello(stringHello: String){
        textHello.text = stringHello
    }
}