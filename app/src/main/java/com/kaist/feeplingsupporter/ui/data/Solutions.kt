package com.kaist.feeplingsupporter.ui.data

import kotlinx.serialization.Serializable

@Serializable
enum class Solution(
    val ageGroup: AgeGroup,
    val gender: Gender,
    val personality: Personality,
    val interest: Interest,
    val emotionLevel: EmotionLevel,
    val solution: String,
    val type: Type
) {
    Solution1(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_HIGH, "Take a solo walk and recall three happy moments from the past week.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution2(AgeGroup.TEENAGE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Share a recent success story with a group of friends.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution3(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_HIGH, "Write a diary entry about a positive event, focusing on sensory details like smell and sound.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution4(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Host a small gathering to celebrate a recent achievement.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution5(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_MODERATE, "Enjoy a quiet dinner at home, savoring every bite of your favorite meal.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution6(AgeGroup.THIRTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_HIGH, "Organize a 'gratitude circle' with friends to talk about positive experiences.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution7(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "Spend time in a garden or park, focusing on the beauty of the surroundings.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution8(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Plan a short weekend trip with friends and relive joyful memories.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution9(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "Reflect on compliments you’ve received and write them in a gratitude journal.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution10(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Share a joyful memory with family over dinner.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution11(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_HIGH, "Write down three positive lessons learned from a recent mistake.", Type.POSITIVE_REAPPRAISAL),
    Solution12(AgeGroup.TEENAGE, Gender.MALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_MODERATE, "Talk to a coach or mentor about the silver linings of a recent challenge.", Type.POSITIVE_REAPPRAISAL),
    Solution13(AgeGroup.TWENTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_MODERATE, "Reflect on a past difficulty and how it contributed to your current strengths while exercising.", Type.POSITIVE_REAPPRAISAL),
    Solution14(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_LOW, "Share a frustrating experience with a friend and brainstorm its positive aspects.", Type.POSITIVE_REAPPRAISAL),
    Solution15(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_HIGH, "List three outcomes of a challenging situation and focus on their positive impact.", Type.POSITIVE_REAPPRAISAL),
    Solution16(AgeGroup.THIRTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Reframe a work setback as an opportunity for skill-building.", Type.POSITIVE_REAPPRAISAL),
    Solution17(AgeGroup.FOURTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "During a walk, identify one positive outcome from a recent family-related stress.", Type.POSITIVE_REAPPRAISAL),
    Solution18(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Discuss with a group how challenges can lead to personal growth.", Type.POSITIVE_REAPPRAISAL),
    Solution19(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "Write about a life lesson you learned from a tough time in your journal.", Type.POSITIVE_REAPPRAISAL),
    Solution20(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Recall and share a story of resilience with grandchildren or younger family members.", Type.POSITIVE_REAPPRAISAL),
    Solution21(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_HIGH, "Use a mindfulness app to practice a 3-minute breathing exercise.", Type.MINDFULNESS_AND_MEDITATION),
    Solution22(AgeGroup.TEENAGE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Join a group meditation session and focus on being present.", Type.MINDFULNESS_AND_MEDITATION),
    Solution23(AgeGroup.TWENTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_HIGH, "Perform a body scan meditation for 5 minutes to relax and release tension.", Type.MINDFULNESS_AND_MEDITATION),
    Solution24(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Attend a yoga class with friends and practice mindfulness during the session.", Type.MINDFULNESS_AND_MEDITATION),
    Solution25(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_MODERATE, "Take a mindful walk and focus on the sensation of each step.", Type.MINDFULNESS_AND_MEDITATION),
    Solution26(AgeGroup.THIRTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_HIGH, "Host a mindfulness workshop at work to practice staying present with colleagues.", Type.MINDFULNESS_AND_MEDITATION),
    Solution27(AgeGroup.FOURTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "Spend 10 minutes sitting quietly, focusing on the rhythm of your breathing.", Type.MINDFULNESS_AND_MEDITATION),
    Solution28(AgeGroup.FOURTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Share a daily mindfulness practice with your partner or family.", Type.MINDFULNESS_AND_MEDITATION),
    Solution29(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "Listen to a guided meditation focusing on gratitude.", Type.MINDFULNESS_AND_MEDITATION),
    Solution30(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_LOW, "Join a local senior meditation group to build mindfulness habits.", Type.MINDFULNESS_AND_MEDITATION),
    Solution31(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_HIGH, "Write a gratitude letter to a close friend.", Type.GRATITUDE_PRACTICES),
    Solution32(AgeGroup.TEENAGE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Create a gratitude jar and share the notes during family dinners.", Type.GRATITUDE_PRACTICES),
    Solution33(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_HIGH, "Reflect on three things you’re grateful for after your morning jog.", Type.GRATITUDE_PRACTICES),
    Solution34(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Compliment someone on something they’ve done well recently.", Type.GRATITUDE_PRACTICES),
    Solution35(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "Keep a daily gratitude journal, listing three things you appreciate.", Type.GRATITUDE_PRACTICES),
    Solution36(AgeGroup.THIRTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Share one thing you’re grateful for in a team meeting or group chat.", Type.GRATITUDE_PRACTICES),
    Solution37(AgeGroup.FOURTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "Pause during your day to appreciate your health or surroundings.", Type.GRATITUDE_PRACTICES),
    Solution38(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_LOW, "Thank someone in person for their support or kindness.", Type.GRATITUDE_PRACTICES),
    Solution39(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_MODERATE, "Write about past achievements you are proud of in your journal.", Type.GRATITUDE_PRACTICES),
    Solution40(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_LOW, "Host a family gathering to express gratitude collectively.", Type.GRATITUDE_PRACTICES),
    Solution41(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_HIGH, "Imagine succeeding in an upcoming test and how it will feel.", Type.POSITIVE_IMAGERY),
    Solution42(AgeGroup.TEENAGE, Gender.MALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_MODERATE, "Picture yourself achieving a fitness goal, like finishing a race.", Type.POSITIVE_IMAGERY),
    Solution43(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_HIGH, "Visualize your ideal career and the steps to get there.", Type.POSITIVE_IMAGERY),
    Solution44(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Create a vision board with friends and discuss your goals.", Type.POSITIVE_IMAGERY),
    Solution45(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_MODERATE, "Reflect on a happy memory and imagine reliving it in the future.", Type.POSITIVE_IMAGERY),
    Solution46(AgeGroup.THIRTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_LOW, "Share your happiest vacation story with your family or friends.", Type.POSITIVE_IMAGERY),
    Solution47(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "Imagine completing a long-term project at work and receiving recognition for it.", Type.POSITIVE_IMAGERY),
    Solution48(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Host a vision board activity with friends and discuss your future plans.", Type.POSITIVE_IMAGERY),
    Solution49(AgeGroup.FIFTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.POSITIVE_LOW, "Visualize a peaceful retirement activity like gardening and plan how to make it real.", Type.POSITIVE_IMAGERY),
    Solution50(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.POSITIVE_MODERATE, "Share with your family how you imagine your upcoming birthday celebration and what it means to you.", Type.POSITIVE_IMAGERY),
    Solution51(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Write emotions on paper and burn them in a safe setting.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution52(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Host a dinner discussion on emotional acceptance.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution53(AgeGroup.THIRTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Volunteer and use the present activity to reflect.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution54(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Meditate on your breath and observe emotions pass by.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution55(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Dance while naming emotions and letting them flow.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution56(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_HIGH, "Visualize negative feelings as objects and 'let them go.'", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution57(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Host an ACT mini-workshop with friends.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution58(AgeGroup.FIFTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Role-play your emotions with a friend humorously.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution59(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_LOW, "Join a mindfulness-based yoga session.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution60(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_LOW, "Reflect on values guiding your decisions each morning.", Type.ACCEPTANCE_AND_COMMITMENT_THERAPY),
    Solution61(AgeGroup.TEENAGE, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Dance to a random song and enjoy the moves.", Type.BEHAVIORAL_DISTRACTION),
    Solution62(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Play board games with family or friends.", Type.BEHAVIORAL_DISTRACTION),
    Solution63(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Paint or draw your feelings on paper.", Type.BEHAVIORAL_DISTRACTION),
    Solution64(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "Sort through photos and organize them creatively.", Type.BEHAVIORAL_DISTRACTION),
    Solution65(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "Try a new video game and enjoy the storyline.", Type.BEHAVIORAL_DISTRACTION),
    Solution66(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Plant a mini herb garden and care for it daily.", Type.BEHAVIORAL_DISTRACTION),
    Solution67(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Solve a complex puzzle to redirect mental energy.", Type.BEHAVIORAL_DISTRACTION),
    Solution68(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_LOW, "Go window shopping and set a small, achievable budget.", Type.BEHAVIORAL_DISTRACTION),
    Solution69(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Bake something new and share it with someone.", Type.BEHAVIORAL_DISTRACTION),
    Solution70(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_LOW, "Watch a funny movie and note favorite moments.", Type.BEHAVIORAL_DISTRACTION),
    Solution71(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "Watch a motivational video and note takeaways.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution72(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "Rewrite a negative event with a humorous twist.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution73(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Write down things you're grateful for and pin them.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution74(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "Play a positive team sport and reflect on collaboration.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution75(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_LOW, "Join a gratitude group and share positive outcomes.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution76(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "Take a short jog while reframing a past mistake.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution77(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Practice seeing stressful situations from another’s perspective.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution78(AgeGroup.FIFTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Focus on three positive aspects of a stressful event.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution79(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "List lessons learned from a recent challenge.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution80(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Identify three outcomes of a seemingly bad day.", Type.COGNITIVE_REAPPRAISAL_AND_REFOCUSING),
    Solution81(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Do 10 slow squats while thinking about what emotions you are currently feeling.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution82(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_HIGH, "Call a close friend and share one thing that made you feel down today.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution83(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Write a letter to yourself about a difficult emotion and read it later.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution84(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_LOW, "Do light stretching while reflecting on how emotions guide your choices.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution85(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "Join a yoga class focused on emotional balance.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution86(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_HIGH, "Share an emotional moment in a trusted online forum.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution87(AgeGroup.FOURTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "List emotions you felt today and rate their intensity.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution88(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Go for a solo walk in a quiet park and reflect on your emotions.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution89(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_HIGH, "Sit quietly in a garden and name each emotion you experienced.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution90(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Host a journaling circle to explore emotions with friends.", Type.INTEGRATIVE_EMOTION_REGULATION),
    Solution91(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_LOW, "Create a stress preparation checklist for predictable events.", Type.RESILIENCE_TRAINING),
    Solution92(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_MODERATE, "Set a physical fitness goal and note improvements.", Type.RESILIENCE_TRAINING),
    Solution93(AgeGroup.THIRTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_LOW, "Share a story of resilience with a group.", Type.RESILIENCE_TRAINING),
    Solution94(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Write a daily affirmation and place it in a visible spot.", Type.RESILIENCE_TRAINING),
    Solution95(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Reflect weekly on one way you showed resilience.", Type.RESILIENCE_TRAINING),
    Solution96(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_LOW, "Learn a new skill and connect it to overcoming challenges.", Type.RESILIENCE_TRAINING),
    Solution97(AgeGroup.FOURTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Join a community gardening project.", Type.RESILIENCE_TRAINING),
    Solution98(AgeGroup.FOURTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_MODERATE, "Attend a local resilience-building seminar.", Type.RESILIENCE_TRAINING),
    Solution99(AgeGroup.FIFTY, Gender.FEMALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.NEGATIVE_LOW, "Volunteer to teach skills to local youth.", Type.RESILIENCE_TRAINING),
    Solution100(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.NEGATIVE_LOW, "Reflect on what resilience means to you and journal it.", Type.RESILIENCE_TRAINING)
}


@Serializable
enum class AgeGroup {
    TEENAGE,
    TWENTY,
    THIRTY,
    FOURTY,
    FIFTY,
    SIXTY_ABOVE
}

@Serializable
enum class Type {
    SAVORING_POSITIVE_EXPERIENCE,
    POSITIVE_REAPPRAISAL,
    MINDFULNESS_AND_MEDITATION,
    GRATITUDE_PRACTICES,
    POSITIVE_IMAGERY,
    ACCEPTANCE_AND_COMMITMENT_THERAPY,
    BEHAVIORAL_DISTRACTION,
    COGNITIVE_REAPPRAISAL_AND_REFOCUSING,
    INTEGRATIVE_EMOTION_REGULATION,
    RESILIENCE_TRAINING
}


@Serializable
enum class Gender {
    MALE,
    FEMALE
}

@Serializable
enum class Personality {
    INTROVERT, EXTROVERT
}

@Serializable
enum class Interest {
    PHYSICAL, SOCIAL
}

@Serializable
enum class EmotionLevel {
    POSITIVE_HIGH,
    POSITIVE_MODERATE,
    POSITIVE_LOW,
    NEGATIVE_LOW,
    NEGATIVE_MODERATE,
    NEGATIVE_HIGH
}