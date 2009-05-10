package com.weborient.codemirror.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class CodeMirrorListBox extends ListBox implements ChangeListener {
	CodeMirrorEditorWidget widget;

	public CodeMirrorListBox(CodeMirrorEditorWidget widget) {
		this.widget = widget;
		if (widget.getConfiguration() != null
				&& widget.getConfiguration().getListBoxPreInsert() != null
				&& widget.getConfiguration().getListBoxPreInsert().length > 0) {
			GWT.log("is not null", null);
			addItem("");
			for (String preCode : widget.getConfiguration()
					.getListBoxPreInsert()) {
				addItem(preCode);
			}
			setVisibleItemCount(1);
			addChangeListener(this);
			this.setStyleName("listBox");
		}
	}

	public void onChange(Widget w) {
		String value = getValue(getSelectedIndex());
		GWT.log("list box value: " + value, null);
		if (value != null && !value.equals("")) {
			widget.replaceText(value);
		}
	}
}
