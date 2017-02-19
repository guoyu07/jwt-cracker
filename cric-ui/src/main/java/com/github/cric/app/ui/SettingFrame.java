/**
 *   Copyright 2017 Pratapi Hemant Patel
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *   
 */
package com.github.cric.app.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;

import com.github.cric.app.model.Settings;
import com.github.cric.app.service.MainLock;
import com.github.cric.common.model.Match;
import com.github.cric.common.service.ScoreService;

public class SettingFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private Settings settings;
    private MainLock mainLock;

    public SettingFrame(ScoreService scoreService, MainLock mainLock) {

        super();
        this.mainLock = mainLock;
        
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new SettingPanel(this, scoreService));
        pack();
    }

    void submitted(Settings settings) {

        this.setExtendedState(ICONIFIED);
        this.settings = settings;
        mainLock.unlock();
    }

    public Settings getSettings() {

        return settings;
    }

    public boolean hasUpdatedSettings() {

        return (settings != null);
    }

    static {
        JFrame.setDefaultLookAndFeelDecorated(true);
    }
}
