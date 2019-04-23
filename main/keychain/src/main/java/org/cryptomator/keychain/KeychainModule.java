/*******************************************************************************
 * Copyright (c) 2017 Skymatic UG (haftungsbeschränkt).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the accompanying LICENSE file.
 *******************************************************************************/
package org.cryptomator.keychain;

import java.util.Optional;
import java.util.Set;

import org.cryptomator.jni.JniModule;

import com.google.common.collect.Sets;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;

@Module(includes = {JniModule.class})
public class KeychainModule {

	@Provides
	@ElementsIntoSet
	Set<KeychainAccessStrategy> provideKeychainAccessStrategies(MacSystemKeychainAccess macKeychain, WindowsProtectedKeychainAccess winKeychain) {
		return Sets.newHashSet(macKeychain, winKeychain);
	}

	@Provides
	public Optional<KeychainAccess> provideSupportedKeychain(Set<KeychainAccessStrategy> keychainAccessStrategies) {
		return keychainAccessStrategies.stream().filter(KeychainAccessStrategy::isSupported).map(KeychainAccess.class::cast).findFirst();
	}

}
