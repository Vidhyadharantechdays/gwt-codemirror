package com.weborient.codemirror.client;

import com.google.gwt.core.client.JavaScriptObject;

public class CodeMirrorJSNI {
	
	private JavaScriptObject editorObject;
	private CodeMirrorConfiguration configuration;

	String height = "350px";
	boolean readOnly = false;
	int continuousScanning = 1000;
	boolean lineNumbers = true;
	boolean textWrapping = false;
	String styleUrl = "css/xmlcolors.css";
	
	
	public CodeMirrorJSNI() {
		editorObject = initCodeMirror();
	}
	
	public CodeMirrorJSNI(CodeMirrorConfiguration configuration) {
		this.configuration = configuration;
		initConfigurations();
		editorObject = initCodeMirror();
	}

	private void initConfigurations() {
		if (configuration.getHeight() != null && !configuration.getHeight().equals("")) {
			height = configuration.getHeight();
		}
		if (configuration.getContinuousScanning() > 0) {
			continuousScanning = configuration.getContinuousScanning();
		}
		if (configuration.isTextWrapping()) {
			textWrapping = configuration.isTextWrapping();
		}
		if (configuration.getStyleUrl() != null && !configuration.getStyleUrl().equals("")) {
			styleUrl = configuration.getStyleUrl();
		}
		readOnly = configuration.isReadOnly();
		lineNumbers = configuration.isLineNumbers();
	}

	public native JavaScriptObject initCodeMirror() /*-{
		
		var h = this.@com.weborient.codemirror.client.CodeMirrorJSNI::height;
		var ro = this.@com.weborient.codemirror.client.CodeMirrorJSNI::readOnly;
		var cs = this.@com.weborient.codemirror.client.CodeMirrorJSNI::continuousScanning;
		var ln = this.@com.weborient.codemirror.client.CodeMirrorJSNI::lineNumbers;
		var tr = this.@com.weborient.codemirror.client.CodeMirrorJSNI::textWrapping;
		var su = this.@com.weborient.codemirror.client.CodeMirrorJSNI::styleUrl;

		var editor = $wnd.CodeMirror.fromTextArea('code', {
		    height:		h,
		    parserfile: "parsexml.js",
		    stylesheet: su,
		    path: "js/",
		    continuousScanning: cs,
		    lineNumbers: ln,
		    readOnly: ro,
		    textWrapping: tr,
		    tabMode: "spaces"
		  });
		  
		  return editor;
	}-*/;

	public native String getEditorCode()/*-{
		var ed = this.@com.weborient.codemirror.client.CodeMirrorJSNI::editorObject; 
		return ed.getCode();
	}-*/;
	
	public native void setEditorCode(String code)/*-{
		var txed = this.@com.weborient.codemirror.client.CodeMirrorJSNI::editorObject;
		$wnd.setTimeout(function(a, b){
			txed.setCode(code);
		}, 1000);	
	}-*/;
	
	public native void undoEditor()/*-{
		var ed = this.@com.weborient.codemirror.client.CodeMirrorJSNI::editorObject;
		ed.undo();
	}-*/;
	
	public native void redoEditor()/*-{
		var ed = this.@com.weborient.codemirror.client.CodeMirrorJSNI::editorObject;
		ed.redo();
	}-*/;
	
	public native void reindentEditor()/*-{
		var ed = this.@com.weborient.codemirror.client.CodeMirrorJSNI::editorObject;
		ed.reindent();
	}-*/; 
	
	public native void replaceText(String text)/*-{
		var ed = this.@com.weborient.codemirror.client.CodeMirrorJSNI::editorObject;
		ed.replaceSelection(text);
	}-*/; 
	
	public JavaScriptObject getEditorObject() {
		return editorObject;
	}

	public void setEditorObject(JavaScriptObject editorObject) {
		this.editorObject = editorObject;
	}
	
}
