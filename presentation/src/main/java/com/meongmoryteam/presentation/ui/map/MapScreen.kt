package com.meongmoryteam.presentation.ui.map

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.map.entity.ListMode
import com.meongmoryteam.presentation.ui.map.entity.MapViewMode
import com.meongmoryteam.presentation.ui.map.entity.SelectPosition
import com.meongmoryteam.presentation.ui.map.model.Document
import com.meongmoryteam.presentation.ui.map.model.DocumentResult
import kotlinx.coroutines.launch
import net.daum.mf.map.api.MapView.CurrentLocationTrackingMode
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    mapViewMode: MapViewMode?,
    documentResult: DocumentResult?,
    selectPositionEvent: SelectPosition?,
    trackingMode: CurrentLocationTrackingMode?,
    listMode: ListMode?,
    onDocumentClick: ((Document, Int) -> Unit?)?,
    onBackCLick: () -> Unit?,
    onSearchClick: () -> Unit?,
    onFavoriteClick: () -> Unit?,
    onTrackingModeClick: () -> Unit?,
    onListModeClick: () -> Unit?,
    mapView: @Composable () -> Unit?,
) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        sheetContent = {
            val lazyListState = rememberLazyListState()
            val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
            if (selectPositionEvent != null) {
                if (selectPositionEvent.position != -1 && selectPositionEvent.selectedByMap) {
                    LaunchedEffect(Unit) {
                        coroutineScope.launch {
                            if (selectPositionEvent != null) {
                                lazyListState.scrollToItem(selectPositionEvent.position)
                            }
                        }
                    }
                }
            }
            if (documentResult != null) {
                if (selectPositionEvent != null) {
                    if (onDocumentClick != null) {
                        MapBottomSheet(
                            state = lazyListState,
                            documentList = documentResult.documentList,
                            selectedPosition = selectPositionEvent.position,
                            onDocumentClick = onDocumentClick
                        )
                    }
                }
            }
        },
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 0.dp,
    ) {
        Box {
           mapView()
            Column {
                MapTopAppBar(
                    mapViewMode = mapViewMode,
                    onBackCLick = onBackCLick,
                    onSearchClick = onSearchClick,
                )
            }
        }
    }
}

@Composable
fun ColumnScope.MapTopAppBar(
    mapViewMode: MapViewMode?,
    onBackCLick: () -> Unit?,
    onSearchClick: () -> Unit?
) {
    CommonTopAppBar(
        navigationIcon = {
            if (mapViewMode != null) {
                if (mapViewMode.isDefault) {
                    SearchImage()
                }
            }
        },
        title = {
            val modifier = if (mapViewMode?.isDefault == true) {
                Modifier.clickable { onSearchClick() }
            } else {
                Modifier
            }
            if (mapViewMode != null) {
                Text(
                    text = stringResource(mapViewMode.toTitleRes()),
                    modifier = modifier,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        },
    )
}

@StringRes
private fun MapViewMode.toTitleRes(): Int {
    return when (this) {
        MapViewMode.DEFAULT -> R.string.map_search_bar
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapButton(
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.defaultMinSize(minWidth = 60.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = if (isSelected) BorderStroke(width = 1.dp, color = Color.Black) else null,
        onClick = onClick
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            color = Color.Gray
        )
    }
}

@Composable
fun MapBottomSheet(
    state: LazyListState,
    documentList: List<Document>,
    selectedPosition: Int,
    onDocumentClick: (Document, Int) -> Unit?,
) {
    DocumentList(
        modifier = Modifier
            .height(190.dp)
            .background(Color.White),
        state = state,
        documentList = documentList,
        selectedPosition = selectedPosition,
        onClick = onDocumentClick
    )
}

@Composable
fun DocumentList(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    documentList: List<Document>,
    selectedPosition: Int = -1,
    onClick: (Document, Int) -> Unit? = { _, _ -> },
) {
    LazyColumn(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding
    ) {
        itemsIndexed(
            items = documentList,
            key = { _, item -> item.toString() },
            itemContent = { index, item ->
                val isSelected = index == selectedPosition
                DocumentListItem(
                    modifier = if (isSelected) {
                        Modifier.border(
                            width = 1.dp,
                            color = Color.Black
                        )
                    } else {
                        Modifier
                    },
                    index = index,
                    document = item,
                    onClick = onClick
                )
            }
        )
    }
}


@Composable
fun DocumentListItem(
    modifier: Modifier = Modifier,
    index: Int,
    document: Document,
    onClick: (Document, Int) -> Unit? = { _, _ -> },
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(document, index) }
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row {
                Text(
                    text = document.placeName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = document.category(),
                    modifier = Modifier.padding(start = 8.dp),
                    color = Color.Gray,
                    fontSize = 12.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Row {
                Text(
                    text = document.roadAddressName,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = stringResource(
                        R.string.map_rate,
                        String.format(
                            Locale.getDefault(),
                            "%.1f",
                            document.rate
                        )
                    ),
                    modifier = Modifier.padding(start = 8.dp),
                    color = Color.Gray,
                    fontSize = 12.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun DocumentListItemPreview() {
    MaterialTheme {
        Column {
            DocumentListItem(
                index = 0,
                document = Document(
                    id = "0",
                    placeName = stringResource(R.string.map_place_name),
                    categoryName = stringResource(R.string.map_category_name),
                    roadAddressName = stringResource(R.string.map_road_address_name),
                    x = stringResource(R.string.map_x),
                    y = stringResource(R.string.map_y),
                    rate = 4.3f,
                    isFavorite = true
                ))
        }
    }
}