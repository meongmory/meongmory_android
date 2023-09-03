package com.meongmoryteam.domain.model.response.pet

data class GetSearchBreedEntity(
    val status: Int,
    val code: String,
    val data: Data
)

data class Data(
    val animalTypeLists: PageSearchBreedResponse
)

data class PageSearchBreedResponse(
    val content: MutableList<SearchBreedResponse>,
    val pageable: CustomPage,
    val totalElements: Int,
    val totalPages: Int,
    val last: Boolean,
    val size: Int,
    val number: Int,
    val sort: Sort,
    val numberOfElements: Int,
    val first: Boolean,
    val empty: Boolean,
)

data class SearchBreedResponse(
    val animalId: Int,
    val animalName: String,
    val animalType: String
)

data class CustomPage(
    val sort: Sort,
    val offset: Int,
    val pageNumber: Int,
    val pageSize: Int,
    val paged: Boolean,
    val unpaged: Boolean,
)

//data class PageSearchBreedResponse(
//    val content: List<SearchBreedResponse>,
//    val empty: Boolean,
//    val first: Boolean,
//    val last: Boolean,
//    val number: Int,
//    val numberOfElements: Int,
//    val pageable: CustomPage,
//    val size:Int,
//    val sort: Sort,
//    val totalElements: Int,
//    val totalPages: Int
//)
//
//data class SearchBreedResponse(
//    val animalId:Int,
//    val animalName: String,
//    val animalType: String
//)
//
//data class CustomPage(
//    val page:Int,
//    val size: Int,
//    val sort: List<String>
//)

data class Sort(
    val empty:Boolean,
    val sorted: Boolean,
    val unsorted:Boolean
)
