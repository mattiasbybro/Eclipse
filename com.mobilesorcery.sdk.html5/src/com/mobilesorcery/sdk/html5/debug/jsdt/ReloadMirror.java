package com.mobilesorcery.sdk.html5.debug.jsdt;

import org.eclipse.wst.jsdt.debug.core.jsdi.Mirror;
import org.eclipse.wst.jsdt.debug.core.jsdi.VirtualMachine;

public class ReloadMirror implements Mirror {

	private final ReloadVirtualMachine vm;

	ReloadMirror(ReloadVirtualMachine vm) {
		this.vm = vm;
	}

	@Override
	public VirtualMachine virtualMachine() {
		return vm;
	}

}
