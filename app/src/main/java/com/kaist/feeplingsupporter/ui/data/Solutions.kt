package com.kaist.feeplingsupporter.ui.data

enum class Solution(
    val ageGroup: AgeGroup,
    val gender: Gender,
    val personality: Personality,
    val interest: Interest,
    val emotionLevel: EmotionLevel,
    val solution: String,
    val type: Type
) {
    Solution1(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Write emotions on paper and burn them in a safe setting.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution2(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Host a dinner discussion on emotional acceptance.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution3(AgeGroup.THIRTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Volunteer and use the present activity to reflect.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution4(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Meditate on your breath and observe emotions pass by.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution5(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Dance while naming emotions and letting them flow.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution6(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Visualize negative feelings as objects and 'let them go.'", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution7(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Host an ACT mini-workshop with friends.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution8(AgeGroup.FIFTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Role-play your emotions with a friend humorously.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution9(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Join a mindfulness-based yoga session.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution10(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Reflect on values guiding your decisions each morning.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution11(AgeGroup.TEENAGE, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Dance to a random song and enjoy the moves.", Type.BEHAVIORAL_DISTRACTION),
    Solution12(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Play board games with family or friends.", Type.BEHAVIORAL_DISTRACTION),
    Solution13(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Paint or draw your feelings on paper.", Type.BEHAVIORAL_DISTRACTION),
    Solution14(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Sort through photos and organize them creatively.", Type.BEHAVIORAL_DISTRACTION),
    Solution15(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Try a new video game and enjoy the storyline.", Type.BEHAVIORAL_DISTRACTION),
    Solution16(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Plant a mini herb garden and care for it daily.", Type.BEHAVIORAL_DISTRACTION),
    Solution17(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Solve a complex puzzle to redirect mental energy.", Type.BEHAVIORAL_DISTRACTION),
    Solution18(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Go window shopping and set a small, achievable budget.", Type.BEHAVIORAL_DISTRACTION),
    Solution19(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Bake something new and share it with someone.", Type.BEHAVIORAL_DISTRACTION),
    Solution20(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Watch a funny movie and note favorite moments.", Type.BEHAVIORAL_DISTRACTION),
    Solution21(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Watch a motivational video and note takeaways.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution22(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Rewrite a negative event with a humorous twist.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution23(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Write down things you're grateful for and pin them.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution24(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Play a positive team sport and reflect on collaboration.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution25(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Join a gratitude group and share positive outcomes.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution26(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Take a short jog while reframing a past mistake.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution27(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Practice seeing stressful situations from another’s perspective.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution28(AgeGroup.FIFTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Focus on three positive aspects of a stressful event.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution29(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "List lessons learned from a recent challenge.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution30(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Identify three outcomes of a seemingly bad day.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution31(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Do 10 slow squats while thinking about what emotions you are currently feeling.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution32(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Call a close friend and share one thing that made you feel down today.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution33(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Write a letter to yourself about a difficult emotion and read it later.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution34(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Do light stretching while reflecting on how emotions guide your choices.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution35(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Join a yoga class focused on emotional balance.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution36(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Share an emotional moment in a trusted online forum.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution37(AgeGroup.FOURTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "List emotions you felt today and rate their intensity.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution38(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Go for a solo walk in a quiet park and reflect on your emotions.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution39(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Sit quietly in a garden and name each emotion you experienced.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution40(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Host a journaling circle to explore emotions with friends.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution41(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Create a stress preparation checklist for predictable events.", Type.RESILIENCE_TRAINING),
    Solution42(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Set a physical fitness goal and note improvements.", Type.RESILIENCE_TRAINING),
    Solution43(AgeGroup.THIRTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Share a story of resilience with a group.", Type.RESILIENCE_TRAINING),
    Solution44(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Write a daily affirmation and place it in a visible spot.", Type.RESILIENCE_TRAINING),
    Solution45(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Reflect weekly on one way you showed resilience.", Type.RESILIENCE_TRAINING),
    Solution46(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Learn a new skill and connect it to overcoming challenges.", Type.RESILIENCE_TRAINING),
    Solution47(AgeGroup.FOURTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Join a community gardening project.", Type.RESILIENCE_TRAINING),
    Solution48(AgeGroup.FOURTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Attend a local resilience-building seminar.", Type.RESILIENCE_TRAINING),
    Solution49(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Volunteer to teach skills to local youth.", Type.RESILIENCE_TRAINING),
    Solution50(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Reflect on what resilience means to you and journal it.", Type.RESILIENCE_TRAINING)
}

enum class AgeGroup {
    TEENAGE,
    TWENTY,
    THIRTY,
    FORTY,
    FIFTY,
    SIXTY_PLUS
}

enum class Type {
    ACCEPTANCE_AND_COMMITMENT_THERAPY,
    BEHAVIORAL_DISTRACTION,
    COGNITIVE_REAPPRAISAL_AND_REFOCUSING,
    INTEGRATIVE_EMOTION_REGULATION,
    RESILIENCE_TRAINING
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