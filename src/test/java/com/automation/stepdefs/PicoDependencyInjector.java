package com.automation.stepdefs;

import com.config.ChromeBrowser;
import cucumber.runtime.java.picocontainer.PicoFactory;

public class PicoDependencyInjector extends PicoFactory {

    public PicoDependencyInjector() {
        addClass(ChromeBrowser.class);
    }
}