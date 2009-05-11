package com.weborient.codemirror.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * @author Saman Giahi
 *
 */
public class CodemirrorGwt implements EntryPoint {


	public void onModuleLoad() {
		
		CodeMirrorConfiguration configuration = new CodeMirrorConfiguration();
		configuration.setTagSelectorLabel("Temlatesasasas: ");
        configuration.setListBoxPreSets("<html></html>", "<div></div>", "<a href=''></a>");
        
        CodeMirrorEditorWidget widget = new CodeMirrorEditorWidget(configuration);
        
        RootPanel.get().add(widget);
	}
}
