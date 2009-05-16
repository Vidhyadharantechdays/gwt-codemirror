package com.weborient.codemirror.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author samangiahi
 *
 */
public class CodeMirrorListBox extends ListBox implements ChangeHandler {
	CodeMirrorEditorWidget widget;

	public CodeMirrorListBox(CodeMirrorEditorWidget widget) {
		this.widget = widget;
		if (widget.getConfiguration() != null
				&& widget.getConfiguration().getListBoxPreSets() != null
				&& widget.getConfiguration().getListBoxPreSets().length > 0) {

			addItem("");
			for (String preCode : widget.getConfiguration()
					.getListBoxPreSets()) {
				addItem(preCode);
			}
			setVisibleItemCount(1);
			addChangeHandler(this);
			this.setStyleName("listBox");
			
		}
	}

	public void onChange(ChangeEvent event) {
		String value = getValue(getSelectedIndex());
		GWT.log("list box value: " + value, null);
		if (value != null && !value.equals("")) {
			widget.replaceText(value);
		}
	}
}
