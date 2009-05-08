package com.weborient.codemirror.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CodemirrorGwt implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		CodeMirrorConfiguration configuration = new CodeMirrorConfiguration();
		configuration.setListBoxPreInsert(new String[] {"<div></div>", "<html></html>"});
		RootPanel.get().add(new CodeMirrorEditorWidget(configuration));
	}
}
