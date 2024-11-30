package com.kaist.feeplingsupporter.ui.data

enum class Solution(
    enum class Solution(
        val ageGroup: AgeGroup,
        val gender: Gender,
        val personality: Personality,
        val interest: Interest,
        val emotionLevel: EmotionLevel,
        val solution: String
    ) {
        Solution1(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Write emotions on paper and burn them in a safe setting."),
        Solution2(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Host a dinner discussion on emotional acceptance."),
        Solution3(AgeGroup.THIRTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Volunteer and use the present activity to reflect."),
        Solution4(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Meditate on your breath and observe emotions pass by."),
        Solution5(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Dance while naming emotions and letting them flow."),
        Solution6(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Visualize negative feelings as objects and 'let them go.'"),
        Solution7(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Host an ACT mini-workshop with friends."),
        Solution8(AgeGroup.FIFTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Role-play your emotions with a friend humorously."),
        Solution9(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Join a mindfulness-based yoga session."),
        Solution10(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Reflect on values guiding your decisions each morning."),
        Solution11(AgeGroup.TEENAGE, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Dance to a random song and enjoy the moves."),
        Solution12(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Play board games with family or friends."),
        Solution13(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Paint or draw your feelings on paper."),
        Solution14(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Sort through photos and organize them creatively."),
        Solution15(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Try a new video game and enjoy the storyline."),
        Solution16(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Plant a mini herb garden and care for it daily."),
        Solution17(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Solve a complex puzzle to redirect mental energy."),
        Solution18(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Go window shopping and set a small, achievable budget."),
        Solution19(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Bake something new and share it with someone."),
        Solution20(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Watch a funny movie and note favorite moments."),
        Solution21(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Watch a motivational video and note takeaways."),
        Solution22(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Rewrite a negative event with a humorous twist."),
        Solution23(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Write down things you're grateful for and pin them."),
        Solution24(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Play a positive team sport and reflect on collaboration."),
        Solution25(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Join a gratitude group and share positive outcomes."),
        Solution26(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Take a short jog while reframing a past mistake."),
        Solution27(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Practice seeing stressful situations from another’s perspective."),
        Solution28(AgeGroup.FIFTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Focus on three positive aspects of a stressful event."),
        Solution29(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "List lessons learned from a recent challenge."),
        Solution30(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Identify three outcomes of a seemingly bad day."),
        Solution31(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Do 10 slow squats while thinking about what emotions you are currently feeling."),
        Solution32(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Call a close friend and share one thing that made you feel down today."),
        Solution33(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Write a letter to yourself about a difficult emotion and read it later."),
        Solution34(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Do light stretching while reflecting on how emotions guide your choices."),
        Solution35(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Join a yoga class focused on emotional balance."),
        Solution36(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Share an emotional moment in a trusted online forum."),
        Solution37(AgeGroup.FOURTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "List emotions you felt today and rate their intensity."),
        Solution38(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Go for a solo walk in a quiet park and reflect on your emotions."),
        Solution39(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Sit quietly in a garden and name each emotion you experienced."),
        Solution40(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Host a journaling circle to explore emotions with friends."),
        Solution41(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Create a stress preparation checklist for predictable events."),
        Solution42(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Set a physical fitness goal and note improvements."),
        Solution43(AgeGroup.THIRTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Share a story of resilience with a group."),
        Solution44(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Write a daily affirmation and place it in a visible spot."),
        Solution45(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Reflect weekly on one way you showed resilience."),
        Solution46(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Learn a new skill and connect it to overcoming challenges."),
        Solution47(AgeGroup.FOURTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Join a community gardening project."),
        Solution48(AgeGroup.FOURTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Attend a local resilience-building seminar."),
        Solution49(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Volunteer to teach skills to local youth."),
        Solution50(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Reflect on what resilience means to you and journal it.")
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