package com.example.mysampleapp.diceroll.userInterface

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mysampleapp.diceroll.data_source.RepositoryImpl


class ArtifactViewModel(
    private val repo: RepositoryImpl
) : ViewModel() {

    private val _state = mutableStateOf(DataState())
    val state: State<DataState> = _state
    private val data = repo.getData()

    fun event() {
        val myVal = _state.value.changeVal
        print("print val fon state data: $myVal ")

        if (myVal < 2) {
            _state.value = state.value.copy(
                changeVal = _state.value.changeVal + 1,
            )
            _state.value = state.value.copy(
                dataArtifact = data[_state.value.changeVal]
            )
        } else {
            _state.value = state.value.copy(
                changeVal = 0,
            )
            _state.value = state.value.copy(
                dataArtifact = data[_state.value.changeVal]
            )
        }

    }
}