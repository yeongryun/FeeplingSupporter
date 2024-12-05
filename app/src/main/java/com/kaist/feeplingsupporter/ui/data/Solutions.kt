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
    Solution51(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Take a solo walk and recall three happy moments from the past week.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution52(AgeGroup.TEENAGE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Share a recent success story with a group of friends.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution53(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Write a diary entry about a positive event, focusing on sensory details like smell and sound.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution54(AgeGroup.TWENTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Host a small gathering to celebrate a recent achievement.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution55(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Enjoy a quiet dinner at home, savoring every bite of your favorite meal.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution56(AgeGroup.THIRTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Organize a 'gratitude circle' with friends to talk about positive experiences.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution57(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Spend time in a garden or park, focusing on the beauty of the surroundings.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution58(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Plan a short weekend trip with friends and relive joyful memories.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution59(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Reflect on compliments you’ve received and write them in a gratitude journal.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution60(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Share a joyful memory with family over dinner.", Type.SAVORING_POSITIVE_EXPERIENCE),
    Solution61(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Write down three positive lessons learned from a recent mistake.", Type.POSITIVE_REAPPRAISAL),
    Solution62(AgeGroup.TEENAGE, Gender.MALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Talk to a coach or mentor about the silver linings of a recent challenge.", Type.POSITIVE_REAPPRAISAL),
    Solution63(AgeGroup.TWENTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Reflect on a past difficulty and how it contributed to your current strengths while exercising.", Type.POSITIVE_REAPPRAISAL),
    Solution64(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Share a frustrating experience with a friend and brainstorm its positive aspects.", Type.POSITIVE_REAPPRAISAL),
    Solution65(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "List three outcomes of a challenging situation and focus on their positive impact.", Type.POSITIVE_REAPPRAISAL),
    Solution66(AgeGroup.THIRTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Reframe a work setback as an opportunity for skill-building.", Type.POSITIVE_REAPPRAISAL),
    Solution67(AgeGroup.FOURTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "During a walk, identify one positive outcome from a recent family-related stress.", Type.POSITIVE_REAPPRAISAL),
    Solution68(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Discuss with a group how challenges can lead to personal growth.", Type.POSITIVE_REAPPRAISAL),
    Solution69(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Write about a life lesson you learned from a tough time in your journal.", Type.POSITIVE_REAPPRAISAL),
    Solution70(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Recall and share a story of resilience with grandchildren or younger family members.", Type.POSITIVE_REAPPRAISAL),
    Solution71(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Use a mindfulness app to practice a 3-minute breathing exercise.", Type.MINDFULNESS_AND_MEDITATION),
    Solution72(AgeGroup.TEENAGE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Join a group meditation session and focus on being present.", Type.MINDFULNESS_AND_MEDITATION),
    Solution73(AgeGroup.TWENTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Perform a body scan meditation for 5 minutes to relax and release tension.", Type.MINDFULNESS_AND_MEDITATION),
    Solution74(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Attend a yoga class with friends and practice mindfulness during the session.", Type.MINDFULNESS_AND_MEDITATION),
    Solution75(AgeGroup.THIRTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Take a mindful walk and focus on the sensation of each step.", Type.MINDFULNESS_AND_MEDITATION),
    Solution76(AgeGroup.THIRTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Host a mindfulness workshop at work to practice staying present with colleagues.", Type.MINDFULNESS_AND_MEDITATION),
    Solution77(AgeGroup.FOURTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Spend 10 minutes sitting quietly, focusing on the rhythm of your breathing.", Type.MINDFULNESS_AND_MEDITATION),
    Solution78(AgeGroup.FOURTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Share a daily mindfulness practice with your partner or family.", Type.MINDFULNESS_AND_MEDITATION),
    Solution79(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Listen to a guided meditation focusing on gratitude.", Type.MINDFULNESS_AND_MEDITATION),
    Solution80(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Join a local senior meditation group to build mindfulness habits.", Type.MINDFULNESS_AND_MEDITATION),
    Solution81(AgeGroup.TEENAGE, Gender.FEMALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Write a gratitude letter to a close friend.", Type.GRATITUDE_PRACTICES),
    Solution82(AgeGroup.TEENAGE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Create a gratitude jar and share the notes during family dinners.", Type.GRATITUDE_PRACTICES),
    Solution83(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Reflect on three things you’re grateful for after your morning jog.", Type.GRATITUDE_PRACTICES),
    Solution84(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Compliment someone on something they’ve done well recently.", Type.GRATITUDE_PRACTICES),
    Solution85(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Keep a daily gratitude journal, listing three things you appreciate.", Type.GRATITUDE_PRACTICES),
    Solution86(AgeGroup.THIRTY, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Share one thing you’re grateful for in a team meeting or group chat.", Type.GRATITUDE_PRACTICES),
    Solution87(AgeGroup.FOURTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Pause during your day to appreciate your health or surroundings.", Type.GRATITUDE_PRACTICES),
    Solution88(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Thank someone in person for their support or kindness.", Type.GRATITUDE_PRACTICES),
    Solution89(AgeGroup.FIFTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Write about past achievements you are proud of in your journal.", Type.GRATITUDE_PRACTICES),
    Solution90(AgeGroup.SIXTY_ABOVE, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Host a family gathering to express gratitude collectively.", Type.GRATITUDE_PRACTICES),
    Solution91(AgeGroup.TEENAGE, Gender.MALE, Personality.INTROVERT, Interest.SOCIAL, EmotionLevel.HIGH, "Imagine succeeding in an upcoming test and how it will feel.", Type.POSITIVE_IMAGERY),
    Solution92(AgeGroup.TEENAGE, Gender.MALE, Personality.EXTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Picture yourself achieving a fitness goal, like finishing a race.", Type.POSITIVE_IMAGERY),
    Solution93(AgeGroup.TWENTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.HIGH, "Visualize your ideal career and the steps to get there.", Type.POSITIVE_IMAGERY),
    Solution94(AgeGroup.TWENTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Create a vision board with friends and discuss your goals.", Type.POSITIVE_IMAGERY),
    Solution95(AgeGroup.THIRTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.MODERATE, "Reflect on a happy memory and imagine reliving it in the future.", Type.POSITIVE_IMAGERY),
    Solution96(AgeGroup.THIRTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.LOW, "Share your happiest vacation story with your family or friends.", Type.POSITIVE_IMAGERY),
    Solution97(AgeGroup.FOURTY, Gender.MALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Imagine completing a long-term project at work and receiving recognition for it.", Type.POSITIVE_IMAGERY),
    Solution98(AgeGroup.FOURTY, Gender.FEMALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Host a vision board activity with friends and discuss your future plans.", Type.POSITIVE_IMAGERY),
    Solution99(AgeGroup.FIFTY, Gender.FEMALE, Personality.INTROVERT, Interest.PHYSICAL, EmotionLevel.LOW, "Visualize a peaceful retirement activity like gardening and plan how to make it real.", Type.POSITIVE_IMAGERY),
    Solution100(AgeGroup.SIXTY_ABOVE, Gender.MALE, Personality.EXTROVERT, Interest.SOCIAL, EmotionLevel.MODERATE, "Share with your family how you imagine your upcoming birthday celebration and what it means to you.", Type.POSITIVE_IMAGERY)
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