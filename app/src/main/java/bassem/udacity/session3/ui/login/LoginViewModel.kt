package bassem.udacity.session3.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bassem.udacity.session3.User

class LoginViewModel : ViewModel() {

    private val _user: MutableLiveData<User> = MutableLiveData(User())
    val user: LiveData<User> = _user

    private val _isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData(false)
    val isUserLoggedIn: LiveData<Boolean> = _isUserLoggedIn

    fun onLoginButtonClicked() {
        _user.value?.let {
            _isUserLoggedIn.value = true
        }
    }
}