package com.jhlee.cleanarchitecture.data.remote.dto

import com.jhlee.cleanarchitecture.domain.model.CoinDetail

data class CoinDetailDto(
    val description: String = "",
    val development_status: String = "",
    val first_data_at: String = "",
    val hardware_wallet: Boolean = false,
    val hash_algorithm: String = "",
    val id: String = "",
    val is_active: Boolean = false,
    val is_new: Boolean = false,
    val last_data_at: String = "",
    val links: Links = Links(),
    val links_extended: List<LinksExtended> = arrayListOf(),
    val logo: String = "",
    val message: String = "",
    val name: String = "",
    val open_source: Boolean = false,
    val org_structure: String = "",
    val proof_type: String = "",
    val rank: Int = 0,
    val started_at: String = "",
    val symbol: String = "",
    val tags: List<Tag> = arrayListOf(),
    val team: List<TeamMember> = arrayListOf(),
    val type: String = "",
    val whitepaper: Whitepaper = Whitepaper()
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = is_active,
        tags = tags.map { it.name },
        team = team
    )
}