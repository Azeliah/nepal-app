package com.example.sundmadnepal.data

import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.*
import com.example.sundmadnepal.model.ElementType.*

fun loadRecipes(): List<Recipe> {

    // This is just dummy data, until we can implement a proper repository for recipe data
    return listOf(
        /*Recipe(
            id = 1,
            name = R.string.dahl,
            image = R.drawable.dahl
        ),
        Recipe(
            id = 2,
            name = R.string.momo,
            image = R.drawable.momo
        ),
        Recipe(
            id = 3,
            name = R.string.newari,
            image = R.drawable.newarithali
        ),
        Recipe(
            id = 4,
            name = R.string.fried_chicken,
            image = R.drawable.fried_chicken
        ),
        Recipe(
            id = 5,
            name = R.string.pumpking_pudding,
            image = R.drawable.pudding_final,
            stepList = listOf(
                Step(1, R.drawable.pudding_ingredienses, "Step1: 3 cups of milk"),
                Step(2, R.drawable.pudding_final, "Step2: Follow the shown picture")
            ),
            ingredientList = listOf(
                Ingredient(1, R.drawable.red_chili, "Half a red chili"),
                Ingredient(2, R.drawable.red_lentils, "1½ cup of lentils"),
                Ingredient(3, R.drawable.potatoes, "3 potatoes in either squares or whole")
            )

        )*/
        Recipe(
            id = 1,
            name = R.string.nutritious_flower,
            image = R.drawable.nutritiousflower,
            stepList = listOf(
                Step(1, R.drawable.grainsfornutritiousflour, "पोषिलो पिठो अन्न समूहबाट भिन्न किसिमका २ भाग अन्न  (चामल, गहुँ, मकै, कोदो, जौ, फापर आदि मध्येबाट १÷भाग)\n"),
                Step(2, null, " र १ भाग गेडागुडी (भटमास, चना केराउ मध्ये आदि)\n"),
                Step(3, null, " लाई छुट्टाछुट्टै केलाउने र राम्ररी पाक्ने गरि भुट्ने र छुट्टाछुट्टै पिधेर तयार गरिएको पिठोलाई पकाउँदा साग, गाजर , दूध, घ्यू, मह, अण्डा, मासु, आयोडिनयुक्त नुन मिसाई तयार गर्न सकिन्छ ।"),
                Step(4, R.drawable.sortoutthegrains, "१"),
                Step(5, R.drawable.roastthegrains, "२"),
                Step(6, R.drawable.grindthegrains, "३"),
                Step(7, R.drawable.putflourincontainer, "४"))
        ),
        Recipe(
            id = 2,
            name = R.string.jaulo,
            image = R.drawable.jaulo_finished,
            ingredientList = listOf(
                Ingredient(1, R.drawable.rice_for_jaulo, "चमल       २५ ग्राम"),
                Ingredient(2, R.drawable.lentil_for_jaulo, "मुंग वा मुसुरो वा रहको वा कालो दाल ८ ग्राम"),
                Ingredient(3, R.drawable.oiljaulo, "घ्यू वा तेल    ५ ग्राम"),
                Ingredient(4, R.drawable.spinach_saag_for_jaulo, "हरिायो सागपात  इच्छा अनुसार")
            ),
            stepList = listOf(
                Step(1, null, "१: चामल र दाललाई केलाउने ।"),
                Step(2, null, "२: चामल र दाललाईमिासएर थोरै पानीले आभा घण्टा सम्म भिजाउने ।\n"),
                Step(3, null, "३: आधा घण्टा पछि थोरै घ्यू र पानी हालेर छोपेर पकाउने ।"),
                Step(4, null, "४: पाक्दै गरेको जाउलोमा पिसेको वा मसिनो पारेर टुक्रा गरेको साग पनि मिसाउने र एकछिन छोपेर पकाउने।\n"),
                Step(5, null, "५: स्वादको लागि थोरै आयोडिन युक्त नून हाल्ने ।")
            )
        )
    )
}

// Dummy data for quiz questions
fun loadQuestions(): MutableList<QuizQuestion> {
    return mutableListOf(
        QuizQuestion(R.string.healthyQuestion, R.drawable.fried_chicken, false),
        QuizQuestion(R.string.healthyQuestion, R.drawable.potatoes, true),
        QuizQuestion(R.string.chipsQuestion, null, false),
        QuizQuestion(R.string.waterQuestion, null, false)
    )
}

// Dummy data for health-info page
fun loadHealthInfo(): List<HealthInfoPage> {

    val placeholderPage = listOf(
        HealthInfoElement(
            type = PARAGRAPH,
            contentRef = R.string.zeroToSix1,
        ),
        HealthInfoElement(
            type = IMAGE,
            contentRef = R.drawable.woman_breastfeeding,
        ),
        HealthInfoElement(
            type = PARAGRAPH,
            contentRef = R.string.zeroToSix2,
        ),
        HealthInfoElement(
            type = IMAGE,
            contentRef = R.drawable.fried_chicken,
        )
    )

    return listOf(
        HealthInfoPage(
            id = 1,
            image = R.drawable.health_info_general,
            title = R.string.general_information,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 2,
            image = R.drawable.health_info_pregnant,
            title = R.string.pregnant,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 3,
            image = R.drawable.health_info_0_6_months,
            title = R.string.zero_to_six_months,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 4,
            image = R.drawable.health_info_6_9_months,
            title = R.string.six_to_nine_months,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 5,
            image = R.drawable.health_info_9_12_months,
            title = R.string.nine_to_twelve_months,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 6,
            image = R.drawable.health_info_12_24_months,
            title = R.string.twelve_to_twenty_four_months,
            content = placeholderPage,
        ),
    )
}
