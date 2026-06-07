package com.github.toastshaman.zcamp26.parcel

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ParcelDeliveryRateCalculatorTest {

    private val calculator = ParcelDeliveryRateCalculator()

    @ParameterizedTest(name = "{0} / {1} -> {2}")
    @CsvSource(
        "same day, documents, 4.0",
        "same day, small parcel, 7.0",
        "same day, large parcel, 9.0",
        "two days, documents, 1.0",
        "two days, small parcel, 2.5",
        "two days, large parcel, 3.0"
    )
    fun `calculates delivery price for given delivery type and parcel type`(
        deliveryType: String,
        parcelType: String,
        expectedPrice: Double
    ) {
        expectThat(calculator.calculate(deliveryType, parcelType)).isEqualTo(expectedPrice)
    }
}