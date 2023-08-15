package com.meongmoryteam.presentation.ui.map

import androidx.compose.runtime.ComposableTargetMarker

/**
 * [NaverMapComposable] composable 함수에서 사용할 것으로 예상되는 composable 함수를 표시하는데 사용합니다.
 *
 * [NaverMapComposable] content lambda 외부에서 [NaverMapComposable] composable 함수를 사용하거나
 * 그 반대의 경우에도 빌드 경고를 생성합니다.
 */
@Retention(AnnotationRetention.BINARY)
@ComposableTargetMarker(description = "Naver Map Composable")
@Target(
    AnnotationTarget.FILE,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.TYPE,
    AnnotationTarget.TYPE_PARAMETER,
)
public annotation class NaverMapComposable
