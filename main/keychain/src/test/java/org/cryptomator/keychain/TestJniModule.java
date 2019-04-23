/*******************************************************************************
 * Copyright (c) 2017 Skymatic UG (haftungsbeschränkt).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the accompanying LICENSE file.
 *******************************************************************************/
package org.cryptomator.keychain;

import java.util.Optional;

import org.cryptomator.jni.JniModule;
import org.cryptomator.jni.MacFunctions;
import org.cryptomator.jni.WinFunctions;

import dagger.Lazy;

public class TestJniModule extends JniModule {

	@Override
	public Optional<WinFunctions> winFunctions(Lazy<WinFunctions> winFunction) {
		return Optional.empty();
	}

	@Override
	public Optional<MacFunctions> macFunctions(Lazy<MacFunctions> winFunction) {
		return Optional.empty();
	}

}
