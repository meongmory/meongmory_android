package com.meongmoryteam.data.model.response.pet

import com.meongmoryteam.domain.model.response.pet.GetSearchBreedEntity
import com.meongmoryteam.domain.model.response.pet.PageSearchBreedResponse
import com.meongmoryteam.domain.model.response.pet.SearchBreedResponse
import com.meongmoryteam.domain.model.response.pet.CustomPage
import com.meongmoryteam.domain.model.response.pet.Sort
import com.meongmoryteam.domain.model.response.pet.Data

import kotlinx.serialization.Serializable

@Serializable
data class GetSearchBreedResponse(
    val status: Int,
    val code: String,
    val data: DataList
)

@Serializable
data class DataList(
    val animalTypeLists: PageSearchBreedRes
)
@Serializable
data class PageSearchBreedRes(
    val content: MutableList<SearchBreedRes>,
    val pageable: Page,
    val totalElements: Int,
    val totalPages: Int,
    val last: Boolean,
    val size: Int,
    val number: Int,
    val sort: Sorted,
    val numberOfElements: Int,
    val first: Boolean,
    val empty: Boolean,
)

@Serializable
data class SearchBreedRes(
    val animalId: Int,
    val animalName: String,
    val animalType: String
)

@Serializable
data class Page(
    val sort: Sorted,
    val offset: Int,
    val pageNumber: Int,
    val pageSize: Int,
    val paged: Boolean,
    val unpaged: Boolean,
)

@Serializable
data class Sorted(
    val empty: Boolean,
    val sorted: Boolean,
    val unsorted: Boolean
)

fun MutableList<SearchBreedRes>.toSearchBreedResponse(): MutableList<SearchBreedResponse> = map { it.toSearchBreed() }.toMutableList()
fun SearchBreedRes.toSearchBreed(): SearchBreedResponse {
    return SearchBreedResponse(
        animalId = this.animalId,
        animalName = this.animalName,
        animalType = this.animalType
    )
}
fun GetSearchBreedResponse.toGetSearchBreedEntity(): GetSearchBreedEntity {
    return GetSearchBreedEntity(
        status = this.status,
        code = this.code,
        data = Data(
            animalTypeLists = PageSearchBreedResponse(
                content = this.data.animalTypeLists.content.toSearchBreedResponse(),
                empty = this.data.animalTypeLists.empty,
                first = this.data.animalTypeLists.first,
                last = this.data.animalTypeLists.last,
                number = this.data.animalTypeLists.number,
                numberOfElements = this.data.animalTypeLists.numberOfElements,
                pageable = CustomPage(
//                    page = this.data.animalTypeLists.pageable.page,
//                    size = this.data.animalTypeLists.pageable.size,
//                    sort = this.data.animalTypeLists.pageable.sort
                    sort = Sort(
                        empty = this.data.animalTypeLists.sort.empty,
                        sorted = this.data.animalTypeLists.sort.sorted,
                        unsorted = this.data.animalTypeLists.sort.unsorted
                    ),
                    offset = this.data.animalTypeLists.pageable.offset,
                    pageNumber = this.data.animalTypeLists.pageable.pageNumber,
                    pageSize = this.data.animalTypeLists.pageable.pageSize,
                    paged = this.data.animalTypeLists.pageable.paged,
                    unpaged = this.data.animalTypeLists.pageable.unpaged
                ),
                size = this.data.animalTypeLists.size,
                sort = Sort(
                    empty = this.data.animalTypeLists.sort.empty,
                    sorted = this.data.animalTypeLists.sort.sorted,
                    unsorted = this.data.animalTypeLists.sort.unsorted
                ),
                totalElements = this.data.animalTypeLists.totalElements,
                totalPages = this.data.animalTypeLists.totalPages
            )
        )
    )
}




//@Serializable
//data class PageSearchBreedRes(
//    val content: List<SearchBreedRes>,
//    val empty: Boolean,
//    val first: Boolean,
//    val last: Boolean,
//    val number: Int,
//    val numberOfElements: Int,
//    val pageable: Page,
//    val size: Int,
//    val sort: Sorted,
//    val totalElements: Int,
//    val totalPages: Int
//)
//
//@Serializable
//data class SearchBreedRes(
//    val animalId: Int,
//    val animalName: String,
//    val animalType: String
//)
//
//@Serializable
//data class Page(
//    val page: Int,
//    val size: Int,
//    val sort: List<String>
//)
//
//@Serializable
//data class Sorted(
//    val empty: Boolean,
//    val sorted: Boolean,
//    val unsorted: Boolean
//)
//
//fun GetSearchBreedResponse.toGetSearchBreedEntity(): GetSearchBreedEntity {
//    return GetSearchBreedEntity(
//        status = this.status,
//        code = this.code,
//        data = Data(
//            animalTypeLists = PageSearchBreedResponse(
//                content = listOf<SearchBreedResponse>(),
//                empty = this.data.animalTypeLists.empty,
//                first = this.data.animalTypeLists.first,
//                last = this.data.animalTypeLists.last,
//                number = this.data.animalTypeLists.number,
//                numberOfElements = this.data.animalTypeLists.numberOfElements,
//                pageable = CustomPage(
//                    page = this.data.animalTypeLists.pageable.page,
//                    size = this.data.animalTypeLists.pageable.size,
//                    sort = this.data.animalTypeLists.pageable.sort
//                ),
//                size = this.data.animalTypeLists.size,
//                sort = Sort(
//                    empty = this.data.animalTypeLists.sort.empty,
//                    sorted = this.data.animalTypeLists.sort.sorted,
//                    unsorted = this.data.animalTypeLists.sort.unsorted
//                ),
//                totalElements = this.data.animalTypeLists.totalElements,
//                totalPages = this.data.animalTypeLists.totalPages
//            )
//        )
//    )
//}
