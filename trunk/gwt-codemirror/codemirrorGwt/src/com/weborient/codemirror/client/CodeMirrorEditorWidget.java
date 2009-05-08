package com.weborient.codemirror.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.MouseListener;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CodeMirrorEditorWidget extends Composite {
	
	TextArea textArea;
	CodeMirrorConfiguration configuration;
	CodeMirrorJSNI codeMirrorJSNI;
	HorizontalPanel toolbar;
	
	public CodeMirrorEditorWidget() {
		super();
		initWidget();
	}
	
	public CodeMirrorEditorWidget(CodeMirrorConfiguration configuration) {
		super();
		this.configuration = configuration;
		initWidget();
	}

	private void initWidget() {
		VerticalPanel panel = new VerticalPanel();
		panel.setWidth("100%");
		textArea = new TextArea();
		DOM.setElementAttribute(textArea.getElement(), "id", "code");
		panel.add(getToolbar());
		panel.add(textArea);
		initWidget(panel);
	}
	
	private HorizontalPanel getToolbar() {
		toolbar = new HorizontalPanel();
		toolbar.setStyleName("html-editor-toolbar");
		toolbar.setWidth("65px");
		toolbar.setHeight("30px");
		return toolbar;
	}
	
	private void prepareToolbarItems() {
		
		Image undoButton = new Image("images/icons/undo_blue.png");
		undoButton.setSize("20px", "20px");
		undoButton.addClickListener(new ClickListener() {
			
			public void onClick(Widget arg0) {
				codeMirrorJSNI.undoEditor();
			}
		});
		
		prepareUndoButtonHover(undoButton);
		toolbar.add(undoButton);
		
		Image redoButton = new Image("images/icons/redo_blue.png");
		redoButton.setSize("20px", "20px");
		redoButton.addClickListener(new ClickListener() {
			
			public void onClick(Widget arg0) {
				codeMirrorJSNI.redoEditor();
			}
		});
		
		prepareRedoButtonHover(redoButton);
		toolbar.add(redoButton);
		
		
		Image refreshButton = new Image("images/icons/refresh_blue.png");
		refreshButton.setSize("20px", "20px");
		refreshButton.addClickListener(new ClickListener() {
			
			public void onClick(Widget arg0) {
				codeMirrorJSNI.reindentEditor();
			}
		});
		
		prepareRefreshButtonHover(refreshButton);
		toolbar.add(refreshButton);
		
		if (configuration != null
				&& configuration.getListBoxPreInsert() != null
				&& configuration.getListBoxPreInsert().length > 0) {
			
			CodeMirrorListBox listBox = new CodeMirrorListBox(this);
			toolbar.add(listBox);
		}
		
	}

	private void prepareRefreshButtonHover(final Image redoButton) {
		redoButton.addMouseListener(new MouseListener() {
			
			public void onMouseEnter(Widget arg0) {
				redoButton.setUrl("images/icons/refresh_hover.png");
			}
			public void onMouseLeave(Widget arg0) {
				redoButton.setUrl("images/icons/refresh_blue.png");
			}
			public void onMouseDown(Widget arg0, int arg1, int arg2) {}
			public void onMouseMove(Widget arg0, int arg1, int arg2) {}
			public void onMouseUp(Widget arg0, int arg1, int arg2) {}
		});
	}
	
	private void prepareRedoButtonHover(final Image redoButton) {
		redoButton.addMouseListener(new MouseListener() {
			
			public void onMouseEnter(Widget arg0) {
				redoButton.setUrl("images/icons/redo_blue_hover.png");
			}
			public void onMouseLeave(Widget arg0) {
				redoButton.setUrl("images/icons/redo_blue.png");
			}
			public void onMouseDown(Widget arg0, int arg1, int arg2) {}
			public void onMouseMove(Widget arg0, int arg1, int arg2) {}
			public void onMouseUp(Widget arg0, int arg1, int arg2) {}
		});
	}

	private void prepareUndoButtonHover(final Image undoButton) {
		undoButton.addMouseListener(new MouseListener() {
			
			public void onMouseEnter(Widget arg0) {
				undoButton.setUrl("images/icons/undo_blue_hover.png");
			}
			public void onMouseLeave(Widget arg0) {
				undoButton.setUrl("images/icons/undo_blue.png");
			}
			public void onMouseDown(Widget arg0, int arg1, int arg2) {}
			public void onMouseMove(Widget arg0, int arg1, int arg2) {}
			public void onMouseUp(Widget arg0, int arg1, int arg2) {}
		});
	}
	
	
	protected void onLoad() {
		if (configuration != null) {
			codeMirrorJSNI = new CodeMirrorJSNI(configuration);
		}
		else {
			codeMirrorJSNI = new CodeMirrorJSNI();
		}
		prepareToolbarItems();
	}
	
	public TextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(TextArea ta) {
		this.textArea = ta;
	}
	
	public String getText() {
		return codeMirrorJSNI.getEditorCode();
	}
	
	public void setText(String code) {
		codeMirrorJSNI.setEditorCode(code);
	}
	
	public HorizontalPanel getToolBar() {
		return toolbar;
	}
	
	public void replaceText(String text) {
		codeMirrorJSNI.replaceText(text);
	}

	public CodeMirrorConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(CodeMirrorConfiguration configuration) {
		this.configuration = configuration;
	}
}
