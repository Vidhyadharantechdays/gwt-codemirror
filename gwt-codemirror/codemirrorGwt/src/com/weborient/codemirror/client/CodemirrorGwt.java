package com.weborient.codemirror.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * @author Saman Giahi
 *
 */
public class CodemirrorGwt implements EntryPoint {


	public void onModuleLoad() {
		
		CodeMirrorConfiguration configuration1 = new CodeMirrorConfiguration();
		configuration1.setTagSelectorLabel("Temlatesasasas1: ");
        configuration1.setListBoxPreSets("<html></html>", "<div></div>", "<a href=''></a>");
        GWT.log(configuration1.getId(), null);
        
		CodeMirrorConfiguration configuration2 = new CodeMirrorConfiguration();
		configuration2.setTagSelectorLabel("Temlatesasasas2: ");
        configuration2.setListBoxPreSets("<html></html>", "<div></div>", "<a href=''></a>");
        GWT.log(configuration2.getId(), null);
        
        CodeMirrorEditorWidget widget1 = new CodeMirrorEditorWidget(configuration1);
        
        CodeMirrorEditorWidget widget2 = new CodeMirrorEditorWidget(configuration2);
        
        RootPanel.get().add(widget1);
        RootPanel.get().add(widget2);
        widget2.setText("oooo");
	}
}
