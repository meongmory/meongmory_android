package com.meongmoryteam.presentation.ui

import androidx.compose.ui.graphics.vector.ImageVector
import com.meongmoryteam.presentation.ui.myiconpack.Crown
import com.meongmoryteam.presentation.ui.myiconpack.`Arrow-left`
import kotlin.collections.List as ____KtList

public object MyIconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val MyIconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Crown, `Arrow-left`)
    return __AllIcons!!
  }
