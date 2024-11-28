package com.kaist.feeplingsupporter.ui.data

enum class Solution(
    val ageGroup: AgeGroup,
    val gender: Gender,
    val personality: Personality,
    val interest: Interest,
    val emotionLevel: EmotionLevel,
    val solution: String
) {
    // example
    Solution1(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_HIGH, "Solution1"),
    Solution2(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_MODERATE, "solution2")
}

enum class AgeGroup {
    TEENAGE,
    TWENTY,
    THIRTY,
    FORTY,
    FIFTY,
    SIXTY_PLUS
}

enum class Gender {
    MALE,
    FEMALE
}

enum class Personality {
    INTROVERT, EXTROVERT
}

enum class Interest {
    PHYSICAL, SOCIAL
}

enum class EmotionLevel {
    POSITIVE_HIGH,
    POSITIVE_MODERATE,
    POSITIVE_LOW,
    NEGATIVE_LOW,
    NEGATIVE_MODERATE,
    NEGATIVE_HIGH
}