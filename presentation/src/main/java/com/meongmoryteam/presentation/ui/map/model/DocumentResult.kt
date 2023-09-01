package com.meongmoryteam.presentation.ui.map.model

data class DocumentResult(
    val documentList: List<Document>,
    val isMoveCamera: Boolean
) {
    companion object {
        fun empty() = DocumentResult(
            documentList = emptyList(),
            isMoveCamera = false
        )
    }
}
