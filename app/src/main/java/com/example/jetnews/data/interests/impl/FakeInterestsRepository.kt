

package com.example.jetnews.data.interests.impl

import com.example.jetnews.data.Result
import com.example.jetnews.data.interests.InterestSection
import com.example.jetnews.data.interests.InterestsRepository
import com.example.jetnews.data.interests.TopicSelection
import com.example.jetnews.utils.addOrRemove
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

/**
 * Implementation of InterestRepository that returns a hardcoded list of
 * topics, people and publications synchronously.
 */
@OptIn(ExperimentalCoroutinesApi::class)
class FakeInterestsRepository : InterestsRepository {

    private val topics by lazy {
        listOf(
            InterestSection("Mobile Development", listOf("Jetpack Compose", "Kotlin", "Jetpack")),
            InterestSection(
                "Best Chisinau",
                listOf("Achievements", "Upcoming Events", "New Members", "Next Year Target", "New Partners")
            ),
            InterestSection("Robotics", listOf("MicroLab", "Latest Events at UTM"))
        )
    }

    private val people by lazy {
        listOf(
            "Anatol Cebotari",
            "Aliona Cojocaru",
            "Cristina Burduja",
            "Maria Chirica",
            "Vladimir Doga",
            "Vitalie Gămurari",
            "Alina Gorghiu",
            "Andrei Juc",
            "Elena Panfilova",
            "Oleg Serebrian"
        )
    }

    private val publications by lazy {
        listOf(
            "Embedded Minds",
            "Code Convergence",
            "Tech Dynamics",
            "Digital Horizons",
            "Innovatech",
            "CyberSphere",
            "Engineer's Haven",
            "TechneXus",
            "Connective Minds",
            "Innovation Station",
        )
    }

    // for now, keep the selections in memory
    private val selectedTopics = MutableStateFlow(setOf<TopicSelection>())
    private val selectedPeople = MutableStateFlow(setOf<String>())
    private val selectedPublications = MutableStateFlow(setOf<String>())

    override suspend fun getTopics(): Result<List<InterestSection>> {
        return Result.Success(topics)
    }

    override suspend fun getPeople(): Result<List<String>> {
        return Result.Success(people)
    }

    override suspend fun getPublications(): Result<List<String>> {
        return Result.Success(publications)
    }

    override suspend fun toggleTopicSelection(topic: TopicSelection) {
        selectedTopics.update {
            it.addOrRemove(topic)
        }
    }

    override suspend fun togglePersonSelected(person: String) {
        selectedPeople.update {
            it.addOrRemove(person)
        }
    }

    override suspend fun togglePublicationSelected(publication: String) {
        selectedPublications.update {
            it.addOrRemove(publication)
        }
    }

    override fun observeTopicsSelected(): Flow<Set<TopicSelection>> = selectedTopics

    override fun observePeopleSelected(): Flow<Set<String>> = selectedPeople

    override fun observePublicationSelected(): Flow<Set<String>> = selectedPublications
}
