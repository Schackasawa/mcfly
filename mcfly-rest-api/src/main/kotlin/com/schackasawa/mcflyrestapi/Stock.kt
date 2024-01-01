package com.schackasawa.mcflyrestapi

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table;

@Entity
@Table(name = "stocks")
data class Stock(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val ticker: String = "",
    val name: String = ""
)
