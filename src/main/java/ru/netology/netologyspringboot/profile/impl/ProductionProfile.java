package ru.netology.netologyspringboot.profile.impl;

import ru.netology.netologyspringboot.profile.SystemProfile;

/**
 * @author Vladimir Troshin
 * @since 23.01.2023
 */
public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
