phonegap-plugin-loading-spinner
===============================

PhoneGap 3 plugin to show a loading spinner with optional dark overlay.

![screenshot](https://raw.github.com/mobimentum/phonegap-plugin-loading-spinner/master/screenshot.png "Screenshot")

Compatibility
=============

This plugin works on PhoneGap/Cordova 3.x. It's currently not tested against PhoneGap 4.x and known not to be working on PhoneGap/Cordova 5.x and above.

Usage
=====

Add plugin to your project:

    cordova plugin add https://github.com/mobimentum/phonegap-plugin-loading-spinner.git

Add the following to your config.xml to use version 1.0.0 of this plugin (recommended):

    <gap:plugin name="it.mobimentum.phonegapspinnerplugin" />
	
You can also omit the version tag to always use the most recent version of this plugin. Note that this will result in your app being automatically updated with new versions of this plugin as they are released, and may result in unexpected behaviour.

Show spinner with default arguments:

    spinnerplugin.show();
    
Show spinner with optional arguments:

    spinnerplugin.show({
        overlay: false,    // defaults to true
        timeout: 30,       // defaults to 0 (no timeout)
        fullscreen: true,  // defaults to false
    });

Hide spinner:

    spinnerplugin.hide();

Usage with jQuery Mobile
========================

I encourage you to use the following code to gracefully replace the default jQM loader:

    onDeviceReady: function() {
		// Native loading spinner
		if (window.spinnerplugin) {
			$.extend($.mobile, {
				loading: function() {
					// Show/hide spinner
					var arg = arguments ? arguments[0] : '';
					if (arg == 'show') spinnerplugin.show({'overlay':true});
					else if (arg == 'hide') spinnerplugin.hide();			

					// Compatibility with jQM 1.4
					return { loader: function() { } }
				}
			});	
		}
	}

Thus, if the SpinnerPlugin is added and working the native spinner would be used, otherwise the standard jQM loader is fired.
