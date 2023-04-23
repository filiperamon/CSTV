package com.example.cstv.presentation.match.players

import androidx.lifecycle.*
import com.example.core.domain.model.Player
import com.example.core.usecase.GetPlayersUseCase
import com.example.core.usecase.base.AppCoroutinesDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class MatchPlayerViewModel(): ViewModel() { }