package com.github.pixelase.webproject.webapp.panel.layout.footer;

import com.github.pixelase.webproject.webapp.panel.layout.common.FooterPanel;
import com.github.pixelase.webproject.webapp.panel.layout.footer.i18n.LanguageSelectionPanel;

public class DefaultFooterPanel extends FooterPanel {

    public static final String LANGUAGE_SELECTION_PANEL_ID = "language-selection-panel";

    public DefaultFooterPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new LanguageSelectionPanel(LANGUAGE_SELECTION_PANEL_ID));
    }
}