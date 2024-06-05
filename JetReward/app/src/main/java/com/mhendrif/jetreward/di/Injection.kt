package com.mhendrif.jetreward.di

import com.mhendrif.jetreward.data.RewardRepository


object Injection {
    fun provideRepository(): RewardRepository {
        return RewardRepository.getInstance()
    }
}