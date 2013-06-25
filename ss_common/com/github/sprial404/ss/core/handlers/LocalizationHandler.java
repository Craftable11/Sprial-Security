package com.github.sprial404.ss.core.handlers;

import com.github.sprial404.ss.core.util.LocalizationUtil;
import com.github.sprial404.ss.lib.Localizations;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler {

    /***
     * Loads in all the localization files from the Localizations library class
     */
    public static void loadLanguages() {
        // For every file specified in the Localization library class, load them into the Language Registry
        for (String localizationFile : Localizations.localeFiles) {
            LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationUtil.getLocaleFromFileName(localizationFile), LocalizationUtil.isXMLLanguageFile(localizationFile));
        }
    }
}
