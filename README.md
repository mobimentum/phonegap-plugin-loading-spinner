phonegap-plugin-loading-spinner
===============================

PhoneGap 3 plugin to show a loading spinner with optional dark overlay.

![screenshot](https://raw.github.com/mobimentum/phonegap-plugin-loading-spinner/master/screenshot.png "Screenshot")


Usage
=====

Add plugin to your project:

    cordova plugin add https://github.com/mobimentum/phonegap-plugin-loading-spinner.git

Show spinner with default arguments:

    spinnerplugin.show();
    
Show spinner with optional arguments:

    spinnerplugin.show({
        overlay: false, // defaults to true
        timeout: 30     // defaults to 0 (no timeout)
    });

Hide spinner:

    spinnerplugin.hide();
