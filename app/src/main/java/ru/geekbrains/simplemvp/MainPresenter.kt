package ru.geekbrains.simplemvp

class MainPresenter(private val resources: IStringResource) {
    private var view: IViewMainActivity? = null
    private lateinit var modelUser: ModelUser

    fun attachView(mainActivity: IViewMainActivity) {
        this.view = mainActivity
    }

    fun detachView() {
        view = null
    }

    fun sayHello() {
        if (view == null){
            return
        }
        modelUser = ModelUser(resources, view!!.name)
        var helloString = modelUser.makeGreeting()
        view!!.sayHello(helloString)
    }
}